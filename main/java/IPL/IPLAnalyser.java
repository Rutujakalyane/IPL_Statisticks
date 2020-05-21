
package IPL;

import CSVBuilder.CSVBuilderFactory;
import CSVBuilder.ICSVBuilder;
import com.google.gson.Gson;
import exception.CensusAnalyserException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class IPLAnalyser {
    Map< String, IPLRecordDAO> runCSVMap = new HashMap<>();
    private SortByField.Parameter parameter;
    public <T>int loadIPLMostRunsData(String csvFilePath) throws IPLException {
        int count = 0;
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator mostRunCSVIterator = csvBuilder.getIterator(reader, IplRunsCSV.class);
            Iterable<T> mostRunCSVIterable = () -> mostRunCSVIterator;
            StreamSupport.stream(mostRunCSVIterable.spliterator(), false)
                    .map(IplRunsCSV.class::cast)
                    .forEach(mostRunCSV -> runCSVMap.put(mostRunCSV.player, new IPLRecordDAO(mostRunCSV)));

            return runCSVMap.size();
        } catch (IOException e) {
            throw new IPLException(e.getMessage(), IPLException.ExceptionType.NO_CRICKET_DATA);
        } catch (RuntimeException | CensusAnalyserException e) {
            throw new IPLException(e.getMessage(), IPLException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
        }
    }
    public <T>int loadIPLMostWktsData(String csvFilePath) throws IPLException {
        int count = 0;
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator mostRunCSVIterator = csvBuilder.getIterator(reader, MostWktsCSV.class);
            Iterable<T> mostRunCSVIterable = () -> mostRunCSVIterator;
            StreamSupport.stream(mostRunCSVIterable.spliterator(), false)
                    .map(MostWktsCSV.class::cast)
                    .forEach(mostWktsCSV -> runCSVMap.put(mostWktsCSV.player, new IPLRecordDAO(mostWktsCSV)));
            return runCSVMap.size();
        } catch (IOException e) {
            throw new IPLException(e.getMessage(), IPLException.ExceptionType.NO_CRICKET_DATA);
        } catch (RuntimeException | CensusAnalyserException e) {
            throw new IPLException(e.getMessage(), IPLException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
        }
    }


    public String getFieldWiseSortedIPLPLayersRecords(SortByField.Parameter parameter) throws IPLException {
        Comparator<IPLRecordDAO> censusComparator = null;
        if (runCSVMap == null || runCSVMap.size() == 0) {
            throw new IPLException("NO_CENSUS_DATA", IPLException.ExceptionType.NO_CRICKET_DATA);
        }
        censusComparator = SortByField.getParameter(parameter);
        ArrayList runCSVList =  runCSVMap.values().stream().
                sorted(censusComparator).collect(Collectors.toCollection(ArrayList::new));

        String sortedStateCensusJson = new Gson().toJson(runCSVList);
        return  sortedStateCensusJson;
    }

}