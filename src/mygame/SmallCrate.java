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
public class SmallCrate extends DynamicBody {
    private static final Shape smallCrateShape = new BoxShape(1f, 1f);
    private static final BodyImage smallCrateTexture = new BodyImage("data/SmallCrateTexture.png", 2f);
    
    //Create shape and images
    public SmallCrate(World world) {
        super(world, smallCrateShape);
        addImage(smallCrateTexture);
    }
}
