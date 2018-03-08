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
public class Floor extends StaticBody {
    private static final Shape floorWallShape = new BoxShape(1f, 1f);
    private static final BodyImage floorWallTexture = new BodyImage("data/Floor.png", 2.1f);

    public Floor(GameLevel world) {
        super(world, floorWallShape);
        addImage(floorWallTexture);
    }
}
