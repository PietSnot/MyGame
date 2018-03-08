/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import javax.swing.JFrame;

/**
 *
 * @author domingas
 */
public class MyGame {

    private GameLevel world;
    private MyView userView;

    public ScoreTracker currentScoreTracker;
    //Store my levels in an array.
    private GameLevel[] levels = {new Level1(), new Level2(), new Level3(), new Level4(), new Level5()};
    private int level;

    public MyGame() {
        level = 0; //Level you want to start on - 1 as it is an index e.g. For level 2 set level to 1

        //Make the world
        world = levels[level];
        world.populate(this);

        
        
        //Create View and Set Background Color
        userView = new MyView(world, 800, 520, this);

        //1 Metre-Ruler
        //userView.setGridResolution(1);
        //Add mouse handler
        MouseHandler mouseHandler = new MouseHandler(this, userView, world, 5, world.getScoreTracker());
        userView.addMouseListener(mouseHandler);
        userView.setScoreTracker(world.getScoreTracker());

        
        final JFrame frame = new JFrame("My Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.add(userView);
        
        //frame.setSize(800, 520);
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);

        //Make a debugging view
        //JFrame debugView = new DebugViewer(world, 800, 520);
        world.start();
    }

    public void goNextLevel() {
        world.stop();
        world.checkNumberOfStars();

        for (boolean star : world.getScoreTracker().getStars()) {
            System.out.println(star);
        }

        if (level == levels.length - 1) {
            int highScore = 0;

            for (GameLevel level : levels) {
                highScore += level.getScoreTracker().getScore();
            }

            System.out.println("Your score was: " + highScore);
            System.out.println("You won!!!");
        } else {
            //debugView.dispose();
            level++;
            world = levels[level];

            MouseHandler mouseHandler = new MouseHandler(this, userView, world, 5, world.getScoreTracker());
            userView.addMouseListener(mouseHandler);
            world.populate(this);
            userView.setScoreTracker(world.getScoreTracker());
            userView.setWorld(world);

            userView.repaint();

            //Debug view for each world
            //JFrame debugView = new DebugViewer(world, 800, 520);
            world.start();
        }
    }

    public int getLevel() {
        return level;
    }

    public static void main(String[] args) {
        //Start the game
        new MyGame();
    }

}
