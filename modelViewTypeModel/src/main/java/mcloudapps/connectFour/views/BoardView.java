package mcloudapps.connectFour.views;

import mcloudapps.connectFour.models.Game;

public class BoardView {

    public void write(Game game) {
        Message.HORIZONTAL_LINE.writeln();
        for (int row = 0; row < game.getNumberOfRows(); row++) {
            Message.VERTICAL_LINE.write();
            for (int col = 0; col < game.getNumberOfColumns(); col++) {
                game.getColor(row, col).write();
                Message.VERTICAL_LINE.write();
            }
            Message.NEW_LINE.write();
        }
        Message.HORIZONTAL_LINE.writeln();
    }
    
}
