package mcloudapps.connectFour.controllers;

import mcloudapps.connectFour.models.Session;
import mcloudapps.connectFour.types.Error;

public class ActionController extends Controller{
    
    public ActionController(Session session) {
        super(session);
    }

    public void next() {
        this.session.nextState();
    }

    public void putToken(int column) {
        this.session.putToken(column);
    }

    public Error getPutTokenError(int column) {
        return this.session.getPutTokenError(column);
    }

}
