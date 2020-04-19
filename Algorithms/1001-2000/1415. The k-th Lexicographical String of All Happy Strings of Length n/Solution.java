class Solution {
    public String getHappyString(int n, int k) {
        if (n == 1) {
            if (k <= 3)
                return String.valueOf((char) ('a' + k - 1));
            else
                return "";
        }
        int max = 3 * (int) Math.pow(2, n - 1);
        if (k > max)
            return "";
        int groupSize = max / 3;
        int highest = (k - 1) / groupSize;
        int index = (k - 1) % groupSize;
        int[] array = toArray(highest, index, n);
        StringBuffer sb = new StringBuffer();
        char letter0 = (char) ('a' + array[0]);
        sb.append(letter0);
        char prevLetter = letter0;
        for (int i = 1; i < n; i++) {
            char letter = getNextLetter(array[i], prevLetter);
            sb.append(letter);
            prevLetter = letter;
        }
        return sb.toString();
    }

    public int[] toArray(int highest, int index, int length) {
        int[] array = new int[length];
        array[0] = highest;
        int position = length - 1;
        while (index > 0) {
            array[position] = index % 2;
            index /= 2;
            position--;
        }
        return array;
    }

    public char getNextLetter(int num, char prevLetter) {
        char letter = (char) ('a' + num);
        if (letter >= prevLetter)
            letter++;
        return letter;
    }
}