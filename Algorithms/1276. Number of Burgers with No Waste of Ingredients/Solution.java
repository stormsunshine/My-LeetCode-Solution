class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> numbers = new ArrayList<Integer>();
        if (tomatoSlices % 2 != 0)
            return numbers;
        int halfTomatoSlices = tomatoSlices / 2;
        int totalJumbo = halfTomatoSlices - cheeseSlices;
        int totalSmall = cheeseSlices * 2 - halfTomatoSlices;
        if (totalJumbo >= 0 && totalSmall >= 0) {
            numbers.add(totalJumbo);
            numbers.add(totalSmall);
        }
        return numbers;
    }
}