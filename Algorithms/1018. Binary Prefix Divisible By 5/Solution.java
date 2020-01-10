class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<Boolean>();
        int length = A.length;
        int num = 0;
        for (int i = 0; i < length; i++) {
            num = (num * 2 + A[i]) % 5;
            list.add(num == 0);
        }
        return list;
    }
}