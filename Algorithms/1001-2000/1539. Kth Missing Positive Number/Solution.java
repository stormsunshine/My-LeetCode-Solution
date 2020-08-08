class Solution {
    public int findKthPositive(int[] arr, int k) {
        List<Integer> list = new ArrayList<Integer>();
        int length = arr.length;
        int max = arr[length - 1];
        int index = 0;
        for (int i = 1; i < max; i++) {
            if (arr[index] == i)
                index++;
            else
                list.add(i);
        }
        int size = list.size();
        if (size >= k)
            return list.get(k - 1);
        else
            return max + k - size;
    }
}