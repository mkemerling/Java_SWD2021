/**
 * This class was created to create new Teams to play in the sports games
 * This links a team, and a team's score
 */
public class Team {
    //Name & Score
    //You never want a team without a score, so this simplifies it
    /**
     * This private variable is the name of the Team
     */
    private String name;
    /**
     * This private variable is the score of the Team
     */
    private int score;

    //Constructor

    /**
     * Team constructor, has name and score
     * @param teamName Name of the team
     */
    Team(String teamName){
        this.name = teamName;
        score = 0;
    }

    //getters and setters for name and score

    /**
     * Gets the name of the team
     * @return name of team
     */
    public String getName() {
        return name; }

    /**
     * Sets the name of the team
     * @param name of Team
     */
    public void setName(String name) {
        this.name = name; }

    /**
     * Get's the score of the team
     * @return score of team
     */
    public int getScore() {
        return score; }

    /**
     * Sets the score of the team
     * @param score Score of the team
     */
    public void setScore(int score) {
        this.score = score; }
}