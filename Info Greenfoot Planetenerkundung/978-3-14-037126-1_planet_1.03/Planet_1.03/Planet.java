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
        Huegel huegel23 = new Huegel();
        addObject(huegel23,5,0);
        Huegel huegel24 = new Huegel();
        addObject(huegel24,5,1);
        Huegel huegel25 = new Huegel();
        addObject(huegel25,6,0);
        Huegel huegel26 = new Huegel();
        addObject(huegel26,7,0);
        Huegel huegel27 = new Huegel();
        addObject(huegel27,8,0);
        Huegel huegel28 = new Huegel();
        addObject(huegel28,9,0);
        Huegel huegel29 = new Huegel();
        addObject(huegel29,9,1);
        Huegel huegel30 = new Huegel();
        addObject(huegel30,8,1);
        Huegel huegel31 = new Huegel();
        addObject(huegel31,7,1);
        Huegel huegel32 = new Huegel();
        addObject(huegel32,6,1);
        Huegel huegel33 = new Huegel();
        addObject(huegel33,5,2);
        Huegel huegel34 = new Huegel();
        addObject(huegel34,6,2);
        Huegel huegel35 = new Huegel();
        addObject(huegel35,7,2);
        Huegel huegel36 = new Huegel();
        addObject(huegel36,8,2);
        Huegel huegel37 = new Huegel();
        addObject(huegel37,9,2);
        Huegel huegel38 = new Huegel();
        addObject(huegel38,4,0);
        Huegel huegel39 = new Huegel();
        addObject(huegel39,3,0);
        Huegel huegel40 = new Huegel();
        addObject(huegel40,2,0);
        Huegel huegel41 = new Huegel();
        addObject(huegel41,1,0);
        Huegel huegel42 = new Huegel();
        addObject(huegel42,0,0);
        Huegel huegel43 = new Huegel();
        addObject(huegel43,1,1);
        Huegel huegel44 = new Huegel();
        addObject(huegel44,2,1);
        Huegel huegel45 = new Huegel();
        addObject(huegel45,3,1);
        Huegel huegel46 = new Huegel();
        addObject(huegel46,4,1);
        Huegel huegel47 = new Huegel();
        addObject(huegel47,4,2);
        Huegel huegel48 = new Huegel();
        addObject(huegel48,3,2);
        Huegel huegel49 = new Huegel();
        addObject(huegel49,0,3);
        Huegel huegel50 = new Huegel();
        addObject(huegel50,1,3);
        Huegel huegel51 = new Huegel();
        addObject(huegel51,0,7);
        Huegel huegel52 = new Huegel();
        addObject(huegel52,1,7);
        Huegel huegel53 = new Huegel();
        addObject(huegel53,1,8);
        Huegel huegel54 = new Huegel();
        addObject(huegel54,1,9);
        Huegel huegel55 = new Huegel();
        addObject(huegel55,0,8);
        Huegel huegel56 = new Huegel();
        addObject(huegel56,0,9);
        Huegel huegel57 = new Huegel();
        addObject(huegel57,2,7);
        Huegel huegel58 = new Huegel();
        addObject(huegel58,3,7);
        Huegel huegel59 = new Huegel();
        addObject(huegel59,2,8);
        Huegel huegel60 = new Huegel();
        addObject(huegel60,5,8);
        Huegel huegel61 = new Huegel();
        addObject(huegel61,7,9);
        Huegel huegel62 = new Huegel();
        addObject(huegel62,9,8);
        Huegel huegel63 = new Huegel();
        addObject(huegel63,9,9);
        Huegel huegel64 = new Huegel();
        addObject(huegel64,3,4);
        Huegel huegel65 = new Huegel();
        addObject(huegel65,2,6);
        removeObject(huegel64);
    }
}