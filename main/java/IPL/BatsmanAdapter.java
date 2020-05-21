package IPL;

import java.util.Map;

public class BatsmanAdapter extends IPLAdapter{

        @Override
        public Map<String, IPLRecordDAO> loadIPLData(IPLAnalyser.IPLEntity iplEntity, String csvFilePath) throws IPLException {
            Map<String, IPLRecordDAO> recordDAOMap = super.loadIPLData(IplRunsCSV.class, csvFilePath);
            return recordDAOMap;
        }


    }

