package mcloudapps.connectFour;

import mcloudapps.utils.Cell;
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
            if (this.checkLine(this.board.lastCell, direction)) {
                return this.board.cells.get(this.board.lastCell);
            }
        }
        return null;
    }   

    private boolean checkLine(Cell cell, Direction direction) {
        assert cell != null;
        assert direction != null;
        if (isLine(cell, direction) || isLine(cell, direction.reverse())) {
            return true;
        }
        return false;
    }

    private boolean isLine(Cell originCell, Direction direction) {
        int inLineTokenCounter = 1;
        Cell nextCell = (Cell) originCell.clone();
        while (inLineTokenCounter < this.line_length){
            nextCell.shift(direction);               
            if (this.board.cells.containsKey(nextCell) && this.board.cells.get(nextCell).equals(this.board.cells.get(originCell))) {
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
