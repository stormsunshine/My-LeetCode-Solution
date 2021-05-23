class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        List<Integer> indices = new ArrayList<Integer>();
        int length = s.length();
        if (s.charAt(length - 1) != '0')
            return false;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '0')
                indices.add(i);
        }
        int size = indices.size();
        boolean[] visited = new boolean[size];
        visited[0] = true;
        int curr = 0, next = 0;
        while (curr < size) {
            while (curr < size && !visited[curr])
                curr++;
            if (curr == size)
                return false;
            int currIndex = indices.get(curr);
            while (next < size && indices.get(next) - currIndex < minJump)
                next++;
            while (next < size && indices.get(next) - currIndex <= maxJump) {
                visited[next] = true;
                next++;
            }
            curr++;
        }
        return visited[size - 1];
    }
}