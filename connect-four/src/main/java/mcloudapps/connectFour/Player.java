package mcloudapps.connectFour;

import mcloudapps.utils.Console;

public class Player {

    private Color color;
    private Board board;
    private int tokens;

    public Player(Color color, Board board, int tokens) {
        assert color != Color.NONE;;
        assert board != null;
        assert tokens > 3;
        this.color = color;
        this.board = board;
        this.tokens = tokens;
    }

    public boolean isTokenAvailable() {
        return this.tokens > 0;
    }

    public Color getColor() {
        return this.color;
    }    

    public void play(){
        int column;
        Error error;
        do {
            column = this.getColumn(Message.ENTER_COLUMN_TO_PUT, this.color);
            error = this.getPutTokenError(column, this.color);
        } while (!error.isNull());
        this.board.putToken(column, this.color);
        this.tokens--;
    }

    private int getColumn(Message message, Color color) {
        int column = Console.getInstance().readInt(message.toString().replaceAll("#player", "" + color));
        return column;
    }

    public Error getPutTokenError(int column, Color color) {
        Error error = Error.NULL;
        if (!this.board.isColumnValid(column)) {
            error = Error.WRONG_COLUMN;
        } else if (!this.board.isColumnFull(column)) {
            error = Error.COLUMN_FULL;
        } else if (!this.isTokenAvailable()) {
            error = Error.NOT_TOKEN;
        }
        error.writeln();
        return error;
    }
}
