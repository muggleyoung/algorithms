import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int n;
    private boolean[][] opened;
    private int openPositions;
    private final WeightedQuickUnionUF weightedQuickUnionUF;

    private final int top;
    private final int bottom;

    public Percolation(int n) {

        if (n <= 0) {
            throw new IllegalArgumentException("n can not be less than 0");
        }

        this.n = n;
        this.weightedQuickUnionUF = new WeightedQuickUnionUF((n + 1) * (n + 1));
        this.opened = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                this.opened[i][j] = false;
            }
        }

        this.top = 0;
        this.bottom = n * n + 1;

        this.openPositions = 0;
    }

    public void open(int row, int col) {
        inRange(row, col);
        if (isOpen(row, col)) {
            return;
        }

        this.opened[row][col] = true;
        this.openPositions += 1;
        int index1 = getIndex(row, col);

        if (row == 1) {
            this.weightedQuickUnionUF.union(index1, top);
        }
        if (row == n) {
            this.weightedQuickUnionUF.union(index1, bottom);
        }
        if ((row > 1) && (isOpen(row - 1, col))) {
            int index2 = getIndex(row - 1, col);
            this.weightedQuickUnionUF.union(index1, index2);
        }
        if ((row < n) && (isOpen(row + 1, col))) {
            int index2 = getIndex(row + 1, col);
            this.weightedQuickUnionUF.union(index1, index2);
        }
        if ((col > 1) && (isOpen(row, col - 1))) {
            int index2 = getIndex(row, col - 1);
            this.weightedQuickUnionUF.union(index1, index2);
        }
        if ((col < n) && (isOpen(row, col + 1))) {
            int index2 = getIndex(row, col + 1);
            this.weightedQuickUnionUF.union(index1, index2);
        }
    }

    public boolean isOpen(int row, int col) {
        inRange(row, col);
        return this.opened[row][col];
    }

    public boolean isFull(int row, int col) {
        inRange(row, col);
        int index = getIndex(row, col);
        return (isOpen(row, col) && (this.weightedQuickUnionUF.connected(index, top)));
    }

    private int getIndex(int row, int col) {
        return (row - 1) * n + col;
    }

    private void inRange(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException("Illegal Number!");
        }
    }

    public int numberOfOpenSites() {
        return this.openPositions;
    }

    public boolean percolates() {
        return this.weightedQuickUnionUF.connected(top, bottom);
    }
}