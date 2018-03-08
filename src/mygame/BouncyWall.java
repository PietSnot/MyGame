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
public class BouncyWall extends StaticBody {
    private static final Shape bouncyWallShape = new BoxShape(1f, 1f);
        private static final BodyImage bouncyWallTexture = new BodyImage("data/BouncyWallTexture.png", 2.1f);
    public BouncyWall(GameLevel world) {
        super(world, bouncyWallShape);
        addImage(bouncyWallTexture);
    }
}
