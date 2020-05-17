package IPL;

import java.util.Comparator;

public class IPLSorMode {
        AVERAGE(Comparator.comparing(IPLDAO::getAvg).reversed()),
        FOURS(Comparator.comparing(IPLDAO::getFours).reversed()),
        SIXES(Comparator.comparing(IPLDAO::getSixes).reversed()),
        STRIKE_RATE(Comparator.comparing(IPLDAO::getSR).reversed());

        public final Comparator comparator;

        IPLSortMode(Comparator<IPLDAO> comparator) {
        this.comparator = comparator;
    }
    }

