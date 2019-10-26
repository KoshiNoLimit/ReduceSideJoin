class Parse {
    private static final Integer DELAY = 18;
    private static final Integer CANCEL = 19;
    private static final String WALL = ",";
    private static final String IS_CANCEL = "1.00";
    private static final String NOT_DELAY = "1.00";
    private static final String[] EMPTY = {};
    private static final String TRASH = "\"";

    static String[] parse(String s, Integer ind) {
        String[] set = s.split(WALL);
        if(ind == 1) {
            if(set[CANCEL].equals(IS_CANCEL) || set[DELAY].equals(NOT_DELAY)) {
                return EMPTY;
            }
        }
        for(int i = 0; i < set.length; i++) {
            set[i] = set[i].replaceAll(TRASH, "");
        }
        return set;
    }
}
