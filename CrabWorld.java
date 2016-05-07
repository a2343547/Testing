import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)
import java.util.List;
/**testing message*/
public class CrabWorld extends World
{
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    /**Crab qq=new Crab() */
    public CrabWorld() 
    {
        super(560, 560, 1);
        setPaintOrder(Crab.class,Lobster.class,Worm.class,Hole.class);
        ResetWormsEaten();
        addObject(new Crab(),getWidth()/2,getHeight()/2);
        int i=0;
        while(i<10)
        {
            int x=Greenfoot.getRandomNumber(getWidth());
            int y=Greenfoot.getRandomNumber(getHeight());
            List l=getObjectsAt(x,y,Worm.class);
            if(l.size()==0)
            {
                addObject(new Worm(),x,y);
                i++;
            }
        }
        generateLobster(2);
        generateHole(3);
    }
    public void generateHole(int number)
    {
        int i=0;
        while(i<number)
        {
            int x=Greenfoot.getRandomNumber(getWidth());
            int y=Greenfoot.getRandomNumber(getHeight());
            List l=getObjectsAt(x,y,Hole.class);
            if(l.size()==0)
            {
                addObject(new Hole(),x,y);
                i++;
            }
        }
    }
    
    public void generateLobster(int number)
    {
        int i=0;
        while(i<number)
        {
            int x=Greenfoot.getRandomNumber(getWidth());
            int y=Greenfoot.getRandomNumber(getHeight());
            List l=getObjectsAt(x,y,Crab.class);
            if(l.size()==0)
            {
                addObject(new Lobster(),x,y);
                i++;
            }
        }
    }
    public void detectGameOver()
    { 
        if(numberOfObjects()==3)
        {
            GreenfootSound gs=new GreenfootSound("fanfare.wav");
            gs.play();
            showText("Game Complete",getWidth()/2,getHeight()/2);
            Greenfoot.stop();
        }
    }
    /**Reset the value of WormsEaten(Put this method in the constructor of CrabWorld)*/
    public void ResetWormsEaten()
    {
       Crab.WormEaten = 0;
    }
    public void act()
    {  String stringValue = Integer.toString(Crab.WormEaten);
        showText("WormsEaten:"+stringValue,80,30);
        detectGameOver();
    }
}