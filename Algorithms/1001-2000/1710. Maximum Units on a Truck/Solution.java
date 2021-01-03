class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            public int compare(int[] boxType1, int[] boxType2) {
                if (boxType1[1] != boxType2[1])
                    return boxType2[1] - boxType1[1];
                else
                    return boxType2[0] - boxType1[0];
            }
        });
        int boxes = 0;
        int maxUnits = 0;
        int length = boxTypes.length;
        for (int i = 0; i < length && boxes < truckSize; i++) {
            int[] boxType = boxTypes[i];
            int num = boxType[0], units = boxType[1];
            num = Math.min(num, truckSize - boxes);
            boxes += num;
            maxUnits += units * num;
        }
        return maxUnits;
    }
}