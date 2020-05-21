
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

public class IPLAnalyser {
    Map< String, IplRunsCSV> runCSVMap = new HashMap<>();
    private SortByField.Parameter parameter;

    public int loadIPLMostRunsData(String csvFilePath) throws IPLException {
        int count = 0;
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IplRunsCSV> mostRunCSVIterator = csvBuilder.getIterator(reader, IplRunsCSV.class);
            while (mostRunCSVIterator.hasNext()) {
                IplRunsCSV mostRunCSV = mostRunCSVIterator.next();
                runCSVMap.put(mostRunCSV.player, mostRunCSV);
                count++;
            }
            return count;
        } catch (IOException e) {
            throw new IPLException(e.getMessage(), IPLException.ExceptionType.NO_CRICKET_DATA);
        } catch (RuntimeException e) {
            throw new IPLException(e.getMessage(), IPLException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
        } catch (CensusAnalyserException e) {
            throw new IPLException(e.getMessage(), IPLException.ExceptionType.FILE_PROBLEM);
        }
    }

    public String getFieldWiseSortedIPLPLayersRecords(SortByField.Parameter parameter) throws IPLException {
        Comparator<IplRunsCSV> censusComparator = null;
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