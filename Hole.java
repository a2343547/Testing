import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hole here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hole extends Actor
{
    /**
     * Act - do whatever the Hole wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        detect();
    }
    public void detect()
   {
    if(isTouching(Crab.class))    {
        int timer=500000;
        while(timer>0)
        {
          getOneIntersectingObject(Crab.class).setLocation(getX(), getY());           
          timer--;
        } 
        getOneIntersectingObject(Crab.class).setLocation(getX()+Greenfoot.getRandomNumber(50)+50, getY()+Greenfoot.getRandomNumber(50)+50);
    }
    if(isTouching(Lobster.class))    
    {   
        int timer=500000;
        while(timer>0)
        {
          getOneIntersectingObject(Lobster.class).setLocation(getX(), getY());           
          timer--;          
        }
        getOneIntersectingObject(Lobster.class).setLocation(getX()+Greenfoot.getRandomNumber(50)+50, getY()+Greenfoot.getRandomNumber(50)+50);
    }
   }
   public void wait(int time)
   {
        Greenfoot.delay(time);
   }
}
