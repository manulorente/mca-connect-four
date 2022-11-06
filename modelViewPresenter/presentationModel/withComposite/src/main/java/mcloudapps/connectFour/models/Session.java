package mcloudapps.connectFour.models;

import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.types.Error;
import mcloudapps.utils.models.Coordinate;

public class Session {

    private State state;
    private Game game;

    public Session() {
        this.game = new Game();
        this.state = new State();
    }

    public void reset(){
        this.game.reset();
        this.state.reset();
    }

    public StateValue getValueState() {
        return this.state.getValueState();
    }

    public void nextState() {
        this.state.next();
    }

    public void next() {
        this.game.next();
    }

    public int getNumberOfRows() {
        return this.game.getNumberOfRows();
    }

    public int getNumberOfColumns() {
        return this.game.getNumberOfColumns();
    }
    
    public Color getColor(Coordinate coordinate){
        return this.game.getColor(coordinate);
    }

    public boolean isEmpty(Coordinate coordinate){
        return this.game.isEmpty(coordinate);
    }

    public boolean isGameOver() {
        return this.game.isGameOver();
    }

    public Color getActivePlayerColor(){
        return this.game.getActivePlayerColor();
    }
    
    public Error getPutTokenError(int column) {
        return this.game.getPutTokenError(column);
    }

    public void putToken(int column) {
        this.game.putToken(column, this.getActivePlayerColor());
    }

    public Color getResult() {
        return this.game.getResult();
    }

}
