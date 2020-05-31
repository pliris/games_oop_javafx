package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.Chess;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static ru.job4j.chess.firuges.Cell.*;

public class BishopBlackTest {

    @Test
    public void whenPositionStartThenC8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell expected = bishopBlack.position();
        assertThat(expected, is (Cell.C8));
    }

    @Test
    public void whenCopyStartTheD7() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Figure expected = bishopBlack.copy(Cell.D7);
        assertThat(expected.position(), is (Cell.D7));
    }
    @Test
    public void whenWayFromC1ThenG5() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        Cell [] steps = bishopBlack.way(C1, G5);
        Cell[] expected = new Cell[] {D2, E3, F4, G5};
        assertArrayEquals(expected, steps);
    }

    @Test
    public void whenWayFromE5ThenA1() {
        BishopBlack bishopBlack = new BishopBlack(E5);
        Cell [] steps = bishopBlack.way(E5, A1);
        Cell[] expected = new Cell[] {D4, C3, B2, A1};
        assertArrayEquals(expected, steps);
    }
}