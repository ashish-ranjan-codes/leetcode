class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;
        int n = points.length;
        for (int i = 0; i < n; ++i) {
            int[] p1 = points[i];
            for (int j = i + 1; j < n; ++j) {
                int[] p2 = points[j];
                for (int k = j + 1; k < n; ++k) {
                    int[] p3 = points[k];
                    double area = Math.abs(
                        p1[0] * (p2[1] - p3[1]) +
                        p2[0] * (p3[1] - p1[1]) +
                        p3[0] * (p1[1] - p2[1])
                    ) / 2.0;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}