class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> palindromes = new ArrayList<String>();
        int canPermutePalindrome = canPermutePalindrome(s);
        if (canPermutePalindrome == -2)
            return palindromes;
        int length = s.length();
        if (canPermutePalindrome == -1) {
            char[] strArray = s.toCharArray();
            Arrays.sort(strArray);
            char[] charArray = new char[length / 2];
            for (int i = 0; i < length; i += 2)
                charArray[i / 2] = strArray[i];
            Arrays.sort(charArray);
            List<List<Character>> permutations = permuteUnique(charArray);
            int size = permutations.size();
            for (int i = 0; i < size; i++) {
                List<Character> permutation = permutations.get(i);
                int halfLength = permutation.size();
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < halfLength; j++)
                    sb.append(permutation.get(j));
                for (int j = halfLength - 1; j >= 0; j--)
                    sb.append(permutation.get(j));
                palindromes.add(sb.toString());
            }
        } else {
            char singleChar = (char) canPermutePalindrome;
            StringBuffer evenStr = new StringBuffer(s);
            int singleIndex = s.indexOf(singleChar);
            evenStr.deleteCharAt(singleIndex);
            length--;
            char[] strArray = evenStr.toString().toCharArray();
            Arrays.sort(strArray);
            char[] charArray = new char[length / 2];
            for (int i = 0; i < length; i += 2)
                charArray[i / 2] = strArray[i];
            Arrays.sort(charArray);
            List<List<Character>> permutations = permuteUnique(charArray);
            int size = permutations.size();
            for (int i = 0; i < size; i++) {
                List<Character> permutation = permutations.get(i);
                int halfLength = permutation.size();
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < halfLength; j++)
                    sb.append(permutation.get(j));
                sb.append(singleChar);
                for (int j = halfLength - 1; j >= 0; j--)
                    sb.append(permutation.get(j));
                palindromes.add(sb.toString());
            }
        }
        return palindromes;
    }

    public int canPermutePalindrome(String s) {
        int[] count = new int[128];
        char[] array = s.toCharArray();
        for (char c : array)
            count[c]++;
        int odd = -1;
        for (int i = 0; i < 128; i++) {
            int curCount = count[i];
            if (curCount % 2 != 0) {
                if (odd >= 0)
                    return -2;
                else
                    odd = i;
            }
        }
        return odd;
    }

    public List<List<Character>> permuteUnique(char[] charArray) {
        int length = charArray.length;
        List<List<Character>> permutations = new ArrayList<List<Character>>();
        List<Character> list = new ArrayList<Character>();
        for (int i = 0; i < length; i++)
            list.add(charArray[i]);
        permutations.add(list);
        char[] array = new char[length];
        for (int i = 0; i < length; i++)
            array[i] = charArray[i];
        nextPermutation(array);
        while (!Arrays.equals(charArray, array)) {
            List<Character> permutation = new ArrayList<Character>();
            for (int i = 0; i < length; i++)
                permutation.add(array[i]);
            permutations.add(permutation);
            nextPermutation(array);
        }
        return permutations;
    }

    public void nextPermutation(char[] array) {
        int length = array.length;
        int index = -1;
        char curChar = 128;
        for (int i = length - 1; i > 0; i--) {
            int difference = array[i] - array[i - 1];
            if (difference > 0) {
                index = i - 1;
                curChar = array[i - 1];
                break;
            }
        }
        if (index < 0) {
            Arrays.sort(array);
            return;
        }
        int nextIndex = -1;
        char nextChar = 255;
        for (int i = index + 1; i < length; i++) {
            if (array[i] > curChar && array[i] < nextChar) {
                nextIndex = i;
                nextChar = array[i];
            }
        }
        array[index] = nextChar;
        array[nextIndex] = curChar;
        Arrays.sort(array, index + 1, length);
    }
}