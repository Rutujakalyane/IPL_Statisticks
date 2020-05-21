package IPL;

import java.util.Comparator;

public class SortFieldComparator implements Comparator<IplRunsCSV> {
    @Override
    public int compare(IplRunsCSV obj1, IplRunsCSV obj2) {
        return (((obj1.six * 6) + (obj1.fours * 4)) - ((obj2.six * 6) + (obj2.fours * 4)));
    }
}
