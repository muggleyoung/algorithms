public class Percolation {
    private int n;
    private int[] roots;
    private boolean[][] opened;
    private int openPositions;

    private int top;
    private int bottom;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n can not be less than 0");
        }
        this.n = n;

        this.opened = new boolean[n + 1][n + 1];
        this.roots = new int[n * n + 2];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int index = getIndex(i, j);
                roots[index] = index;
                opened[i][j] = false;
            }
        }

        top = 0;
        bottom = n * n + 1;
        roots[top] = top;
        roots[bottom] = bottom;

        this.openPositions = 0;
    }

    public void open(int row, int col) {
        this.opened[row][col] = true;
        this.openPositions += 1;

        int index1 = getIndex(row, col);

        if (row == 1) {
            connect(index1, top);
        }
        if (row == n) {
            connect(index1, bottom);
        }
        if ((row > 1) && (isOpen(row - 1, col))) {
            int index2 = getIndex(row - 1, col);
            connect(index1, index2);
        }
        if ((row < n) && (isOpen(row + 1, col))) {
            int index2 = getIndex(row + 1, col);
            connect(index1, index2);
        }
        if ((col > 1) && (isOpen(row, col - 1))) {
            int index2 = getIndex(row, col - 1);
            connect(index1, index2);
        }
        if ((col < n) && (isOpen(row, col + 1))) {
            int index2 = getIndex(row, col + 1);
            connect(index1, index2);
        }
    }

    public boolean isOpen(int row, int col) {
        return this.opened[row][col];
    }

    public boolean isFull(int row, int col) {
        int index = row * col;
        return (isOpen(row, col) && (findRoot(index) >= 1 && findRoot(index) <= n));
    }

    private void connect(int index1, int index2) {
        int root1 = findRoot(index1);
        int root2 = findRoot(index2);

        if (root1 == top || root1 == bottom) {
            roots[root2] = root1;
        } else if (root2 == top || root2 == bottom) {
            roots[root1] = root2;
        } else {
            roots[root1] = root2;
        }
    }

    private int getIndex(int row, int col) {
        return (row - 1) * n + col;
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
        return findRoot(top) == findRoot(bottom);
    }

    // test client (optional)
    public static void main(String[] args) {

    }
}