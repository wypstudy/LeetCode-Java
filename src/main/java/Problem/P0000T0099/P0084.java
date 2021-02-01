package Problem.P0000T0099;

public class P0084 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length, maxArea = 0;
        for (int i = 0; i < len; i++) {
            int l = i;
            while (l > -1 && heights[l] >= heights[i]) l--;
            int r = i;
            while (r < len && heights[r] >= heights[i]) r++;
            int area = (r - l - 1) * heights[i];
            if (area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        P0084 solution = new P0084();
        int[] h1 = {2, 1, 5, 6, 2, 3};
        int[] h2 = {2, 1, 2};
        int[] h3 = {1};
        System.out.println(solution.largestRectangleArea(h1));
        System.out.println(solution.largestRectangleArea(h2));
        System.out.println(solution.largestRectangleArea(h3));
    }
}
