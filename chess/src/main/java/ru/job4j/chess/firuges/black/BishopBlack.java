package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(dest.getX() - this.position().getX());
        Cell[] steps = new Cell[size];

        int deltaX = this.position.getX() < dest.getX() ? 1 : -1;

        int deltaY = this.position.getY() < dest.getY() ? 1 : -1;

        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(this.position.getX() + deltaX, this.position.getY() + deltaY);
            deltaX += deltaX > 0 ? 1 : -1;
            deltaY += deltaY > 0 ? 1 : -1;
        }
        return steps;

    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return dest.getX() - source.getX() == source.getY() - dest.getY();
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
