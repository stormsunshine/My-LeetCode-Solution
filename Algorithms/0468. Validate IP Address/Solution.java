class Solution {
    public String validIPAddress(String IP) {
        if (IP.indexOf('.') >= 0)
            return isValidIPv4(IP) ? "IPv4" : "Neither";
        else if (IP.indexOf(':') >= 0)
            return isValidIPv6(IP) ? "IPv6" : "Neither";
        else
            return "Neither";
    }

    public boolean isValidIPv4(String ip) {
        int ipLength = ip.length();
        if (ip.charAt(0) == '.' || ip.charAt(ipLength - 1) == '.')
            return false;
        if (ip.indexOf('+') >= 0 || ip.indexOf('-') >= 0)
            return false;
        String[] array = ip.split("\\.");
        if (array.length != 4)
            return false;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            String numStr = array[i];
            if (numStr.length() == 0 || numStr.length() > 3 || numStr.length() > 1 && numStr.charAt(0) == '0')
                return false;
            try {
                int num = Integer.parseInt(numStr);
                if (num > 255)
                    return false;
            } catch (NumberFormatException ex) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidIPv6(String ip) {
        int ipLength = ip.length();
        if (ip.charAt(0) == ':' || ip.charAt(ipLength - 1) == ':')
            return false;
        String[] array = ip.split(":");
        if (array.length != 8)
            return false;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            String numStr = array[i];
            if (numStr.length() == 0 || numStr.length() > 4)
                return false;
            int curLength = numStr.length();
            for (int j = 0; j < curLength; j++) {
                char c = numStr.charAt(j);
                if (Character.isDigit(c))
                    continue;
                else if (Character.isLetter(c)) {
                    if (c > 'F' && c < 'a' || c > 'f')
                        return false;
                } else
                    return false;
            }
        }
        return true;
    }
}