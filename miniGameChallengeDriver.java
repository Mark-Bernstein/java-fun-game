/**
 *
 * @author Mark Bernstein
 */

/**
 * This (driver) class runs the playerIntroduction() method 
 * in the MiniGameChallenge class, then runs the gamblingGame() method 
 * in the GamblingGame class
 */
public class MiniGameChallengeDriver //extends MiniGameChallenge
{
  public static void main (String[] args)
  {
    //creates new object @startGames so I can call upon it to start the chosen methods
    MiniGameChallenge startGames = new MiniGameChallenge();  
    
   //creates new object @realGame so I can call upon it to start the chosen methods
    GamblingGame realGame = new GamblingGame();
    
    //set variables for timer
    long startTimer = 0, stopTimer = 0;
    
    //start timing the user
    startTimer = System.currentTimeMillis();
    
    //call the playerIntroduction method
    startGames.playerIntroduction();

    //stop the timer at completion of game
    stopTimer = System.currentTimeMillis();
    
    //print final results for user
    System.out.println("");
    System.out.println("Arrrggghhh shiver me timbers. That'll do.");
    System.out.println("Results for " + startGames.getUserName() + ", " + startGames.getUserAge() + " years old... loading...please wait...");
    System.out.println("");
    System.out.println(startGames.toString());
  
    //tell user how long it took to complete the entire challenge
    System.out.println("You spent: " + (stopTimer - startTimer) / 1000 + " seconds on those first 2 games.");
    System.out.println("");
    
    //call the gamblingGame
    realGame.gamblingGame();
 
  }//end main
}//end class
