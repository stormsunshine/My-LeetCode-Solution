class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, String> fileContentMap = new HashMap<String, String>();
        Map<String, List<String>> contentFilesMap = new HashMap<String, List<String>>();
        for (String path : paths) {
            String[] array = path.split(" ");
            String directory = array[0];
            if (directory.charAt(directory.length() - 1) != '/')
                directory += '/';
            int length = array.length;
            for (int i = 1; i < length; i++) {
                String fileNameContent = array[i];
                int leftParenthesisIndex = fileNameContent.indexOf('(');
                String fileName = fileNameContent.substring(0, leftParenthesisIndex);
                String content = fileNameContent.substring(leftParenthesisIndex);
                content = content.substring(1, content.length() - 1);
                String completeFileName = directory + fileName;
                fileContentMap.put(completeFileName, content);
                List<String> filesList = contentFilesMap.getOrDefault(content, new ArrayList<String>());
                filesList.add(completeFileName);
                contentFilesMap.put(content, filesList);
            }
        }
        List<List<String>> duplicates = new ArrayList<List<String>>();
        Set<String> keySet = contentFilesMap.keySet();
        for (String content : keySet) {
            List<String> filesList = contentFilesMap.getOrDefault(content, new ArrayList<String>());
            if (filesList.size() > 1)
                duplicates.add(filesList);
        }
        return duplicates;
    }
}