class Solution {
    public String reformatNumber(String number) {
        StringBuffer digits = new StringBuffer();
        int length = number.length();
        for (int i = 0; i < length; i++) {
            char c = number.charAt(i);
            if (Character.isDigit(c))
                digits.append(c);
        }
        int digitsCount = digits.length();
        if (digitsCount <= 3)
            return digits.toString();
        if (digitsCount == 4)
            return digits.substring(0, 2) + "-" + digits.substring(2);
        int remainder = digitsCount % 3;
        if (remainder == 1)
            remainder += 3;
        int firstPartLength = digitsCount - remainder;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < firstPartLength; i += 3) {
            if (i > 0)
                sb.append('-');
            sb.append(digits.charAt(i));
            sb.append(digits.charAt(i + 1));
            sb.append(digits.charAt(i + 2));
        }
        if (remainder > 0) {
            sb.append('-');
            if (remainder == 4) {
                sb.append(digits.substring(firstPartLength, firstPartLength + 2));
                sb.append('-');
                sb.append(digits.substring(firstPartLength + 2));
            } else
                sb.append(digits.substring(firstPartLength));
        }
        return sb.toString();
    }
}