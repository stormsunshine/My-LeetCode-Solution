class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        List<Integer> list2 = new ArrayList<Integer>();
        for (int i = 0; i < length2; i++)
            list2.add(nums2[i]);
        int[] nextGreaterElements1 = new int[length1];
        int[] nextGreaterElements2 = new int[length2];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < length2; i++) {
            int num = nums2[i];
            while (!stack.isEmpty() && stack.peek() < num) {
                int prevNum = stack.pop();
                int index = list2.indexOf(prevNum);
                nextGreaterElements2[index] = num;
            }
            stack.push(num);
        }
        while (!stack.isEmpty()) {
            int num = stack.pop();
            int index = list2.indexOf(num);
            nextGreaterElements2[index] = -1;
        }
        for (int i = 0; i < length1; i++) {
            int num = nums1[i];
            int index = list2.indexOf(num);
            nextGreaterElements1[i] = nextGreaterElements2[index];
        }
        return nextGreaterElements1;
    }
}