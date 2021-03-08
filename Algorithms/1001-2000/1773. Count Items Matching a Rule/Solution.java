class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for (List<String> item : items) {
            String type = item.get(0), color = item.get(1), name = item.get(2);
            if ("type".equals(ruleKey) && type.equals(ruleValue))
                count++;
            else if ("color".equals(ruleKey) && color.equals(ruleValue))
                count++;
            else if ("name".equals(ruleKey) && name.equals(ruleValue))
                count++;
        }
        return count;
    }
}