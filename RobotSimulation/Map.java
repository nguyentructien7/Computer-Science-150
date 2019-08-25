/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotsimulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author tiennguyen
 */
public class Map {
    private Building[] map;

    public Map() {
        map = null;
    }
    
    // connects to file with name mapFileName
    // then reads the buildings into array "map"
    // then loads adjacencies for each building
    public void loadMap(String mapFileName) throws FileNotFoundException{
        Scanner fileStream = new Scanner(new File(mapFileName));
        String buildingName;
        map = new Building[fileStream.nextInt()];
        fileStream.nextLine(); // moves file ptr to next line
        for (int i = 0; i < map.length; i++) {
            map[i] = new Building();
            map[i].setName(fileStream.nextLine().trim());
        }
        for (int i = 0; i < map.length; i++) {
            map[i].setAdjacentBuildings(new Building[fileStream.nextInt()]);
            fileStream.nextLine(); // move the file ptr to next line
            for (int j = 0; j < map[i].getAdjacentBuildings().length; j++) {
                buildingName = fileStream.nextLine().trim();
                map[i].getAdjacentBuildings()[j] = findBuilding(buildingName);
            }
        }
    }
    
    public Building findBuilding(String buildingName) {
        for (Building currentBuilding : map) {
            if(currentBuilding.getName().equals(buildingName)) {
                return currentBuilding;
            }
        }
        return null;
    }
    
    // assume the output window is the target for 
    // the output
    public void drawMap(Squad mySquad) {
        System.out.println("Map:");
        for (Building currBldg : map) {
            System.out.printf("%10s: %5d%n",currBldg.getName(),currBldg.howManyRobotsAreHere(mySquad));
        }
    }

    public Building[] getMap() {
        return map;
    }

    public void setMap(Building[] map) {
        this.map = map;
    }
      
}
