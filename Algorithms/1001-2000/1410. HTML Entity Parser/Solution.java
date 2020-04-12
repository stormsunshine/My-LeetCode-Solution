class Solution {
    public String entityParser(String text) {
        StringBuffer parse = new StringBuffer();
        StringBuffer temp = new StringBuffer();
        boolean flag = false;
        int length = text.length();
        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            if (flag) {
                temp.append(c);
                if (c == ';') {
                    flag = false;
                    String specialCharacter = getSpecialCharacter(temp.toString());
                    parse.append(specialCharacter);
                    temp.setLength(0);
                }
            } else {
                if (c == '&') {
                    flag = true;
                    temp.append(c);
                } else
                    parse.append(c);
            }
        }
        if (temp.length() > 0)
            parse.append(temp.toString());
        return parse.toString();
    }

    public String getSpecialCharacter(String str) {
        if (str.equals("&quot;"))
            return "\"";
        else if (str.equals("&apos;"))
            return "\'";
        else if (str.equals("&amp;"))
            return "&";
        else if (str.equals("&gt;"))
            return ">";
        else if (str.equals("&lt;"))
            return "<";
        else if (str.equals("&frasl;"))
            return "/";
        else
            return str;
    }
}