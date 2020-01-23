class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
    	List<Integer> tmp = new ArrayList<Integer>();
    	tracebace(n, list, tmp);
    	return list;
    }

	public static void tracebace(int n, List<List<Integer>> list, List<Integer> tmp) {
        if (n == 1 && tmp.size() > 1) {
			list.add(new ArrayList<Integer>(tmp));
			return;
		}
        for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				if (tmp.size() == 0 || i >= tmp.get(tmp.size() - 1)) {
				    tmp.add(i);
				    tracebace(n / i,  list, tmp);
				    tmp.remove(tmp.size() - 1);
				}
			}
		}
    }
}