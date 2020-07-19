package job4j.tictactoe;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        return this.fillBy(f -> f.hasMarkX(), 0, 0, 1, 0) ||
                this.fillBy(f -> f.hasMarkX(), 0, 0, 0, 1) ||
                this.fillBy(f -> f.hasMarkX(), 0, 0, 1, 1) ||
                this.fillBy(f -> f.hasMarkX(), this.table.length - 1, 0, -1, 1);
    }

    public boolean isWinnerO() {
        return this.fillBy(f -> f.hasMarkO(), 0, 0, 1, 0) ||
                this.fillBy(f -> f.hasMarkO(), 0, 0, 0, 1) ||
                this.fillBy(f -> f.hasMarkO(), 0, 0, 1, 1) ||
                this.fillBy(f -> f.hasMarkO(), this.table.length - 1, 0, -1, 1);
    }

    public boolean hasGap() {
        boolean gap = true;
        List<Figure3T> list = Arrays.stream(table)
                .flatMap(Arrays::stream)
                .filter(f -> !f.hasMarkX() || !f.hasMarkO())
                .collect(Collectors.toList());
        if (list.size() == 0) {
            gap = false;
        }
        return gap;
    }
}