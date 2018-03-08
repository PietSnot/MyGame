/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import java.awt.Graphics2D;
import org.jbox2d.common.Vec2;

/**
 *
 * @author domingas
 */
public class Level1 extends GameLevel{

    public ScoreTracker tracker = new ScoreTracker(this, 3);
    private int grenadeFuse = 3000; //Alter grenade fuse depending on level to give more time before grenade explodes
    
    @Override
    public void populate(MyGame game) {
        super.populate(game);
        
        //Brick Wall
        for(float i=-10f;i<-4f;i+=2) {
            BrickWall brickWall = new BrickWall(this);
            brickWall.setPosition(new Vec2(0, i));
        }
        
        //Platform in the for bandit
        for(float i=8f;i<18f;i+=1.99f) {
            Floor floorForBandit = new Floor(this);
            floorForBandit.setPosition(new Vec2(i, -0.5f));
        }
        
        //Spawn Grenade (test)
        //Grenade testGrenade = new Grenade(this);
        //testGrenade.setPosition(new Vec2(-8f, -10f));
        
        //Spawn Crates
        for (int i=0;i<3;i++) {
            SmallCrate smallCrate = new SmallCrate(this);
            smallCrate.setPosition(new Vec2(2*i+8, -12f));
        }
        
        //Spawn Bandit
        Bandit banditOnPlatform = new Bandit(this);
        banditOnPlatform.setPosition(new Vec2(16f, 2.9f));
        //Add a tracker to enable back and forth movement
        this.addStepListener(new BanditTracker(banditOnPlatform));
        
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
        if(tracker.getNumberOfGrenadesRemaining() >= 7) {
            tracker.getStars()[2] = true;
        }
        
    }
    
    @Override
    public boolean completedLevel() {
        if(tracker.getCratesDestroyed() == 3) {
            return true;
        } else {
            return false;
        }
    }
    
}
