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
        Crab crab=((Crab)getOneIntersectingObject(Crab.class));
        Lobster lobster=((Lobster)getOneIntersectingObject(Lobster.class));
        if(isTouching(Crab.class)&&crab.holeTimer<=0)    {
            crab.holeTimer=30;
            crab.setLocation(getX(),getY());
        }
        if(
        isTouching(Lobster.class)&&lobster.holeTimer<=0)    
        {
            lobster.holeTimer=30;
            lobster.setLocation(getX(),getY());
        }
    }

}