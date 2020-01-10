class Solution {
    public int distributeCandies(int[] candies) {
        int length = candies.length;
        int numOfCandies = length / 2;
        Set<Integer> set = new HashSet<Integer>();
        for (int candy : candies)
            set.add(candy);
        return Math.min(numOfCandies, set.size());
    }
}