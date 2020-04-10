package chapter1;

public class LongWrapper {

    // private final Object key = new Object();

    private Long l;

    LongWrapper(Long inL) {
        l = inL;
    }

    public Long getL() {
        return l;
    }

    public void incrementValue() {
        //add synchronized block here to avoid any race conditions
        l = l + 1;
    }

}
