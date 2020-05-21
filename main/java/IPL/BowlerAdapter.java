package IPL;

import java.util.Map;

public class BowlerAdapter extends IPLAdapter {

    @Override
    public Map<String, IPLRecordDAO> loadIPLData(IPLAnalyser.IPLEntity iplEntity, String csvFilePath) throws IPLException {
        Map<String, IPLRecordDAO> recordDAOMap = super.loadIPLData(MostWktsCSV.class, csvFilePath);
        return recordDAOMap;

    }
}
