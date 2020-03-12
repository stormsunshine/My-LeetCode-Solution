class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if (name == null || typed == null || name.length() == 0 || typed.length() == 0)
            return false;
        int nameLength = name.length(), typedLength = typed.length();
        int index2 = 0;
        for (int i = 0; i < nameLength; i++) {
            char c1 = name.charAt(i);
            if (c1 != typed.charAt(index2))
                return false;
            if (i == nameLength - 1 || c1 != name.charAt(i + 1)) {
                while (index2 < typedLength && typed.charAt(index2) == c1)
                    index2++;
            } else
                index2++;
            if (index2 == typedLength && i < nameLength - 1)
                return false;
        }
        return true;
    }
}