/*
 Program 2
 Name: Tien Nguyen
 Date:Mar-18-2016
 Class:Computer Science 150
 Description: This class has mutators and accessors to store the information. Provide all the date flied to create a char
 */
package programs.pkg2;

/**
 *
 * @author tiennguyen
 */
public class Category {

    private String title;
    private double value;
    private int segmentValue = 0;
    private double calculatePercent = 0;
    private double angleInPie = 0;

    //constructor
    public Category(String title, double value) {
        this.title = title;
        this.value = value;
    }

    public double getAngleInPie() {
        return angleInPie;
    }

    public void setAngleInPie(double angleInPie) {
        this.angleInPie = angleInPie;
    }

    public int getSegmentValue() {
        return segmentValue;
    }

    public void setSegmentValue(int segmentValue) {
        this.segmentValue = segmentValue;
    }

    public double getCalculatePercent() {
        return calculatePercent;
    }

    public void setCalculatePercent(double calculatePercent) {
        this.calculatePercent = calculatePercent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
