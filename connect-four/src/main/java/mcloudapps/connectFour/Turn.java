package mcloudapps.connectFour;

public class Turn {
    
    static final int NUMBER_PLAYERS = 2;
    private Board board;
    private Player[] players;
    private int currentPlayer;

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
        this.currentPlayer = this.randomTurn();
    }

    private int randomTurn() {
        return (int) (Math.random() * Turn.NUMBER_PLAYERS);
    }

    public void play(){
        this.currentPlayer = this.nextPlayer();
        this.players[this.currentPlayer].play();
    }

    private int nextPlayer() {
        return (this.currentPlayer + 1) % Turn.NUMBER_PLAYERS;
    }

    public Player getWinner(){
        Player winner = null;
        for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
            if (!this.players[i].isTokenAvailable()) { break;}
            if (this.isWinner(this.players[i].getColor())) {
                winner = this.players[i];
            }
        }
        return winner;
    }

    public void writeResult(){
        if (this.board.isFull() || this.getWinner() == null) {
            Message.RESULT_DRAW.writeln();
        } else {
            Message.RESULT_WIN.writeln(this.players[this.currentPlayer].getColor().toString());
        }
        Message.HORIZONTAL_LINE.writeln();
    }

    public boolean isWinner(Color color) {
        return this.isWinnerHorizontal(color) || this.isWinnerVertical(color) || this.isWinnerDiagonal(color);
    }

    private boolean isWinnerHorizontal(Color color) {
        for (int row = 0; row < this.board.getNumberOfRows(); row++) {
            for (int col = 0; col < this.board.getNumberOfColumns() - 3; col++) {
                if (this.board.getTokenColor(row, col) == color && this.board.getTokenColor(row, col + 1) == color && this.board.getTokenColor(row, col + 2)== color
                        && this.board.getTokenColor(row, col + 3) == color) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWinnerVertical(Color color) {
        for (int row = 0; row < this.board.getNumberOfRows() - 3; row++) {
            for (int col = 0; col < this.board.getNumberOfColumns(); col++) {
                if (this.board.getTokenColor(row, col) == color && this.board.getTokenColor(row + 1, col) == color && this.board.getTokenColor(row + 2, col) == color
                        && this.board.getTokenColor(row + 3, col) == color) {
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
                if (this.board.getTokenColor(row, col) == color && this.board.getTokenColor(row + 1, col + 1) == color && this.board.getTokenColor(row + 2, col + 2) == color
                        && this.board.getTokenColor(row + 3, col + 3) == color) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWinnerDiagonalRight(Color color) {
        for (int row = 0; row < this.board.getNumberOfRows() - 3; row++) {
            for (int col = 3; col < this.board.getNumberOfColumns(); col++) {
                if (this.board.getTokenColor(row, col) == color && this.board.getTokenColor(row + 1, col - 1) == color && this.board.getTokenColor(row + 2, col - 2) == color
                        && this.board.getTokenColor(row + 3, col - 3) == color) {
                    return true;
                }
            }
        }
        return false;
    }


}
