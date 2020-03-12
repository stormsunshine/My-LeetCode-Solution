/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int num = 100;
        while (num >= 40) {
            int num1 = rand7() - 1;
            int num2 = rand7() - 1;
            num = num1 * 7 + num2;
        }
        int randNum = num / 4 + 1;
        return randNum;
    }
}