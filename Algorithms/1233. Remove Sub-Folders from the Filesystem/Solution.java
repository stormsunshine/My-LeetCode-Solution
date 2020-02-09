class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<Folder> roots = new ArrayList<Folder>();
        for (String folderName : folder) {
            if (roots.isEmpty()) {
                Folder newFolder = new Folder(folderName);
                roots.add(newFolder);
            } else {
                boolean flag = false;
                for (Folder root : roots) {
                    boolean addSubfolder = addSubfolder(root, folderName);
                    if (addSubfolder) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    Folder newFolder = new Folder(folderName);
                    roots.add(newFolder);
                }
            }
        }
        List<String> remainingFolders = new ArrayList<String>();
        for (Folder root : roots) {
            String rootName = root.folderName;
            remainingFolders.add(rootName);
        }
        return remainingFolders;
    }

    public boolean addSubfolder(Folder root, String folderName) {
        String rootName = root.folderName;
        if (!folderName.contains(rootName))
            return false;
        String[] rootNameArray = rootName.split("/");
        String[] folderNameArray = folderName.split("/");
        if (rootNameArray.length == folderNameArray.length)
            return false;
        else {
            root.addSubfolder(folderName);
            return true;
        }
    }
}

class Folder {
    String folderName;
    List<Folder> children;

    public Folder() {
        
    }

    public Folder(String folderName) {
        this.folderName = folderName;
        children = new ArrayList<Folder>();
    }

    public void addSubfolder(String subFolderName) {
        Folder subFolder = new Folder(subFolderName);
        children.add(subFolder);
    }
}