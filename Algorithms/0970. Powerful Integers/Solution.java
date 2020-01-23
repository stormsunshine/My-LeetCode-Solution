class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> xList = new ArrayList<Integer>();
        List<Integer> yList = new ArrayList<Integer>();
        int xNum = 1, yNum = 1;
        if (x == 1)
            xList.add(1);
        else {
            while (xNum <= bound) {
                xList.add(xNum);
                xNum *= x;
            }
        }
        if (y == 1)
            yList.add(1);
        else {
            while (yNum <= bound) {
                yList.add(yNum);
                yNum *= y;
            }
        }
        List<Integer> powerfulIntegers = new ArrayList<Integer>();
        int xSize = xList.size(), ySize = yList.size();
        for (int i = 0; i < xSize; i++) {
            int numX = xList.get(i);
            for (int j = 0; j < ySize; j++) {
                int numY = yList.get(j);
                int sum = numX + numY;
                if (sum > bound)
                    break;
                if (!powerfulIntegers.contains(sum))
                    powerfulIntegers.add(sum);
            }
        }
        Collections.sort(powerfulIntegers);
        return powerfulIntegers;
    }
}