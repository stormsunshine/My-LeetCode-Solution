class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int roomsCount = warehouse.length;
        int[] validWarehouse = new int[roomsCount];
        validWarehouse[0] = warehouse[0];
        for (int i = 1; i < roomsCount; i++)
            validWarehouse[i] = Math.min(validWarehouse[i - 1], warehouse[i]);
        int maxBoxes = 0;
        Arrays.sort(boxes);
        int boxesCount = boxes.length;
        for (int i = 0, j = roomsCount - 1; i < boxesCount && j >= 0; i++) {
            while (j >= 0 && boxes[i] > validWarehouse[j])
                j--;
            if (j >= 0 && boxes[i] <= validWarehouse[j]) {
                maxBoxes++;
                j--;
            }
        }
        return maxBoxes;
    }
}