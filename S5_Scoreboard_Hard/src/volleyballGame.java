/**
 * This is the volleyball Game class that extends sports Game
 */
public class volleyballGame extends sportsGame{
    //constructor
    /**
     * This is the volleyball Game constructor that calls the super constructor
     * @param homeTeam Team object for home team
     * @param awayTeam Team object for away team
     */
    public volleyballGame(Team homeTeam, Team awayTeam) {
        super(homeTeam, awayTeam, 1,1, "Game"); //calling super constructor
        this.setHomeTeam(homeTeam); // sets home team
        this.setAwayTeam(awayTeam); //sets away team
        scoringComponent[] scoring = new scoringComponent[2]; // creates a new scoring array

        scoring[0] = new scoringComponent(homeTeam.getName() + " point = ", 1);
        scoring[1] = new scoringComponent(awayTeam.getName()+" point = ", 1);

        super.setScoringArray(scoring); // setting the sportsGame's scoring array to this array
    }
}

