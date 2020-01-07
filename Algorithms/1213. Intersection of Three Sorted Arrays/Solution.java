class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> intersection = new ArrayList<Integer>();
        int length1 = arr1.length, length2 = arr2.length, length3 = arr3.length;
        int index1 = 0, index2 = 0, index3 = 0;
        while (index1 < length1 && index2 < length2 && index3 < length3) {
            int num1 = arr1[index1], num2 = arr2[index2], num3 = arr3[index3];
            if (num1 == num2 && num1 == num3) {
                intersection.add(num1);
                index1++;
                index2++;
                index3++;
            } else {
                int increment1 = 0, increment2 = 0, increment3 = 0;
                if (num1 < num2 || num1 < num3)
                    increment1 = 1;
                if (num2 < num1 || num2 < num3)
                    increment2 = 1;
                if (num3 < num1 || num3 < num2)
                    increment3 = 1;
                index1 += increment1;
                index2 += increment2;
                index3 += increment3;
            }
        }
        return intersection;
    }
}