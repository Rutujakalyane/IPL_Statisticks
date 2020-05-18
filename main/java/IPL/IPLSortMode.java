package IPL;

import java.util.Comparator;

public enum IPLSortMode {
        AVERAGE(Comparator.comparing(IPLDAO::getAvg).reversed());


        public final Comparator comparator;

        IPLSortMode(Comparator<IPLDAO> comparator) {
        this.comparator = comparator;
    }
    }

