package IPL;

import org.junit.Test;

public class IPLTest {
    static public String IPL_PLAYERS_RUNS_CSV = ".src/test/resources/IPL2019FactsheetMostRuns.csv";
    static public String IPL_PLAYERS_SAMPLE_RUNS_CSV = ".src/test/resources/IPL2019FactsheetMostRunsSample.csv";

    @Test
    public void givenMethod_ReadingCSV_AndShould_ReturnPlayersList() {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        iplAnalyser.loadRunsCSV(IPL_PLAYERS_SAMPLE_RUNS_CSV);
    }
}
