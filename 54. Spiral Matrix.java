import java.util.*;

class SprialMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0)
            return result;

        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++)
                result.add(matrix[top][i]);

            for (int i = top + 1; i <= bottom; i++)
                result.add(matrix[i][right]);

            for (int i = right - 1; i >= left && top != bottom; i--)
                result.add(matrix[bottom][i]);

            for (int i = bottom - 1; i > top && left != right; i--)
                result.add(matrix[i][left]);

            top++;
            left++;
            right--;
            bottom--;
        }

        return result;
    }

    public static void main(String[] args) {
        SprialMatrix sm = new SprialMatrix();
        // int[][] grid = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // int[][] grid = new int[][] { { 1, 2, 3, 4 } };
        // int[][] grid = new int[][] { { 1 }, { 2 }, { 3 }, { 4 } };
        int[][] grid = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

        System.out.println(sm.spiralOrder(grid));
    }
}