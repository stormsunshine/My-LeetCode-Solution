class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int lowLength = low.length(), highLength = high.length();
        if (lowLength > highLength || lowLength == highLength && low.compareTo(high) > 0)
            return 0;
        if (lowLength == highLength) {
            List<String> strobogrammatics = findStrobogrammatic(lowLength);
            int lowIndex = binarySearch(strobogrammatics, low), highIndex = binarySearch(strobogrammatics, high);
            if (lowIndex < 0)
                lowIndex = -lowIndex - 1;
            if (highIndex < 0)
                highIndex = -highIndex - 2;
            return highIndex - lowIndex + 1;
        } else {
            int count = 0;
            for (int i = lowLength + 1; i < highLength; i++) {
                List<String> strobogrammatics = findStrobogrammatic(i);
                count += strobogrammatics.size();
            }
            List<String> lowStrobogrammatics = findStrobogrammatic(lowLength);
            List<String> highStrobogrammatics = findStrobogrammatic(highLength);
            int lowIndex = binarySearch(lowStrobogrammatics, low);
            if (lowIndex < 0)
                lowIndex = -lowIndex - 1;
            count += lowStrobogrammatics.size() - lowIndex;
            int highIndex = binarySearch(highStrobogrammatics, high);
            if (highIndex < 0)
                highIndex = -highIndex - 2;
            count += highIndex + 1;
            return count;
        }
    }

    public List<String> findStrobogrammatic(int n) {
        List<String> strobogrammatics = findStrobogrammaticWithZero(n);
        if (n == 1)
            return strobogrammatics;
        int size = strobogrammatics.size();
        for (int i = size - 1; i >= 0; i--) {
            if (strobogrammatics.get(i).charAt(0) == '0')
                strobogrammatics.remove(i);
        }
        Collections.sort(strobogrammatics);
        return strobogrammatics;
    }

    public List<String> findStrobogrammaticWithZero(int n) {
        List<String> strobogrammatics = new ArrayList<String>();
        if (n == 1) {
            strobogrammatics.add("0");
            strobogrammatics.add("1");
            strobogrammatics.add("8");
            return strobogrammatics;
        }
        if (n == 2) {
            strobogrammatics.add("00");
            strobogrammatics.add("11");
            strobogrammatics.add("69");
            strobogrammatics.add("88");
            strobogrammatics.add("96");
            return strobogrammatics;
        }
        List<String> prevStrobogrammatics = findStrobogrammaticWithZero(n - 2);
        for (String prevStrobogrammatic : prevStrobogrammatics) {
            strobogrammatics.add("0" + prevStrobogrammatic + "0");
            strobogrammatics.add("1" + prevStrobogrammatic + "1");
            strobogrammatics.add("6" + prevStrobogrammatic + "9");
            strobogrammatics.add("8" + prevStrobogrammatic + "8");
            strobogrammatics.add("9" + prevStrobogrammatic + "6");
        }
        return strobogrammatics;
    }

    public int binarySearch(List<String> list, String key) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            String str = list.get(mid);
            if (str.equals(key))
                return mid;
            else if (str.compareTo(key) > 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -low - 1;
    }
}