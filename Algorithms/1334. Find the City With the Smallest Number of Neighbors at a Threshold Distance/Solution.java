class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> distancesMap = new HashMap<Integer, List<int[]>>();
        for (int[] edge : edges) {
            int city1 = edge[0], city2 = edge[1], distance = edge[2];
            List<int[]> list1 = distancesMap.getOrDefault(city1, new ArrayList<int[]>());
            List<int[]> list2 = distancesMap.getOrDefault(city2, new ArrayList<int[]>());
            list1.add(new int[]{city2, distance});
            list2.add(new int[]{city1, distance});
            distancesMap.put(city1, list1);
            distancesMap.put(city2, list2);
        }
        int[] reachableCounts = new int[n];
        for (int i = 0; i < n; i++) {
            int[] distances = getDistance(n, i, distancesMap);
            for (int distance : distances) {
                if (distance > 0 && distance <= distanceThreshold)
                    reachableCounts[i]++;
            }
        }
        int minReachable = n - 1;
        for (int i = 0; i < n; i++)
            minReachable = Math.min(minReachable, reachableCounts[i]);
        int cityIndex = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (reachableCounts[i] == minReachable) {
                cityIndex = i;
                break;
            }
        }
        return cityIndex;
    }

    public int[] getDistance(int n, int source, Map<Integer, List<int[]>> distancesMap) {
        int[] distances = new int[n];
        for (int i = 0; i < n; i++)
            distances[i] = Integer.MAX_VALUE;
        distances[source] = 0;
        PriorityQueue<CityDistance> priorityQueue = new PriorityQueue<CityDistance>();
        priorityQueue.offer(new CityDistance(source, 0));
        while (!priorityQueue.isEmpty()) {
            CityDistance cityDistance = priorityQueue.poll();
            int city = cityDistance.city, distance = cityDistance.distance;
            if (distance > distances[city])
                continue;
            List<int[]> adjacentCities = distancesMap.getOrDefault(city, new ArrayList<int[]>());
            for (int[] adjacentCity : adjacentCities) {
                int nextCity = adjacentCity[0], nextDistance = adjacentCity[1];
                int newDistance = distance + nextDistance;
                if (newDistance < distances[nextCity]) {
                    distances[nextCity] = newDistance;
                    priorityQueue.offer(new CityDistance(nextCity, newDistance));
                }
            }
        }
        return distances;
    }
}

class CityDistance implements Comparable<CityDistance> {
    public int city;
    public int distance;

    public CityDistance(int city, int distance) {
        this.city = city;
        this.distance = distance;
    }

    public int compareTo(CityDistance cityDistance2) {
        return this.distance - cityDistance2.distance;
    }
}