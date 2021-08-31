import java.util.Arrays;
import java.util.Scanner;

/**
 * This is the driver class that tests the functionality and prints out to the user
 */
public class driverTestGames {
    public static void main(String[] args) {
         Scanner in; // initializing the scanner
         int gameChoice = 0; // the game choice is created and initialized
         String team1; // creating a string for team1
         String team2; // creating a string for team2


        in = new Scanner(System.in); // Creating Scanner input

        // naming the teams
        System.out.println("Please input the name of the two teams playing....team 1? ");
        team1 = in.nextLine(); //User input
        Team homeTeam = new Team(team1); // Creating a new Team object for their input
        System.out.println("And now the name of team 2?");
        team2 = in.nextLine(); // User input
        Team awayTeam = new Team(team2); // Creating a new Team object for their input
        sportsGame sportsGame = new sportsGame(homeTeam,awayTeam,0,4,"throwaway") {}; // creating a new sportsGame

        //user selection of games
        System.out.println("Select a type of game: ");
        System.out.println("1. Football ");
        System.out.println("2. Soccer ");
        System.out.println("3. Volleyball");
        System.out.println("4. Basketball");

        try {
            gameChoice = in.nextInt();
        } // makes sure input is an int
        catch (Exception e) { // catching any exception
            System.out.println("You did not input a valid input");
            System.out.println("The game will end now.");
            return;
        }
        if((gameChoice < 0) || (gameChoice > 4)){ // catching if input is outside of 0-6
            System.out.println("Your input for choice of game invalid");
            System.out.println("No action will be taken. Game over.");
            return;
        }
        sportsGame gameOfChoice; // just an initialization

        //dependant upon the input, a new object is created
        if(gameChoice == 1){ // if they chose 1, a new football Game object will be created
           gameOfChoice = new footballGame(homeTeam,awayTeam);
        }
        // if soccer is chosen as the game
        else if (gameChoice == 2){
            gameOfChoice = new soccerGame(homeTeam,awayTeam); // creates a new sports game: soccer game
        }
        // if volleyball is chosen as a game
        else if (gameChoice == 3){
          gameOfChoice = new volleyballGame(homeTeam,awayTeam);

        }
        // if basketball is chosen as the game
        // it will automatically be basketball if they input 4
        else {
            gameOfChoice = new basketballGame(homeTeam,awayTeam);
        }

        scoringComponent[] sportScoring = gameOfChoice.getScoringArray(); //getting the Scoring array of the game chosen
        int inputOfChoice = 0; // initializing
        System.out.println(sportScoring.length);
        while(sportsGame.endOfGame(gameOfChoice.getCurrentPeriod(), gameOfChoice.getNumberOfPeriods())) { // while its not the end of the game
            //Takes in the current period and number of periods
            for (int i = 0; i < sportScoring.length; i++) { // printing out the scoring method for that choice
                System.out.println("Choice " + i + " : " + sportScoring[i].getMethodName() + sportScoring[i].getMethodPointValue());
            }
            // Organizational outputs
            System.out.println("Choice " + sportScoring.length +" : End the current period"); // outside of the for loop, ending current period of play
            System.out.println(gameOfChoice.getHomeTeam() + " = "+ sportsGame.getScoreHome() + "    "+ gameOfChoice.getAwayTeam() + " = " + sportsGame.getScoreAway());
            System.out.println("Current Period of play: " + gameOfChoice.getNameOfPeriod() + " " +   gameOfChoice.getCurrentPeriod() );
            System.out.println("Please input your choice of play: ");
           try {
               inputOfChoice = in.nextInt();
           }
           catch(Exception e){ //catching exception if they put in something other than a number
               System.out.println("Your input for choice of play was invalid.");
               return;
           }
           if((inputOfChoice < 0) || (inputOfChoice > sportScoring.length)){ // catching if input is outside of 0-6
               System.out.println("Your input for choice of play was invalid");
               System.out.println("No action will be taken. Game over.");
               return;
           }
           else if(inputOfChoice == sportScoring.length){ // if the input is to change the period
               gameOfChoice.setCurrentPeriod(gameOfChoice.getCurrentPeriod()+1); // add one to current period
           }
           else { // this is the main scoring methods
               sportsGame.makeGameChoice(gameOfChoice.getScoringArray(), inputOfChoice); // calling from super
               System.out.println("Current Period of play: " + gameOfChoice.getNameOfPeriod() + " " +   gameOfChoice.getCurrentPeriod() );
               System.out.println("Here are the current scores of your game: ");
               System.out.println(gameOfChoice.getHomeTeam() + " : " + gameOfChoice.getScoreHome() + "   " + gameOfChoice.getAwayTeam() + " : " + gameOfChoice.getScoreAway());
               System.out.println(); // just for formatting

           }
        }
        //the current period > number of periods, and thus the game is over
        System.out.println("The game is over! The final scores are: ");
        System.out.println(gameOfChoice.getHomeTeam() + " : " + gameOfChoice.getScoreHome());
        System.out.println(gameOfChoice.getAwayTeam() + " : " + gameOfChoice.getScoreAway());
        if(gameOfChoice.getScoreHome() > gameOfChoice.getScoreAway()){ //printing out the winning team if team 1
            System.out.println("The winning team: " + gameOfChoice.getHomeTeam());
        }
        else if (gameOfChoice.getScoreAway() > gameOfChoice.getScoreHome()){ // printing out the winning team if team 2
            System.out.println("The winning team: "+ gameOfChoice.getAwayTeam());
        }
        else{ // if the teams tied
            System.out.println("The teams tied as winners!");
        }
        //This next line shows the ability to make a new sports game... polymorphism
        sportsGame checkingPolymorphism = new footballGame(homeTeam,awayTeam);
    }
}
