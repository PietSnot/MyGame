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
public class Level5 extends GameLevel {
    public ScoreTracker tracker = new ScoreTracker(this, 1);
    private int grenadeFuse = 5000; //Alter grenade fuse depending on level to give more time before grenade explodes
    
    @Override
    public void populate(MyGame game) {
        super.populate(game);

        
        
        
        //Bouncy Walls
        for(float i=-10f;i<0;i+=2) {
            BouncyWall bouncyWallLeft = new BouncyWall(this);
            BouncyWall bouncyWallRight = new BouncyWall(this);
            bouncyWallLeft.setPosition(new Vec2(-2f, i));
            bouncyWallRight.setPosition(new Vec2(2f, i));
        }
        
        //Entrance Walls
        DullWall dullWallLeft = new DullWall(this);
        DullWall dullWallRight = new DullWall(this);
        dullWallLeft.setPosition(new Vec2(-1.6f, -2.02f));
        dullWallRight.setPosition(new Vec2(1.6f, -2.02f));
        
        
        //Dull wall
        DullWall dullWall = new DullWall(this);
        dullWall.setPosition(new Vec2(6.5f, 2f));
        
        //Crates
        SmallCrate smallCrate = new SmallCrate(this);
        smallCrate.setPosition(new Vec2(0f, -10f));
        
        //Bandit
        Bandit bandit = new Bandit(this);
        bandit.setPosition(new Vec2(4f, -8f));
        
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
