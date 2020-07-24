class Solution {
    public int closestToTarget(int[] arr, int target) {
        int difference = Math.abs(arr[0] - target);
        List<Integer> valid = new ArrayList<Integer>();
        valid.add(arr[0]);
        for (int num : arr) {
            List<Integer> validNew = new ArrayList<Integer>();
            validNew.add(num);
            int last = num;
            difference = Math.min(difference, Math.abs(num - target));
            for (int prev : valid) {
                int curr = prev & num;
                if (curr != last) {
                    validNew.add(curr);
                    difference = Math.min(difference, Math.abs(curr - target));
                    last = curr;
                }
            }
            valid = validNew;
        }
        return difference;
    }
}