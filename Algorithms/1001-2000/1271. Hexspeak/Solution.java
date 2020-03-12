class Solution {
    public String toHexspeak(String num) {
        long decimal = Long.parseLong(num);
        String hex = toHex(decimal);
        hex = hex.toUpperCase();
        hex = hex.replaceAll("0", "O");
        hex = hex.replaceAll("1", "I");
        String validStr = "ABCDEFIO";
        char[] hexArray = hex.toCharArray();
        for (char c : hexArray) {
            if (validStr.indexOf(c) < 0)
                return "ERROR";
        }
        return hex;
    }

    public String toHex(long num) {
        String hex = "";
        while (num > 0) {
            int remainder = (int) (num % 16);
            String digit = remainder < 10 ? String.valueOf(remainder) : String.valueOf((char) ('A' + (remainder - 10)));
            hex = digit + hex;
            num /= 16;
        }
        return hex;
    }
}