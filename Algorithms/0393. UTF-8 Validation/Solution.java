class Solution {
    public boolean validUtf8(int[] data) {
        int length = data.length;
        int index = 0;
        while (index < length) {
            int beginByte = data[index];
            int curBytes = getBytes(beginByte);
            if (curBytes == 0 || index + curBytes > length)
                return false;
            for (int i = 1; i < curBytes; i++) {
                int nextByte = data[index + i];
                if ((nextByte >>> 6 & 0b10) != 0b10)
                    return false;
            }
            index += curBytes;
        }
        return true;
    }

    public int getBytes(int beginByte) {
        if (beginByte >>> 7 == 0)
            return 1;
        else if ((beginByte >>> 5 & 0b111) == 0b110)
            return 2;
        else if ((beginByte >>> 4 & 0b1111) == 0b1110)
            return 3;
        else if ((beginByte >>> 3 & 0b11111) == 0b11110)
            return 4;
        else
            return 0;
    }
}