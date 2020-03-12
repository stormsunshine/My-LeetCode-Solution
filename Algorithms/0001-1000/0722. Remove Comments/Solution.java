class Solution {
    public List<String> removeComments(String[] source) {
        List<String> code = new ArrayList<String>();
        boolean inCommentBlock = false;
        StringBuffer row = new StringBuffer();
        int linesCount = source.length;
        for (int i = 0; i < linesCount; i++) {
            if (!inCommentBlock)
                row = new StringBuffer();
            char[] lineArray = source[i].toCharArray();
            int length = lineArray.length;
            for (int j = 0; j < length; j++) {
                if (inCommentBlock) {
                    if (j < length - 1 && lineArray[j] == '*' && lineArray[j + 1] == '/') {
                        inCommentBlock = false;
                        j++;
                    }
                } else {
                    if (j < length - 1 && lineArray[j] == '/') {
                        if (lineArray[j + 1] == '*') {
                            inCommentBlock = true;
                            j++;
                        } else if (lineArray[j + 1] == '/')
                            break;
                    }
                    if (!inCommentBlock)
                        row.append(lineArray[j]);
                }
            }
            if (!inCommentBlock && row.length() > 0)
                code.add(row.toString());
        }
        return code;
    }
}