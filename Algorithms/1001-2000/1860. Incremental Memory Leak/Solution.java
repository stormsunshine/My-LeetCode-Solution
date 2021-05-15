class Solution {
    public int[] memLeak(int memory1, int memory2) {
        int time = 0;
        boolean flag = true;
        while (flag) {
            time++;
            if (memory1 < time && memory2 < time)
                flag = false;
            else {
                if (memory1 >= memory2)
                    memory1 -= time;
                else
                    memory2 -= time;
            }
        }
        return new int[]{time, memory1, memory2};
    }
}