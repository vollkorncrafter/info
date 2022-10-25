import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class indexObjectIn2DStringArray here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class indexObjectIn2DStringArray extends Actor
{
    public static int[] find(String[][] arr,String querry) {
        for(int i = 0; i < arr.length; i++) {
            String[] c = arr[i];
            for(int j = 0; j < c.length; j++) {
                int[] rv = {i,j};
                if(c[j] == querry){
                    return rv;
                }
            }
        }
        int[] nope = {69,420};
        return nope;
    }
}

