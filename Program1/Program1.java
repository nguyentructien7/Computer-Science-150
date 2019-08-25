/*
Program 1
 Name: Tien Nguyen
 Date:Feb-5-2016
 Class:Computer Science 150
 Description: Create a RaceCar class that tracks the data and display the information and find the winners.
 */
package program1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 
 */
public class Program1 {

    //An array that stores the racers and numbers.
    public static RaceCar[] Drivers = new RaceCar[100];

    /**
     * @param args the command line arguments
     */
    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int NumberOfDrivers = 0;

        //An array that holds all the race files
        String[] files = {"Race1.txt", "Race2.txt", "Race3.txt", "Race4.txt", "Race5.txt"};
        String readOneFile = "racers.txt";
        NumberOfDrivers = readRaceCarFiles(readOneFile);
        //temporary array that is able to grow that size that being called.
        RaceCar[] tempDriving = new RaceCar[NumberOfDrivers];

        //The loop runs through the files array and print the ouput
        for (int i = 0; i < files.length; i++) {
            ouputCurrentStandingsDocuments(NumberOfDrivers);
            readRacesFile(files[i], NumberOfDrivers);

            //The nested loop to save the information from the racers file to the temporary array
            for (int j = 0; j < NumberOfDrivers; j++) {
                tempDriving[j] = Drivers[j];
            }

            Arrays.sort(tempDriving);
            for (int j = 0; j < NumberOfDrivers; j++) {
                Drivers[j] = tempDriving[j];
                Drivers[j].setRank(j + 1);
            }

        }
        ouputCurrentStandingsDocuments(NumberOfDrivers);
    }

    //method read the files
    public static int readRaceCarFiles(String readFile) {
        int numberOfMorists = 0;
        //try to open the files
        try {
            Scanner documents = new Scanner(new File(readFile));
            //stores driver names and car number in the files
            while (documents.hasNext()) {
                String carNumber = documents.next().trim();
                String nameOfDriver = documents.nextLine().trim();
                Drivers[numberOfMorists] = new RaceCar();
                Drivers[numberOfMorists].setCarNumber(carNumber);
                Drivers[numberOfMorists].setDriverName(nameOfDriver);
                Drivers[numberOfMorists].setRank(numberOfMorists + 1);
                numberOfMorists++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file: " + readFile);
            System.exit(1);
        }

        return numberOfMorists;

    }

    //method read the files
    public static void readRacesFile(String readDocuments, int total) {
        String positionNumber = "";
        String vehicleNumber = "";
        int rewardPoints = 0;
        int points = 0;
        int position = 0;
        int update = 0;
        try {
            Scanner documents = new Scanner(new File(readDocuments));
            String raceTile = documents.nextLine().trim();
            System.out.println("");
            System.out.println("");
            System.out.println("              Results for the" + raceTile);
            System.out.println("Finish     Car #               Driver           Points");
            System.out.println("------------------------------------------------------");
            //store rank, car number, driver name, points, bonus points from the files
            while (documents.hasNext()) {
                positionNumber = documents.next().trim();
                vehicleNumber = documents.next().trim();
                //read the whole driver name
                //If it is not a string then stop
                String driversName = documents.next().trim();
                while (!documents.hasNextInt()) {
                    driversName = driversName + " " + documents.next().trim();

                }

                points = documents.nextInt();
                rewardPoints = documents.nextInt();

                System.out.printf("%5s %8s %25s %10d/%d\n", positionNumber, vehicleNumber, driversName, points, rewardPoints);

                //compare the car number in the file to the car number that stored in the array
                for (int i = 0; i < total; i++) {
                    if (Drivers[i].getCarNumber().equals(vehicleNumber)) {
                        position = i;
                    }

                }
                //set the the points and races for the car
                Drivers[position].setPoints(points);
                Drivers[position].setRaces();

                //checking the bonus points to displaced the ledlaps or ledMostLaps.
                if (rewardPoints == 10) {
                    Drivers[position].setLedMostLaps();

                } else if (rewardPoints == 5) {
                    Drivers[position].setLedLaps();
                }
                if (update == 0) {
                    Drivers[position].setWins();
                }

                update++;
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error opening file: " + readDocuments);
            System.exit(1);
        }

    }
//Method that print the output

    public static void ouputCurrentStandingsDocuments(int finalPoints) {
        System.out.println("");
        System.out.println("");
        System.out.println("                            Current Standings                             ");
        System.out.println("Rank  Car#          Driver             Races  Points  Wins  LedALap  LedMostLaps");
        System.out.println("------------------------------------------------------------------------------");

        //print the new updated car number, driver name, points, wins, ledMostLaps...
        for (int i = 0; i < finalPoints; i++) {

            System.out.printf("%3s %4s %25s      %-6d %-8d %-6d %-6d %-30d\n", Drivers[i].getRank(), Drivers[i].getCarNumber(), Drivers[i].getDriverName(), Drivers[i].getRaces(),
                    Drivers[i].getPoints(), Drivers[i].getWins(), Drivers[i].getLedLaps(), Drivers[i].getLedMostLaps());
        }

    }
}
