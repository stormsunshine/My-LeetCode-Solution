class Solution {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    TreeSet<Integer> set = new TreeSet<Integer>();

    public int minimumOneBitOperations(int n) {
        map.put(0, 0);
        int maxPow2 = 1;
        while (maxPow2 <= n){
            map.put(maxPow2, map.get(maxPow2 / 2) * 2 + 1);
            set.add(maxPow2);
            maxPow2 <<= 1;
        }
        return calculate(n);
    }

    public int calculate(int n) {
        if (!map.containsKey(n)) {
            int low = set.floor(n);
            int operations = calculate(low) - calculate(n - low);
            map.put(n, operations);
        }
        return map.get(n);
    }
}