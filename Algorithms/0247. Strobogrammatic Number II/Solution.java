class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> strobogrammatics = findStrobogrammaticWithZero(n);
        if (n == 1)
            return strobogrammatics;
        int size = strobogrammatics.size();
        for (int i = size - 1; i >= 0; i--) {
            if (strobogrammatics.get(i).charAt(0) == '0')
                strobogrammatics.remove(i);
        }
        Collections.sort(strobogrammatics);
        return strobogrammatics;
    }

    public List<String> findStrobogrammaticWithZero(int n) {
        List<String> strobogrammatics = new ArrayList<String>();
        if (n == 1) {
            strobogrammatics.add("0");
            strobogrammatics.add("1");
            strobogrammatics.add("8");
            return strobogrammatics;
        }
        if (n == 2) {
            strobogrammatics.add("00");
            strobogrammatics.add("11");
            strobogrammatics.add("69");
            strobogrammatics.add("88");
            strobogrammatics.add("96");
            return strobogrammatics;
        }
        List<String> prevStrobogrammatics = findStrobogrammaticWithZero(n - 2);
        for (String prevStrobogrammatic : prevStrobogrammatics) {
            strobogrammatics.add("0" + prevStrobogrammatic + "0");
            strobogrammatics.add("1" + prevStrobogrammatic + "1");
            strobogrammatics.add("6" + prevStrobogrammatic + "9");
            strobogrammatics.add("8" + prevStrobogrammatic + "8");
            strobogrammatics.add("9" + prevStrobogrammatic + "6");
        }
        return strobogrammatics;
    }
}