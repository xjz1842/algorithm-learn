package algorithms.array;

/**
 * 最长子矩阵
 */
class MaxSubMatrix {

    // 利用矩阵压缩
    public static void main(String[] args) {
        int[][] matrix = { { 1, 0, 1 }, { 0, -2, 3 } };

        System.out.println(maxSubMatrixSumLessThanK(matrix, 2));
    }

    public static int maxSubMatrixSumLessThanK(int[][] matrix, int k) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                // 列
                for (int c = 0; c < matrix[j].length; c++) {
                    // 压缩到第一行数组
                    if (i != j) {
                        matrix[i][c] += matrix[j][c];
                    }
                }

                // 利用一维数组的值
                ans = Math.max(MaxSubArray.maxLength(matrix[i], k) * (j - i + 1), ans);
            }
        }
        return ans;
    }
}
