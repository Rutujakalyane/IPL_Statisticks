
package IPL;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class IPLAnalyser  {
    public enum IPLEntity{
        BATING, BOWLING
    }
    Map< String, IPLRecordDAO> runCSVMap ;
    private SortByField.Parameter parameter;
    public IPLEntity iplEntity;

    public IPLAnalyser(IPLEntity iplEntity) {
        this.iplEntity = iplEntity;
    }

    public IPLAnalyser() {
        this.runCSVMap = new HashMap<>();

    }

    public <T>int loadIPLData(String csvFilePath) throws IPLException {
        runCSVMap = new IPLAdapterFactory().cricketleagueFactory(iplEntity,csvFilePath);
        return runCSVMap.size();
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