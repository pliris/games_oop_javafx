package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.Chess;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

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
    public void whenWayFromC1Then

}