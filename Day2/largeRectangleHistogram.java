package Day2;

import java.util.*;

public class largeRectangleHistogram {

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Previous Smaller Element
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                    heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                left[i] = -1;
            else
                left[i] = stack.peek();

            stack.push(i);
        }

        stack.clear();

        // Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                    heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                right[i] = n;
            else
                right[i] = stack.peek();

            stack.push(i);
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
 
    public static void main(String[] args) {

        largeRectangleHistogram obj = new largeRectangleHistogram();

        int[] heights = {2,1,5,6,2,3};

        System.out.println(obj.largestRectangleArea(heights));
    }
}
