package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

public class LogicTest {

    @Test(expected = ImpossibleMoveException.class)
    public void testImpossibleMoveException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        bishopBlack.way(Cell.F4);
    }

    @Test(expected = OccupiedCellException.class)
    public void testOccupiedCellException()
            throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        logic.add(new PawnBlack(Cell.B7));
        logic.move(Cell.C8, Cell.A6);
    }

    @Test(expected = FigureNotFoundException.class)
    public void testFigureNotFoundException()
            throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.move(Cell.C8, Cell.A6);
    }
}
