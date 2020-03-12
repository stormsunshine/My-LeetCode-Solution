class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] array = new int[num_people];
        int index = 0;
        int curCandies = 1;
        while (candies > 0) {
            int num = Math.min(curCandies, candies);
            array[index] += num;
            candies -= num;
            curCandies++;
            index = (index + 1) % num_people;
        }
        return array;
    }
}