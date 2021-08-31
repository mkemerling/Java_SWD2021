import java.util.Arrays;

/**
 * This is the abstract super class of all of our sports
 */
public abstract class sportsGame {
    //class variables
    /**
     * Private object, home team from the Team class
     */
    private Team homeTeam;
    /**
     * Private array, scoring array
     */
    private scoringComponent[] scoringArray;
    /**
     * Private object, away team from the Team class
     */
    private Team awayTeam;
    /**
     * Private integer score for home team
     */
    private int scoreHome;
    /**
     * Private integer score for away team
     */
    private int scoreAway;
    /**
     * Private integer for the current period
     */
    private int currentPeriod;
    /**
     * Private integer for the number of periods
     */
    private int numberOfPeriods;
    /**
     * Private integer for the name of the period
     */
    private String nameOfPeriod;

    /**
     * This is the constructor for a sportsGame
     * @param homeTeam The home team
     * @param awayTeam The away team
     * @param currentPeriod The current Period
     * @param numberOfPeriods The number of periods
     * @param nameOfPeriod // the name of the period
     */
    public sportsGame(Team homeTeam, Team awayTeam , int currentPeriod, int numberOfPeriods, String nameOfPeriod){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.currentPeriod = currentPeriod;
        this.numberOfPeriods = numberOfPeriods;
        this.nameOfPeriod = nameOfPeriod;
    }
    /**
     * This is a check to see if the game has ended(current period > number of periods)
     * @param currentPeriod This is the current period of the game
     * @param numberOfPeriods This is the number of periods allowed in the game
     * @return Returns a boolean true if game is not over, and false if it is over
     */
     public boolean endOfGame(int currentPeriod, int numberOfPeriods)
     {
        boolean result = true; // This is a throwaway variable to figure out if its the end of the game
         if(currentPeriod > numberOfPeriods){ // if the game is over
             result = false;
         }
         return result; // will return t/f based on the calculation here
     }

    /**
     * This is for the user to choose what they want to happen in the game
     * @param scoringArray1 Takes in the scoring array of the current game
     * @param choiceOfScoring Takes in the users input of choice
     */
     public void makeGameChoice(scoringComponent[] scoringArray1, int choiceOfScoring){
        int evenOrOdd; //The even or odd variable determines if its for the home team or away team
        int newScore; // the new score to be changes to
        evenOrOdd = choiceOfScoring % 2; // Will be 0 for even, or 1 for odd
         // if the variable is even it correlates to home team
        if(evenOrOdd == 0){
            //Home team's new score is the current score plus the array's correlated points
            newScore = homeTeam.getScore() + scoringArray1[choiceOfScoring].getMethodPointValue();
            homeTeam.setScore(newScore); // setting the new score
        }
        else if(evenOrOdd == 1){ // if the variable is odd it correlates to away team
            //The new score is the current score plus the array's correlated points
            newScore = awayTeam.getScore()+ scoringArray1[choiceOfScoring].getMethodPointValue();
            awayTeam.setScore(newScore);
        }
     }

    //getters for private variables

    /**
     * Sets the home team
     * @param homeTeam Team object
     */
    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    /**
     * Sets the away team
     * @param awayTeam Team object
     */
    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
     }

    /**
     * Gets the home team's name
     * @return String of name
     */
    public String getHomeTeam() { return homeTeam.getName(); }

    /**
     * Gets the away team's name
     * @return String of name
     */
    public String getAwayTeam() { return awayTeam.getName(); }

    /**
     * Gets the home team's score
     * @return Int score
     */
    public int getScoreHome() { return homeTeam.getScore(); }

    /**
     * Gets the away team's score
     * @return
     */
    public int getScoreAway() {return awayTeam.getScore();}

    /**
     * Sets the home team's score
     * @param scoreHome
     */
    public void setScoreHome(int scoreHome) { this.scoreHome = scoreHome; }

    /**
     * Sets the away team's score
     * @param scoreAway
     */
    public void setScoreAway(int scoreAway) { this.scoreAway = scoreAway; }

    /**
     * Sets the scoring Array, used to individualize the sports
     * @param scoringArray1
     */
    public void setScoringArray(scoringComponent[] scoringArray1) {
        this.scoringArray = scoringArray1; }

    /**
     * Gets the scoring Array, also used to individualize the sports
     * @return
     */
    public scoringComponent[] getScoringArray() {
        return scoringArray; }

    /**
     * Gets the current period
     * @return
     */
    public int getCurrentPeriod() {return currentPeriod;}

    /**
     * Sets the current period
     * @param currentPeriod1
     */
    public void setCurrentPeriod(int currentPeriod1){
        this.currentPeriod = currentPeriod1;
    }

    /**
     * Gets the number of periods
     * @return
     */
    public int getNumberOfPeriods(){return numberOfPeriods;}

    /**
     * Sets the number of periods
     * @param numberOfPeriods1
     */
    public void setNumberOfPeriods(int numberOfPeriods1){
        this.numberOfPeriods=numberOfPeriods1;
    }

    /**
     * Gets the name of the period
     * @return
     */
    public String getNameOfPeriod(){return nameOfPeriod;}

    /**
     * Sets the name of the period
     * @param nameOfPeriod1
     */
    public void setNameOfPeriod(String nameOfPeriod1){
        this.nameOfPeriod = nameOfPeriod1;
    }
}
