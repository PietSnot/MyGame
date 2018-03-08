/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author domingas
 */
public abstract class GameLevel extends World {
    private static final BodyImage groundImage = new BodyImage("data/Ground.png", 2f);
    private Character character;
    
    public void populate(MyGame game) {
        // Ground
        Shape groundShape = new BoxShape(20, 1f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -12f));
        ground.addImage(groundImage);
        
        //Create Character
        character = new Character(this);
        character.setPosition(new Vec2(-16f, -8.7f));
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
    
    public abstract void setScoreTracker(ScoreTracker tracker);
    
    public abstract ScoreTracker getScoreTracker();
    
    public abstract void checkNumberOfStars();
    
    public abstract int getGrenadeFuse();
    
    public abstract boolean completedLevel();
}
