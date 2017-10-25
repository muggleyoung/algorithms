import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PercolationTest {

    @Test
    void input1NoPercolation() {
        String fileName = "/Users/rca/workspace/practice/algorithms/percolation/percolation-test/input1-no.txt";
        Percolation percolation = run(fileName);
        assertFalse(percolation.percolates());
        assertEquals(0, percolation.numberOfOpenSites());
    }

    @Test
    void input1Percolation() {
        String fileName = "/Users/rca/workspace/practice/algorithms/percolation/percolation-test/input1.txt";
        Percolation percolation = run(fileName);
        assertTrue(percolation.percolates());
        assertEquals(1, percolation.numberOfOpenSites());
    }

    @Test
    void input2NoPercolation() {
        String fileName = "/Users/rca/workspace/practice/algorithms/percolation/percolation-test/input2-no.txt";
        Percolation percolation = run(fileName);
        assertFalse(percolation.percolates());
        assertEquals(2, percolation.numberOfOpenSites());
    }

    @Test
    void input2Percolation() {
        String fileName = "/Users/rca/workspace/practice/algorithms/percolation/percolation-test/input2.txt";
        Percolation percolation = run(fileName);
        assertTrue(percolation.percolates());
        assertEquals(3, percolation.numberOfOpenSites());
    }

    @Test
    void input3Percolation() {
        String fileName = "/Users/rca/workspace/practice/algorithms/percolation/percolation-test/input3.txt";
        Percolation percolation = run(fileName);
        assertTrue(percolation.percolates());
        assertEquals(6, percolation.numberOfOpenSites());
    }

    @Test
    void input4Percolation() {
        String fileName = "/Users/rca/workspace/practice/algorithms/percolation/percolation-test/input4.txt";
        Percolation percolation = run(fileName);
        assertTrue(percolation.percolates());
        assertEquals(8, percolation.numberOfOpenSites());
    }

    @Test
    void input5Percolation() {
        String fileName = "/Users/rca/workspace/practice/algorithms/percolation/percolation-test/input5.txt";
        Percolation percolation = run(fileName);
        assertTrue(percolation.percolates());
        assertEquals(25, percolation.numberOfOpenSites());
    }

    @Test
    void input6Percolation() {
        String fileName = "/Users/rca/workspace/practice/algorithms/percolation/percolation-test/input6.txt";
        Percolation percolation = run(fileName);
        assertTrue(percolation.percolates());
        assertEquals(18, percolation.numberOfOpenSites());
    }

    @Test
    void input8DupsPercolation() {
        String fileName = "/Users/rca/workspace/practice/algorithms/percolation/percolation-test/input8-dups.txt";
        Percolation percolation = run(fileName);
        assertTrue(percolation.percolates());
        assertEquals(34, percolation.numberOfOpenSites());
    }

    @Test
    void input8NoPercolation() {
        String fileName = "/Users/rca/workspace/practice/algorithms/percolation/percolation-test/input8-no.txt";
        Percolation percolation = run(fileName);
        assertFalse(percolation.percolates());
        assertEquals(33, percolation.numberOfOpenSites());
    }

    @Test
    void input8Percolation() {
        String fileName = "/Users/rca/workspace/practice/algorithms/percolation/percolation-test/input8.txt";
        Percolation percolation = run(fileName);
        assertTrue(percolation.percolates());
        assertEquals(34, percolation.numberOfOpenSites());
    }

    @Test
    void input10NoPercolation() {
        String fileName = "/Users/rca/workspace/practice/algorithms/percolation/percolation-test/input10-no.txt";
        Percolation percolation = run(fileName);
        assertFalse(percolation.percolates());
        assertEquals(55, percolation.numberOfOpenSites());
    }

    private Percolation run(String fileName) {
        List<String> lines = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(lines::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int grid = Integer.parseInt(lines.get(0));
        Percolation percolation = new Percolation(grid);

        for (int i = 1; i < lines.size(); i++) {
            if (lines.get(i).isEmpty()) {
                continue;
            }
            String[] site = lines.get(i).trim().split("\\s+");
            int row = Integer.parseInt(site[0]);
            int column = Integer.parseInt(site[1]);
            percolation.open(row, column);
            percolation.isFull(row, column);
        }
        return percolation;
    }

}