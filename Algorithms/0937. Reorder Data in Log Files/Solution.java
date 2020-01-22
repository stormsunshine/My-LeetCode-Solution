class Solution {
    public String[] reorderLogFiles(String[] logs) {
        int length = logs.length;
        for (int i = 1; i < length; i++) {
            String log = logs[i];
            int insertIndex = 0;
            for (int j = i - 1; j >= 0; j--) {
                String curLog = logs[j];
                if (compare(curLog, log) <= 0) {
                    insertIndex = j + 1;
                    break;
                }
                logs[j + 1] = logs[j];
            }
            logs[insertIndex] = log;
        }
        return logs;
    }

    public int compare(String log1, String log2) {
        String[] array1 = log1.split(" ");
        String[] array2 = log2.split(" ");
        String str1 = array1[1], str2 = array2[1];
        boolean isLetter1 = Character.isLetter(str1.charAt(0)), isLetter2 = Character.isLetter(str2.charAt(0));
        if (isLetter1 && isLetter2) {
            int space1 = log1.indexOf(' '), space2 = log2.indexOf(' ');
            String identifier1 = log1.substring(0, space1), identifier2 = log2.substring(0, space2);
            String letters1 = log1.substring(space1 + 1), letters2 = log2.substring(space2 + 1);
            if (letters1.compareTo(letters2) != 0)
                return letters1.compareTo(letters2);
            else
                return identifier1.compareTo(identifier2);
        } else if (isLetter1)
            return -1;
        else if (isLetter2)
            return 1;
        else
            return 0;
    }
}