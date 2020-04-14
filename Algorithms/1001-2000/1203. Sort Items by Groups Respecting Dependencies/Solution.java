class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m;
                m++;
            }
        }
        Map<Integer, Set<Integer>> groupOrderMap = new HashMap<Integer, Set<Integer>>();
        Map<Integer, Set<Integer>> itemOrderMap = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < n; i++) {
            int currGroup = group[i];
            List<Integer> beforeList = beforeItems.get(i);
            for (int before : beforeList) {
                int prevGroup = group[before];
                Set<Integer> groupSet = groupOrderMap.getOrDefault(prevGroup, new HashSet<Integer>());
                groupSet.add(currGroup);
                groupOrderMap.put(prevGroup, groupSet);
                Set<Integer> itemSet = itemOrderMap.getOrDefault(before, new HashSet<Integer>());
                itemSet.add(i);
                itemOrderMap.put(before, itemSet);
            }
        }
        int[] groupIndegrees = new int[m];
        for (int i = 0; i < m; i++) {
            Set<Integer> set = groupOrderMap.getOrDefault(i, new HashSet<Integer>());
            for (int nextGroup : set) {
                if (nextGroup != i)
                    groupIndegrees[nextGroup]++;
            }
        }
        Queue<Integer> groupQueue = new LinkedList<Integer>();
        for (int i = 0; i < m; i++) {
            if (groupIndegrees[i] == 0)
                groupQueue.offer(i);
        }
        int[] groupsOrder = new int[m];
        int groupIndex = 0;
        while (!groupQueue.isEmpty()) {
            int currGroup = groupQueue.poll();
            groupsOrder[groupIndex] = currGroup;
            groupIndex++;
            Set<Integer> set = groupOrderMap.getOrDefault(currGroup, new HashSet<Integer>());
            for (int nextGroup : set) {
                groupIndegrees[nextGroup]--;
                if (groupIndegrees[nextGroup] == 0)
                    groupQueue.offer(nextGroup);
            }
        }
        if (groupIndex < m)
            return new int[0];
        Map<Integer, Set<Integer>> groupItemsMap = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < n; i++) {
            int currGroup = group[i];
            Set<Integer> set = groupItemsMap.getOrDefault(currGroup, new HashSet<Integer>());
            set.add(i);
            groupItemsMap.put(currGroup, set);
        }
        int[] itemIndegrees = new int[n];
        for (int i = 0; i < n; i++) {
            Set<Integer> set = itemOrderMap.getOrDefault(i, new HashSet<Integer>());
            for (int nextItem : set)
                itemIndegrees[nextItem]++;
        }
        int[] itemsOrder = new int[n];
        int itemIndex = 0;
        for (int i = 0; i < m; i++) {
            int currGroup = groupsOrder[i];
            Set<Integer> itemSet = groupItemsMap.getOrDefault(currGroup, new HashSet<Integer>());
            Queue<Integer> itemQueue = new LinkedList<Integer>();
            for (int item : itemSet) {
                if (itemIndegrees[item] == 0)
                    itemQueue.offer(item);
            }
            while (!itemQueue.isEmpty()) {
                int item = itemQueue.poll();
                itemsOrder[itemIndex] = item;
                itemIndex++;
                Set<Integer> set = itemOrderMap.getOrDefault(item, new HashSet<Integer>());
                for (int nextItem : set) {
                    itemIndegrees[nextItem]--;
                    if (itemIndegrees[nextItem] == 0 && group[nextItem] == currGroup)
                        itemQueue.offer(nextItem);
                }
            }
        }
        if (itemIndex < n)
            return new int[0];
        else
            return itemsOrder;
    }
}