class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int roomsCount = warehouse.length;
        int[] validWarehouse = new int[roomsCount];
        int leftValid = Integer.MAX_VALUE;
        for (int i = 0; i < roomsCount; i++) {
            leftValid = Math.min(leftValid, warehouse[i]);
            validWarehouse[i] = Math.max(validWarehouse[i], leftValid);
        }
        int rightValid = Integer.MAX_VALUE;
        for (int i = roomsCount - 1; i >= 0; i--) {
            rightValid = Math.min(rightValid, warehouse[i]);
            validWarehouse[i] = Math.max(validWarehouse[i], rightValid);
        }
        int maxBoxes = 0;
        Arrays.sort(boxes);
        Arrays.sort(validWarehouse);
        int boxesCount = boxes.length;
        for (int i = 0, j = 0; i < boxesCount && j < roomsCount; i++) {
            while (j < roomsCount && boxes[i] > validWarehouse[j])
                j++;
            if (j < roomsCount && boxes[i] <= validWarehouse[j]) {
                maxBoxes++;
                j++;
            }
        }
        return maxBoxes;
    }
}