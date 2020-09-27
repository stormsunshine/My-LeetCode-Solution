class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int maximumRequestsCount = 0;
        int requestsLength = requests.length;
        int counts = 1 << requestsLength;
        for (int i = 0; i < counts; i++) {
            boolean[] selections = getSelections(requestsLength, i);
            if (isPossible(n, requests, selections)) {
                int requestsCount = 0;
                for (boolean selection : selections) {
                    if (selection)
                        requestsCount++;
                }
                maximumRequestsCount = Math.max(maximumRequestsCount, requestsCount);
            }
        }
        return maximumRequestsCount;
    }

    public boolean[] getSelections(int requestsLength, int index) {
        boolean[] selections = new boolean[requestsLength];
        for (int i = 0; i < requestsLength && index > 0; i++) {
            selections[i] = index % 2 == 1;
            index /= 2;
        }
        return selections;
    }

    public boolean isPossible(int n, int[][] requests, boolean[] selections) {
        int[] outdegrees = new int[n];
        int[] indegrees = new int[n];
        int requestsLength = requests.length;
        for (int i = 0; i < requestsLength; i++) {
            if (selections[i]) {
                int[] request = requests[i];
                int from = request[0], to = request[1];
                outdegrees[from]++;
                indegrees[to]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (outdegrees[i] != indegrees[i])
                return false;
        }
        return true;
    }
}