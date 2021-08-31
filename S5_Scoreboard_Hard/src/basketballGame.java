/**
 * This is the basketball Game class that extends the sports game class
 */
public class basketballGame extends sportsGame{
    //constructor

    /**
     * This is the basketball game constructor
     * @param homeTeam Team object for home team
     * @param awayTeam Team object for away team
     */
    public basketballGame(Team homeTeam, Team awayTeam) {
        super(homeTeam, awayTeam, 1,4, "Period"); //calls the super constructor
        this.setHomeTeam(homeTeam); // sets the home team
        this.setAwayTeam(awayTeam); //sets the away team
        scoringComponent[] scoring = new scoringComponent[6]; // creates a new scoring component array

        scoring[0] = new scoringComponent(homeTeam.getName() + " 3 pointer = ", 3);
        scoring[1] = new scoringComponent(awayTeam.getName()+" 3 pointer = ", 3);
        scoring[2] = new scoringComponent(homeTeam.getName()+  " 2 pointer  = ", 2);
        scoring[3] = new scoringComponent(awayTeam.getName()+ " 2 pointer = ", 2);
        scoring[4] = new scoringComponent(homeTeam.getName()+ " 1 pointer  = ", 1);
        scoring[5] = new scoringComponent(awayTeam.getName() +" 1 pointer = ", 1);

        super.setScoringArray(scoring); // setting the sportsGame's scoring array to this array
    }
}
