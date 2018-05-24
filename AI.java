
/**
 * Write a description of class AI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AI
{
    private MoveGenerator movegenerator;
    private Move[] movelist;
    private Board board;
    private Being player;
    private Being being;
    
    /**
     * Constructor for objects of class AI
     */
    public AI (Being being, Being player, Board board)
    {
        movegenerator = new MoveGenerator(being, player);
        movelist = new Move[10];
        movelist = movegenerator.getMoves();
        this.board = board;
        this.being = being;
        this.player = player;
    }
    
    public Being getBeing(){
        return being;
    }
    
    public Move rate(){
        Move master = movelist[0];
        
        //master rating (0-10)
        //attack rating (0-5)
        //movement rating (0-5)
        
        int att = 0;
        int mov = 0;
        int masternum = 0;
        
        movelist[0].setRate(masternum);
        
        for(int j = 1; j < movelist.length; j++){
            
            String[] a = movelist[j].getList();
            
            for(int i = 0; i < a.length; i++){
                if(a[i].equals("attack")){
                     att = att + 5;
                     //skip the string "player1"
                     i++;
                }
                if(a[i].equals("move")){
                    if(board.comparePositions(being.getPosition(), player.getPosition())){
                        mov = mov + 2;
                    }
                    i++;
                }
            }
            masternum = att + mov;
            movelist[j].setRate(masternum);
            
            if(movelist[j].getRate() > movelist[j-1].getRate()){
                master = movelist[j];
            }
        }
        
        return master;
    }

    }

