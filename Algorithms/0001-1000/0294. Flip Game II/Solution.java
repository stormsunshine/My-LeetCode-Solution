class Solution {
    Map<String, Boolean> map = new HashMap<String, Boolean>();

    public boolean canWin(String s) {
        if (map.containsKey(s))
            return map.get(s);
        int maxIndex = s.length() - 2;
        for (int i = 0; i <= maxIndex; i++) {
            String sub = s.substring(i, i + 2);
            if (sub.equals("++")) {
                String newStr = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!canWin(newStr)) {
                    map.put(newStr, false);
                    return true;
                }
                map.put(newStr, true);
            }
        }
        return false;
    }
}