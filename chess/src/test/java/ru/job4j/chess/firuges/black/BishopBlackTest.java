package ru.job4j.chess.firuges.black;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
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
    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B1);
        Cell[] expected = new Cell[] {Cell.C2, Cell.D3, Cell.E4};
        Cell[] actual = bishopBlack.way(Cell.E4);
        assertThat(expected, is(actual));
    }
}
