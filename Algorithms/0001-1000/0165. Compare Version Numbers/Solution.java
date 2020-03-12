import java.math.BigInteger;

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        int length1 = version1Array.length, length2 = version2Array.length;
        int minLength = Math.min(length1, length2);
        for (int i = 0; i < minLength; i++) {
            String revision1Str = version1Array[i], revision2Str = version2Array[i];
            BigInteger revision1 = new BigInteger(revision1Str), revision2 = new BigInteger(revision2Str);
            int compare = revision1.compareTo(revision2);
            if (compare != 0)
                return compare;
        }
        BigInteger zero = new BigInteger("0");
        if (length1 == length2)
            return 0;
        else if (minLength < length1) {
            for (int i = minLength; i < length1; i++) {
                String revision1Str = version1Array[i];
                BigInteger revision1 = new BigInteger(revision1Str);
                if (revision1.compareTo(zero) > 0)
                    return 1;
            }
            return 0;
        } else {
            for (int i = minLength; i < length2; i++) {
                String revision2Str = version2Array[i];
                BigInteger revision2 = new BigInteger(revision2Str);
                if (revision2.compareTo(zero) > 0)
                    return -1;
            }
            return 0;
        }
    }
}