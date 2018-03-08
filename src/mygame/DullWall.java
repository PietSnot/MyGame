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
public class DullWall extends StaticBody {
    private static final Shape dullWallShape = new BoxShape(1f, 1f);
        private static final BodyImage dullWallTexture = new BodyImage("data/DullWallTexture.png", 2.1f);

    public DullWall(GameLevel world) {
        super(world, dullWallShape);
        addImage(dullWallTexture);
    }
}
