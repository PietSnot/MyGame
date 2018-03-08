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
public class Bandit extends Walker {
    private static final float banditSize = 6f;
    
    private static final Shape banditShape = new PolygonShape(0.037f*banditSize,-0.473f*banditSize, -0.09f*banditSize,-0.475f*banditSize, -0.087f*banditSize,0.185f*banditSize, -0.055f*banditSize,0.335f*banditSize, -0.007f*banditSize,0.343f*banditSize, 0.048f*banditSize,0.202f*banditSize, 0.048f*banditSize,-0.162f*banditSize);
    
    private static final BodyImage banditImage =
        new BodyImage("data/Bandit(Left).png", banditSize);
    
    //Create bandit shape and set image
    public Bandit(World world) {
        super(world,banditShape);
        addImage(banditImage);
    }
    
    public Shape getBanditShape() {
        return banditShape;
    }
}
