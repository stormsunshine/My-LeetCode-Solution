class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2))
            return true;
        String[] array1 = sentence1.split(" ");
        String[] array2 = sentence2.split(" ");
        int length1 = array1.length, length2 = array2.length;
        if (length1 == length2) {
            for (int i = 0; i < length1; i++) {
                if (!array1[i].equals(array2[i]))
                    return false;
            }
            return true;
        } else if (length1 < length2)
            return areSentencesSimilar(array1, array2);
        else
            return areSentencesSimilar(array2, array1);
    }

    public boolean areSentencesSimilar(String[] array1, String[] array2) {
        int length1 = array1.length, length2 = array2.length;
        int difference = length2 - length1;
        int[] indices = new int[length1];
        for (int i = 0; i < length1; i++)
            indices[i] = i + difference;
        for (int i = 0; i <= length1; i++) {
            boolean flag = true;
            for (int j = 0; j < length1; j++) {
                int index = indices[j];
                if (!array1[j].equals(array2[index])) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return true;
            if (i < length1)
                indices[i] -= difference;
        }
        return false;
    }
}