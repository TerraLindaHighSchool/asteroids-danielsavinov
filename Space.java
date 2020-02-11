import greenfoot.*;

/**
 * Space. Something for rockets to fly in.
 * 
 * @author Michael Kölling
 * @version 1.1
 */
public class Space extends World
{
    private Counter scoreCounter;
    private int startAsteroids = 3;
    private int starSize;

    /**
     * Create the space and all objects within it.
     */
    public Space() 
    {
        super(600, 500, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        
        Rocket rocket = new Rocket();
        addObject(rocket, getWidth()/2 + 100, getHeight()/2);
        
        addAsteroids(startAsteroids);
        
        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60, 480);

        Explosion.initializeImages();
        ProtonWave.initializeImages();
        
        paintStars(300);
        
    }
    private void paintStars(int count)
    {
        GreenfootImage background = getBackground();
        for (int i =0; i < count; i++)
        {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            starSize = Greenfoot.getRandomNumber(5);
            background.setColor(Color.WHITE);
            background.fillOval( x, y, starSize, starSize);
            
          
        } 
    }   
    /**
     * Add a given number of asteroids to our world. Asteroids are only added into
     * the left half of the world.
     */
    private void addAsteroids(int count) 
    {
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth()/2);
            int y = Greenfoot.getRandomNumber(getHeight()/2);
            addObject(new Asteroid(), x, y);
        }
    }
    
    /**
     * This method is called when the game is over to display the final score.
     */
    public void gameOver() 
    {
        // TODO: show the score board here. Currently missing.
    }

}