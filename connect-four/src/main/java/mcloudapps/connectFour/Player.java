package mcloudapps.connectFour;

import mcloudapps.utils.Console;

public class Player {

    private Color color;
    private Board board;
    private int tokens;

    public Player(Color color, Board board, int tokens) {
        assert board != null;
        assert tokens > 3;
        assert this.isColorValid(color);

        this.color = color;
        this.board = board;
        this.tokens = tokens;
    }

    private boolean isColorValid(Color color) {
        return color != Color.NONE;
    }

    public Color getColor(){
        return this.color;
    }

    public void play(){
        Error error = Error.NULL;
        do {
            int column = Console.getInstance().readInt(Message.ENTER_COLUMN_TO_PUT.toString().replaceAll("#player", "" + this.getColor()));
            error = this.putToken(column, this.color);
            error.writeln();
        } while (!error.isNull());
    }

    public Error putToken(int columnIndex, Color color) {

        Error error = Error.NULL;
        if (!isColorValid(color)) {
            error = Error.WRONG_COLOR;
        } else if (!this.board.isColumnValid(columnIndex)) {
            error = Error.WRONG_COLUMN;
        } else if (!this.board.isColumnFull(columnIndex)) {
            error = Error.COLUMN_FULL;
        } else if (!this.isTokenAvailable()) {
            error = Error.NOT_TOKEN;
        } else {
            this.board.putToken(columnIndex, color);
            this.tokens--;
        }

        return error;
    }

    public boolean isTokenAvailable() {
        return this.tokens > 0;
    }
   
}
