class Solution {
    public boolean canTransform(String start, String end) {
        if (start == null || end == null || start.length() != end.length())
            return false;
        List<Integer> indices1 = getLRIndices(start);
        List<Integer> indices2 = getLRIndices(end);
        if (indices1.size() != indices2.size())
            return false;
        int size = indices1.size();
        for (int i = 0; i < size; i++) {
            int index1 = indices1.get(i), index2 = indices2.get(i);
            if (index1 > 0 && index2 < 0 || index1 < 0 && index2 > 0 || index1 > index2)
                return false;
        }
        return true;
    }

    public List<Integer> getLRIndices(String str) {
        List<Integer> indices = new ArrayList<Integer>();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c == 'L')
                indices.add(-i - 1);
            else if (c == 'R')
                indices.add(i + 1);
        }
        return indices;
    }
}