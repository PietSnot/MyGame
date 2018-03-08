/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

/**
 *
 * @author domingas
 */
public class GrenadeContact implements CollisionListener {

    private MyGame game;
    private Grenade grenade;
    private ScoreTracker scoreTracking;
    private GameLevel level;
    
    private MouseHandler handler;

    public GrenadeContact(MouseHandler handler, MyGame game, Grenade grenade, ScoreTracker scoreTracking, GameLevel level) {
        this.game = game;
        this.grenade = grenade;
        this.scoreTracking = scoreTracking;
        this.level = level;
        
        this.handler = handler;
    }

    //Collision listener each explosion has one
    @Override
    public void collide(CollisionEvent e) {
        //Checks if explosion hits small box
        if (e.getReportingBody() instanceof Explosion) {
            if (e.getOtherBody() instanceof SmallCrate) {
                scoreTracking.incrementCratesDestroyed();
                e.getOtherBody().destroy();
                if (level.completedLevel()) {
                    game.goNextLevel();
                }
            } else if (e.getOtherBody() instanceof Character) {
                //Decrease liveCount if explosion touches Character
                scoreTracking.decrementLiveCount();
                //If you hit your game character a certain amount of times you lose and the world stops
                if (scoreTracking.getLiveCount() == 0) {
                    e.getOtherBody().destroy();
                    System.out.println("Out of lives.");
                    scoreTracking.gameOver();
                }
            } else if (e.getOtherBody() instanceof Bandit) {
                e.getOtherBody().destroy();
                scoreTracking.incrementBanditsKilled();
            }
        } else if (e.getReportingBody() instanceof Grenade) {
            if (e.getOtherBody() instanceof DullWall) {
                grenade.setLinearVelocity(new Vec2(grenade.getLinearVelocity().x*0, grenade.getLinearVelocity().y *0.5f));
            } else if (e.getOtherBody() instanceof BouncyWall) {
                grenade.setLinearVelocity(new Vec2(grenade.getLinearVelocity().x*1.75f, grenade.getLinearVelocity().y*1.75f));
            } else if (e.getOtherBody() instanceof SmallCrate) {
                grenade.setLinearVelocity(new Vec2(grenade.getLinearVelocity().x*0.75f, grenade.getLinearVelocity().y*0.75f));
            }
        }
    }
}
