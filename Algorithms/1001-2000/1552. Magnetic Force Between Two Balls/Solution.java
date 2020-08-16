class Solution {
    public int maxDistance(int[] position, int m) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int num : position)
            set.add(num);
        Arrays.sort(position);
        int length = position.length;
        int low = 1, high = position[length - 1] - position[0];
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (possible(set, m, mid))
                low = mid;
            else
                high = mid - 1;
        }
        return low;
    }

    public boolean possible(TreeSet<Integer> set, int m, int distance) {
        int prevPosition = set.first();
        m--;
        while (m > 0) {
            Integer currPosition = set.ceiling(prevPosition + distance);
            if (currPosition == null)
                return false;
            else {
                prevPosition = currPosition;
                m--;
            }
        }
        return true;
    }
}