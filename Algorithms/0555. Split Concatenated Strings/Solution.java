class Solution {
    public String splitLoopedString(String[] strs) {
        int length = strs.length;
        for (int i = 0; i < length; i++) {
            String str = strs[i];
            String str2 = new StringBuffer(str).reverse().toString();
            if (str2.compareTo(str) > 0)
                strs[i] = str2;
        }
        String biggestStr = "";
        for (int i = 0; i < length; i++) {
            String str = strs[i];
            String str2 = new StringBuffer(str).reverse().toString();
            String[] tempArray = {str, str2};
            for (String curStr : tempArray) {
                int curLength = curStr.length();
                for (int j = 0; j < curLength; j++) {
                    StringBuffer sb = new StringBuffer(curStr.substring(j));
                    int index = (i + 1) % length;
                    for (int k = 1; k < length; k++) {
                        sb.append(strs[index]);
                        index = (index + 1) % length;
                    }
                    sb.append(curStr.substring(0, j));
                    String curTotalStr = sb.toString();
                    if (curTotalStr.compareTo(biggestStr) > 0)
                        biggestStr = curTotalStr;
                }
            }
        }
        return biggestStr;
    }
}