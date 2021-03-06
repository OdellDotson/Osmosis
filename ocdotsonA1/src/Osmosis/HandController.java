package Osmosis;

import ks.common.model.Column;
import ks.common.model.Move;
import ks.common.view.*;

public class HandController extends java.awt.event.MouseAdapter {

	protected Osmosis osmosisGame = null;
    FanPileView handView;

    public HandController(Osmosis game, FanPileView handView) {
        super();

        osmosisGame = game;
        this.handView = handView;
    }
    
    /**
     * On mouse Press for now, we simply delete top card. 
     * 
     * @param me     low-level mouse event
     */
    
    public void mousePressed(java.awt.event.MouseEvent me) {

    }
    
    
    public void mouseReleased(java.awt.event.MouseEvent me)
    {
    	Column h = (Column) osmosisGame.getModelElement("hand");
	    
	    
        Move m = new HandToFoundationMove(osmosisGame,h);
        if (m.doMove(osmosisGame)) {
            // SUCCESS: have solitaire game store this move
        	osmosisGame.pushMove(m);

            // have solitaire game refresh widgets that were affected 
        	osmosisGame.refreshWidgets();
        }
        else{}
        	//System.out.println("Hand controller messed UP");
    }
}
