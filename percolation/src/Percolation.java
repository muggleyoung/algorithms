public class Percolation {
    private int n;
    private int[] roots;
    private boolean[][] opened;
    private int openPositions;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n can not be less than 0");
        }
        this.n = n;

        this.opened = new boolean[n + 1][n + 1];
        this.roots = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                roots[((i - 1) * n) + j] = ((i - 1) * n) + j;
                opened[i][j] = false;
            }
        }

        this.openPositions = 0;
    }

    public void open(int row, int col) {
        this.opened[row][col] = true;
        this.openPositions += 1;

        int index1 = getIndex(row, col);

        if ((row != 1) && (isOpen(row - 1, col))) {
            int index2 = getIndex(row - 1, col);
            connect(index1, index2);
        }
        if ((row < n) && (isOpen(row + 1, col))) {
            int index2 = getIndex(row + 1, col);
            connect(index1, index2);
        }
        if ((col != 1) && (isOpen(row, col - 1))) {
            int index2 = getIndex(col - 1, col);
            connect(index1, index2);
        }
        if ((col < n) && (isOpen(row, col + 1))) {
            int index2 = getIndex(col + 1, col);
            connect(index1, index2);
        }
    }

    public boolean isOpen(int row, int col) {
        return this.opened[row][col];
    }

    public boolean isFull(int row, int col) {
        int index = row * col;
        return (findRoot(index) >= 1 || findRoot(index) <= n);
    }

    private void connect(int index1, int index2) {
        if (findRoot(index1) != findRoot(index2)) {
            roots[index1] = findRoot(index2);
        }
    }

    private int getIndex(int row1, int col1) {
        return row1 * col1;
    }

    private int findRoot(int i) {
        while (roots[i] != i) {
            i = roots[i];
        }
        return i;
    }

    public int numberOfOpenSites() {
        return this.openPositions;
    }

    public boolean percolates() {
        for (int j = 1; j <= n; j++) {
            if (opened[n][j] && isFull(n, j)) {
                return true;
            }
        }
        return false;
    }

    // test client (optional)
    public static void main(String[] args) {

    }
}