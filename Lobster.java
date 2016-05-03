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
    private int moveCount=20;
   public void LobsterMove()
   {
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
    }
   public void eatCrab()
   {
    if(isTouching(Crab.class))
    {    GreenfootSound gs=new GreenfootSound("slurp.wav");
         gs.play();
        removeTouching(Crab.class);
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

