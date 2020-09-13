class Solution {
    public boolean isTransformable(String s, String t) {
        int length = s.length();
        int[] counts = new int[10];
        for (int i = 0; i < length; i++)
            counts[s.charAt(i) - '0']++;
        for (int i = 0; i < length; i++)
            counts[t.charAt(i) - '0']--;
        for (int i = 0; i < 10; i++) {
            if (counts[i] != 0)
                return false;
        }
        List[] locations = new List[10];
        for (int i = 0; i < 10; i++)
            locations[i] = new ArrayList<Integer>();
        for (int i = length - 1; i >= 0; i--)
            locations[s.charAt(i) - '0'].add(i);
        for (int i = 0; i < length; i++) {
            int digit = t.charAt(i) - '0';
            List<Integer> indices = locations[digit];
            int next = indices.remove(indices.size() - 1);
            for (int j = 0; j < digit; j++) {
                List<Integer> listJ = locations[j];
                int size = listJ.size();
                if (size > 0 && listJ.get(size - 1) < next)
                    return false;
            }
        }
        return true;
    }
}