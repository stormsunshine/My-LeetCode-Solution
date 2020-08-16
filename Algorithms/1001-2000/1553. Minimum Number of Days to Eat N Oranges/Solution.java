class Solution {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int minDays(int n) {
        if (n <= 1)
            return n;
        if (map.containsKey(n))
            return map.get(n);
        int days = Math.min(minDays(n / 2) + n % 2 + 1, minDays(n / 3) + n % 3 + 1);
        map.put(n, days);
        return days;
    }
}