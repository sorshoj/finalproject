import java.util.Random;
/**
 * Write a description of class Board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Board
{
    private Being[][] board;
    private Random random;

    //enemylist must be under 9
    public Board(Being[] enemylist){
        board = new Being[3][3];
        random = new Random();
        setUpBoard(enemylist);
    }

    
    //enemylist is under 3
    public void setUpBoard(Being[] enemylist){
        int c = 0;
        for(Being being: enemylist){
            setPosition(being, new Position(0,c));
            c++;
        }
    }

    public void setPosition(Being being, Position position){
        if(isFreePosition(position) == true){
            board[position.getR()][position.getC()] = being;
            being.setPosition(position);
        } else {
            System.out.println("Position not available");
        }
    }
    
    public boolean isFreePosition(Position position){
        if(board[position.getR()][position.getC()]  == null){
            return true;
        }
        return false;
    }
    
    public void emptyPosition(Being being){
        board[being.getPosition().getR()][being.getPosition().getC()] = null;
        being.setPosition(null);
    }

    public void printBoard(){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                System.out.print(board[r][c] + ",  ");
            }
            System.out.println();
        }
    }
    
        
    //compare Positions. returns true if in 4 adjacent squares
    public boolean comparePositions(Position position1, Position position2){
        //System.out.println("" + position1.getR() + position1.getC() + position2.getR() + position2.getC());
        if((position1.getR()+1 == position2.getR() || position1.getR()-1 == position2.getR() ||
        position1.getR() == position2.getR()) && (position1.getC()+1 == position2.getC() 
        || position1.getC()-1 == position2.getC() || position1.getC() == position2.getC())){
            return true;
        }
        return false;
    }
}
