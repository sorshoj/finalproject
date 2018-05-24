
/**
 * Write a description of class Move here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Move
{
    private String[] list;
    private int masterrate;
    
    public Move(String command){
        list = new String[command.split(" ").length];
        list = command.split(" ");
        for( int i = 0; i < list.length; i++){
            list[i] = list[i].trim();
        }
    }
    
    public String[] getList(){
        return list;
    }
    
    public void setRate(int s){
        masterrate = s;
    }
    
    public int getRate(){
        return masterrate;
    }
}
