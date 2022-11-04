package mcloudapps.connectFour;

import java.util.HashMap;
import java.util.Map;

import mcloudapps.utils.Direction;

public class Board {

    public static final int NCOLS = 7;
    public static final int NROWS = 6;

    public Map<Cell, Color> cells;
    public Cell lastCell;

    public Board() {
        this.cells = new HashMap<>();
        this.reset();
    }

    public void reset() {
        this.cells.clear();
        this.lastCell = null;
    }

    public void putToken(int column, Color color) {
        assert color != null;
        assert this.isColumnValid(column);
        assert this.isColumnFull(column);
        int row = 1;
        Cell cell = new Cell(row, column);
        while (row <= Board.NROWS && this.cells.containsKey(cell)) {
            cell.shift(Direction.NORTH);
            row++;
        }
        this.cells.put(cell, color);
        this.lastCell = cell;
    }

    public boolean isColumnValid(int column) {
        return column >= 1 && column <= Board.NCOLS;
    }

    public boolean isColumnFull(int column) {
        return this.cells.containsKey(new Cell(NROWS, column));
    }

    public boolean isBoardFull(){
        int full_columns = 1;
        for (int column = 1 ; column <= Board.NCOLS ; column++){
            if (this.isColumnFull(column)){
                full_columns++;
            }
        }
        return (full_columns == Board.NCOLS);
    }

    public void write() {
        Message.HORIZONTAL_LINE.writeln();
        for (int row = Board.NROWS; row >= 1 ; row--) {
            Message.VERTICAL_LINE.write();
            for (int col = 1; col <= Board.NCOLS; col++) {
                Cell cell = new Cell(row, col);
                if (this.cells.containsKey(cell)) {
                    Message.COLOR.writeColor(this.cells.get(cell).toString());
                } else {
                    Message.EMPTY.write();
                }
                Message.VERTICAL_LINE.write();
            }
            Message.NEW_LINE.write();
        }
        Message.HORIZONTAL_LINE.writeln();
    }
}
