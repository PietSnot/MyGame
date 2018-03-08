/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import city.cs.engine.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author domingas
 */
public class MyView extends UserView {

    Image backgroundImage;
    ScoreTracker score;
    MyGame game;
    
    public MyView(GameLevel world, int width, int height, MyGame game) {
        super(world, width, height);
        backgroundImage = new ImageIcon("data/Background.png").getImage();
        this.game = game;
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.setColor(Color.red);
        g.fillOval(100, 100, 100, 100);

        g.drawImage(backgroundImage, 0, 0, 800, 520, this);

        if (game.getLevel() == 0) {
            g.setFont(new Font("Helvetica", Font.BOLD, 18));

            g.setColor(new Color(38, 83, 108));
            g.drawString("Click to throw a grenade.", 199, 259);
            g.drawString("Click to throw a grenade.", 199, 261);
            g.drawString("Click to throw a grenade.", 201, 259);
            g.drawString("Click to throw a grenade.", 201, 261);
            g.setColor(Color.white);
            g.drawString("Click to throw a grenade.", 200, 260);

            g.drawString("Be careful not", 40, 360);
            g.drawString("to kill yourself!", 40, 380);

            g.setColor(Color.black);
            g.drawString("Destroy the crates to complete", 464, 399);
            g.drawString("the levels.", 554, 419);
            g.drawString("Destroy the crates to complete", 464, 401);
            g.drawString("the levels.", 554, 421);
            g.drawString("Destroy the crates to complete", 466, 399);
            g.drawString("the levels.", 556, 419);
            g.drawString("Destroy the crates to complete", 466, 401);
            g.drawString("the levels.", 556, 421);
            g.setColor(Color.white);
            g.drawString("Destroy the crates to complete", 465, 400);
            g.drawString("the levels.", 555, 420);

            g.setColor(new Color(38, 83, 108));
            g.drawString("Kill the bandit for bonus points.", 524, 139);
            g.drawString("Kill the bandit for bonus points.", 524, 141);
            g.drawString("Kill the bandit for bonus points.", 526, 139);
            g.drawString("Kill the bandit for bonus points.", 526, 141);
            g.setColor(Color.white);
            g.drawString("Kill the bandit for bonus points.", 525, 140);
        }
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        g.setColor(Color.white);
        g.setFont(new Font("Helvetica", Font.BOLD, 20));

        BufferedImage topBar = null;

        try {
            topBar = ImageIO.read(new File("data/TopBar.png"));
            g.drawImage(topBar, 0, 0, null);
        } catch (IOException ex) {
            Logger.getLogger(MyView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //If Image fails to load then draw a rectange instead
        if (topBar == null) {
            g.setColor(new Color(83, 59, 8));
            g.drawRect(0, 0, 800, 28);
            g.setColor(new Color(119, 84, 9));
            g.fillRect(0, 0, 800, 28);
        }
        
        if (score.getLiveCount() > 0) {
            g.setColor(new Color(83, 59, 8));
            g.drawString("Lives: " + score.getLiveCount(), 39, 509);
            g.drawString("Lives: " + score.getLiveCount(), 39, 511);
            g.drawString("Lives: " + score.getLiveCount(), 41, 509);
            g.drawString("Lives: " + score.getLiveCount(), 41, 511);
            g.setColor(Color.white);
            g.drawString("Lives: " + score.getLiveCount(), 40, 510);
        } else {
            g.setColor(new Color(83, 59, 8));
            g.drawString("You died.", 39, 509);
            g.drawString("You died.", 39, 511);
            g.drawString("You died.", 41, 509);
            g.drawString("You died.", 41, 511);
            g.setColor(Color.white);
            g.drawString("You died.", 40, 510);
        }

        g.setColor(new Color(83, 59, 8));
        g.drawString("Grenades Left: " + score.getNumberOfGrenadesRemaining(), 19, 21);
        g.drawString("Grenades Left: " + score.getNumberOfGrenadesRemaining(), 19, 23);
        g.drawString("Grenades Left: " + score.getNumberOfGrenadesRemaining(), 21, 21);
        g.drawString("Grenades Left: " + score.getNumberOfGrenadesRemaining(), 21, 23);
        g.setColor(Color.white);
        g.drawString("Grenades Left: " + score.getNumberOfGrenadesRemaining(), 20, 22);

        g.setColor(new Color(83, 59, 8));
        g.drawString("Crates remaining: " + (score.getCratesToDestroy() - score.getCratesDestroyed()), 599, 21);
        g.drawString("Crates remaining: " + (score.getCratesToDestroy() - score.getCratesDestroyed()), 599, 23);
        g.drawString("Crates remaining: " + (score.getCratesToDestroy() - score.getCratesDestroyed()), 601, 21);
        g.drawString("Crates remaining: " + (score.getCratesToDestroy() - score.getCratesDestroyed()), 601, 23);
        g.setColor(Color.white);
        g.drawString("Crates remaining: " + (score.getCratesToDestroy() - score.getCratesDestroyed()), 600, 22);
        
    }

    public ScoreTracker getScoreTracker() {
        return score;
    }

    public void setScoreTracker(ScoreTracker score) {
        this.score = score;
    }

}
