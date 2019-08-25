/*
 Program 2
 Name: Tien Nguyen
 Date:Mar-18-2016
 Class:Computer Science 150
 Description: This class extends from chart. It makes a bar graph.
 */
package programs.pkg2;

/**
 *
 * @author tiennguyen
 */
public class BarChart extends Chart {

    double totalValue = 0;
    char[] characterArray = {'@', '&', 'π', '^', '#', '/', '$', '~', 'l', '-'};

    public BarChart() {
        super();
        this.numberOfCategories = numberOfCategories;
    }

    //Find the sum of the value

    private void calculateTotalValue() {
        for (int i = 0; i < numberOfCategories; i++) {
            totalValue += categoryArray[i].getValue();
        }

    }

    //this method overrides the displayChart method in the parent class
    @Override
    public void displayChart() {
        int position = 0;
        Category biggestValue = categoryArray[position];

        //find the highest value by looping through the categories
        for (int i = 0; i < numberOfCategories; i++) {
            if (categoryArray[i].getValue() <= biggestValue.getValue()) {

            } else {
                position = i;
                biggestValue = categoryArray[i];
            }
        }

        // calculate the proportion and percentage by looping through the categories
        for (int y = 0; y < numberOfCategories; y++) {

            calculateTotalValue();

            //find and set the segment
            double segment;
            segment = (categoryArray[y].getValue() / biggestValue.getValue());
            categoryArray[y].setSegmentValue((int) (segment * 20));

            //calculate the percentage
            double percent;
            percent = (categoryArray[y].getValue() / totalValue);
            categoryArray[y].setCalculatePercent(percent * 100);

            totalValue = 0;
        }

        System.out.println("---------------------");

        //output the charater base on the category
        for (int i = 20; i > 0; i--) {
            System.out.print("        ");
            for (int j = 0; j < numberOfCategories; j++) {
                if (categoryArray[j].getSegmentValue() < i) {
                    System.out.print(" ");
                } else {
                    System.out.print(characterArray[j]);
                }
            }
            System.out.println();
        }
        System.out.println("---------------------");

        //invoke the method to print the legend
        outputLegend();
        System.out.println();

    }

    //this method prints the legend
    public void outputLegend() {
        for (int i = 0; i < numberOfCategories; i++) {
            String percentSign = "%";
            System.out.print("      ");
            System.out.print(characterArray[i] + " - ");
            System.out.printf("%30s : ", categoryArray[i].getTitle().trim());
            System.out.printf("\t%.3f%s", categoryArray[i].getCalculatePercent(), percentSign);
            System.out.printf("%15.3f", categoryArray[i].getValue());
            System.out.println();

        }

    }

}
