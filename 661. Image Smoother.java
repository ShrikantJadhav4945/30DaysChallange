class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];

        // Directions for the 8 neighbors and itself
        int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;

                // Check all 9 positions (itself + neighbors)
                for (int k = 0; k < 9; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];

                    // Check if the neighbor is within bounds
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        sum += img[x][y];
                        count++;
                    }
                }

                // Compute the average and store in the result
                result[i][j] = sum / count;
            }
        }

        return result;
    }
}
