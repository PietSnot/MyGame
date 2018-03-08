/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import city.cs.engine.*;
import java.awt.Image;
import org.jbox2d.common.Vec2;

/**
 *
 * @author domingas
 */
public class Level4 extends GameLevel {
    public ScoreTracker tracker = new ScoreTracker(this, 1);
    private int grenadeFuse = 4000; //Alter grenade fuse depending on level to give more time before grenade explodes
        
    @Override
    public void populate(MyGame game) {
        super.populate(game);
        
        //Floors
        for(float i=-8f;i<0;i+=2f) {
            Floor floorForCrate = new Floor(this);
            floorForCrate.setPosition(new Vec2(i, -4));
        }
        
        //Dull Wall
        for(float i=-2f;i<20;i+=2) {
            DullWall dullWall = new DullWall(this);
            dullWall.setPosition(new Vec2(-6f, i));
        }  
        
        //Bouncy Wall
        float xPosition = 6f;
        for(float i=-10.6f;i<=-6.2f;i+=1.7f) {
            BouncyWall bouncyWall = new BouncyWall(this);
            bouncyWall.setPosition(new Vec2(xPosition, i));
            bouncyWall.setAngleDegrees(-30);
            xPosition += 1f;
        }
        
        //Crates
        SmallCrate crate = new SmallCrate(this);
        crate.setPosition(new Vec2(-3f, -2f));
        
        //Bandit
        Bandit bandit = new Bandit(this);
        bandit.setPosition(new Vec2(-8f, 0f));
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
