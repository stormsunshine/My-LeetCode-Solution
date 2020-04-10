class Solution {
    public String crackSafe(int n, int k) {
        if (n == 1 && k == 1)
            return "0";
        Set<String> set = new HashSet<String>();
        StringBuffer input = new StringBuffer();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < n; i++)
            sb.append("0");
        String start = sb.toString();
        depthFirstSearch(start, k, set, input);
        input.append(start);
        return input.toString();
    }

    public void depthFirstSearch(String start, int k, Set<String> set, StringBuffer input) {
        for (int i = 0; i < k; i++) {
            String next = start + i;
            if (set.add(next)) {
                depthFirstSearch(next.substring(1), k, set, input);
                input.append(i);
            }
        }
    }
}