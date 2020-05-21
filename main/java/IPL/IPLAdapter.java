package IPL;

import CSVBuilder.CSVBuilderFactory;
import CSVBuilder.ICSVBuilder;
import exception.CensusAnalyserException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public abstract class IPLAdapter {
    public abstract Map<String, IPLRecordDAO> loadIPLData(IPLEntity iplEntity, String... csvFilePath) throws IPLException;

    public <T> Map<String, IPLRecordDAO> loadIPLData(Class<T> iplCSVClass, String... csvFilePath) throws IPLException {
        Map<String, IPLRecordDAO> iplRecordDAOMap = new HashMap<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath[0]))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator mostRunCSVIterator = csvBuilder.getIterator(reader, iplCSVClass);
            Iterable<T> mostRunCSVIterable = () -> mostRunCSVIterator;
            if (iplCSVClass.getName().equals("iplanalysis.MostRunCSV")) {
                StreamSupport.stream(mostRunCSVIterable.spliterator(), false)
                        .map(IplRunsCSV.class::cast)
                        .forEach(mostRunCSV -> iplRecordDAOMap.put(mostRunCSV.player, new IPLRecordDAO(mostRunCSV)));
            } else if (iplCSVClass.getName().equals("iplanalysis.MostWktsCSV")) {
                StreamSupport.stream(mostRunCSVIterable.spliterator(), false)
                        .map(MostWktsCSV.class::cast)
                        .filter(mostWktsCSV -> mostWktsCSV.average != 0.0)
                        .forEach(mostWktsCSV -> iplRecordDAOMap.put(mostWktsCSV.player, new IPLRecordDAO(mostWktsCSV)));
            }
            return iplRecordDAOMap;
        } catch (IOException e) {
            throw new IPLException(e.getMessage(), IPLException.ExceptionType.NO_IPL_DATA);
        } catch (RuntimeException | CensusAnalyserException e) {
            throw new IPLException(e.getMessage(), IPLException.ExceptionType.IPL_FILE_INTERNAL_ISSUES);
        }
    }

}