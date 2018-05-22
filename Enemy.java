
/**
 * Write a description of class Enemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enemy extends Being
{
    
    public Enemy(int health, int ac, int damage, String name){
        super(health, ac, damage, name);
    }
    
    public Enemy(String name){
        super(name);
    }
}
