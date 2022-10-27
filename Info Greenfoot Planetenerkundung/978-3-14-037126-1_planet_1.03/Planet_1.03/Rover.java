import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

public class Rover extends Actor
{
    private Display anzeige;

    
    
    
    
    public String fahrEntscheidung(int[] c){
        String richtung = "";
        if(c[0] > getX()){
            richtung = "rechts";
        }else if(c[0] <getX()){
            richtung = "links";
        }else if(c[1] > getY()){
            richtung = "unten";
        }else if(c[1] < getY()){
            richtung = "oben";
        }
        
        
        
        return richtung;
    }
    
    
    public void fahreNach(String richtung)
    {
            //setRotation(getRotation()+90);
        if(richtung == "links") {
            setRotation(180); 
            fahre();
        }
        if(richtung == "rechts") {
            setRotation(0); 
            fahre();
        }
        if(richtung == "unten") {
            setRotation(90); 
            fahre();
        }
        if(richtung == "oben") {
            setRotation(270); 
            fahre();
        }
    }
    
    
    public ArrayList<int[]> driveTo(int zielX, int zielY) 
    {
        ArrayList<Cell> open = new ArrayList<Cell>();
        ArrayList<Cell> closed = new ArrayList<Cell>();
        ArrayList<Cell> parents = new ArrayList<Cell>();
        ArrayList<int[]> notloesung = new ArrayList<int[]>();
        boolean[][] walkable = Welt();
        Cell first = new Cell();
        first.setCoords(getX(),getY());
        open.add(first);

        int maxX = 9;
        int maxY = 9;
        
        int live = 100;
        
        ArrayList<int[]> way = new ArrayList<int[]>();
        
        
        while(open.size() > 0){
            int lowest = 10000;
            int index = 0;
            boolean moeglich = false;
            Cell q = new Cell();
            for(int n = 0;n < open.size(); n++){
                if(open.get(n).getF() < lowest){
                    q = open.get(n);
                    lowest = q.getF();
                    index = n;
                    if(q.it == live){
                        open.remove(n);
                        System.out.println("ohje");
                    }
                }
            }
            open.remove(index);
            System.out.println(q.getUID());
            parents = q.getParents();
            parents.add(q);
            if(q.getX() == zielX && q.getY() == zielY){
                System.out.println("found");
                for(int i=0; i < q.getParents().size(); i++) {
                    int x =q.getParents().get(i).getX();
                    int y =q.getParents().get(i).getY();
                    System.out.println(x + " " + y);
                    int[] xy = {x,y};
                    way.add(xy);
                    
                    fahreNach(fahrEntscheidung(xy));
                }
                return way;
            }

            if(!(q.getY()+1 > maxY)){
                if(walkable[q.getX()][q.getY()+1]){
                    Cell OBEN = new Cell();
                    OBEN.setCoords(q.getX(),q.getY()+1);
                    OBEN.set(1,(Math.abs(OBEN.getX() - zielX)+Math.abs(OBEN.getY() - zielY)));
                    OBEN.setParents(parents);
                    OBEN.it = q.it + 1;
                    if(checkUID.check(OBEN)){
                        open.add(OBEN);
                        moeglich = true;
                    }

                }
            }

            if(q.getY()-1 > 0){
                if(walkable[q.getX()][q.getY()-1]){
                    Cell UNTEN = new Cell();
                    UNTEN.setCoords(q.getX(),q.getY()-1);
                    UNTEN.set(1,(Math.abs(UNTEN.getX() - zielX)+Math.abs(UNTEN.getY() - zielY)));
                    UNTEN.setParents(parents);
                    UNTEN.it = q.it + 1;
                    if(checkUID.check(UNTEN)){
                        open.add(UNTEN);
                        moeglich = true;
                    }
                }
            }

            if(!(q.getX()+1 > maxX)){
                if(walkable[q.getX()+1][q.getY()]){
                    Cell RECHTS = new Cell();
                    RECHTS.setCoords(q.getX()+1,q.getY());
                    RECHTS.set(1,(Math.abs(RECHTS.getX() - zielX)+Math.abs(RECHTS.getY() - zielY)));
                    RECHTS.setParents(parents);
                    RECHTS.it = q.it + 1;
                    if(checkUID.check(RECHTS)){
                        open.add(RECHTS);
                        moeglich = true;
                    }
                }
            }

            if(q.getX()-1 > 0){
                if(walkable[q.getX()-1][q.getY()]){
                    Cell LINKS = new Cell();
                    LINKS.setCoords(q.getX()-1,q.getY());
                    LINKS.set(1,(Math.abs(LINKS.getX() - zielX)+Math.abs(LINKS.getY() - zielY)));
                    LINKS.setParents(parents);
                    LINKS.it = q.it + 1;
                    if(checkUID.check(LINKS)){
                        open.add(LINKS);
                        moeglich = true;
                    }
                }
            }
            
            if(!moeglich){
                open.remove(q);
            }

        }
        return notloesung;
    } 

