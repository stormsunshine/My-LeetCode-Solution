class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		Map<Integer, String> map = new HashMap<Integer, String>();
        int length = values.length;
        for (int i = 0; i < length; i++)
            map.put(values[i], symbols[i]);
		int index = 0;
		String roman = "";
		while (num > 0 && index < length) {
			int current = values[index];
			int count = num / current;
			if (count > 0) {
				String currentStr = map.get(current);
				for (int i = 0; i < count; i++)
					roman += currentStr;
				num = num % current;
			}
			index++;
		}
		return roman;
	}
}