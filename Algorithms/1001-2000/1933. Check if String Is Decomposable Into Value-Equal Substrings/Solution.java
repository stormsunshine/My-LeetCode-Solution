class Solution {
    public boolean isDecomposable(String s) {
        int length = s.length();
        if (length % 3 != 2)
            return false;
        boolean hasTwo = false;
        int count = 1;
        char prev = s.charAt(0);
        for (int i = 1; i < length; i++) {
            char curr = s.charAt(i);
            if (curr == prev)
                count++;
            else {
                int remainder = count % 3;
                if (remainder == 2) {
                    if (!hasTwo)
                        hasTwo = true;
                    else
                        return false;
                } else if (remainder == 1)
                    return false;
                count = 1;
                prev = curr;
            }
        }
        return true;
    }
}