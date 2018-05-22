
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Being
{
    
    public Player(int health, int ac, int damage, String name){
        super(health, ac, damage, name);
    }
    
    public Player(String name){
        super(name);
    }
}

