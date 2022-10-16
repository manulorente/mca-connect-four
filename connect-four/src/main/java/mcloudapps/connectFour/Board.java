package mcloudapps.connectFour;

public class Board {

    private static final int NCOLS = 7;
    private static final int NROWS = 6;
    private static final int NTOKENS = NCOLS * NROWS;

    private Color[][] board;
    private int tokens;

    public Board() {
        this.board = new Color[Board.NROWS][Board.NCOLS];
        this.tokens = (int) Board.NTOKENS/2;
        this.reset();
    }

    public int getNumberOfTokens() {
        return this.tokens;
    }

    public int getNumberOfRows() {
        return Board.NROWS;
    }

    public int getNumberOfColumns() {
        return Board.NCOLS;
    }

    public void reset() {
        for (int row = 0; row < Board.NROWS; row++) {
            for (int col = 0; col < Board.NCOLS; col++) {
                this.board[row][col] = Color.NONE;
            }
        }
    }

    public boolean isColumnValid(int columnIndex) {
        return columnIndex >= 1 && columnIndex <= Board.NCOLS;
    }

    public boolean isColumnFull(int columnIndex) {
        return this.board[0][columnIndex-1] == Color.NONE;
    }
    
    public boolean isBoardFull() {
        for (int col = 0; col < Board.NCOLS; col++) {
            if (this.board[0][col] == Color.NONE) {
                return false;
            }
        }
        return true;
    }

    public void putToken(int columnIndex, Color color) {
        this.board[this.getValidRow(columnIndex - 1)][columnIndex - 1] = color;
    }

    public int getValidRow(int columnIndex) {
        assert columnIndex >= 0 && columnIndex < Board.NCOLS;
        int row = Board.NROWS - 1;
        while (row >= 0 && this.board[row][columnIndex] != Color.NONE) {
            row--;
        }
        return row;
    }

    public Color getColor(int row, int col) {
        assert col >= 0 && col < Board.NCOLS;
        assert row >= 0 && row < Board.NROWS;
        return this.board[row][col];
    }

    public void write() {
        Message.HORIZONTAL_LINE.writeln();
        for (int row = 0; row < Board.NROWS; row++) {
            Message.VERTICAL_LINE.write();
            for (int col = 0; col < Board.NCOLS; col++) {
                getColor(row, col).write();
                Message.VERTICAL_LINE.write();
            }
            Message.NEW_LINE.write();
        }
        Message.HORIZONTAL_LINE.writeln();
    }
}
