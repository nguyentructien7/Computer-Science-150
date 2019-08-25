/*Tien Nguyen
 * date: Feb-23-2016
 * Avtivities: CS 150. Subclass of Robot.
 * Description: The robot check if it's at the target building. If it's at the target building then it says I'm here. Then the other robot who is not at the target building continue moving random. It wont say I'm here again once it said it.
 */
package robotsimulation;

/**
 *
 * @author tiennguyen
 */
public class RobotAnouncesWhenArrivedAtTargetBuilding extends Robot {

    // Check if the robot is at the target building. If it already says I'm here then it wont say again.

    private boolean robotAlreadySayImHere = false;

    public void RobotAnouncesWhenArrivedAtTargetBuilding() {

    }

    // robot anounces I'm here if not then dont say anything.

    public void sayImThere() {
        if (!robotAlreadySayImHere) {
            System.out.println("Im Here");
            robotAlreadySayImHere = true;
        } else {
        }

    }

    // robot move randomly to buildings

    @Override
    public void move() {
        if (amIThere()) {
            sayImThere();
            return;
        }
        int newBuilding = (int) (Math.random() * currentBuilding.getAdjacentBuildings().length);
        currentBuilding = currentBuilding.getAdjacentBuildings()[newBuilding];
    }
}
