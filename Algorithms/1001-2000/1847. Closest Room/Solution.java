class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int roomsCount = rooms.length;
        int queriesCount = queries.length;
        Arrays.sort(rooms, new Comparator<int[]>() {
            public int compare(int[] room1, int[] room2) {
                return room2[1] - room1[1];
            }
        });
        int[][] newQueries = new int[queriesCount][3];
        for (int i = 0; i < queriesCount; i++) {
            newQueries[i][0] = queries[i][0];
            newQueries[i][1] = queries[i][1];
            newQueries[i][2] = i;
        }
        Arrays.sort(newQueries, new Comparator<int[]>() {
            public int compare(int[] query1, int[] query2) {
                return query2[1] - query1[1];
            }
        });
        TreeSet<Integer> set = new TreeSet<Integer>();
        int roomIndex = 0;
        int[] answer = new int[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            int[] query = newQueries[i];
            int preferred = query[0], minSize = query[1], index = query[2];
            while (roomIndex < roomsCount && rooms[roomIndex][1] >= minSize) {
                set.add(rooms[roomIndex][0]);
                roomIndex++;
            }
            Integer floor = set.floor(preferred), ceiling = set.ceiling(preferred);
            if (floor == null && ceiling == null)
                answer[index] = -1;
            else if (floor == null)
                answer[index] = ceiling;
            else if (ceiling == null)
                answer[index] = floor;
            else {
                int difference1 = preferred - floor, difference2 = ceiling - preferred;
                if (difference1 <= difference2)
                    answer[index] = floor;
                else
                    answer[index] = ceiling;
            }
        }
        return answer;
    }
}