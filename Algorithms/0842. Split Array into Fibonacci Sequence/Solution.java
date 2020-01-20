class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<Integer>();
        if (S == null || S.length() == 0)
            return list;
        int length = S.length();
        int firstMax = Math.min(length / 2, 10), secondMax = Math.min(length * 2 / 3, 20);
        for (int i = 1; i <= firstMax; i++) {
            if (i > 1 && S.charAt(0) == '0' || Long.parseLong(S.substring(0, i)) > Integer.MAX_VALUE)
                break;
            int secondMaxUpper = Math.min(secondMax, i + 11);
            for (int j = i + 1; j <= secondMaxUpper; j++) {
                List<Integer> splitIndices = new ArrayList<Integer>();
                String firstNumStr = S.substring(0, i);
                String secondNumStr = S.substring(i, j);
                splitIndices.add(i);
                splitIndices.add(j);
                if (secondNumStr.length() > 1 && secondNumStr.charAt(0) == '0')
                    break;
                StringBuffer sb = new StringBuffer(firstNumStr + secondNumStr);
                int prevIndex = j;
                while (sb.length() < length) {
                    long firstNum = Long.parseLong(firstNumStr);
                    long secondNum = Long.parseLong(secondNumStr);
                    long sum = firstNum + secondNum;
                    if (sum > Integer.MAX_VALUE)
                        break;
                    String sumStr = String.valueOf(sum);
                    sb.append(sumStr);
                    int index = prevIndex + sumStr.length();
                    if (index < length)
                        splitIndices.add(index);
                    prevIndex = index;
                    firstNumStr = secondNumStr;
                    secondNumStr = sumStr;
                }
                if (sb.toString().equals(S)) {
                    int size = splitIndices.size();
                    for (int k = size - 1; k >= 0; k--) {
                        int splitIndex = splitIndices.get(k);
                        sb.insert(splitIndex, ',');
                    }
                    String[] array = sb.toString().split(",");
                    int sequenceLength = array.length;
                    for (int k = 0; k < sequenceLength; k++)
                        list.add(Integer.parseInt(array[k]));
                    return list;
                }
            }
        }
        return list;
    }
}