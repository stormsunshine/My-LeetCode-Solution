class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> closestElements = new ArrayList<Integer>();
        int count = 0;
        int length = arr.length;
        int index = binarySearch(arr, x);
        int index1 = -1, index2 = -1;
        if (index >= 0) {
            closestElements.add(arr[index]);
            count++;
            index1 = index - 1;
            index2 = index + 1;
        } else {
            index = -index - 1;
            index1 = index - 1;
            index2 = index;
        }
        while (count < k && index1 >= 0 && index2 < length) {
            int num1 = arr[index1], num2 = arr[index2];
            int compare = (num2 - x) - (x - num1);
            if (compare >= 0) {
                closestElements.add(num1);
                index1--;
            } else {
                closestElements.add(num2);
                index2++;
            }
            count++;
        }
        while (count < k && index1 >= 0) {
            int num1 = arr[index1];
            closestElements.add(num1);
            index1--;
            count++;
        }
        while (count < k && index2 < length) {
            int num2 = arr[index2];
            closestElements.add(num2);
            index2++;
            count++;
        }
        Collections.sort(closestElements);
        return closestElements;
    }

    public int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            int num = arr[mid];
            if (num == key)
                return mid;
            else if (num > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -low - 1;     
    }
}