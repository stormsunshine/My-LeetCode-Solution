class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuffer merge = new StringBuffer();
        int length1 = word1.length(), length2 = word2.length();
        int index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            char c1 = word1.charAt(index1), c2 = word2.charAt(index2);
            if (c1 > c2) {
                merge.append(c1);
                index1++;
            } else if (c1 < c2) {
                merge.append(c2);
                index2++;
            } else {
                int temp1 = index1 + 1, temp2 = index2 + 1;
                boolean flag = true;
                while (temp1 < length1 && temp2 < length2) {
                    if (word1.charAt(temp1) == word2.charAt(temp2)) {
                        temp1++;
                        temp2++;
                    } else if (word1.charAt(temp1) > word2.charAt(temp2)) {
                        merge.append(c1);
                        index1++;
                        flag = false;
                        break;
                    } else {
                        merge.append(c2);
                        index2++;
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    if (temp2 == length2) {
                        merge.append(c1);
                        index1++;
                    } else {
                        merge.append(c2);
                        index2++;
                    }
                }
            }
        }
        while (index1 < length1) {
            merge.append(word1.charAt(index1));
            index1++;
        }
        while (index2 < length2) {
            merge.append(word2.charAt(index2));
            index2++;
        }
        return merge.toString();
    }
}