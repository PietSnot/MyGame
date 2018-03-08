/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import city.cs.engine.*;

/**
 *
 * @author domingas
 */

//Create an explosion shape
public class Explosion extends StaticBody {
    private static final Shape explosionShape = new CircleShape(2.3f);
    private static final BodyImage explosionTexture = new BodyImage("data/Explosion.png", 6f);
    
    public Explosion(GameLevel world) {
        super(world, explosionShape);
        addImage(explosionTexture);
    }
}
