import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class node here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class node extends Actor
{
        int x;
	int y;
	int distanceFromSource;

	node(int x, int y, int dis) {
		this.x = x;
		this.y = y;
		this.distanceFromSource = dis;
	}
}
