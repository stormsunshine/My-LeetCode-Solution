class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        StringBuffer aBinarySB = new StringBuffer(Integer.toBinaryString(a));
        StringBuffer bBinarySB = new StringBuffer(Integer.toBinaryString(b));
        StringBuffer cBinarySB = new StringBuffer(Integer.toBinaryString(c));
        while (aBinarySB.length() < 32)
            aBinarySB.insert(0, '0');
        while (bBinarySB.length() < 32)
            bBinarySB.insert(0, '0');
        while (cBinarySB.length() < 32)
            cBinarySB.insert(0, '0');
        for (int i = 0; i < 32; i++) {
            char aChar = aBinarySB.charAt(i);
            char bChar = bBinarySB.charAt(i);
            char cChar = cBinarySB.charAt(i);
            if (cChar == '0') {
                if (aChar == '1')
                    flips++;
                if (bChar == '1')
                    flips++;
            } else {
                if (aChar == '0' && bChar == '0')
                    flips++;
            }
        }
        return flips;
    }
}