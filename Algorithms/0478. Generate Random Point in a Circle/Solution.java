class Solution {
    double radius;
    double x_center;
    double y_center;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }
    
    public double[] randPoint() {
        double radian = Math.random() * 2 * Math.PI;
        double curRadius = Math.sqrt(Math.random()) * radius;
        double x = x_center + curRadius * Math.cos(radian);
        double y = y_center + curRadius * Math.sin(radian);
        double[] point = {x, y};
        return point;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */