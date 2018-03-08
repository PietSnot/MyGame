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
public class Character extends Walker {
    
    private static final float characterSize = 5f;
    
    private static final Shape characterShape = new PolygonShape(
            0.098f*characterSize,-0.457f*characterSize, -0.122f*characterSize,-0.458f*characterSize, -0.125f*characterSize,0.34f*characterSize, -0.092f*characterSize,0.39f*characterSize, -0.05f*characterSize,0.422f*characterSize, 0.005f*characterSize,0.423f*characterSize, 0.052f*characterSize,0.397f*characterSize, 0.095f*characterSize,0.328f*characterSize);

    private static final BodyImage characterImage =
        new BodyImage("data/Character.png", characterSize);
    
    //Create character shape and set image
    public Character(World world) {
        super(world,characterShape);
        addImage(characterImage);
    }
    
}
