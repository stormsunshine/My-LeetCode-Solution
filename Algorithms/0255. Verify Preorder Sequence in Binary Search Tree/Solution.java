class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int index = -1;
        int min = Integer.MIN_VALUE;
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            int element = preorder[i];
            if (element < min)
                return false;
            while (index >= 0 && element > preorder[index])
                min = preorder[index--];
            preorder[++index] = element;
        }
        return true;
    }
}