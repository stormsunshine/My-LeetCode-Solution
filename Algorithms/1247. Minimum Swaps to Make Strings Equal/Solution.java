class Solution {
    public int minimumSwap(String s1, String s2) {
        List<Integer> difX = new ArrayList<Integer>();
        List<Integer> difY = new ArrayList<Integer>();
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (c1 != c2) {
                if (c1 == 'x')
                    difX.add(i);
                else
                    difY.add(i);
            }
        }
        int sizeX = difX.size(), sizeY = difY.size();
        if ((sizeX + sizeY) % 2 != 0)
            return -1;
        else if (sizeX % 2 == 0)
            return (sizeX + sizeY) / 2;
        else
            return (sizeX + sizeY) / 2 + 1;
    }
}