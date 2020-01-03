class Solution {
    public String simplifyPath(String path) {
        while (path.indexOf("//") >= 0)
            path = path.replaceAll("//", "/");
        if (path.charAt(path.length() - 1) == '/')
            path = path.substring(0, path.length() - 1);
        if (path.length() > 0 && path.charAt(0) == '/')
            path = path.substring(1);
        String[] pathArray = path.split("/");
        List<String> pathList = new ArrayList<String>();
        int size = 0;
        int length = pathArray.length;
        for (int i = 0; i < length; i++) {
            String dir = pathArray[i];
            if (dir.equals("."))
                continue;
            else if (dir.equals("..")) {
                if (size > 0) {
                    pathList.remove(size - 1);
                    size--;
                }
            } else {
                pathList.add(dir);
                size++;
            }
        }
        StringBuffer simplifyPathSB = new StringBuffer();
        for (int i = 0; i < size; i++) {
            simplifyPathSB.append("/");
            simplifyPathSB.append(pathList.get(i));
        }
        if (simplifyPathSB.length() == 0)
            simplifyPathSB.append("/");
        String simplifyPath = simplifyPathSB.toString();
        return simplifyPath;
    }
}