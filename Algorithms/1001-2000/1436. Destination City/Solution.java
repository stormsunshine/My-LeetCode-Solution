class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> srcSet = new HashSet<String>();
        for (List<String> path : paths) {
            String src = path.get(0);
            srcSet.add(src);
        }
        for (List<String> path : paths) {
            String dst = path.get(1);
            if (!srcSet.contains(dst))
                return dst;
        }
        return "";
    }
}