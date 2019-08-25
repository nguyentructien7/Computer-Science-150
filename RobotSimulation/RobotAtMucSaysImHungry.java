/*Tien Nguyen
 * date: Feb-23-2016
 * Avtivities: CS 150. Subclass of Robot.
 * Description: Robot check if it's at the MUC. If robot is at the MUC then it says I'm hungry. If not then continue move randomly until they are at the target building.
 */
package robotsimulation;

/**
 *
 * @author tiennguyen
 */
public class RobotAtMucSaysImHungry extends Robot {

    //receives information from the parent class
    public RobotAtMucSaysImHungry() {

        super();
    }

//robot says I'm hungry when it at the MUC.
    public void sayImHungry() {
        System.out.println("I'm Hungry");
    }

    // robot move randomly to buildings. Check if it at the MUC
    @Override
    public void move() {
        if (amIThere()) {
            return;

        }
        if (currentBuilding.getName().equals("MUC")) {
            sayImHungry();

        }
        int newBuilding = (int) (Math.random() * currentBuilding.getAdjacentBuildings().length);
        currentBuilding = currentBuilding.getAdjacentBuildings()[newBuilding];

    }
}
