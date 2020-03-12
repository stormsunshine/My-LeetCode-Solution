class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] time = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        int prevTimestamp = 0;
        for (String log : logs) {
            String[] array = log.split(":");
            int id = Integer.parseInt(array[0]);
            String action = array[1];
            int timestamp = Integer.parseInt(array[2]);
            if (action.equals("start")) {
                if (!stack.isEmpty()) {
                    int prevId = stack.peek();
                    time[prevId] += timestamp - prevTimestamp;
                }
                stack.push(id);
            } else {
                timestamp++;
                stack.pop();
                time[id] += timestamp - prevTimestamp;
            }
            prevTimestamp = timestamp;
        }
        return time;
    }
}