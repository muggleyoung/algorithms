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
            String[] site = lines.get(i).split(" ");
            int row = Integer.parseInt(site[0]);
            int column = Integer.parseInt(site[1]);
            percolation.open(row, column);
        }
        return percolation;
    }

}