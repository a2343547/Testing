import greenfoot.*;

/**
 * This class defines a crab. Crabs live on the beach.
 */
/**  
  *  github is crazy
  */
public class Crab extends Actor
{
  static int WormEaten=0;
  private GreenfootImage img1;
  private GreenfootImage img2;
  private int switcher=10;
  private int switchTimer=0;
  public Crab()
  {
      img1=new GreenfootImage("crab.png");
      img2=new GreenfootImage("crab2.png");
  }
  public void changeImage()
  {
    GreenfootImage img=getImage();      
    if(switcher!=switchTimer)
    switcher--;
    else
    {
    if(img==img1)
    {
        setImage(img2);
        switcher=10;
    }
    else
    {
        setImage(img1);
        switcher=10;
    }
}
  }
  public void eatWorm()
  {
      if(isTouching(Worm.class))      
      {  GreenfootSound gs=new GreenfootSound("au.wav");
         gs.play();
         removeTouching(Worm.class);
         WormEaten++;
      }
    }
  public void crabMove()
   {
    if(Greenfoot.isKeyDown("left"))
    {
     turn(-5);
    }
    if(Greenfoot.isKeyDown("right"))
    {
     turn(5);
    }
    if(isAtEdge())
    {
        //setRotation(getRotation()*2);
    }
    move(2);
   }
  public void act()
    {
        // Add your action code here
        crabMove();
        eatWorm();
        
        changeImage();
    }
}


