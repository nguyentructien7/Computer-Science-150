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
public class Building {
  
    private String name;
    private Building[] adjacentBuildings;

    public Building() {
        name = "";
        adjacentBuildings = null;
    }

    // counts how many Robots in someSquad are at 
    // this Building and returns that count.
    public int howManyRobotsAreHere(Squad someSquad) {
        int count = 0;
        for (Robot squad : someSquad.getSquad()) {
            if (squad.getCurrentBuilding() == this) {
                count++;
            }
        }
        return count;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Building[] getAdjacentBuildings() {
        // leaks our Building[] object.
        return adjacentBuildings;
    }

    public void setAdjacentBuildings(Building[] adjacentBuildings) {
        this.adjacentBuildings = adjacentBuildings;
    }
        
}

