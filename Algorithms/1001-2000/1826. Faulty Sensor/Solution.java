class Solution {
    public int badSensor(int[] sensor1, int[] sensor2) {
        int length = sensor1.length;
        int index = 0;
        while (index < length && sensor1[index] == sensor2[index])
            index++;
        if (index >= length - 1)
            return -1;
        while (index < length - 1 && sensor1[index] == sensor2[index + 1])
            index++;
        return index == length - 1 ? 1 : 2;
    }
}