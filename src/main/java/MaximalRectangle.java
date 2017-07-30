import java.util.ArrayList;
import java.util.Stack;


/*
 * https://leetcode.com/problems/maximal-rectangle/description/
 * @author luzheng, @date 7/29/17 11:01 PM
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[] histogram = new int[matrix[0].length];
        int result = 0;

        for (char[] row : matrix) {
            updateHistogram(histogram, row);
            result = Math.max(result, findMaxRectangleInHistogram(histogram));
        }

        return result;
    }

    private void updateHistogram(int[] histogram, char[] oneRow) {
        for (int i = 0; i < histogram.length; i++) {
            if (oneRow[i] == '1') {
                histogram[i]++;
            } else {
                histogram[i] = 0;
            }
        }
    }

    private int findMaxRectangleInHistogram (int[] histogram) {
        Stack<HistBar> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i <= histogram.length; i++) {
            // simulate a virtual bar with height at the end
            int currentBarHeight = i < histogram.length ? histogram[i] : 0;
            HistBar currentBar = new HistBar(currentBarHeight, i);

            while(!stack.empty() && stack.peek().getHeight() > currentBar.getHeight()) {
                HistBar bar = stack.pop();
                int temp = bar.getHeight() * (i - bar.getPosition());
                result = Math.max(result, temp);
                currentBar.setPosition(bar.getPosition());
            }
            stack.push(currentBar);
        }

        return result;
    }

    class HistBar {
        private int _height;
        private int _position;

        HistBar(int height, int position) {
            this._height = height;
            this._position = position;
        }

        int getHeight() { return this._height; }
        int getPosition() { return this._position; }
        void setPosition(int p) { this._position = p; }
    }
}
