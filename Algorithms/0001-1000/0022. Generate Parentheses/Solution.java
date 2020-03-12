class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> generated = new ArrayList<String>();
        if (n == 0) {
            generated.add("");
            return generated;
        }
        for (int i = 0; i < n; i++) {
            int j = n - 1 - i;
            for (String left: generateParenthesis(i)) {
                for (String right: generateParenthesis(j))
                    generated.add("(" + left + ")" + right);
            }
        }
        Collections.sort(generated);
        return generated;
    }
}