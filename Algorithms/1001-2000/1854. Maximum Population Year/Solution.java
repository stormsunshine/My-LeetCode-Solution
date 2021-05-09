class Solution {
    public int maximumPopulation(int[][] logs) {
        List<Integer> birthDeathList = new ArrayList<Integer>();
        for (int[] log : logs) {
            birthDeathList.add(log[0]);
            birthDeathList.add(-(log[1] - 1));
        }
        Collections.sort(birthDeathList, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                if (Math.abs(num1) != Math.abs(num2))
                    return Math.abs(num1) - Math.abs(num2);
                else
                    return num2 - num1;
            }
        });
        int maxYear = 0;
        int maxAlive = 0;
        int curAlive = 0;
        int size = birthDeathList.size();
        for (int i = 0; i < size; i++) {
            int year = birthDeathList.get(i);
            if (year > 0) {
                curAlive++;
                if (curAlive > maxAlive) {
                    maxYear = year;
                    maxAlive = curAlive;
                }
            } else
                curAlive--;
        }
        return maxYear;
    }
}