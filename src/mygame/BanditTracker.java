package mygame;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class BanditTracker implements StepListener {

    private Bandit body;
    
    private BodyImage banditLeftImage = new BodyImage("data/Bandit(Left).png", 6f);
    private BodyImage banditRightImage = new BodyImage("data/Bandit(Right).png", 6f);
    
    private float walkingSpeed = -2f;
    int counter;

    public BanditTracker(Bandit body) {
        this.body = body;
        counter = 0;
        
        body.startWalking(walkingSpeed);
    }

    @Override
    public void preStep(StepEvent e) {
        
    }

    @Override
    public void postStep(StepEvent e) {
        counter++;
        if (counter == 260) {
            counter = 0;
            walkingSpeed *= -1;
            body.startWalking(walkingSpeed);
        }
        
        //Check which way the bandit is walking and update his image accordingly
        if (walkingSpeed < 0) {
            body.removeAllImages();
            body.addImage(banditLeftImage);
        } else {
            body.removeAllImages();
            body.addImage(banditRightImage);
        }
    }
}
