class OrderedStream {
    int ptr;
    int n;
    Map<Integer, String> map;

    public OrderedStream(int n) {
        this.ptr = 1;
        this.n = n;
        this.map = new HashMap<Integer, String>();
    }
    
    public List<String> insert(int id, String value) {
        map.put(id, value);
        List<String> list = new ArrayList<String>();
        if (id == ptr) {
            for (int i = ptr; i <= n && map.containsKey(i); i++) {
                list.add(map.get(i));
                ptr = i + 1;
            }
        }
        return list;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */