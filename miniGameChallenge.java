/**
 *
 * @author Mark Bernstein
 */
import java.util.*;
import java.util.Scanner;
import java.awt.*;
import java.util.Random;
import java.io.*;
import java.util.InputMismatchException;
import java.lang.Exception;

/**
 * This class runs 2 mini games back to back asking the user for their
 * name, age, and guesses to 2 number-guessing-questions
 */
public class MiniGameChallenge
{
  ////////////////////fields////////////////////
  //private int scoreCounter;
  private String userName;
  private int userAge;
  private int userScore;
  
  ////////////////////constructors////////////////////
  
  /**
   * Constructor without parameters.
   * Sets fields with default values.
   */
  public MiniGameChallenge()
  {
    this.userName = "CPU_1";
    this.userAge = 150;
    this.userScore = 9001;
  }//end constructor
  
  /**
   * Constructor that takes name, age, and as parameters.
   * @param theUserName -- the name for the player
   * @param theUserAge -- the age of the player
   * @param theUserScore -- the total score of the player
   */
  public MiniGameChallenge(String theUserName, int theUserAge, int theUserScore)
  {
    this.userName = theUserName;
    this.userAge = theUserAge;
    this.userScore = theUserScore;
  }//end constructor
  
  ////////////////////methods////////////////////

  public String toString() //toString method
  {
    return "Player Name: " + this.userName + '\n' + 
      "Player Age: " + this.userAge + '\n' +
      "Player Score: " + this.userScore;
  }
  
  //method to get the users name @return the users name
  public String getUserName()
  {
    return userName;
  }
  
  //method to get the users age @return the users age
  public int getUserAge()
  {
    return userAge;
  }//end method
  
  //method to get the users score @return the users score
  public int getUserScore()
  {
    return userScore;
  }//end method
  
  /**
   * Method to set the users name
   * @param theUserName
   */
  public boolean setUserName(String theUserName)
  {
    boolean result = false;  
    if (userName != "")
    {
      userName = theUserName;
      result = true;
    }//end if
    else
    {
      System.out.println("Error. Invalid name. Default name will be CPU_1.");
      return false;
    }//end else
    //return the name
    return result;
  }//end method
  
  /**
   * Method to set the users age
   * @param theUserAge
   */
  public boolean setUserAge(int theUserAge)
  {
    boolean result = false;
    if (theUserAge >= 0)
    {
      userAge = theUserAge;
      result = true;
    }//end if
    else
    {
      System.out.println("Age needs to be greater than 0. Default value will be 150.");
    }//end else
    return result;    
  }//end method  
  
  /**
   * Method to set the users total score
   * @param theUserScore
   */
  public boolean setUserScore(int theUserScore)
  {
    boolean result = false;
    if (theUserScore >= 0)
    {
      userScore = theUserScore;
      result = true;
    }//end if
    else
    {
      System.out.println("Score needs to be 0 or higher. Default score will be 9001.");
    }//end else
    return result;
  }//end method
  
  ////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////
  
  /**
   * Method to play the game
   */
  public void playerIntroduction()
  {
    ////////////////////variables used////////////////////////////
    Scanner keyboard = new Scanner(System.in);
    userAge = 0; //initializes user age to 0
//    int scoreCounterGame1 = 0; //count for number of incorrect answer in game 1
//    int scoreCounterGame2 = 0; //count for number of incorrect answer in game 2
    int correctAnswer = 2; //the only correct answer
    int guess = 0; //what the user guesses
    userScore = 0; //= scoreCounterGame1 + scoreCounterGame2; //summed score from both games
    
    /////////////////////**START GAME**//////////////////////////
    
    System.out.println("Welcome to the MEGA ULTRA DELUXE MINI GAME CHALLENGEEEEEE!!!!");
    System.out.println("I am your host with the most, Mr. Computer Robot...thing...(!?)");
    System.out.println("Anyways...What shall I call you?");
    
    //sets the variable 'userName' to an empty string
    userName = "";
    
    //forces the while loop from initialization above
    while (userName.equals(""))
    {
        //sets the variable 'userName' to whatever the user enters next on their keyboard
        userName = keyboard.nextLine();
        
        if (userName.equals("")) //if user just presses enter
        {
          System.out.println("C'mon, you must have a name.");
        }//end try
    }//end while
    
    setUserName(userName);
    
    System.out.println("\nNow if there's anything I know about great names... It's that yours is one for sure.");
    System.out.println("...so ...um...");
    System.out.println("What is your age? Although yes, I know, age is but a mere number.");
    
    //continue asking for users age until a valid integer is given
    while (!keyboard.hasNextInt())  //while input is not an integer
    { 
      System.out.print("Not a valid age. Enter your real age. ");
      keyboard.next(); //give user a text box for input     
    }//end while

    //sets the variable 'userAge' to whatever the user enters next on their keyboard
    userAge = keyboard.nextInt(); //set userAge to the user's input  
      
    System.out.println("\nWoahhh, that's like " + (userAge * 365 * 24) + " hours. " + "Now THAT'S A NUMBER!" + 
                       "\n...errr... what I mean is that... uhh... I think we have a very wise mortal here.");
    System.out.println("Okay " + userName + ", are you ready for the 'best' adventure of your life?");
    
    //doesn't matter what the user enters here
    keyboard.next();
    
    System.out.println("\nWell, you don't need to be ready anyways. You were BORN ready! Now let's go!");
    System.out.println("Oh and by the way... " 
                         + " this is ***TIMED***. Go and show us what you're made of and crush your opponents!");
    System.out.println("\nGuess a number between 0-10... or use your wisdom to find the perfect 'match'.");
    
    //continue loop until user guesses the correctAnswer (which is 2)
    while(guess != correctAnswer)
    {
      try
      { 
        guess = keyboard.nextInt(); //give user a text box for input
        
        if (guess == 0 || guess == 10)
        {
          System.out.println("I asked for a number BETWEEN 0 and 10. Try again.");
          userScore++; //add +1 to the FAIL counter
        }//end if
        
        else if (guess < 0 || guess > 10)
        {
          System.out.println(guess + " is not between 0 and 10. Try again.");
          userScore++; //add +1 to the FAIL counter
        }//end else if
        
        else if (guess < 10 && guess > 2)
        {
          System.out.println("Hmmm... " + guess + "... verifying...please wait... " + 
                           "\nNope " + guess + " isn't it. " + 
                           "\nYou're in the right range... but too high.");
          userScore++; //add +1 to the FAIL counter 
        }//end else if
        
        else if (guess == 1)
        {
          System.out.println("Ooo... so close.. but it takes more than 1 to tango.");
          userScore++; //add +1 to the FAIL counter
        }//end else if
        else if (guess == correctAnswer)
        {
          System.out.println("Good job. You had " + userScore + 
                             " failed attempt(s) this round. " 
                             + userScore + " point(s) will be added to your score."); 
          System.out.println("Your total score so far is " + userScore + ".");
          System.out.println("On to the next question.");
          System.out.println(""); //for spacing purposes
        }//end else if
      }//end try
   
      //if user types something other than an integer, catch here and re-ask the previous question
      catch (InputMismatchException e)
      {
        System.out.print("Not a valid (integer) input. Error. Try again. ");
        userScore++; //add +1 to the FAIL counter
        keyboard.next(); //give user a text box for input
      }//end catch
    }//end while
    
    /////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////    
      
    //moving seamlessly onto the next game of Higher Or Lower
    System.out.println("Okay this time the secret number is somewhere between 10-20..." + 
                       " but even I don't know what it is! #Goodluck");
      
    Random randomNumber = new Random(); //random number generator
    int number = randomNumber.nextInt(9) + 11; //have the generator pick a number between 10-20
    
    //loop continues until the users guess is equal to whatever the random number is
    while (guess != number)
    {
      try
      { 
        System.out.print("What is your guess?");
        guess = keyboard.nextInt();
        
        if (guess < number) //if users guess is lower than the random number
        {
          System.out.println("Argh, ye choice be too low! I want more than that!");
          userScore++; //add +1 to the FAIL counter
        }//end if
        else if (guess > number) //if users guess is higher than the random number
        {
          System.out.println("Argh, ye choice be too high! I don't want that much!");
          userScore++; //add +1 to the FAIL counter
        }//end else if
      }//end try    
    
    //if user types something other than an integer, catch here and re-ask the previous question
    catch (InputMismatchException e)
      {
        System.out.print("Not a valid (integer) input. Error. Try again. ");
        userScore++; //add +1 to the FAIL counter
        keyboard.next();
      }//end catch   
    }//while 
  }//end method
}//end class -- PUT EVERYTHING ABOVE THIS LINE!!! //////////////////////////////////////////////////////
