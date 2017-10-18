public class Percolation {
    private int n;
    private int[][] metric;
    private int openPositions;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n can not be less than 0");
        }
        this.n = n;

        this.metric = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                metric[i][j] = 0;
            }
        }

        this.openPositions = 0;
    }

    public void open(int row, int col) {
        this.metric[row][col] = 1;
        this.openPositions += 1;
    }

    public boolean isOpen(int row, int col) {
        return this.metric[row][col] == 1;
    }

    public boolean isFull(int row, int col) {
        return this.metric[row][col] == -1;
    }

    public int numberOfOpenSites() {
        return this.openPositions;
    }

    public boolean percolates() {
        int i = 0;
        while (i <= n) {
            if (isFull(n - 2, i) && isOpen(n - 1, i)) {
                return true;
            }
            i++;
        }
        return false;
    }

    // test client (optional)
    public static void main(String[] args) {

    }
}