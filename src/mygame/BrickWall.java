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
public class BrickWall extends StaticBody {
    private static final Shape brickWallShape = new BoxShape(1f, 1f);
    private static final BodyImage brickWallTexture = new BodyImage("data/BrickWallTexture.png", 2.1f);
    public BrickWall(World world) {
        super(world, brickWallShape);
        addImage(brickWallTexture);
    }
}
