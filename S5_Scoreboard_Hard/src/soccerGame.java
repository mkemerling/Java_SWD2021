/**
 * This is the soccer Game class that extends the abstract sports Game class
 */
public class soccerGame extends sportsGame{
    /**
     * The soccer Game constructor that calls from the super class constructor
     * @param homeTeam Takes in team object for home team
     * @param awayTeam Takes in team object for away team
     */
    public soccerGame(Team homeTeam, Team awayTeam) {
        super(homeTeam, awayTeam, 1,2, "Halves"); // calls the super constructor
        this.setHomeTeam(homeTeam); // sets home team
        this.setAwayTeam(awayTeam); // sets away team
        scoringComponent[] scoring = new scoringComponent[2]; // creates a new scoring component away for Soccer

        //New scoring components
        scoring[0] = new scoringComponent(homeTeam.getName() + " goal = ", 1);
        scoring[1] = new scoringComponent(awayTeam.getName()+" goal = ", 1);

        super.setScoringArray(scoring); // setting the sportsGame's scoring array to this array
    }
}
