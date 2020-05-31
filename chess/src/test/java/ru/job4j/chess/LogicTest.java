package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void whenMoveC1ToH6ThenTrue() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = logic.move(Cell.C1, Cell.H6);
        assertThat(rsl, is(true));
    }
    @Ignore
    @Test
    public void whenMoveC1ToH6ThenFalse() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        logic.add(bishopBlack);
        BishopBlack bishopBlackEnemy = new BishopBlack(Cell.E3);
        logic.add(bishopBlackEnemy);
        boolean rst = logic.move(Cell.C1, Cell.H6);
        assertThat(rst, is(false));
    }
}