class Fancy {
    static final int MODULO = 1000000007;
    List<Long> list;
    long globalMultiply;
    long globalIncrement;

    public Fancy() {
        list = new ArrayList<Long>();
        globalMultiply = 1;
        globalIncrement = 0;
    }

    public void append(int val) {
        long toAppend = (val + MODULO - globalIncrement) % MODULO;
        toAppend = toAppend * pow(globalMultiply, MODULO - 2) % MODULO;
        list.add(toAppend);
    }

    public void addAll(int inc) {
        globalIncrement = (globalIncrement + inc) % MODULO;
    }

    public void multAll(int m) {
        globalIncrement = (globalIncrement * m) % MODULO;
        globalMultiply = (globalMultiply * m) % MODULO;
    }

    public int getIndex(int idx) {
        if (idx >= list.size())
            return -1;
        return (int) (list.get(idx) * globalMultiply % MODULO + globalIncrement) % MODULO;
    }

    private long pow(long x, int y) {
        long result = 1;
        long multiply = x;
        while (y > 0) {
            if (y % 2 != 0)
                result = (result * multiply) % MODULO;
            multiply = (multiply * multiply) % MODULO;
            y >>= 1;
        }
        return result;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */