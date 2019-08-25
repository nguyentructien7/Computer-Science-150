/*Tien Nguyen
 * date: Feb-23-2016
 * Avtivities: CS 150. 
 * Description: It moves all the robot. change the RobotThatYellsWhenItMoves to RobotAnouncesWhenArrivedAtTargetBuilding();. change the RobotThatMovesRandomly to RobotAtMucSaysImHungry();. In the method initializeSquad.
 */

package robotsimulation;

/**
 *
 * @author tiennguyen
 */
public class Squad {

    private Robot[] squad;

    public Squad() {
        squad = null;
    }

    public boolean areAllRobotsAtTarget() {
        for (Robot currentRobot : squad) {
            if (!currentRobot.amIThere()) {
                return false;
            }
        }
        return true;
    }

    // sort of self explanatory.
    public void moveAllRobots() {
        for (Robot currentRobot : squad) {
            currentRobot.move();
        }
    }

    // Make squad an array of howMany Robots.
    // then set each Robot's current and target
    // buildings to start and target respectively.
    public void initializeSquad(int howMany,
            Building start,
            Building target) {
        squad = new Robot[howMany];
        for (int i = 0; i < squad.length; i++) {
            if(Math.random() >= 0.5) {
                squad[i] = new RobotAnouncesWhenArrivedAtTargetBuilding();
            }else {                
                squad[i] = new RobotAtMucSaysImHungry();
            }
            squad[i].setCurrentBuilding(start);
            squad[i].setTargetBuilding(target);
        }
    }

    public Robot[] getSquad() {
        return squad;
    }

    public void setSquad(Robot[] squad) {
        this.squad = squad;
    }

}