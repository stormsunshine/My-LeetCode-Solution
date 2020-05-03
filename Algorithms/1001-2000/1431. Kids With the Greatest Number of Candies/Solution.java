class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int length = candies.length;
        int max = candies[0];
        for (int i = 1; i < length; i++)
            max = Math.max(max, candies[i]);
        List<Boolean> list = new ArrayList<Boolean>();
        for (int i = 0; i < length; i++) {
            int total = candies[i] + extraCandies;
            list.add(total >= max);
        }
        return list;
    }
}