class Parse {
    public static final Integer AIRPORT_ID = 0;
    public static final Integer FLY_ID = 14;
    public static final Integer AIRPORT_IND = 0;
    public static final Integer FLY_IND = 1;
    private static final Integer DELAY = 18;
    private static final Integer CANCEL = 19;
    private static final String DELIMITER_FLY = ",";
    private static final String DELIMITER_AIR = "\",\"";
    private static final String IS_CANCEL = "1.00";
    private static final String NOT_DELAY = "1.00";
    public static final String[] EMPTY = {};
    private static final String COMMA = "\"";

    String[] raws;

    static String[] parseAir(String s) {

    }

    static String[] parseFly(String s) {

    }

    static String[] parse(String s, Integer ind) {
        String[] set;
        if(ind == 1) {
            set = s.split(DELIMITER_FLY);
            if(set[CANCEL].equals(IS_CANCEL) || set[DELAY].equals(NOT_DELAY)) {
                return EMPTY;
            }
        } else {
            set = s.split(DELIMITER_AIR);
        }
        for(int i = 0; i < set.length; i++) {
            set[i] = set[i].replaceAll(COMMA, "");
        }
        return set;
    }
}
