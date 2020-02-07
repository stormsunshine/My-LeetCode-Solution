class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> intersectionList = new ArrayList<int[]>();
        int length1 = A.length, length2 = B.length;
        int index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            int[] interval1 = A[index1];
            int[] interval2 = B[index2];
            int intersectionLow = Math.max(interval1[0], interval2[0]);
            int intersectionHigh = Math.min(interval1[1], interval2[1]);
            if (intersectionLow <= intersectionHigh) {
                int[] curIntersection = {intersectionLow, intersectionHigh};
                intersectionList.add(curIntersection);
            }
            int high1 = interval1[1], high2 = interval2[1];
            if (high1 <= high2)
                index1++;
            if (high1 >= high2)
                index2++;
        }
        int size = intersectionList.size();
        int[][] intersectionArray = new int[size][2];
        for (int i = 0; i < size; i++) {
            int[] curIntersection = intersectionList.get(i);
            intersectionArray[i][0] = curIntersection[0];
            intersectionArray[i][1] = curIntersection[1];
        }
        return intersectionArray;
    }
}