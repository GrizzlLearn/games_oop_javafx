package ru.job4j.chess.firuges.black;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        assertThat(bishopBlack.position(), is(Cell.F8));
    }

    @Test
    public void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        BishopBlack expected = (BishopBlack) bishopBlack.copy(Cell.G2);
        assertThat(expected.position(), is(Cell.G2));
    }

    @Test
    public void testWayC8ToF5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell[] expected = new Cell[] {Cell.D7, Cell.E6, Cell.F5};
        Cell[] actual = bishopBlack.way(Cell.F5);
        assertThat(actual, is(expected));
    }

    @Test
    public void testWayF8ToA3() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Cell[] expected = new Cell[] {Cell.E7, Cell.D6, Cell.C5, Cell.B4, Cell.A3};
        Cell[] actual = bishopBlack.way(Cell.A3);
        assertThat(actual, is(expected));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testWayException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B1);
        bishopBlack.way(Cell.F4);
    }

    @Test
    public void testIsDiagonalC8ToF5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        boolean expected = bishopBlack.isDiagonal(bishopBlack.position(), Cell.F5);
        assertThat(expected, is(true));
    }

    @Test
    public void testIsDiagonalF8ToA3() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        boolean expected = bishopBlack.isDiagonal(bishopBlack.position(), Cell.A3);
        assertThat(expected, is(true));
    }

    @Test
    public void testIsDiagonalFalse() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B1);
        boolean expected = bishopBlack.isDiagonal(bishopBlack.position(), Cell.F4);
        assertThat(expected, is(false));
    }
}
