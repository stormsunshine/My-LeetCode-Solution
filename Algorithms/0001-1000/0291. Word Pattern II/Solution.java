class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || str == null)
            return false;
        if (pattern.equals(str))
            return true;
        if (pattern.length() == 0 || str.length() == 0 || pattern.length() > str.length())
            return false;
        Map<Character, String> letterStringMap = new HashMap<Character, String>();
        Map<String, Character> stringLetterMap = new HashMap<String, Character>();
        return wordPatternMatch(pattern, str, letterStringMap, stringLetterMap);
    }

    public boolean wordPatternMatch(String pattern, String str, Map<Character, String> letterStringMap, Map<String, Character> stringLetterMap) {
        if (pattern.length() == 1) {
            char letter = pattern.charAt(0);
            String mapStr = letterStringMap.getOrDefault(letter, str);
            if (!str.equals(mapStr))
                return false;
            char mapLetter = stringLetterMap.getOrDefault(str, letter);
            if (letter != mapLetter)
                return false;
            return true;
        }
        char letter = pattern.charAt(0);
        int patternLength = pattern.length();
        int strIndexEnd = str.length() - patternLength + 1;
        for (int i = 1; i <= strIndexEnd; i++) {
            String substr = str.substring(0, i);
            String mapStr = letterStringMap.get(letter);
            boolean strFlag = mapStr == null;
            if (!strFlag && !substr.equals(mapStr))
                continue;
            Character mapLetter = stringLetterMap.get(substr);
            boolean letterFlag = mapLetter == null;
            if (!letterFlag && letter != mapLetter)
                continue;
            if (strFlag)
                letterStringMap.put(letter, substr);
            if (letterFlag)
                stringLetterMap.put(substr, letter);
            boolean isMatch = wordPatternMatch(pattern.substring(1), str.substring(i), letterStringMap, stringLetterMap);
            if (isMatch)
                return true;
            else {
                if (strFlag)
                    letterStringMap.remove(letter);
                if (letterFlag)
                    stringLetterMap.remove(substr);
            }
        }
        return false;
    }
}