/*
 Program 2
 Name: Tien Nguyen
 Date:Mar-18-2016
 Class:Computer Science 150
 Description: This uses the classes and the subclasses. The file is print and open.
 */
package programs.pkg2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author tiennguyen
 */
public class Program2 {

    public static Scanner keyboard = new Scanner(System.in);
//
//    /**
//     * @param args the command line arguments
//     * @throws java.io.IOException
//     */
//
//    

    public static void main(String[] args) throws IOException {

        //To be able to read the file
        String file = "ChartData.txt";
        Scanner document = new Scanner(new File(file));

        //An array size 10 of chart objects
        Chart[] chartList = new Chart[10];
        int size = fillArray(chartList);
        System.out.println("\n\t\tWelcome to the charting program!\n\n");

        //The for loop goes through the whole file
        //The witch checks on which graph to print
        // create new chart
        for (int y = 0; y < size; y++) {
            String charCase = document.next();
            switch (charCase) {
                
//If the letter is P the PieChart will be created
                case "P": {
                    Chart newPie = new PieChart();
                    chartList[y] = newPie;// store then new chart in an array
                    newPie.loadChart(document);
                    break;

                }
                //If the letter is B the new BarChart will be created
                case "B": {
                    Chart newBar = new BarChart();
                    chartList[y] = newBar;
                    newBar.loadChart(document);
                    break;
                }
                //If the letter is C the new Chart will be created
                case "C": {
                    Chart newChart = new Chart();
                    chartList[y] = newChart;
                    newChart.loadChart(document);

                    break;
                }
            }
        }
        //print the chart base on what the users input
        do {
            chartList[getIndex(size)].displayChart();
        } while (true);
    }

    //This method makes sure the the users input is in the bounds
    public static int getIndex(int size) {
        int index;
        System.out.print("Which chart would you like to see? (1.." + size + "): ");
        index = keyboard.nextInt();
        while ((index < 1) || (index > size)) {
            System.out.println("That is not a valid chart number. Try again.\n");
            System.out.print("Which chart would you like to see? (1.." + size + "): ");
            index = keyboard.nextInt();
        }
        index--;
        return index;
    }

    //This method creates a new chart by counts the empty lines in file 
    public static int fillArray(Chart list[]) throws FileNotFoundException {

        String file = "ChartData.txt";
        Scanner readFile = new Scanner(new File(file));//read the input files
        
        
        
        
        //calculate is 1 because there is no space at the begining
        //This will calculate how many chart it has because everytime it hits a 
        //space it creates a new chart.
        int calculate = 1;
        while (readFile.hasNext()) {
            if ("".equals(readFile.nextLine())) {
                calculate++;
            }
        }
        readFile.close();
        return calculate;

    }

}
