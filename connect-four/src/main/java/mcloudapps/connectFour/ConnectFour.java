package mcloudapps.connectFour;

import mcloudapps.utils.YesNoDialog;

public class ConnectFour 
{
    private Board board;
    private Turn turn;

    public ConnectFour() {
        board = new Board();
        turn = new Turn(this.board);
    }

    public void play() {
        do {
            this.playGame();
            }
        while (this.isResumedGame());
    }

    private void playGame() {
		Message.TITLE.writeln();
		this.board.write();        
        do {
            this.turn.play();
            this.board.write();
        } while (!this.isGameOver());
        this.turn.writeResult();
    }

    private boolean isGameOver() {
        return (this.board.isFull() || this.turn.getWinner() != null);
    }

    private boolean isResumedGame() {
		YesNoDialog yesNoDialog = new YesNoDialog();
		yesNoDialog.read(Message.RESUME.toString());
		if (yesNoDialog.isAffirmative()) {
			this.board.reset();
			this.turn.reset();
		}
		return yesNoDialog.isAffirmative();
	}

    public static void main( String[] args )
    {
        new ConnectFour().play();
    }
}