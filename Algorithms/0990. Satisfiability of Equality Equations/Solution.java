class Solution {
    public boolean equationsPossible(String[] equations) {
        Map<Character, Set<Character>> equalMap = new HashMap<Character, Set<Character>>();
        Map<Character, Set<Character>> unequalMap = new HashMap<Character, Set<Character>>();
        for (String equation : equations) {
            char var1 = equation.charAt(0), var2 = equation.charAt(3);
            if (equation.charAt(1) == '=') {
                Set<Character> equalSet1 = equalMap.getOrDefault(var1, new HashSet<Character>());
                equalSet1.add(var1);
                Set<Character> equalSet2 = equalMap.getOrDefault(var2, new HashSet<Character>());
                equalSet2.add(var2);
                equalSet1.addAll(equalSet2);
                equalSet2.addAll(equalSet1);
                for (char var : equalSet1)
                    equalMap.put(var, equalSet1);
                for (char var : equalSet2)
                    equalMap.put(var, equalSet2);
            } else if (var1 == var2)
                return false;
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                char var1 = equation.charAt(0), var2 = equation.charAt(3);
                Set<Character> equalSet = equalMap.getOrDefault(var1, new HashSet<Character>());
                if (equalSet.contains(var2))
                    return false;
            }
        }
        return true;
    }
}