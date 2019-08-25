/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotsimulation;

/**
 *
 * @author tiennguyen
 */
public abstract class Robot {
    protected Building currentBuilding;
    protected Building targetBuilding;

    public Robot() {
        currentBuilding = targetBuilding = null;
    }
    
    // moves the robot from currentBuilding to one of its neighbors
    // unless it is at targetBuilding, then it will do nothing.
    abstract public void move();
    
    public boolean amIThere() {
        return (currentBuilding == targetBuilding);
    }

    public Building getCurrentBuilding() {
        return currentBuilding;
    }

    public void setCurrentBuilding(Building currentBuilding) {
        this.currentBuilding = currentBuilding;
    }

    public Building getTargetBuilding() {
        return targetBuilding;
    }

    public void setTargetBuilding(Building targetBuilding) {
        this.targetBuilding = targetBuilding;
    }
    
    
}