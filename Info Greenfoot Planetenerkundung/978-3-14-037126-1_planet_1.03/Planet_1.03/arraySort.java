import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class arraySort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class arraySort extends Actor
{
    
    public ArrayList<int[]> sortFour(ArrayList<int[]> one,ArrayList<int[]> two,ArrayList<int[]> three,ArrayList<int[]> four){
        ArrayList<int[]> rv = new ArrayList<int[]>();
        ArrayList<ArrayList<int[]>> Liste = new ArrayList<ArrayList<int[]>>();
        ArrayList<ArrayList<int[]>> Liste2 = new ArrayList<ArrayList<int[]>>();
        
        for(int i = 0; i < 4; i++){
            if(Liste.get(i).size() < 1){
                //:(
            }else{
                Liste2.add(Liste.get(i));
            }
        }
        for(int i=1; i <4; i++){
            if(Liste2.size()>1){
                if(Liste2.get(i-1).size() > (Liste2.get(i).size())){
                    ////a = Liste2.get(i-1);//ArrayList<Int[]> b = Liste2.get(i);//Liste2.set(i) = /////Liste2.set(i-1) = b;/
                }
            }else{
                rv=Liste2.get(0);
            }
        }
        return rv;
    }
}
