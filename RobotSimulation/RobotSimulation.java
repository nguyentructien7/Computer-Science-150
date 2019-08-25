/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotsimulation;

import java.io.FileNotFoundException;

/**
 *
 * @author tiennguyen
 */
 public class RobotSimulation {

    public static void main(String[] args) {
        Map myMap = new Map();
        Squad mySquad = new Squad();
        int move = 0;
        try {
            myMap.loadMap("siuemap.txt");
        } catch (FileNotFoundException e) {
            System.err.println("Map file not found.");
            System.exit(1);
        }
        mySquad.initializeSquad(100, myMap.findBuilding("EB"), myMap.findBuilding("BBH"));
        myMap.drawMap(mySquad);
        do {
            move++;
            System.out.println("Move " + move);
            mySquad.moveAllRobots();
            myMap.drawMap(mySquad);
        } while (!mySquad.areAllRobotsAtTarget());
    }
}