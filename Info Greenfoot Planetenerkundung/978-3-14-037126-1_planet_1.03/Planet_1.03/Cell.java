import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Cell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cell extends Actor
{
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int x = 0;
    private int y = 0;
    int it = 0;
    private String UID = "";

    private ArrayList<Cell> parents = new ArrayList<Cell>();

    public int getF(){
        return f;
    }
    
    public String getUID(){
        return UID;
    }
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setCoords(int X,int Y){
        y = Y;
        x = X;
        UID = x+""+y;
    }

    public void set(int G, int H){
        g = G;
        h = H;
        f = g + h;
    }

    public ArrayList<Cell> getParents(){
        return parents;
    }

    public void setParents(ArrayList<Cell> newParents){
        parents = newParents;
    }
}

