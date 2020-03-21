class MajorityChecker {
    int[] arr;

	public MajorityChecker(int[] arr) {
		this.arr = arr;
	}

	public int query(int left, int right, int threshold) {
		int[] count = new int[20001];
		for (int i = left; i <= right; i++) {
            int num = arr[i];
			if (++count[num] == threshold)
				return num;
		}
		return -1;
	}
}

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */