import java.util.Random;
import java.lang.Math;
/**
 * Write a description of class MoveGeneratir here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MoveGenerator
{
    
    private Move[] moves;
    private Random random;
    private Being being;
    private Being player;
    
    public MoveGenerator(Being being, Being player){
        moves = new Move[10];
        random = new Random();
        this.being = being;
        this.player = player;
        generate();
    }
    
    public void generate(){
        System.out.println(being);
        
        for(int i = 0; i < moves.length; i++){
            String ret = "";
            
            
            int att = 1;
            int move = 2;
            
            boolean b = false;
            
            while(b == false){
                int a = random.nextInt(2);
                if(a == 0 && att > 0){
                    ret = ret + "attack player1 ";
                    att--;
                }
                 else if (move > 0){
                    ret = ret + "move " + positionToString(generatePosition());
                    move--;                
                }
                if(att == 0 && move == 0){
                    b = true;
                }
            }
            System.out.println(ret);
            moves[i] = new Move(ret);
        }
    }
    
    public Move[] getMoves(){
        return moves;
    }
    
    public String positionToString(Position position){
        int r = position.getR();
        int c = position.getC();
        
        if(r == 0){
            if(c == 0){
                return "one ";
            } else if (c == 1){
                return "two ";
            } else if (c==2){
                return "three ";
            }
        } else if (r == 1){
            if(c == 0){
                return "four ";
            } else if (c == 1){
                return "five ";
            } else if (c == 2){
                return "six ";
            }
        } else if (r == 2){
            if(c == 0){
                return "seven ";
            } else if (c == 1){
                return "eight ";
            } else if (c==2){
                return "nine ";
            }
        }
        
        return null;
    }
    //creates a position one space closer to player.
    public Position generatePosition(){
        int r = being.getPosition().getR();
        int c = being.getPosition().getC();
        int pr = player.getPosition().getR();
        int pc = player.getPosition().getC();
        int a = random.nextInt(2);
        
        if(a == 0){
            if (r < pr){
                r++;
            } else if (r > pr){
                r--;
            } else if (r == pr){
                if (c > pc){
                    c++;
                } else if (c < pc){
                    c--;
                }
            }
        }
        
        if(a == 1){
            if (c > pc){
                c--;
            } else if (c < pc){
                c++;
            } else if (c == pc){
                if (r < pr){
                    r++;
                } else if (r > pr){
                    r--;
                }
            }
        }
        
        if(c == pc && r == pr){
            if (a == 0){
                if( r >= 1){
                    r--;
                } else {
                    r++;
                }
            }
        }
        System.out.println(r + " " + c);
        return new Position(r,c);
    }
}
