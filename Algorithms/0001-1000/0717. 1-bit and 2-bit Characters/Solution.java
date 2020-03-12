class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int length = bits.length;
        int index = 0;
        while (index < length) {
            if (index == length - 1)
                return true;
            int bit = bits[index];
            if (bit == 0)
                index++;
            else if (bit == 1)
                index += 2;
        }
        return false;
    }
}