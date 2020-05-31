package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Objects;

public class    BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
            );
        }
            int size = Math.abs(dest.x - source.x);
            Cell[] steps = new Cell[size];
            int deltaX = (dest.x - source.x) / size;
            int deltaY = (dest.y - source.y) / size ;
            for (int index = 0; index < size; index++) {
                int x = index + deltaX;
                int y = index + deltaY;
                steps[index] = Cell.findBy(x + source.x,y + source.y);
            }
            return steps;
}

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rst = dest.x - source.x == dest.y - source.y;
        return rst;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
