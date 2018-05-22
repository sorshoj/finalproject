import java.util.Random;
/**
 * Write a description of class tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class tester
{
    public static void main(String[] args){
        Random random = new Random();
        
        Being enemy1 = new Enemy("enemy1");
        Being enemy2 = new Enemy("enemy2");
        Being[] enemylist = {enemy1, enemy2};
        Board board = new Board(enemylist);
        Being player1 = new Player("player1");
        
        //Game game  = new Game(board);
        
        //game.move(player1, new Position(random.nextInt(2), random.nextInt(2)));
        
        board.printBoard();
        
        //game.attack(player1, enemy2);
        
        System.out.println();
        
    }
}
