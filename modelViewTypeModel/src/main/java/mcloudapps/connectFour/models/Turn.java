package mcloudapps.connectFour.models;

import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.types.Error;

public class Turn {
    
    static final int NUMBER_PLAYERS = 2;
    private Board board;
    private Player[] players;
    private int activePlayer;

    public Turn(Board board) {
        assert board != null;
        this.board = board;
		this.players = new Player[Turn.NUMBER_PLAYERS];
		this.reset();
    }

    public void reset() {
		for (int i = 0; i < NUMBER_PLAYERS; i++) {
			this.players[i] = new Player(Color.get(i), this.board, this.board.getNumberOfTokens());
		}        
        this.activePlayer = this.randomTurn();
    }

    public boolean isTokenAvailable() {
        return this.getActivePlayer().isTokenAvailable();
    }

    public Player getActivePlayer() {
        return this.players[this.activePlayer];
    }
    
    private int randomTurn() {
        return (int) (Math.random() * Turn.NUMBER_PLAYERS);
    }

    public void nextPlayer() {
        this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
    }

    public void putToken(int columnIndex) {
        this.getActivePlayer().putToken(columnIndex);
    }

    public Error getPutTokenError(int columnIndex) {
        return this.getActivePlayer().getPutTokenError(columnIndex);
    }

}
