class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int length = nums.length;
        int[] hasLoop = new int[length];
        for (int i = 0; i < length; i++) {
            if (hasLoop[i] == 0) {
                boolean loop = checkLoop(nums, hasLoop, i);
                if (loop)
                    return true;
            }
        }
        return false;
    }

    public boolean checkLoop(int[] nums, int[] hasLoop, int startIndex) {
        int length = nums.length;
        List<Integer> indices = new ArrayList<Integer>();
        indices.add(startIndex);
        int index = startIndex;
        int direction = 0;
        do {
            int num = nums[index];
            if (direction == 0)
                direction = num / Math.abs(num);
            else if (direction * num < 0)
                return false;
            index = (index + num) % length;
            if (index < 0)
                index += length;
            int occur = indices.indexOf(index);
            if (occur < 0)
                indices.add(index);
            else {
                int size = indices.size();
                if (occur == size - 1) {
                    for (int curIndex : indices)
                        hasLoop[curIndex] = -1;
                    return false;
                } else {
                    for (int i = 0; i < occur; i++)
                        hasLoop[indices.get(i)] = -1;
                    for (int i = occur; i < size; i++)
                        hasLoop[indices.get(i)] = 1;
                    return true;
                }
            }
        } while (index != startIndex);
        return false;
    }
}