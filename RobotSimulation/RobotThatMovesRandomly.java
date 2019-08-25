/*/* author: Tien Nguyen
 * date: Feb-20-2016
 * description: Subclass of Robot.
 */
 
package robotsimulation;

/**
 *
 * @author tiennguyen
 */
public class RobotThatMovesRandomly extends Robot {

    public void move() {
        if (amIThere()) {
            return;
        }
        int newBuilding = (int) (Math.random() * currentBuilding.getAdjacentBuildings().length);
        currentBuilding = currentBuilding.getAdjacentBuildings()[newBuilding];
    }
}