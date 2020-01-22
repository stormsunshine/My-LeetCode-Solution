class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A == null || B == null || A.length() != B.length())
            return false;
        if (A.equals(B)) {
            char[] array = A.toCharArray();
            Arrays.sort(array);
            int length = array.length;
            for (int i = 1; i < length; i++) {
                if (array[i] == array[i - 1])
                    return true;
            }
            return false;
        }
        List<Integer> differentIndices = new ArrayList<Integer>();
        int length = A.length();
        for (int i = 0; i < length; i++) {
            char cA = A.charAt(i), cB = B.charAt(i);
            if (cA != cB)
                differentIndices.add(i);
        }
        if (differentIndices.size() != 2)
            return false;
        int index1 = differentIndices.get(0), index2 = differentIndices.get(1);
        return A.charAt(index1) == B.charAt(index2) && A.charAt(index2) == B.charAt(index1);
    }
}