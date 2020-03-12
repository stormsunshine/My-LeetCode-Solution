class Solution {
    public List<String> ambiguousCoordinates(String S) {
        List<String> coordinatesList = new ArrayList<String>();
        int length = S.length();
        int left = 1, right = length - 1;
        for (int i = left + 1; i < right; i++) {
            String xCoordinateStr = S.substring(left, i);
            String yCoordinateStr = S.substring(i, right);
            List<String> xCoordinatesList = getPossibleCoordinates(xCoordinateStr);
            List<String> yCoordinatesList = getPossibleCoordinates(yCoordinateStr);
            for (String xCoordinate : xCoordinatesList) {
                for (String yCoordinate : yCoordinatesList) {
                    String coordinate = "(" + xCoordinate + ", " + yCoordinate + ")";
                    coordinatesList.add(coordinate);
                }
            }
        }
        return coordinatesList;
    }

    public List<String> getPossibleCoordinates(String coordinateStr) {
        List<String> coordinatesList = new ArrayList<String>();
        if (coordinateStr.length() == 1 || coordinateStr.charAt(0) != '0')
            coordinatesList.add(coordinateStr);
        int leadingZeros = 0;
        int length = coordinateStr.length();
        for (int i = 0; i < length; i++) {
            if (coordinateStr.charAt(i) == '0')
                leadingZeros++;
            else
                break;
        }
        if (leadingZeros < length && coordinateStr.charAt(length - 1) != '0') {
            int maxInsertionIndex = leadingZeros > 0 ? 1 : length - 1;
            for (int i = 1; i <= maxInsertionIndex; i++) {
                StringBuffer sb = new StringBuffer(coordinateStr);
                sb.insert(i, '.');
                coordinatesList.add(sb.toString());
            }
        }
        return coordinatesList;
    }
}