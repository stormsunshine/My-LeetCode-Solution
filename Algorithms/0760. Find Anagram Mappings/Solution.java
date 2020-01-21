class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int length = A.length;
        List<Integer> listB = new ArrayList<Integer>();
        for (int i = 0; i < length; i++)
            listB.add(B[i]);
        int[] anagram = new int[length];
        for (int i = 0; i < length; i++) {
            int num = A[i];
            int index = listB.indexOf(num);
            anagram[i] = index;
            listB.set(index, -1);
        }
        return anagram;
    }
}