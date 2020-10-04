class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int visiblePoints = 0;
        int x = location.get(0), y = location.get(1);
        List<Double> pointAngles = new ArrayList<Double>();
        for (List<Integer> point : points) {
            int pointX = point.get(0) - x, pointY = point.get(1) - y;
            if (pointX == 0 && pointY == 0)
                visiblePoints++;
            else if (pointX == 0) {
                if (pointY > 0)
                    pointAngles.add(90.0);
                else
                    pointAngles.add(270.0);
            } else if (pointY == 0) {
                if (pointX > 0)
                    pointAngles.add(0.0);
                else
                    pointAngles.add(180.0);
            } else {
                double radian = Math.abs(Math.atan(1.0 * pointY / pointX));
                double degrees = Math.toDegrees(radian);
                if (pointX < 0 && pointY > 0)
                    degrees = 180 - degrees;
                else if (pointX < 0 && pointY < 0)
                    degrees = 180 + degrees;
                else if (pointX > 0 && pointY < 0)
                    degrees = 360 - degrees;
                pointAngles.add(degrees);
            }
        }
        Collections.sort(pointAngles);
        int maxCount = 0;
        int size = pointAngles.size();
        for (int i = 0; i < size; i++)
            pointAngles.add(pointAngles.get(i) + 360);
        size *= 2;
        int start = 0, end = 0;
        while (end < size) {
            double degrees = pointAngles.get(end);
            while (start < end && degrees - pointAngles.get(start) > angle)
                start++;
            end++;
            maxCount = Math.max(maxCount, end - start);
        }
        visiblePoints += maxCount;
        return visiblePoints;
    }
}