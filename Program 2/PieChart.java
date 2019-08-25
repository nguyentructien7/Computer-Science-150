/*Program 2
 Name: Tien Nguyen
 Date:Mar-18-2016
 Class:Computer Science 150
 Description: This class extends from Chart. This class print the pie based on its values and categories.
 */
package programs.pkg2;

/**
 *
 * @author tiennguyen
 */
public class PieChart extends Chart {

    char[] charArray = {'@', '&', 'π', '^', '#', '/', '$', '~', 'l', '-'};
    protected final int MAXRADIUS = 8;
    double totalValue = 0;
    double addedAngle = 0;

    public PieChart() {
        super();
    }

    //this method calculates the total values of all the categories in a pie
    //chart to be able to compute the angle and percentages of the pie
    private void calculateTotalValues() {
        for (int k = 0; k < numberOfCategories; k++) {
            totalValue += categoryArray[k].getValue();
        }
    }

    //overrides the displaychart method in the parent class
    @Override
    public void displayChart() {

        //invokes this method to calculate the sum of the all values in of all categories
        calculateTotalValues();

        //This for loop checks through  piechart object and set the percent and angle
        for (int i = 0; i < numberOfCategories; i++) {
            categoryArray[i].setCalculatePercent(categoryArray[i].getValue() / totalValue);
            categoryArray[i].setAngleInPie(addedAngle + 2 * Math.PI * categoryArray[i].getCalculatePercent());
            addedAngle = categoryArray[i].getAngleInPie();
        }

        // The horizontal and vertical coordinates of the pie chart point being 
        //considered.
        int y, x;

        // The distance (in characters) from the pie chart's center to the point which
        // is currently being considered.
        double distanceFromCenter;

        // The angle (in radians) formed by the three points: the point at the top of the pie
        // chart, the center of the pie chart, and the point which is currently being considered.
        double currentAngle;
        System.out.println("");
        for (x = MAXRADIUS; x >= -MAXRADIUS; x--) {
            calculateTotalValues();
            System.out.print("\t");
            for (y = (int) (-2.0 * MAXRADIUS); y <= (int) (2.0 * MAXRADIUS); y++) {
                int index=0;
                
                distanceFromCenter = Math.sqrt((2.0 * y / 4.0) * (2.0 * y / 4.0) + x * x);
                if (distanceFromCenter > MAXRADIUS) {
                    System.out.print(" ");
                } else {

                    currentAngle = Math.atan2(2.0 * y / 3.0, x);
                    if (currentAngle < 0) {
                        currentAngle += 2 * Math.PI;
                    }

                    //for loop to loop through all the categories in the piechart object
                    for (int i = 1; i < numberOfCategories; i++) {
                        //makes sure the angle stay in bounds and cant be overriden
                       
                        if ((currentAngle >= categoryArray[i - 1].getAngleInPie()) && (currentAngle <= categoryArray[i].getAngleInPie())) {
                            index = i;
                            
                        
                        }
                       
                    }
                   
                    //print the output above
                    System.out.print(charArray[index]);
                   
                    //In order to print the character at the next index. The index has to be 0
                   index=0;
                     
                }
            }

            System.out.println("");
            totalValue = 0;
             
        }
        
        
            
        printTheLegend();
       
        
    }

    //this method prints the legend with the percentage, the title, the character, and the values
    public void printTheLegend() {
        String percent = "%";
        for (int i = 0; i < numberOfCategories; i++) {
            System.out.print("      ");
            System.out.print(charArray[i] + " - ");
            System.out.printf("%17s : ", categoryArray[i].getTitle().trim());
            System.out.printf("\t%7.3f%s", (categoryArray[i].getCalculatePercent() * 100), percent);
            System.out.printf("\t\t%8.3f", categoryArray[i].getValue());
            System.out.println();

        }

    }
}
