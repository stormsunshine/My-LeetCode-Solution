class Solution {
    public int findComplement(int num) {
        int power = (int) (Math.log(num) / Math.log(2));
        long max = (long) Math.pow(2, power + 1) - 1;
        return (int) (max - num);
    }
}