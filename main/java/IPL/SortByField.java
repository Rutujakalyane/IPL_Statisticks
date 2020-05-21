package IPL;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortByField {
        static Map<Parameter, Comparator> sortParameterComparator = new HashMap<>();

        public enum Parameter {
            AVG, STRIKERATE, CENTUARY, FOURS, HALFCENTUARY, HIGHSCORE, SIX, RUN;
        }

        SortByField() {

    }
        public static Comparator getParameter(SortByField.Parameter parameter) {

        Comparator<IplRunsCSV> avgComparator = Comparator.comparing(mostRunCSV -> mostRunCSV.avg);
        Comparator<IplRunsCSV> strikeRateComparator = Comparator.comparing(mostRunCSV -> mostRunCSV.strikeRate);
        Comparator<IplRunsCSV> centuaryComparator = Comparator.comparing(mostRunCSV -> mostRunCSV.centuary);
        Comparator<IplRunsCSV> foursComparator = Comparator.comparing(mostRunCSV -> mostRunCSV.fours);
        Comparator<IplRunsCSV> HalfCentuaryComparator = Comparator.comparing(mostRunCSV -> mostRunCSV.halfCentuary);
        Comparator<IplRunsCSV> highScoreComparator = Comparator.comparing(mostRunCSV -> mostRunCSV.highScore);
        Comparator<IplRunsCSV> sixComparator = Comparator.comparing(mostRunCSV -> mostRunCSV.six);
        Comparator<IplRunsCSV> runComparator = Comparator.comparing(mostRunCSV -> mostRunCSV.run);

        sortParameterComparator.put(Parameter.AVG, avgComparator);
        sortParameterComparator.put(Parameter.STRIKERATE, strikeRateComparator);
        sortParameterComparator.put(Parameter.CENTUARY, centuaryComparator);
        sortParameterComparator.put(Parameter.FOURS, foursComparator);
        sortParameterComparator.put(Parameter.HALFCENTUARY, HalfCentuaryComparator);
        sortParameterComparator.put(Parameter.HIGHSCORE, highScoreComparator);
        sortParameterComparator.put(Parameter.SIX, sixComparator);
        sortParameterComparator.put(Parameter.RUN, runComparator);


        Comparator<IplRunsCSV> comparator = sortParameterComparator.get(parameter);

        return comparator;
    }
    }
