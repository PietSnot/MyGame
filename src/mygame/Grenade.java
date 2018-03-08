/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import city.cs.engine.*;
import java.util.Timer;

/**
 *
 * @author domingas
 */
public class Grenade extends DynamicBody {
    private static final Shape grenadeShape = new CircleShape(0.35f);
    private static final BodyImage grenadeTexture = new BodyImage("data/Bomb.png", 1f);
    private CollisionListener listener;
    
    private GameLevel world;
    
    Timer grenadeTimer = new Timer();
    private int grenadeFuse;
    
    //Generate grenade shape and image
    public Grenade(GameLevel world, int grenadeFuse) {
        super(world, grenadeShape);
        addImage(grenadeTexture);
        
        this.world = world;
        this.grenadeFuse = grenadeFuse;
    }
    
    public Shape getGrenadeShape() {
        return grenadeShape;
    }
    
    public void startTimer() {
        //Destroy grenade after 5 seconds
        grenadeTimer.schedule(new GrenadeTimerTask(this), grenadeFuse);
    }
    
    public GameLevel getWorld() {
        return world;
    }
    
    public void setListener(CollisionListener listener) {
        this.listener = listener;
    }
    
    public CollisionListener getListener() {
        return this.listener;
    }
}