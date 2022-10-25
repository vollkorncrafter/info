import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Die einzigen aktiven Akteure in der Roboterwelt sind die Roboter.
 * Die Welt besteht aus 14 * 10 Feldern.
 */

public class Planet extends World
{
    private static int zellenGroesse = 50;

    /**
     * Erschaffe eine Welt mit 15 * 12 Zellen.
     */
    public Planet()
    {
        super(10, 10, zellenGroesse);
        setBackground("images/boden.png");
        setPaintOrder(String.class, Rover.class, Marke.class, Gestein.class, Huegel.class);
        Greenfoot.setSpeed(20); 
        prepare();
    }

    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Rover rover = new Rover();
        addObject(rover,0,5);
        Huegel huegel = new Huegel();
        addObject(huegel,5,3);
        Huegel huegel2 = new Huegel();
        addObject(huegel2,6,3);
        Huegel huegel3 = new Huegel();
        addObject(huegel3,7,3);
        Huegel huegel4 = new Huegel();
        addObject(huegel4,8,3);
        Huegel huegel5 = new Huegel();
        addObject(huegel5,9,3);
        Huegel huegel6 = new Huegel();
        addObject(huegel6,10,3);
        Huegel huegel7 = new Huegel();
        addObject(huegel7,10,4);
        Huegel huegel8 = new Huegel();
        addObject(huegel8,10,5);
        Huegel huegel9 = new Huegel();
        addObject(huegel9,9,5);
        Huegel huegel10 = new Huegel();
        addObject(huegel10,8,5);
        Huegel huegel11 = new Huegel();
        addObject(huegel11,7,5);
        Huegel huegel12 = new Huegel();
        addObject(huegel12,6,5);
        Huegel huegel13 = new Huegel();
        addObject(huegel13,5,5);
        Huegel huegel14 = new Huegel();
        addObject(huegel14,5,6);
        Huegel huegel15 = new Huegel();
        addObject(huegel15,12,3);
        Huegel huegel16 = new Huegel();
        addObject(huegel16,5,7);
        Huegel huegel17 = new Huegel();
        addObject(huegel17,6,7);
        Huegel huegel18 = new Huegel();
        addObject(huegel18,7,7);
        Huegel huegel19 = new Huegel();
        addObject(huegel19,8,7);
        Huegel huegel20 = new Huegel();
        addObject(huegel20,9,7);
        Huegel huegel21 = new Huegel();
        addObject(huegel21,10,7);
        Huegel huegel22 = new Huegel();
        addObject(huegel22,12,3);
        removeObject(huegel15);
        removeObject(huegel22);
        Gestein gestein = new Gestein();
        addObject(gestein,8,4);
    }
}