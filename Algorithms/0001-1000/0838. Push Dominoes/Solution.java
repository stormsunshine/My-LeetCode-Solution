class Solution {
    public String pushDominoes(String dominoes) {
        char[] array = dominoes.toCharArray();
        int length = array.length;
        List<Integer> indices = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            char c = array[i];
            if (c == 'L')
                indices.add(-i);
            else if (c == 'R')
                indices.add(i);
        }
        int size = indices.size();
        if (size == 0)
            return dominoes;
        int firstIndex = indices.get(0), lastIndex = indices.get(size - 1);
        if (firstIndex < 0) {
            for (int i = -firstIndex - 1; i >= 0; i--)
                array[i] = 'L';
        }
        if (lastIndex >= 0) {
            if (lastIndex > 0 || array[0] == 'R') {
                for (int i = lastIndex + 1; i < length; i++)
                    array[i] = 'R';
            }
        }
        for (int i = 1; i < size; i++) {
            int index1 = indices.get(i - 1), index2 = indices.get(i);
            if (index1 >= 0 && array[index1] == 'R' && index2 < 0) {
                index2 = Math.abs(index2);
                if (index1 % 2 == index2 % 2) {
                    int mid = (index2 - index1) / 2 + index1;
                    for (int j = index1 + 1; j < mid; j++)
                        array[j] = 'R';
                    for (int j = index2 - 1; j > mid; j--)
                        array[j] = 'L';
                } else {
                    int midLeft = (index2 - index1) / 2 + index1;
                    for (int j = index1 + 1; j <= midLeft; j++)
                        array[j] = 'R';
                    for (int j = index2 - 1; j > midLeft; j--)
                        array[j] = 'L';
                }
            } else if (index1 >= 0 && array[index1] == 'R') {
                for (int j = index1 + 1; j < index2; j++)
                    array[j] = 'R';
            } else if (index2 < 0) {
                for (int j = -index1 + 1; j < -index2; j++)
                    array[j] = 'L';
            }
        }
        return new String(array);
    }
}