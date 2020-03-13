class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T)
            return 0;
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        int length = routes.length;
        for (int i = 0; i < length; i++)
            Arrays.sort(routes[i]);
        Set<Integer> visitedSet = new HashSet<Integer>();
        Set<Integer> targetRoutes = new HashSet<Integer>();
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (intersect(routes[i], routes[j])) {
                    Set<Integer> set1 = map.getOrDefault(i, new HashSet<Integer>());
                    Set<Integer> set2 = map.getOrDefault(j, new HashSet<Integer>());
                    set1.add(j);
                    set2.add(i);
                    map.put(i, set1);
                    map.put(j, set2);
                }
            }
        }
        for (int i = 0; i < length; i++) {
            int indexS = binarySearch(routes[i], S);
            if (indexS >= 0) {
                visitedSet.add(i);
                queue.offer(new int[]{i, 0});
            }
            int indexT = binarySearch(routes[i], T);
            if (indexT >= 0)
                targetRoutes.add(i);
        }
        while (!queue.isEmpty()) {
            int[] routeDepth = queue.poll();
            int routeIndex = routeDepth[0];
            int depth = routeDepth[1] + 1;
            if (targetRoutes.contains(routeIndex))
                return depth;
            Set<Integer> nextRoutes = map.getOrDefault(routeIndex, new HashSet<Integer>());
            for (int nextRoute : nextRoutes) {
                if (visitedSet.add(nextRoute))
                    queue.offer(new int[]{nextRoute, depth});
            }
        }
        return -1;
    }

    public boolean intersect(int[] route1, int[] route2) {
        int index1 = 0, index2 = 0;
        int length1 = route1.length, length2 = route2.length;
        while (index1 < length1 && index2 < length2) {
            if (route1[index1] == route2[index2])
                return true;
            else if (route1[index1] < route2[index2])
                index1++;
            else
                index2++;
        }
        return false;
    }

    public int binarySearch(int[] array, int target) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = array[mid];
            if (num == target)
                return mid;
            else if (num > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -low - 1;
    }
}