class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> sortedList = new ArrayList<Integer>();
        int length = nums.length;
        for (int i = length - 1; i >= 0; i--) {
            int num = nums[i];
            int index = binarySearch(sortedList, num);
            stack.push(index);
            sortedList.add(index, num);
        }
        List<Integer> counts = new ArrayList<Integer>();
        while (!stack.isEmpty())
            counts.add(stack.pop());
        return counts;
    }

    public int binarySearch(List<Integer> list, int target) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = list.get(mid);
            if (num > target)
                high = mid - 1;
            else if (num < target)
                low = mid + 1;
            else
                high = mid;
            if (low == high && list.get(low) == target)
                break;
        }
        return low;
    }
}