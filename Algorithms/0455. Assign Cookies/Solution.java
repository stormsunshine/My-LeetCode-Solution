class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int content = 0;
        int numOfChildren = g.length, numOfCookies = s.length;
        int childIndex = 0, cookieIndex = 0;
        while (childIndex < numOfChildren && cookieIndex < numOfCookies) {
            int child = g[childIndex], cookie = s[cookieIndex];
            if (child <= cookie) {
                childIndex++;
                cookieIndex++;
                content++;
            } else
                cookieIndex++;
        }
        return content;
    }
}