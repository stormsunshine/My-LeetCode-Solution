class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int length = s.length();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            array[i] = map.get(c);
        }
        for (int i = 0; i < length - 1; i++) {
            if (array[i] < array[i + 1])
                array[i] *= -1;
        }
        int num = 0;
        for (int val : array)
            num += val;
        return num;
    }
}