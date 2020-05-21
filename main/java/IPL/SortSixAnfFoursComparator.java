package IPL;

import java.util.Comparator;

class SortSixAndFoursComparator implements Comparator<IPLRecordDAO> {

    @Override
    public int compare(IPLRecordDAO obj1, IPLRecordDAO obj2) {
        return (((obj1.six * 6) + (obj1.fours * 4)) - ((obj2.six * 6) + (obj2.fours * 4)));
    }

}
