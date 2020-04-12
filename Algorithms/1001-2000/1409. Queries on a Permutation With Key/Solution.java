class Solution {
    public int[] processQueries(int[] queries, int m) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 1; i <= m; i++)
            list.add(i);
        int length = queries.length;
        int[] queryResults = new int[length];
        for (int i = 0; i < length; i++) {
            int query = queries[i];
            int index = list.indexOf(query);
            queryResults[i] = index;
            list.remove(new Integer(query));
            list.addFirst(query);
        }
        return queryResults;
    }
}