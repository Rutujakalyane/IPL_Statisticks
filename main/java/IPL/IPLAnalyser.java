package IPL;

import CSVBuilder.CSVBuilderFactory;
import CSVBuilder.ICSVBuilder;
import com.google.gson.Gson;
import exception.CensusAnalyserException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class IPLAnalyser {
    List<IplRunsCSV> runCSVList = new ArrayList<>();

    public int loadIPLMostRunsData(String csvFilePath) throws IPLException {
        int count = 0;
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IplRunsCSV> mostRunCSVIterator = csvBuilder.getIterator(reader, IplRunsCSV.class);
            while (mostRunCSVIterator.hasNext()) {
                IplRunsCSV iplRunCSV = mostRunCSVIterator.next();
                runCSVList.add(iplRunCSV);
                count++;
            }
            return count;
        } catch (IOException e) {
            throw new IPLException(e.getMessage(), IPLException.ExceptionType.NO_CRICKET_DATA);
        } catch (RuntimeException | CensusAnalyserException e) {
            throw new IPLException(e.getMessage(), IPLException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
        }
    }

    public String getAvgWiseSortedIPLPLayersRecords() {
        runCSVList.sort(Comparator.comparing(mostRunCSV -> mostRunCSV.avg));
        String sortedStateCensusJson = new Gson().toJson(runCSVList);
        return  sortedStateCensusJson;

    }

    public String getStrikeWiseWiseSortedIPLPLayersRecords() {
        runCSVList.sort(Comparator.comparing(mostRunCSV -> mostRunCSV.strikeRate));
        String sortedStateCensusJson = new Gson().toJson(runCSVList);
        return  sortedStateCensusJson;
    }
}

