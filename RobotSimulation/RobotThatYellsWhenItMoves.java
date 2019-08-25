/*/* author: Tien Nguyen
 * date: Feb-20-2016
 * description: 
 */
package robotsimulation;

/**
 *
 * @author tiennguyen
 */
public class RobotThatYellsWhenItMoves extends Robot {

    public RobotThatYellsWhenItMoves() {
        super();
        // then init your stuff for this class.
    }
    

    @Override
    public void move() {
        if (amIThere()) {
            return;
        }
        int newBuilding = (int) (Math.random() * currentBuilding.getAdjacentBuildings().length);
        currentBuilding = currentBuilding.getAdjacentBuildings()[newBuilding];
        System.out.println("YYYEEEEHHAAAAAAWWWWW");
    }

}