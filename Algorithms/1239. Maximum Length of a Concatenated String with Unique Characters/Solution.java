class Solution {
    public int maxLength(List<String> arr) {
        for (int i = arr.size() - 1; i >= 0; i--) {
            if (!isValid(arr.get(i)))
                arr.remove(i);
        }
        int maxLength = 0;
        for (String str : arr)
            maxLength = Math.max(maxLength, str.length());
        int size = arr.size();
        int maxCount = (int) Math.pow(2, size);
        for (int i = 0; i < maxCount; i++) {
            int[] array = indexToArray(i, size);
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < size; j++) {
                if (array[j] == 1)
                    sb.append(arr.get(j));
            }
            String str = sb.toString();
            if (isValid(str))
                maxLength = Math.max(maxLength, str.length());
        }
        return maxLength;
    }

    public boolean isValid(String str) {
        char[] array = str.toCharArray();
        boolean[] flags = new boolean[26];
        for (char c : array) {
            boolean flag = flags[c - 'a'];
            if (flag)
                return false;
            else
                flags[c - 'a'] = true;
        }
        return true;
    }

    public int[] indexToArray(int index, int length) {
        int[] array = new int[length];
        int position = length - 1;
        while (index > 0) {
            int remainder = index % 2;
            array[position--] = remainder;
            index /= 2;
        }
        return array;
    }
}