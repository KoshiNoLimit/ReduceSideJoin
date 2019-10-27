class ParseAF {
    static final Integer AIRPORT_ID = 0;
    static final Integer FLY_ID = 14;
    static final Integer AIRPORT_IND = 0;
    static final Integer FLY_IND = 1;
    static final Integer DELAY = 18;
    static final Integer AIRPORT_NAME = 1;
    static final String[] EMPTY = new String[0];
    private static final Integer CANCEL = 19;
    private static final String DELIMITER_FLY = ",";
    private static final String DELIMITER_AIR = "\",\"";
    private static final String IS_CANCEL = "1.00";
    private static final String NOT_DELAY = "1.00";

    private static final String COMMA = "\"";

    private static String[] deleteCommas(String[] s) {
        for(int i = 0; i < s.length; i++) {
            s[i] = s[i].replaceAll(COMMA, "");
        }
        return s;
    }

    static String[] parseAir(String s) {
        String[] lines = s.split(DELIMITER_AIR);
        return deleteCommas(lines);
    }

    static String[] parseFly(String s) {
        String[] lines = s.split(DELIMITER_FLY);
        if(lines[CANCEL].equals(IS_CANCEL) || lines[DELAY].equals(NOT_DELAY)) {
            return EMPTY;
        }
        return deleteCommas(lines);
    }
}
