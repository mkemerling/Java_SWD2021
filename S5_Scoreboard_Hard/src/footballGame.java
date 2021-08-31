/**
 * The footballGame class extends sportsGame as a subclass
 */
public class footballGame extends sportsGame {

    //constructor
    /**
     * The constructor for the football Game
     * @param homeTeam Takes in a Team object home team
     * @param awayTeam Takes in a Team object away team
     */
    public footballGame(Team homeTeam, Team awayTeam) {
        super(homeTeam, awayTeam, 1,4, "Quarter"); // calls the SportsGame constructor
        this.setHomeTeam(homeTeam); // sets the home team
        this.setAwayTeam(awayTeam);//sets the away team
        scoringComponent[] scoring = new scoringComponent[6]; // creates a new scoring component object only for football

       //Scoring array
        scoring[0] = new scoringComponent(homeTeam.getName() + " touchdown = ", 7);
        scoring[1] = new scoringComponent(awayTeam.getName()+" touchdown = ", 7);
        scoring[2] = new scoringComponent(homeTeam.getName()+  " field goal  = ", 3);
        scoring[3] = new scoringComponent(awayTeam.getName()+ " field goal = ", 3);
        scoring[4] = new scoringComponent(homeTeam.getName()+ " safety  = ", 2);
        scoring[5] = new scoringComponent(awayTeam.getName() +" safety = ", 2);

        super.setScoringArray(scoring); // setting the sportsGame's scoring array to this array
    }
}
