class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int side = minutesToTest / minutesToDie + 1;
        int min = (int) Math.ceil(Math.log(buckets) / Math.log(side));
        return min;
    }
}