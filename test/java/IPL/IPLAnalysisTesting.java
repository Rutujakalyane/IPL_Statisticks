package IPL;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;


public  class IPLAnalysisTesting {
    private static final String IPL_MOST_RUNS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_MOST_WKTS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenIPLMOstRunsCSVFile_ShouldReturnCorrectRecords() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            int iplRecords = iplAnalyser.loadIPLMostRunsData(IPL_MOST_RUNS_CSV_FILE_PATH);
            Assert.assertEquals(100, iplRecords);
        } catch (IPLException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void givenIPLMOstRunsCSVFile_WhenSortedOnAvg_ShouldReturnCorrectDesiredSortedData() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadIPLMostRunsData(IPL_MOST_RUNS_CSV_FILE_PATH);
            String iplpLayersRecords = iplAnalyser.getAvgWiseSortedIPLPLayersRecords(SortByField.Parameter.AVG);
            IplRunsCSV[] mostRunCSVS = new Gson().fromJson(iplpLayersRecords, IplRunsCSV[].class);
            Assert.assertEquals("MS Dhoni", mostRunCSVS[mostRunCSVS.length - 1].player);
        } catch (IPLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenIPLMOstRunsCSVFile_WhenSortedOnStrikeRate_ShouldReturnCorrectDesiredSortedData() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadIPLMostRunsData(IPL_MOST_RUNS_CSV_FILE_PATH);
            String iplpLayersRecords = iplAnalyser.getAvgWiseSortedIPLPLayersRecords(SortByField.Parameter.STRIKERATE);
            IplRunsCSV[] mostRunCSVS = new Gson().fromJson(iplpLayersRecords, IplRunsCSV[].class);
            Assert.assertEquals("Ishant Sharma", mostRunCSVS[mostRunCSVS.length - 1].player);
        } catch (IPLException e) {
            e.printStackTrace();
        }

    }
}