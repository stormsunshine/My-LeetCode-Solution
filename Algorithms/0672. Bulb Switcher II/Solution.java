class Solution {
    public int flipLights(int n, int m) {
        int[] lights = new int[n];
        for (int i = 0; i < n; i++)
            lights[i] = 1;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(lights);
        for (int i = 0; i < m; i++) {
            int size = queue.size();
            Set<String> set = new HashSet<String>();
            for (int j = 0; j < size; j++) {
                int[] curLights = queue.poll();
                for (int k = 1; k <= 4; k++) {
                    int[] newLights = operateLights(curLights, k);
                    String newLightsStr = Arrays.toString(newLights);
                    if (set.add(newLightsStr))
                        queue.offer(newLights);
                }
            }
        }
        return queue.size();
    }

    public int[] operateLights(int[] lights, int operation) {
        int length = lights.length;
        int[] newLights = new int[length];
        System.arraycopy(lights, 0, newLights, 0, length);
        if (operation == 1) {
            for (int i = 0; i < length; i++)
                newLights[i] = 1 - newLights[i];
        } else if (operation == 2) {
            for (int i = 0; i < length; i += 2)
                newLights[i] = 1 - newLights[i];
        } else if (operation == 3) {
            for (int i = 1; i < length; i += 2)
                newLights[i] = 1 - newLights[i];
        } else if (operation == 4) {
            for (int i = 0; i < length; i += 3)
                newLights[i] = 1 - newLights[i];
        }
        return newLights;
    }
}