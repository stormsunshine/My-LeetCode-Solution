class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> parentChildrenMap = new HashMap<Integer, List<Integer>>();
        int size = pid.size();
        for (int i = 0; i < size; i++) {
            int parentId = ppid.get(i), childId = pid.get(i);
            List<Integer> children = parentChildrenMap.getOrDefault(parentId, new ArrayList<Integer>());
            children.add(childId);
            parentChildrenMap.put(parentId, children);
        }
        List<Integer> killedPid = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(kill);
        while (!queue.isEmpty()) {
            int curId = queue.poll();
            killedPid.add(curId);
            List<Integer> children = parentChildrenMap.getOrDefault(curId, new ArrayList<Integer>());
            for (int child : children)
                queue.offer(child);
        }
        return killedPid;
    }
}