    public void findPath() {
    }

    public boolean[][] Welt() {
        boolean[][] map = new boolean[10][10];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j <10; j++){
                map[i][j] = getCell(i,j);
            }
        }
        return map;
    }

    public boolean getCell(int x, int y) {
        int rx = getX() ;
        int ry = getY() ;
        int px = x - rx;
        int py = y - ry;
        boolean type = true;
        if(getOneObjectAtOffset(px,py,Huegel.class)!=null){ //Huegel = 2
            type = false;
        }else if(getOneObjectAtOffset(px,py,Gestein.class)!=null){ //Gestein = 1
            //number = "1";
            type = true;
        }
        return type;
    }

    /**
     * Der Rover bewegt sich ein Feld in Fahrtrichtung weiter.
     * Sollte sich in Fahrtrichtung ein Objekt der Klasse Huegel befinden oder er sich an der Grenze der Welt befinden,
     * dann erscheint eine entsprechende Meldung auf dem Display.
     */
    public void fahre()
    {
        int posX = getX();
        int posY = getY();

        if(huegelVorhanden("vorne"))
        {
            nachricht("Zu steil!");
        }
        else if(getRotation()==270 && getY()==1)
        {
            nachricht("Ich kann mich nicht bewegen");
        }
        else
        {
            move(1);
            Greenfoot.delay(1);
        }

        if(posX==getX()&&posY==getY()&&!huegelVorhanden("vorne"))
        {
            nachricht("Ich kann mich nicht bewegen");
        }
    }

    /**
     * Der Rover dreht sich um 90 Grad in die Richtung, die mit richtung (�links� oder �rechts�) �bergeben wurde.
     * Sollte ein anderer Text (String) als "rechts" oder "links" �bergeben werden, dann erscheint eine entsprechende Meldung auf dem Display.
     */
    public void drehe(String richtung)
    {
        if(richtung=="rechts")
        {
            setRotation(getRotation()+90);
        }
        else if (richtung=="links")
        {
            setRotation(getRotation()-90);
        }
        else
        {
            nachricht("Befehl nicht korrekt!");
        }
    }

    /**
     * Der Rover gibt durch einen Wahrheitswert (true oder false )zur�ck, ob sich auf seiner Position ein Objekt der Klasse Gestein befindet.
     * Eine entsprechende Meldung erscheint auch auf dem Display.
     */
    public boolean gesteinVorhanden()
    {
        if(getOneIntersectingObject(Gestein.class)!=null)
        {
            nachricht("Gestein gefunden!");
            return true;

        }

        return false;
    }

    /**
     * Der Rover �berpr�ft, ob sich in richtung ("rechts", "links", oder "vorne") ein Objekt der Klasse Huegel befindet.
     * Das Ergebnis wird auf dem Display angezeigt.
     * Sollte ein anderer Text (String) als "rechts", "links" oder "vorne" �bergeben werden, dann erscheint eine entsprechende Meldung auf dem Display.
     */
    public boolean huegelVorhanden(String richtung)
    {
        int rot = getRotation();

        if (richtung=="vorne" && rot==0 || richtung=="rechts" && rot==270 || richtung=="links" && rot==90)
        {
            if(getOneObjectAtOffset(1,0,Huegel.class)!=null && ((Huegel)getOneObjectAtOffset(1,0,Huegel.class)).getSteigung() >30)
            {
                return true;
            }
        }

        if (richtung=="vorne" && rot==180 || richtung=="rechts" && rot==90 || richtung=="links" && rot==270)
        {
            if(getOneObjectAtOffset(-1,0,Huegel.class)!=null && ((Huegel)getOneObjectAtOffset(-1,0,Huegel.class)).getSteigung() >30)
            {
                return true;
            }
        }

        if (richtung=="vorne" && rot==90 || richtung=="rechts" && rot==0 || richtung=="links" && rot==180)
        {
            if(getOneObjectAtOffset(0,1,Huegel.class)!=null && ((Huegel)getOneObjectAtOffset(0,1,Huegel.class)).getSteigung() >30)
            {
                return true;
            }

        }

        if (richtung=="vorne" && rot==270 || richtung=="rechts" && rot==180 || richtung=="links" && rot==0)
        {
            if(getOneObjectAtOffset(0,-1,Huegel.class)!=null && ((Huegel)getOneObjectAtOffset(0,-1,Huegel.class)).getSteigung() >30)
            {
                return true;
            }

        }

        if(richtung!="vorne" && richtung!="links" && richtung!="rechts")
        {
            nachricht("Befehl nicht korrekt!");
        }

        return false;
    }

    /**
     * Der Rover ermittelt den Wassergehalt des Gesteins auf seiner Position und gibt diesen auf dem Display aus.
     * Sollte kein Objekt der Klasse Gestein vorhanden sein, dann erscheint eine entsprechende Meldung auf dem Display.
     */
    public void analysiereGestein()
    {
        if(gesteinVorhanden())
        {
            nachricht("Gestein untersucht! Wassergehalt ist " + ((Gestein)getOneIntersectingObject(Gestein.class)).getWassergehalt()+"%.");
            Greenfoot.delay(1);
            removeTouching(Gestein.class);
        }
        else 
        {
            nachricht("Hier ist kein Gestein");
        }
    }

    /**
     * Der Rover erzeugt ein Objekt der Klasse �Markierung� auf seiner Position.
     */
    public void setzeMarke()
    {
        getWorld().addObject(new Marke(), getX(), getY());
    }

    public void mark(int X, int Y){
        getWorld().addObject(new Marke(), X, Y);
    }

    /**
     * *Der Rover gibt durch einen Wahrheitswert (true oder false )zur�ck, ob sich auf seiner Position ein Objekt der Marke befindet.
     * Eine entsprechende Meldung erscheint auch auf dem Display.
     */
    public boolean markeVorhanden()
    {
        if(getOneIntersectingObject(Marke.class)!=null)
        {
            return true;
        }

        return false;
    }

    public void entferneMarke()
    {
        if(markeVorhanden())
        {
            removeTouching(Marke.class);
        }
    }

    private void nachricht(String pText)
    {
        if(anzeige!=null)
        {
            anzeige.anzeigen(pText);
            Greenfoot.delay(1);
            anzeige.loeschen();
        }
    }

    private void displayAusschalten()
    {
        getWorld().removeObject(anzeige);

    }

    protected void addedToWorld(World world)
    {

        setImage("images/rover.png");
        world = getWorld();
        anzeige = new Display();
        anzeige.setImage("images/nachricht.png");
        world.addObject(anzeige, 7, 0);
        if(getY()==0)
        {
            setLocation(getX(),1);
        }
        anzeige.anzeigen("Ich bin bereit");

    }

    class Display extends Actor
    {
        GreenfootImage bild; 

        public Display()
        {
            bild = getImage();
        }

        public void act() 
        {

        }  

        public void anzeigen(String pText)
        {
            loeschen();
            getImage().drawImage(new GreenfootImage(pText, 25, Color.BLACK, new Color(0, 0, 0, 0)),10,10);

        }

        public void loeschen()
        {
            getImage().clear();
            setImage("images/nachricht.png");
        }

    }
}
