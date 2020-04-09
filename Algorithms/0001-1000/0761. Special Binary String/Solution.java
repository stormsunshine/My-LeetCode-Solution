class Solution {
    public String makeLargestSpecial(String S) {
        List<String> list = new ArrayList<String>();
        int start = 0;
        int ones = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == '1')
                ones++;
            else
                ones--;
            if (ones == 0) {
                String substr = S.substring(start + 1, i);
                String curSpecial = "1" + makeLargestSpecial(substr) + "0";
                list.add(curSpecial);
                start = i + 1;
            }
        }
        Collections.sort(list);
        StringBuffer sb = new StringBuffer();
        for (int i = list.size() - 1; i >= 0; i--)
            sb.append(list.get(i));
        return sb.toString();
    }
}