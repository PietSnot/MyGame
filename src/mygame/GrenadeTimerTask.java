/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import java.util.Timer;
import java.util.TimerTask;
import org.jbox2d.common.Vec2;

/**
 *
 * @author domingas
 */
public class GrenadeTimerTask extends TimerTask {
    Grenade grenade;
    Explosion explosion;
    
    Vec2 grenadePositionAtExplosion;
    Timer explosionTimer = new Timer();
    
    public GrenadeTimerTask(Grenade grenade) {
        this.grenade = grenade;
    }
    
    @Override
    public void run() {
        grenadePositionAtExplosion = grenade.getPosition();
        grenade.destroy();
        
        //Create explosion shape
        createExplosion();
        
        //After a short amount of time remove the explosion
        explosionTimer.schedule(new ExplosionTimerTask(this.explosion), 250);
    }
    
    public void createExplosion() {
        explosion = new Explosion(grenade.getWorld());
        explosion.setPosition(grenadePositionAtExplosion);
        explosion.addCollisionListener(grenade.getListener());
    }
    
}
