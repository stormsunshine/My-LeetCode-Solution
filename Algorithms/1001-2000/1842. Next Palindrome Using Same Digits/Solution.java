class Solution {
    public String nextPalindrome(String num) {
        char[] arr = num.toCharArray();
        int length = arr.length;
        boolean flag = nextPermutation(arr, length / 2);
        if (!flag)
            return "";
        StringBuffer sb = new StringBuffer(new String(arr, 0, (length + 1) / 2));
        for (int i = length / 2 - 1; i >= 0; i--)
            sb.append(sb.charAt(i));
        return sb.toString();
    }

    public boolean nextPermutation(char[] arr, int endIndex) {
        int changeIndex = -1;
        for (int i = endIndex - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                changeIndex = i;
                break;
            }
        }
        if (changeIndex < 0)
            return false;
        int nextIndex = -1;
        for (int i = endIndex - 1; i > changeIndex; i--) {
            if (arr[i] > arr[changeIndex]) {
                nextIndex = i;
                break;
            }
        }
        char temp = arr[changeIndex];
        arr[changeIndex] = arr[nextIndex];
        arr[nextIndex] = temp;
        reverse(arr, changeIndex + 1, endIndex - 1);
        return true;
    }

    public void reverse(char[] arr, int start, int end) {
        int low = start, high = end;
        while (low < high) {
            char temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
}