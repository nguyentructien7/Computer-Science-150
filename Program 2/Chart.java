/*
 Program 2
 Name: Tien Nguyen
 Date:Mar-18-2016
 Class:Computer Science 150
 Description: This class is a superclass. It inherits the PieChart, BarChart.
 */
package programs.pkg2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author tiennguyen
 */
public class Chart {

    protected final int largestCategories = 10;
    protected Category[] categoryArray = new Category[largestCategories];
    protected int numberOfCategories;

    public Chart() {
        this.numberOfCategories = 0;
    }

    public int getNumberOfCategories() {
        return numberOfCategories;
    }

    //Get the title and values and makes new categories
    public void loadChart(Scanner input) throws FileNotFoundException {

        numberOfCategories = input.nextInt();

        //set the tile and value
        for (int t = 0; t < numberOfCategories; t++) {
            input.nextLine();
            String title = input.nextLine().trim();
            double value = input.nextDouble();
            categoryArray[t] = new Category(title, value);

        }
    }

    //make sure the category is in the array
    public Category getCategoryAt(int position) {

        if (position > categoryArray.length) {
            System.out.println("Index out of bounds");
        } else {
            return categoryArray[position - 1];
        }
        return null;
    }

    //this method displays the chart chart
    public void displayChart() {
        for (int i = 0; i < numberOfCategories; i++) {
            System.out.printf("%28s: ", categoryArray[i].getTitle());
            System.out.printf("%12.3f", categoryArray[i].getValue());
            System.out.println();

        }
    }
}
