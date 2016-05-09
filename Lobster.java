import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lobster extends Actor
{
    public int holeTimer=0;//becomes true when crab is in the hall
    private int moveCount=20;
    public void LobsterMove()
    {
        if(holeTimer<=0){
            Crab c=detectCrab(100);
            if(c!= null)
            {
                turnTowards(c.getX(),c.getY());
            }
            if (moveCount!=0)
            {
                move(1);
                moveCount--;
            }
            else{
                turn(Greenfoot.getRandomNumber(181)-90);
                moveCount=20;
            }
        }else{
            holeTimer--;
            if(holeTimer<=0){
                setLocation(getX()+(Greenfoot.getRandomNumber(3)-1)*100, getY()+(Greenfoot.getRandomNumber(3)-1)*100);
            }
        }
    }

    public void eatCrab()
    {
        if(isTouching(Crab.class))
        {    GreenfootSound gs=new GreenfootSound("slurp.wav");
            gs.play();
            removeTouching(Crab.class);
            ((CrabWorld)getWorld()).gameFailed();
        }
    }

    public Crab detectCrab(int radius)
    {
        List l= getObjectsInRange(radius,Crab.class);
        if(l.size()!=0)
        {return (Crab)l.get(0);}
        else{return null;}

    }

    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        LobsterMove();
        eatCrab();
    }    
}

