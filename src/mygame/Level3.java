/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import city.cs.engine.Body;
import org.jbox2d.common.Vec2;

/**
 *
 * @author domingas
 */
public class Level3 extends GameLevel {
    public ScoreTracker tracker = new ScoreTracker(this, 2);
    private int grenadeFuse = 3000; //Alter grenade fuse depending on level to give more time before grenade explodes
    
    @Override
    public void populate(MyGame game) {
        super.populate(game);
                
        //Brick Walls
        for(float i=-10f;i<-4f;i+=2f) {
            BrickWall brickWall1 = new BrickWall(this);
            BrickWall brickWall2 = new BrickWall(this);
            brickWall1.setPosition(new Vec2(0, i));
            brickWall2.setPosition(new Vec2(6f, i+6f));
        }
        
        //Crates
        SmallCrate smallCrate1 = new SmallCrate(this);
        smallCrate1.setPosition(new Vec2(2f, -12f));
        
        SmallCrate smallCrate2 = new SmallCrate(this);
        smallCrate2.setPosition(new Vec2(6f, 2f));
        
        //Bandit
        Bandit bandit = new Bandit(this);
        bandit.setPosition(new Vec2(10f, -8f));
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
        if(tracker.getCratesDestroyed() == 2) {
            tracker.youWin();
            return true;
        } else {
            return false;
        }
    }
}
