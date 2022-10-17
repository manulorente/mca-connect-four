package mcloudapps.connectFour;

import mcloudapps.utils.Console;

public enum Message {
    TITLE("******** CONNECT FOUR ********"),
	HORIZONTAL_LINE("------------------------------"),
	VERTICAL_LINE(" | "),
    EMPTY(" "),
    NEW_LINE("\n"),
	ENTER_COLUMN_TO_PUT("Player #player turn - Enter the column to put a token: "),
	RESULT_WIN("#player player: You win!!! :-)"), 
	RESULT_DRAW("Nobody wins: Draw :/"), 
	RESUME("Do you want to continue");

	private String message;

	Message(String message) {
		this.message = message;
	}

	void write() {
		Console.getInstance().write(this.message);
	}

	void write(String player) {
		assert this == Message.RESULT_WIN;
		Console.getInstance().write(this.message.replaceAll("#player", "" + player));
	}    

	void writeln() {
		Console.getInstance().writeln(this.message);
	}

	void writeln(String player) {
		assert this == Message.RESULT_WIN;
		Console.getInstance().writeln(this.message.replaceAll("#player", "" + player));
	}

	@Override
	public String toString() {
		return message;
	}    
}
