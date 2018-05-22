
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{
    private Board board;
    private Parser parser;
    private Being player;
    private Being enemy1;
    private Being enemy2;
    private Being[] enemylist;

    public Game(){
        
        parser = new Parser();
        player = new Player("player1");
        
        enemy1 = new Enemy("enemy1");
        enemy2 = new Enemy("enemy2");
        enemylist = new Being[]{enemy1, enemy2};
        
        board = new Board(enemylist);
        
        board.setPosition(player, new Position(2,1));
    }
    
    
    public void play(){      
        boolean finished = false;

        board.printBoard();
        
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
    
    public void attack(Being being, Being being2){
        System.out.println(being.getPosition() + " & " + being2.getPosition());
        if(board.comparePositions(being.getPosition(), being2.getPosition())){
            int a =  being.getDamage();
            being2.setHealth(being2.getHealth() - a); 
            System.out.println(being + " hits " + being2 + " for " + a + " damage!");
            System.out.println(being2 + " health is: " + being2.getHealth());
        }  else {
            System.out.println("Target is too far away!");
        }
    }
    
    public void move(Being being, Position position){
        if(board.isFreePosition(position)){
            board.emptyPosition(being);
            board.setPosition(being, position);
        } else {
            System.out.println("Movement not available");
        }
    }
    
    public boolean processCommand(Command command){
        boolean quit = false;
        
        if(command.isUnknown()){
            System.out.println("Not a recognized request");
            return true;
        }
        
        String commandWord = command.getFirstWord();
        if(commandWord.equals("attack")){
            if(command.getSecondWord() == null){
                System.out.println("Attack who?");
           } else {
               attack(player, findBeing(command));
           }
        } else if (commandWord.equals("quit")){
            quit = true;
        } else if (commandWord.equals("position")){
            move(player, findPosition(command));
            board.printBoard();
        } else if (commandWord.equals("show")){
            if(command.getSecondWord().equals("board")){
                board.printBoard();
            }
        }
        
        return quit;
    }
    
    public Position findPosition(Command command){
        String word = command.getSecondWord();
        if(word.equals("one")){
            return new Position(0,0);
        }
        if(word.equals("two")){
            return new Position(0,1);
        }
        if(word.equals("three")){
            return new Position(0,2);
        }
        if(word.equals("four")){
            return new Position(1,0);
        }
        if(word.equals("five")){
            return new Position(1,1);
        }
        if(word.equals("six")){
            return new Position(1,2);
        }
        if(word.equals("seven")){
            return new Position(2,0);
        }
        if(word.equals("eight")){
            return new Position(2,1);
        }
        if(word.equals("nine")){
            return new Position(2,2);
        }

        return null;
    }
    public Being findBeing(Command command){
        for(Being being: enemylist){
            if(being.getName().equals(command.getSecondWord())){
                return being;
            }
        }
        if(command.getSecondWord().equals(player.getName())){
            return player;
        }
        System.out.println("Cannot find this being");
        return null;
    }
}
