class Solution {
    public List<Integer> sortArray(int[] nums) {
        return mergeSort(nums);
    }

    public List<Integer> mergeSort(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[0]);
            return list;
        } else {
            int halfLength = length / 2;
            int[] nums1 = new int[halfLength];
            int[] nums2 = new int[length - halfLength];
            for (int i = 0; i < halfLength; i++)
                nums1[i] = nums[i];
            for (int i = halfLength; i < length; i++)
                nums2[i - halfLength] = nums[i];
            List<Integer> list1 = mergeSort(nums1);
            List<Integer> list2 = mergeSort(nums2);
            return merge(list1, list2);
        }
    }

    public List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<Integer>();
        int size1 = list1.size(), size2 = list2.size();
        int index1 = 0, index2 = 0;
        while (index1 < size1 && index2 < size2) {
            int num1 = list1.get(index1), num2 = list2.get(index2);
            if (num1 <= num2) {
                mergedList.add(num1);
                index1++;
            } else {
                mergedList.add(num2);
                index2++;
            }
        }
        while (index1 < size1) {
            mergedList.add(list1.get(index1));
            index1++;
        }
        while (index2 < size2) {
            mergedList.add(list2.get(index2));
            index2++;
        }
        return mergedList;
    }
}