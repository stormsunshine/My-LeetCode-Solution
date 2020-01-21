class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> largeGroupPositions = new ArrayList<List<Integer>>();
        if (S.length() < 3)
            return largeGroupPositions;
        int begin = 0;
        char prev = S.charAt(0);
        int length = S.length();
        for (int i = 1; i < length; i++) {
            char c = S.charAt(i);
            if (c != prev) {
                if (i - begin >= 3) {
                    int end = i - 1;
                    List<Integer> largeGroupPosition = new ArrayList<Integer>();
                    largeGroupPosition.add(begin);
                    largeGroupPosition.add(end);
                    largeGroupPositions.add(largeGroupPosition);
                }
                begin = i;
            }
            prev = c;
        }
        if (length - begin >= 3) {
            int end = length - 1;
            List<Integer> largeGroupPosition = new ArrayList<Integer>();
            largeGroupPosition.add(begin);
            largeGroupPosition.add(end);
            largeGroupPositions.add(largeGroupPosition);
        }
        return largeGroupPositions;
    }
}