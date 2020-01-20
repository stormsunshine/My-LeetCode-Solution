class Solution {
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        StringBuffer sb = new StringBuffer(String.valueOf(num));
        int length = sb.length();
        for (int i = length - 3; i > 0; i -= 3)
            sb.insert(i, ',');
        String[] array = sb.toString().split(",");
        StringBuffer wordsSB = new StringBuffer();
        int groups = array.length;
        String[] groupNames = {"", " Thousand", " Million", " Billion"};
        for (int i = 0; i < groups; i++) {
            int curNum = Integer.parseInt(array[groups - 1 - i]);
            if (curNum > 0) {
                String numWords = numToWords(curNum);
                wordsSB.insert(0, numWords + groupNames[i]);
            }
        }
        String words = wordsSB.toString().trim();
        return words;
    }

    public String numToWords(int num) {
        String[] numberWords = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"};
        String[] teensWords = {" Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
        String[] tensWords = {"", "", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
        int hundreds = num / 100;
        int tens = num % 100 / 10;
        int ones = num % 10;
        StringBuffer sb = new StringBuffer();
        if (hundreds > 0)
            sb.append(numberWords[hundreds] + " Hundred");
        if (tens > 0) {
            if (tens == 1)
                sb.append(teensWords[ones]);
            else
                sb.append(tensWords[tens]);
        }
        if (ones > 0 && tens != 1)
            sb.append(numberWords[ones]);
        return sb.toString();
    }
}