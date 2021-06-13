class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int low = 0, high = removable.length;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isPossible(s, p, removable, mid))
                low = mid;
            else
                high = mid - 1;
        }
        return low;
    }

    public boolean isPossible(String s, String p, int[] removable, int k) {
        int[] removes = new int[k];
        for (int i = 0; i < k; i++)
            removes[i] = removable[i];
        Arrays.sort(removes);
        StringBuffer sb = new StringBuffer(s);
        for (int i = k - 1; i >= 0; i--)
            sb.deleteCharAt(removes[i]);
        return isSubsequence(p, sb.toString());
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;
        if (s.length() > t.length())
            return false;
        int sLength = s.length(), tLength = t.length();
        int sIndex = 0, tIndex = 0;
        while (sIndex < sLength && tIndex < tLength) {
            char sChar = s.charAt(sIndex), tChar = t.charAt(tIndex);
            if (sChar == tChar)
                sIndex++;
            tIndex++;
        }
        return sIndex == sLength;
    }
}