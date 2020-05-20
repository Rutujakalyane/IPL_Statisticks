package IPL;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class IPLTest {
    static public String IPL_PLAYERS_RUNS_CSV = ".src/test/resources/IPL2019FactsheetMostRuns.csv";
    static public String IPL_PLAYERS_SAMPLE_RUNS_CSV = ".src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenIPLMOstRunsCSVFile_ShouldReturnCorrectRecords() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            int iplRecords = iplAnalyser.loadIPLMostRunsData(IPL_PLAYERS_RUNS_CSV);
            Assert.assertEquals(101, iplRecords);
        } catch (IPLException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void givenIPLMOstRunsCSVFile_WhenSortedOnAvg_ShouldReturnCorrectDesiredSortedData() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadIPLMostRunsData(IplRunsCSV);
            String iplPLayersRecords = iplAnalyser.getAvgWiseSortedIPLPLayersRecords();
            IplRunsCSV[] iplRunCSV = new Gson().fromJson(iplPLayersRecords, IplRunsCSV[].class);
            Assert.assertEquals("MS Dhoni", iplRunCSV[iplRunCSV.length - 1].player);
        } catch (IPLException e) {
            e.printStackTrace();
        }

    }
    }
