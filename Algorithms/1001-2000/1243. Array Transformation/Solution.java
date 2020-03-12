class Solution {
    public List<Integer> transformArray(int[] arr) {
        int length = arr.length;
        boolean flag = true;
        while (flag) {
            flag = false;
            int[] change = new int[length];
            for (int i = 1; i < length - 1; i++) {
                if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    change[i] = 1;
                    flag = true;
                } else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    change[i] = -1;
                    flag = true;
                }
            }
            if (flag) {
                for (int i = 1; i < length - 1; i++)
                    arr[i] += change[i];
            }
        }
        List<Integer> finalList = new ArrayList<Integer>();
        for (int i = 0; i < length; i++)
            finalList.add(arr[i]);
        return finalList;
    }
}