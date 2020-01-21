class Solution {
    public String similarRGB(String color) {
        int red = Integer.parseInt(color.substring(1, 3), 16);
        int green = Integer.parseInt(color.substring(3, 5), 16);
        int blue = Integer.parseInt(color.substring(5, 7), 16);
        int closestRed = 0, closestGreen = 0, closestBlue = 0;
        for (int i = 0; i <= 0xff; i += 0x11) {
            int redDifference = Math.abs(red - i);
            int greenDifference = Math.abs(green - i);
            int blueDifference = Math.abs(blue - i);
            if (redDifference < Math.abs(red - closestRed))
                closestRed = i;
            if (greenDifference < Math.abs(green - closestGreen))
                closestGreen = i;
            if (blueDifference < Math.abs(blue - closestBlue))
                closestBlue = i;
        }
        String similarRGB = "#" + toHex(closestRed) + toHex(closestGreen) + toHex(closestBlue);
        return similarRGB;
    }

    public String toHex(int num) {
        String hex = "";
        while (num > 0) {
            int remainder = num % 16;
            String curHex = remainder < 10 ? String.valueOf(remainder) : String.valueOf((char) (remainder - 10 + 'a'));
            hex = curHex + hex;
            num /= 16;
        }
        while (hex.length() < 2)
            hex = "0" + hex;
        return hex;
    }
}