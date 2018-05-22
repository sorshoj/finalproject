
/**
 * Write a description of class Being here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Being
{
    private int health;
    private int currenthealth;
    
    private int numattacks;
    private int nummovement;
    
    private int ac;
    private int damage;
    private String name;
    private Position position;
    //2 health, 1 weak, 0 dead.
    private int condition;
    
    public Being(int health, int ac, int damage, String name){
        this.health = health;
        this.ac = ac;
        this.damage = damage;
        this.name = name;
        condition = 2;
        currenthealth = health;
        position = new Position(3,3);
    }
    
    public Being(String name){
        health = 10;
        currenthealth = 10;
        ac = 12;
        damage = 8;
        this.name = name;
        condition = 2;
        position = new Position(3,3);
    }
   
    //accessors & modifiers
    public int getHealth(){
        return currenthealth;
    }
    public int getAC(){
        return ac;
    }
    public int getDamage(){
        return damage;
    }
    public String getName(){
        return name;
    }
    public void setHealth(int num){
        currenthealth = num;
        if(currenthealth > health/2){
            condition = 1;
        } else if (currenthealth == 0){
            condition = 0;
        }
    }
    public int getCondition(){
        return condition;
    }
    public void setPosition(Position position){
        this.position = position;
    }
    public Position getPosition(){
        return position;
    }
    public String toString(){
        return name;
    }
}
