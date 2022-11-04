package mcloudapps.connectFour.models;

import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.types.Error;

public class Game {
   
    private Board board;
    private Turn turn;
    private Result result;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
        this.result = new Result(this.board);
    }

    public void reset() {
        this.board.reset();
        this.turn.reset();
    } 

    public void next() {
        this.turn.nextPlayer();
    }

    public void putToken(int column, Color color) {
        this.board.putToken(column, color);
    }

    public Error getPutTokenError(int column) {
        return this.turn.getPutTokenError(column);
    }

    public Color getColor(int row, int col) {
        return this.board.getColor(row, col);
    }

    public boolean isGameOver() {
        return this.board.isGameOver(this.getActivePlayerColor()) || this.result.getResult() != null;
    }

    public Color getActivePlayerColor(){
        return this.turn.getActivePlayer().getColor();
    }

    public int getNumberOfRows() {
        return this.board.getNumberOfRows();
    }

    public int getNumberOfColumns() {
        return this.board.getNumberOfColumns();
    }

    public Color getResult() {
        return this.result.getResult();
    }

}
