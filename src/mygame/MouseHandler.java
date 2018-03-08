package mygame;

import city.cs.engine.*;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;
import org.jbox2d.common.Vec2;

public class MouseHandler extends MouseAdapter {
    
    private MyGame game;
    
    private MyView view;    
    public GameLevel world;
    private Point point1;
    
    public float grenadeVectorX;
    public float grenadeVectorY;
    public Vec2 grenadeVector;
    
    public ScoreTracker scoreTracking;
        
    private int grenadeFuse;
        
    public Vec2 characterPosition  = new Vec2(-16f, -8.7f);
    int characterXOnScreen = 0;
    int characterYOnScreen = 0;
    
    private int maxGrenadesOnScreen = 5; //Change to update number of maximum grenades allowed at a time
    public Grenade[] grenades = new Grenade[maxGrenadesOnScreen]; //Create an array of Bodies to store each grenade

    public MouseHandler(MyGame game, MyView view, GameLevel world, int cratesToDestroy, ScoreTracker tracker) {
        this.game = game;
        this.view = view;
        this.world = world;
        
        grenadeFuse = world.getGrenadeFuse();
        scoreTracking = tracker;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        point1 = e.getPoint();
        
        if (world.isRunning()) {
            //Check if the player has run out of grenades
            if (scoreTracking.getNumberOfGrenadesRemaining() > 0) {
                characterPosition = world.getCharacter().getPosition();
                
                //Character position in the same scale as mouse position

                if(characterPosition.x < 0) {
                    characterXOnScreen = (int) (20-Math.abs(characterPosition.x+0.9f)) * 20;
                } else {
                    characterXOnScreen = (int) (20+characterPosition.x+0.9f) * 20;
                }
                if(characterPosition.y < 0) {
                    characterYOnScreen = 520 - (int) (13+Math.abs(characterPosition.y+1.7f)) * 20;
                } else {
                    characterYOnScreen = 520 - (int) (13-characterPosition.y+1.7f) * 20;
                }                
                
                //Work out grenade vector
                grenadeVectorX = (point1.x - characterXOnScreen)/20;
                grenadeVectorY = (520 - point1.y - characterYOnScreen)/15;
                                
                //If grenadeVector x and y exceed the speed limit then set the speed at the limit, keeps the grenades more controlled
                if(grenadeVectorX > 20) {
                    grenadeVectorX = 20;
                }
                
                if(grenadeVectorY > 20) {
                    grenadeVectorY = 20;
                }
                
                grenadeVector = new Vec2(grenadeVectorX, grenadeVectorY);
                updateGrenadeArray(grenades);
            } else {
                System.out.println("You're out of grenades.");
            }
        }
    }
    
    
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    //Create the grenade, setting the position, velocity and angular velocity
    public Grenade createGrenade(Vec2 grenadeVector) {
       Grenade grenade = new Grenade(world, grenadeFuse);
       
       grenade.setPosition(new Vec2(characterPosition.x+0.9f, characterPosition.y+1.7f));
       grenade.setLinearVelocity(grenadeVector);
       grenade.setAngularVelocity(-2f);
       grenade.setListener(new GrenadeContact(this, game, grenade, scoreTracking, world));
       grenade.addCollisionListener(grenade.getListener());
       
       grenade.startTimer();
       
       SolidFixture grenadeFixture = new SolidFixture(grenade, grenade.getGrenadeShape());
       grenadeFixture.setRestitution(0.3f);
       
       scoreTracking.decrementNumberOfGrenadesRemaining();
       
       return grenade;
    }
    
    int i = 0;
    public Grenade[] updateGrenadeArray(Grenade[] grenades) {
        if (i < grenades.length) {
            //Check if all grenade slots in array have been filled
            while (i < grenades.length) {
                if (grenades[i] == null) {
                    grenades[i] = createGrenade(grenadeVector);
                    i++;
                    break;
                }
            }
        } else {
            //Remove oldest grenade, shift grenades down array and add a new grenade to the last position.
            grenades[0].grenadeTimer.cancel();
            grenades[0].destroy();
            for (int num=0;num<grenades.length-1;num++) {
                grenades[num] = grenades[num+1];
            }
            grenades[grenades.length-1] = createGrenade(grenadeVector);
        }
        
        return grenades;
    }

    public Point getPoint1() {
        return point1;
    }

    public int getCharacterXOnScreen() {
        return characterXOnScreen;
    }

    public int getCharacterYOnScreen() {
        return characterYOnScreen;
    }
    
}
