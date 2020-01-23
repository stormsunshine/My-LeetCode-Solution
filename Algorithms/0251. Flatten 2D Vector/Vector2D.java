class Vector2D {
    List<Integer> list;
    int size;
    int index;

    public Vector2D(int[][] v) {
        list = new ArrayList<Integer>();
        int length = v.length;
        for (int i = 0; i < length; i++) {
            int[] vector1D = v[i];
            int curLength = vector1D.length;
            for (int j = 0; j < curLength; j++)
                list.add(vector1D[j]);
        }
        size = list.size();
        index = 0;
    }
    
    public int next() {
        if (hasNext()) {
            int next = list.get(index);
            index++;
            return next;
        } else
            return -1;
    }
    
    public boolean hasNext() {
        return index < size;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */