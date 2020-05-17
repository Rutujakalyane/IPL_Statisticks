package IPL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class IPLAnalyser {

    public ArrayList<IPLDAO> loadRunsCSV(String csvFilePath) throws IOException {
        List<IplRunsCSV> iplRunsData = new IPLLoader().loadIplCSV(csvFilePath, IplRunsCSV.class);
        return iplRunsData.stream().map(IPLDAO::new).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList sort(ArrayList<IPLDAO> dataList, IPLSortMode sortMode) {
        dataList.sort(sortMode.comparator);
        return dataList;
    }
}
