package IPL;

import java.util.Comparator;

 class Sort5wAnd4wComparator implements Comparator<IPLRecordDAO> {
    @Override
    public int compare(IPLRecordDAO obj1, IPLRecordDAO obj2) {
        return ((obj1.fourWkts + obj1.fiveWkts) - (obj2.fourWkts + obj2.fiveWkts));
    }
}
