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
public class Level2 extends GameLevel {
    public ScoreTracker tracker = new ScoreTracker(this, 1);
    private int grenadeFuse = 3000; //Alter grenade fuse depending on level to give more time before grenade explodes
    
    @Override
    public void populate(MyGame game) {
        super.populate(game);
                
        //Brick Wall
        for(float i=-9f;i<2f;i+=2) {
            BrickWall brickWall = new BrickWall(this);
            brickWall.setPosition(new Vec2(0, i));
        }
        
        //Bandit
        Bandit bandit = new Bandit(this);
        bandit.setPosition(new Vec2(0f, 4f));
        
        //Crate
        SmallCrate smallCrate = new SmallCrate(this);
        smallCrate.setPosition(new Vec2(4f, -12f));
    }
    
    @Override
    public void setScoreTracker(ScoreTracker tracker) {
        this.tracker = tracker;
    }
    
    @Override
    public ScoreTracker getScoreTracker() {
        return tracker;
    }
    
    @Override
    public int getGrenadeFuse() {
        return grenadeFuse;
    }
    
    @Override
    public void checkNumberOfStars() {
        //Get a star for completing the level
        if(completedLevel()) {
            tracker.getStars()[0] = true;
        }
        
        //Get a star for killing the bandits in the level
        if(tracker.getBanditsKilled() == 1) {
            tracker.getStars()[1] = true;
        }
        
        //Get a star if you use less than 4 grenades
        if(tracker.getNumberOfGrenadesRemaining() >= 8) {
            tracker.getStars()[2] = true;
        }
    }
    
    @Override
    public boolean completedLevel() {
        if(tracker.getCratesDestroyed() == 1) {
            tracker.youWin();
            return true;
        } else {
            return false;
        }
    }
}
