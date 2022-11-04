package mcloudapps.connectFour;

import mcloudapps.utils.Direction;

public class Result {

    private final int line_length = 4;
    private Board board;

    public Result(Board board) {
        assert board != null;
        this.board = board;
    }

    public Color getResult() {
        for (Direction direction : Direction.halfValues()) {
            if (this.isLine(this.board.lastCell, direction)) {
                return this.board.cells.get(this.board.lastCell);
            }
        }
        return null;
    }   

    private boolean isLine(Cell cell, Direction direction) {
        assert cell != null;
        assert direction != null;
        int inLineTokenCounter = 1;
        Cell nextCell = (Cell) cell.clone();
        Cell originCell = (Cell) cell.clone();
        while (inLineTokenCounter < this.line_length){
            nextCell.shift(direction);               
            if (this.board.cells.containsKey(nextCell) && this.board.cells.get(nextCell).equals(this.board.cells.get(cell))) {
                inLineTokenCounter++;
            } else {
                break;
            }
        }
        direction = direction.reverse();
        nextCell = originCell;
        while (inLineTokenCounter < this.line_length){
            nextCell.shift(direction);               
            if (this.board.cells.containsKey(nextCell) && this.board.cells.get(nextCell).equals(this.board.cells.get(cell))) {
                inLineTokenCounter++;
            } else {
                break;
            }
        }
        return inLineTokenCounter == this.line_length;
    }

    public boolean isGameOver()
    {
        return this.getResult() != null || this.board.isBoardFull();
    }

    public void writeResult(){
        if (this.getResult() == null || this.board.isBoardFull()) {
            Message.RESULT_DRAW.writeln();
        } else {
            Message.RESULT_WIN.writeln(this.getResult().toString());
        }
        Message.HORIZONTAL_LINE.writeln();
    }
}
