class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0)
            return false;
        if (s.indexOf(' ') >= 0)
            return false;
        if (s.charAt(0) == '+' || s.charAt(0) == '-')
            s = s.substring(1);
        boolean point = false;
        boolean exponent = false;
        int length = s.length();
        char firstC = s.charAt(0), lastC = s.charAt(length - 1);
        if (firstC == 'e' || firstC == '+' || firstC == '-')
            return false;
        if (lastC == 'e' || lastC == '+' || lastC == '-')
            return false;
        if (firstC == '.' && (length == 1 || s.charAt(1) == 'e'))
            return false;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                continue;
            else if (c == '.') {
                if (exponent)
                    return false;
                if (!point)
                    point = true;
                else
                    return false;
            } else if (c == 'e') {
                if (!exponent)
                    exponent = true;
                else
                    return false;
                if (i == 1 && s.charAt(i - 1) == '.')
                    return false;
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) == 'e')
                    continue;
                else
                    return false;
            } else
                return false;
        }
        return true;
    }
}