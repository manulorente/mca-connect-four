package mcloudapps.connectFour;

public class Result {

    private Board board;

    public Result(Board board) {
        assert board != null;
        this.board = board;
    }

    public Color getResult() {
        Color winner = null;
        for (int i = 0; i < this.board.getNumberOfRows(); i++) {
            for (int j = 0; j < this.board.getNumberOfColumns(); j++) {
                if (!this.board.getColor(i, j).isNull()) {
                    winner = this.board.getColor(i, j);
                    if (this.isWinner(winner)) {
                        return winner;
                    }
                }
            }
        }
        return null;
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
    
    public boolean isWinner(Turn turn) {
        Color color;
        if (!turn.getActivePlayer().isTokenAvailable()) {
            return false;
        }
        color = turn.getActivePlayer().getColor();
        return this.isWinner(color);
    }

    public boolean isWinner(Color color) {
        assert color != null;
        return this.isWinnerHorizontal(color) || this.isWinnerVertical(color) || this.isWinnerDiagonal(color);
    }

    private boolean isWinnerHorizontal(Color color) {
        for (int row = 0; row < this.board.getNumberOfRows(); row++) {
            for (int col = 0; col < this.board.getNumberOfColumns() - 3; col++) {
                if (this.board.getColor(row, col) == color && this.board.getColor(row, col + 1) == color && this.board.getColor(row, col + 2)== color
                        && this.board.getColor(row, col + 3) == color) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWinnerVertical(Color color) {
        for (int row = 0; row < this.board.getNumberOfRows() - 3; row++) {
            for (int col = 0; col < this.board.getNumberOfColumns(); col++) {
                if (this.board.getColor(row, col) == color && this.board.getColor(row + 1, col) == color && this.board.getColor(row + 2, col) == color
                        && this.board.getColor(row + 3, col) == color) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWinnerDiagonal(Color color) {
        return this.isWinnerDiagonalLeft(color) || this.isWinnerDiagonalRight(color);
    }
    
    private boolean isWinnerDiagonalLeft(Color color) {
        for (int row = 0; row < this.board.getNumberOfRows() - 3; row++) {
            for (int col = 0; col < this.board.getNumberOfColumns() - 3; col++) {
                if (this.board.getColor(row, col) == color && this.board.getColor(row + 1, col + 1) == color && this.board.getColor(row + 2, col + 2) == color
                        && this.board.getColor(row + 3, col + 3) == color) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWinnerDiagonalRight(Color color) {
        for (int row = 0; row < this.board.getNumberOfRows() - 3; row++) {
            for (int col = 3; col < this.board.getNumberOfColumns(); col++) {
                if (this.board.getColor(row, col) == color && this.board.getColor(row + 1, col - 1) == color && this.board.getColor(row + 2, col - 2) == color
                        && this.board.getColor(row + 3, col - 3) == color) {
                    return true;
                }
            }
        }
        return false;
    }
}
