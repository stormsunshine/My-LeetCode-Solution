class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0, count10 = 0;
        int length = bills.length;
        for (int i = 0; i < length; i++) {
            int bill = bills[i];
            if (bill == 5)
                count5++;
            else if (bill == 10) {
                count10++;
                if (count5 == 0)
                    return false;
                else
                    count5--;
            } else if (bill == 20) {
                if (count10 == 0) {
                    if (count5 < 3)
                        return false;
                    else
                        count5 -= 3;
                } else {
                    if (count5 == 0)
                        return false;
                    else {
                        count10--;
                        count5--;
                    }
                }
            }
        }
        return true;
    }
}