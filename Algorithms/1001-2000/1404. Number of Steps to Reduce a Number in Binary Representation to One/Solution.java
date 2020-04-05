class Solution {
    public int numSteps(String s) {
        int steps = 0;
        StringBuffer sb = new StringBuffer(s);
        while (sb.length() > 1) {
            char lastChar = sb.charAt(sb.length() - 1);
            if (lastChar == '0')
                sb.deleteCharAt(sb.length() - 1);
            else
                sb = addOne(sb);
            steps++;
        }
        return steps;
    }

    public StringBuffer addOne(StringBuffer sb) {
        int length = sb.length();
        int lastZeroIndex = -1;
        for (int i = length - 1; i >= 0; i--) {
            if (sb.charAt(i) == '0') {
                lastZeroIndex = i;
                break;
            }
        }
        if (lastZeroIndex < 0) {
            for (int i = length - 1; i >= 0; i--)
                sb.setCharAt(i, '0');
            sb.insert(0, '1');
        } else {
            sb.setCharAt(lastZeroIndex, '1');
            for (int i = lastZeroIndex + 1; i < length; i++)
                sb.setCharAt(i, '0');
        }
        return sb;
    }
}