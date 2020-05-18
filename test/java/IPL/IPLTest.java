package IPL;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IPLTest {
    static public String IPL_PLAYERS_RUNS_CSV = ".src/test/resources/IPL2019FactsheetMostRuns.csv";
    static public String IPL_PLAYERS_SAMPLE_RUNS_CSV = ".src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenMethod_WhenReadingCSV_ShouldReturnPlayersList() {
        try {
            List runs = IPLAnalyser.loadRunsCSV(IPL_PLAYERS_SAMPLE_RUNS_CSV);
            Assert.assertEquals(5, runs.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenBatsmenCSV_WhenSorted_ShouldReturnListByAverage() {
        try {
            ArrayList<IPLDAO> batsmenList = IPLAnalyser.loadRunsCSV(IPL_PLAYERS_SAMPLE_RUNS_CSV);
            ArrayList<IPLDAO> sortedList = IPLAnalyser.sort(batsmenList, IPLSortMode.AVERAGE);
            Assert.assertEquals((Double) 69.2, sortedList.get(0).getAvg());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}