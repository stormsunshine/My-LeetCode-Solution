class Solution {
    public List<String> braceExpansionII(String expression) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer(expression);
        Set<String> set = new HashSet<String>();
        StringBuffer sb = new StringBuffer();
        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (str.indexOf('{') == -1)
                set.add(str);
            else {
                int index = 0;
                int left = 0, right = 0;
                while (str.charAt(index) != '}') {
                    if (str.charAt(index) == '{')
                        left = index;
                    index++;
                }
                right = index;
                String leftStr = str.substring(0, left);
                String rightStr = str.substring(right + 1);
                String[] array = str.substring(left + 1, right).split(",");
                for (String midStr : array) {
                    sb.setLength(0);
                    sb.append(leftStr);
                    sb.append(midStr);
                    sb.append(rightStr);
                    queue.offer(sb.toString());
                }
            }
        }
        List<String> list = new ArrayList<String>(set);
        Collections.sort(list);
        return list;
    }
}