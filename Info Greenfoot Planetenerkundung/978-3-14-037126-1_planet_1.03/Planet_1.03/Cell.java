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
    int posx = 0;
    int posy = 0;
    Cell[] arr = {};
    ArrayList<String> prev = new ArrayList<String>();
    String UUID = "";
    int MAXY = 9;
    int MAXX = 9;
    int LIMMIT = 100;
    int current = 0;
    public void update(Integer posX, Integer posY,Cell[] oarr,Integer nc,ArrayList<String> prevprev){
        posx = posX;
        posy = posY;
        UUID = posx +""+ posy;
        arr = oarr;
        int X2 = posx -1;
        current = nc;
        prev = prevprev;
        prev.add(UUID);
        System.out.println(posx + " " + posy);
        
        
        System.out.println(current);
        // +1
        int X1 = posx +1;
        if(!(prev.contains(X1 +""+ posy))){
            if(current < LIMMIT){
                if(X1 < MAXX){
                    Cell ZelleX1 = new Cell();
                    ZelleX1.update(X1,posy,arr,current+1,prev);
                }
            }
        }
        X1 = posx -1;
        if(!(prev.contains(X1 +""+ posy))){
            if(current < LIMMIT){
                if(X1 > 0){
                    Cell ZelleX2 = new Cell();
                    ZelleX2.update(X1,posy,arr,current+1,prev);
                }
            }
        }
        int Y1 = posy +1;
        if(!(prev.contains(posx +""+ Y1))){
            if(current < LIMMIT){
                if(Y1 < MAXY){
                    Cell ZelleY1 = new Cell();
                    ZelleY1.update(Y1,posx,arr,current+1,prev);
                }
            }
        }

    }
}
