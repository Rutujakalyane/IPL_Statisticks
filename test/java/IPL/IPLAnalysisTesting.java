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
            int iplRecords = iplAnalyser.loadIPLData(IPL_MOST_RUNS_CSV_FILE_PATH);
            Assert.assertEquals(100, iplRecords);
        } catch (IPLException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void givenIPLMOstRunsCSVFile_WhenSortedOnAvg_ShouldReturnCorrectDesiredSortedData() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadIPLData(IPL_MOST_RUNS_CSV_FILE_PATH);
            String iplpLayersRecords = iplAnalyser.getFieldWiseSortedIPLPLayersRecords(SortByField.Parameter.AVG);
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
            iplAnalyser.loadIPLData(IPL_MOST_RUNS_CSV_FILE_PATH);
            String iplpLayersRecords = iplAnalyser.getFieldWiseSortedIPLPLayersRecords(SortByField.Parameter.STRIKERATE);
            IplRunsCSV[] mostRunCSVS = new Gson().fromJson(iplpLayersRecords, IplRunsCSV[].class);
            Assert.assertEquals("Ishant Sharma", mostRunCSVS[mostRunCSVS.length - 1].player);
        } catch (IPLException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void givenIPLMOstRunsCSVFile_WhenSortedOn4SAnd6s_ShouldReturnCorrectDesiredSortedData() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadIPLData(IPL_MOST_RUNS_CSV_FILE_PATH);
            String iplpLayersRecords = iplAnalyser.getFieldWiseSortedIPLPLayersRecords(SortByField.Parameter.SIX_AND_FOURS);
            IplRunsCSV[] mostRunCSVS = new Gson().fromJson(iplpLayersRecords, IplRunsCSV[].class);
            Assert.assertEquals("Andre Russell", mostRunCSVS[mostRunCSVS.length - 1].player);
        } catch (IPLException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void givenIPLMOstRunsCSVFile_WhenSortedOn4SAnd6sWithStrikeRate_ShouldReturnCorrectDesiredSortedData() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadIPLData(IPL_MOST_RUNS_CSV_FILE_PATH);
            String iplpLayersRecords = iplAnalyser.getFieldWiseSortedIPLPLayersRecords(SortByField.Parameter.SIX_AND_FOURS_WITH_STRIKERATE);
            IplRunsCSV[] mostRunCSVS = new Gson().fromJson(iplpLayersRecords, IplRunsCSV[].class);
            Assert.assertEquals("Andre Russell", mostRunCSVS[mostRunCSVS.length - 1].player);
        } catch (IPLException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void givenIPLMOstRunsCSVFile_WhenSortedOnAverageWithStrikeRate_ShouldReturnCorrectDesiredSortedData() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadIPLData(IPL_MOST_RUNS_CSV_FILE_PATH);
            String iplpLayersRecords = iplAnalyser.getFieldWiseSortedIPLPLayersRecords(SortByField.Parameter.AVG_WITH_STRIKERATE);
            IplRunsCSV[] mostRunCSVS = new Gson().fromJson(iplpLayersRecords, IplRunsCSV[].class);
            Assert.assertEquals("David Warner", mostRunCSVS[mostRunCSVS.length - 1].player);
        } catch (IPLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIPLMOstRunsCSVFile_WhenSortedOnRunWithAvg_ShouldReturnCorrectDesiredSortedData() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadIPLData(IPL_MOST_RUNS_CSV_FILE_PATH);
            String iplpLayersRecords = iplAnalyser.getFieldWiseSortedIPLPLayersRecords(SortByField.Parameter.RUN_WITH_AVG);
            IplRunsCSV[] mostRunCSVS = new Gson().fromJson(iplpLayersRecords, IplRunsCSV[].class);
            Assert.assertEquals("David Warner ", mostRunCSVS[mostRunCSVS.length - 1].player);
        } catch (IPLException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void givenIPLMOstWktsCSVFile_WhenSortedOnAvg_ShouldReturnCorrectDesiredSortedData() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.IPLEntity.BOWLING);
            iplAnalyser.loadIPLData(IPL_MOST_WKTS_CSV_FILE_PATH);
            String iplpLayersRecords = iplAnalyser.getFieldWiseSortedIPLPLayersRecords(SortByField.Parameter.AVG);
            MostWktsCSV[] mostRunCSVS = new Gson().fromJson(iplpLayersRecords, MostWktsCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham", mostRunCSVS[0].player);
        } catch (IPLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLMOstWktsCSVFile_WhenSortedOnStrikeRate_ShouldReturnCorrectDesiredSortedData() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.IPLEntity.BOWLING);
            iplAnalyser.loadIPLData(IPL_MOST_WKTS_CSV_FILE_PATH);
            String iplpLayersRecords = iplAnalyser.getFieldWiseSortedIPLPLayersRecords(SortByField.Parameter.STRIKERATE);
            MostWktsCSV[] mostRunCSVS = new Gson().fromJson(iplpLayersRecords, MostWktsCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham", mostRunCSVS[0].player);
        } catch (IPLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIPLMOstWktsCSVFile_WhenSortedOnEconomy_ShouldReturnCorrectDesiredSortedData() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.IPLEntity.BOWLING);
            iplAnalyser.loadIPLData(IPL_MOST_WKTS_CSV_FILE_PATH);
            String iplpLayersRecords = iplAnalyser.getFieldWiseSortedIPLPLayersRecords(SortByField.Parameter.ECONOMY);
            MostWktsCSV[] mostRunCSVS = new Gson().fromJson(iplpLayersRecords, MostWktsCSV[].class);
            Assert.assertEquals("Suresh Raina", mostRunCSVS[0].player);
        } catch (IPLException e) {
            e.printStackTrace();
        }
    }
}

