class Solution {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> totalSet = new HashSet<Integer>();
        List<Integer> prevList = new ArrayList<Integer>();
        int length = A.length;
        for (int i = 0; i < length; i++) {
            int num = A[i];
            List<Integer> curList = new ArrayList<Integer>();
            totalSet.add(num);
            curList.add(num);
            for (int prevNum : prevList) {
                int bitOR = num | prevNum;
                if (bitOR > num)
                    curList.add(bitOR);
                totalSet.add(bitOR);
                num = bitOR;
            }
            prevList = new ArrayList<Integer>(curList);
        }
        return totalSet.size();
    }
}