class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<String>();
        int length = target.length;
        int curNum = 1;
        for (int i = 0; i < length; i++) {
            int num = target[i];
            while (num != curNum) {
                operations.add("Push");
                operations.add("Pop");
                curNum++;
            }
            operations.add("Push");
            curNum++;
        }
        return operations;
    }
}