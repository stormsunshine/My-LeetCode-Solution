class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0)
            return new ArrayList<String>();
        Map<String, PriorityQueue<String>> graphMap = new HashMap<String, PriorityQueue<String>>();
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            PriorityQueue<String> priorityQueue = graphMap.getOrDefault(src, new PriorityQueue<String>());
            priorityQueue.add(dst);
            graphMap.put(src, priorityQueue);
        }
        List<String> itinerary = depthFirstSearch(graphMap, "JFK");
        return itinerary;
    }

    public List<String> depthFirstSearch(Map<String, PriorityQueue<String>> graphMap, String src) {
        List<String> itinerary = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(src);
        while (!stack.isEmpty()) {
            PriorityQueue<String> priorityQueue;
            while ((priorityQueue = graphMap.get(stack.peek())) != null && priorityQueue.size() > 0)
                stack.push(priorityQueue.poll());
            itinerary.add(stack.pop());
        }
        Collections.reverse(itinerary);
        return itinerary;
    }
}