class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<String, String>();
        for (List<String> entry : knowledge) {
            String key = entry.get(0), value = entry.get(1);
            map.put(key, value);
        }
        StringBuffer sb = new StringBuffer();
        boolean inBracket = false;
        int start = -1;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                inBracket = true;
                start = i + 1;
            } else if (c == ')') {
                inBracket = false;
                String key = s.substring(start, i);
                String value = map.getOrDefault(key, "?");
                sb.append(value);
            } else if (!inBracket)
                sb.append(c);
        }
        return sb.toString();
    }
}