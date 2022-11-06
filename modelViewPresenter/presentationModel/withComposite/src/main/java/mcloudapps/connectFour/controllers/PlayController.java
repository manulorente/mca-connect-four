package mcloudapps.connectFour.controllers;

import mcloudapps.connectFour.models.Session;
import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.types.Error;

public class PlayController extends Controller implements AcceptorController{
    
    public PlayController(Session session) {
        super(session);
    }

    public void nextState() {
        this.session.nextState();
    }

    public void next() {
        this.session.next();
    }

    public Color getResult(){
        return this.session.getResult();
    }

    public void putToken(int column) {
        this.session.putToken(column);
    }

    public Color getActivePlayerColor(){
        return this.session.getActivePlayerColor();
    }

    public Error getPutTokenError(int column) {
        return this.session.getPutTokenError(column);
    }

    public boolean isGameOver() {
        return this.session.isGameOver();
    }
    
    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
