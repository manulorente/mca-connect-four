package mcloudapps.connectFour;

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

    public void play(){
        this.activePlayer = this.nextPlayer();
        this.players[this.activePlayer].play();
    }

    public Player getActivePlayer() {
        return this.players[this.activePlayer];
    }
    
    private int randomTurn() {
        return (int) (Math.random() * Turn.NUMBER_PLAYERS);
    }

    private int nextPlayer() {
        return (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
    }
    
}
