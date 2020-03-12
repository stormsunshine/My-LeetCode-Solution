class Solution {
    public int maxRepOpt1(String text) {
        List<int[]>[] intervals = new List[26];
        for (int i = 0; i < 26; i++)
        	intervals[i] = new ArrayList<int[]>();
        char prevChar = 0;
        int begin = 0, end = 0;
        char[] array = text.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; i++) {
        	char c = array[i];
        	if (c != prevChar) {
        		if (prevChar != 0) {
        			int index = prevChar - 'a';
        			end = i - 1;
        			int[] interval = new int[2];
        			interval[0] = begin;
        			interval[1] = end;
        			intervals[index].add(interval);
        		}
        		begin = i;
        		end = i;
        	} else
        		end = i;
        	prevChar = c;
        }
        int lastIndex = prevChar - 'a';
        int[] lastInterval = new int[2];
        lastInterval[0] = begin;
        lastInterval[1] = end;
        intervals[lastIndex].add(lastInterval);
        int max = 1;
        for (int i = 0; i < 26; i++) {
        	List<int[]> currentIntervals = intervals[i];
        	int size = currentIntervals.size();
        	int currentMax = 1;
        	if (size == 1) {
        		int[] currentInterval = currentIntervals.get(0);
        		int currentLength = currentInterval[1] - currentInterval[0] + 1;
        		currentMax = Math.max(currentMax, currentLength);
        	} else if (size == 2) {
        		int[] currentInterval0 = currentIntervals.get(0);
        		int[] currentInterval1 = currentIntervals.get(1);
        		if (currentInterval1[0] - currentInterval0[1] == 2) {
        			int currentLength = currentInterval0[1] - currentInterval0[0] + 1 + currentInterval1[1] - currentInterval1[0] + 1;
        			currentMax = Math.max(currentMax, currentLength);
        		} else {
        			int currentLength = Math.max(currentInterval0[1] - currentInterval0[0] + 1, currentInterval1[1] - currentInterval1[0] + 1) + 1;
        			currentMax = Math.max(currentMax, currentLength);
        		}
        	} else {
        		for (int j = 1; j < size; j++) {
        			int[] currentInterval0 = currentIntervals.get(j - 1);
        			int[] currentInterval1 = currentIntervals.get(j);
        			if (currentInterval1[0] - currentInterval0[1] == 2) {
            			int currentLength = currentInterval0[1] - currentInterval0[0] + 1 + currentInterval1[1] - currentInterval1[0] + 1 + 1;
            			currentMax = Math.max(currentMax, currentLength);
            		} else {
            			int currentLength = Math.max(currentInterval0[1] - currentInterval0[0] + 1, currentInterval1[1] - currentInterval1[0] + 1) + 1;
            			currentMax = Math.max(currentMax, currentLength);
            		}
        		}
        	}
        	max = Math.max(max, currentMax);
        }
        return max;
    }
}