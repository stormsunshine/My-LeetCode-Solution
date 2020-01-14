class Solution {
    public String[] expand(String S) {
        S = S.replaceAll("\\{", " \\{");
        S = S.replaceAll("}", "} ");
        S = S.trim();
        String[] array = S.split(" ");
        Queue<String> queue = new LinkedList<String>();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            String curStr = array[i];
            if (curStr.indexOf('{') >= 0)
                curStr = curStr.substring(1, curStr.length() - 1);
            String[] curArray = curStr.split(",");
            int curSize = queue.size();
            if (curSize == 0) {
                for (String str : curArray)
                    queue.offer(str);
            } else {
                for (int j = 0; j < curSize; j++) {
                    String prev = queue.poll();
                    for (String str : curArray)
                        queue.offer(prev + str);
                }
            }
        }
        int size = queue.size();
        String[] words = new String[size];
        for (int i = 0; i < size; i++)
            words[i] = queue.poll();
        Arrays.sort(words);
        return words;
    }
}