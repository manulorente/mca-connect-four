package mcloudapps.connectFour.models;

import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.types.Error;

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

    public void putToken(int column)
    {
        this.board.putToken(column, this.color);
        this.tokens--;
    }

    public Error getPutTokenError(int column) {
        Error error = Error.NULL;
        if (!this.board.isColumnValid(column)) {
            error = Error.INVALID_COLUMN;
        } else if (!this.board.isColumnFull(column)) {
            error = Error.FULL_COLUMN;
        } else if (!this.isTokenAvailable()) {
            error = Error.OUT_OF_TOKENS;
        }
        return error;
    }
    
    public Color getColor() {
        return this.color;
    }    

}
