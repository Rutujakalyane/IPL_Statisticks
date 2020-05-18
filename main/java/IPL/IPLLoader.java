package IPL;

import CSVBuilder.CSVBuilderFactory;
import CSVBuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class IPLLoader {

    public List loadIplCSV(String csvPath, Class csvClass) throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvPath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            return csvBuilder.getCSVFileList(reader, csvClass);
        }
    }
}

