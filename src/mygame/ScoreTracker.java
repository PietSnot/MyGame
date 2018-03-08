/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import city.cs.engine.World;

/**
 *
 * @author domingas
 */

//Keeps track of all the different components (cratesDestroyed, liveCount and later grenadesRemaining);
public class ScoreTracker {
    private int numberOfGrenadesRemaining;
    private int cratesDestroyed;
    private int cratesToDestroy;
    private int liveCount;
    private int banditsKilled;
    private int score;
    
    private boolean[] stars = {false, false, false};
    
    private GameLevel level;
    
    public ScoreTracker(GameLevel level, int cratesToDestroy) {
        
        this.level = level;
        this.cratesToDestroy = cratesToDestroy;

        //Set the number of grenades left to throw
        numberOfGrenadesRemaining = 10;
        
        cratesDestroyed = 0;
        liveCount = 3;
        banditsKilled = 0;
        
        //Set score for level
        score = 0;
    }
    
    public int getCratesDestroyed() {
        return cratesDestroyed;
    }

    public void incrementCratesDestroyed() {
        cratesDestroyed++;
        score += 50;
        System.out.println("You destroyed a crate. Crates destroyed: " + cratesDestroyed);
    }

    public int getLiveCount() {
        return liveCount;
    }

    public void decrementLiveCount() {
        liveCount--;
        score -= 25;
        System.out.println("You lost a life. Lives remaining: " + liveCount);
    }

    public int getCratesToDestroy() {
        return cratesToDestroy;
    }

    public void setCratesToDestroy(int cratesToDestroy) {
        this.cratesToDestroy = cratesToDestroy;
    }

    public int getNumberOfGrenadesRemaining() {
        return numberOfGrenadesRemaining;
    }

    public void decrementNumberOfGrenadesRemaining() {
        numberOfGrenadesRemaining--;
        System.out.println("You have " + numberOfGrenadesRemaining + " grenades remaining.");
    }

    public int getBanditsKilled() {
        return banditsKilled;
    }

    public void incrementBanditsKilled() {
        banditsKilled++;
        score += 100;
        System.out.println("Bonus Point! You have killed " + banditsKilled + " bandits.");
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean[] getStars() {
        return stars;
    }

    public void setStars(boolean[] stars) {
        this.stars = stars;
    }
    
    public void gameOver() {
        level.stop();
    }
    
    public void youWin() {
        System.out.println("Level Completed.");
    }
    
}
