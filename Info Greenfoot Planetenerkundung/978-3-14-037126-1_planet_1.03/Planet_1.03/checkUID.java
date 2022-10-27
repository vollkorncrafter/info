import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class checkUID here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class checkUID extends Actor
{
    public static boolean check(Cell in)
    {
        boolean usable = true;
        
        ArrayList<Cell> prev = in.getParents();
        
        for(int i = 0; i < prev.size();i++){
            if(prev.get(i).getUID() == in.getUID()){
                usable = false;
            }

        }
        
        return usable;
    }
}
