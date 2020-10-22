package org.newdawn.slick.state;

import org.newdawn.slick.*;

public interface GameState extends InputListener
{
    void enter(final GameContainer p0, final StateBasedGame p1) throws SlickException;
    
    void leave(final GameContainer p0, final StateBasedGame p1) throws SlickException;
    
    void init(final GameContainer p0, final StateBasedGame p1) throws SlickException;
    
    void update(final GameContainer p0, final StateBasedGame p1, final int p2) throws SlickException;
    
    int getID();
    
    void render(final GameContainer p0, final StateBasedGame p1, final Graphics p2) throws SlickException;
}
