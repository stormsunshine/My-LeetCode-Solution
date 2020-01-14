class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<Integer> indices = new ArrayList<Integer>();
        int index = -1;
        do {
            index = s.indexOf("++", index + 1);
            if (index >= 0)
                indices.add(index);
        } while (index >= 0);
        List<String> nextMoves = new ArrayList<String>();
        for (int num : indices) {
            StringBuffer sb = new StringBuffer(s);
            sb.replace(num, num + 2, "--");
            nextMoves.add(sb.toString());
        }
        return nextMoves;
    }
}