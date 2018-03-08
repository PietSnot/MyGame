/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import java.util.TimerTask;

/**
 *
 * @author domingas
 */
public class ExplosionTimerTask extends TimerTask {
    Explosion explosion;
    
    public ExplosionTimerTask(Explosion explosion) {
        this.explosion = explosion;
    }
    
    @Override
    public void run() {
        explosion.destroy();
    }

}
