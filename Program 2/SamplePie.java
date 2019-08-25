/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programs.pkg2;

import static java.lang.Math.PI;
import java.util.Scanner;

/**
 *
 * @author Steve
 */
public class SamplePie {
//////////////////////////////////////////////////////////////////////////////////
// This program requests four values from the user, representing survey results //
// from a poll which was taken to determine people's favorite Three Stooges     //
// character: Moe, Larry, Curly, or Shemp.  Percentages are computed and the    //
// results are displayed in a pie chart composed entirely of characters.        //
//////////////////////////////////////////////////////////////////////////////////

    public static final int MAXRADIUS = 8;  // Pie chart radius (in characters)
    public static final String MOECHAR = ":", // Pie chart character for Moe
            LARRYCHAR = "#",                  //  "   "     "         "  Larry
            CURLYCHAR = "O",                  //  "   "     "         "  Curly
            SHEMPCHAR = "%";                  //  "   "     "         "  Shemp

    public static void main(String[] args) {
        int[] surveyTotal = new int[4];       // The survey results for the four stooges, indicating
        // how many respondents selected each character as
        // their favorite stooge; #0 is Moe, #1 is Larry, 
        // #2 is Curly, #3 is Shemp.
        int totalVotes;          // The total number of survey respondents (i.e., the
        // sum of the four surveyTotal values).
        double[] surveyPercent = new double[4];  // The percentage of the survey results allocated to
        // each stooge; #0 is Moe, #1 is Larry, #2 is Curly,
        // #3 is Shemp.
        double[] surveyAngle = new double[4];    // The angle (in radians) encompassed by each section
        // of the pie chart.  Thus, Moe's section goes from 0
        // to surveyAngle[0], Larry's from surveyAngle[0] to
        // surveyAngle[1], etc.
        double angleSoFar; // This double tracks how far around the pie
        // the current angle has gone after each stooge's
        // angle is calculated.

        totalVotes = queryUser(surveyTotal);

        angleSoFar = 0.0;
        for (int i = 0; i <= 3; i++) {
            surveyPercent[i] = (double) surveyTotal[i] / totalVotes;
            surveyAngle[i] = angleSoFar + 2 * Math.PI * surveyPercent[i];
            angleSoFar = surveyAngle[i];
        }
        outputPie(surveyAngle);
        outputLegend(surveyPercent);
    }
////////////////////////////////////////////////////////////////////////////
// Query the user for the survey results, compute percentages and angles. //
////////////////////////////////////////////////////////////////////////////

    public static int queryUser(int[] total) {
        int totalVotes;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("How many people surveyed chose Moe as their favorite Stooge? ");
        total[0] = keyboard.nextInt();
        System.out.print("How many people surveyed chose Larry as their favorite Stooge? ");
        total[1] = keyboard.nextInt();
        System.out.print("How many people surveyed chose Curly as their favorite Stooge? ");
        total[2] = keyboard.nextInt();
        System.out.print("How many people surveyed chose Shemp as their favorite Stooge? ");
        total[3] = keyboard.nextInt();
        totalVotes = 0;
        for (int i = 0; i <= 3; i++) {
            totalVotes += total[i];
        }
        return totalVotes;
    }

//////////////////////////////////////////////////////////////////////////
// Cycle point by point through the character positions.  For any char- //
// acter within the pie chart's boundaries, determine which stooge's    //
// pie wedge it lies within, and insert the appropriate character.      //
//////////////////////////////////////////////////////////////////////////
    public static void outputPie(double angle[]) {
        int x, // The horizontal and vertical coordinates
                y;  // of the pie chart point being considered.
        double distanceFromCenter;   // The distance (in characters) from the
        // pie chart's center to the point which
        // is currently being considered.
        double currentAngle; // The angle (in radians) formed by the three
        // points: the point at the top of the pie
        // chart, the center of the pie chart, and the
        // point which is currently being considered.
        System.out.println("");
        for (y = MAXRADIUS; y >= -MAXRADIUS; y--) {
            System.out.print("\t");
            for (x = (int) (-2.0 * MAXRADIUS); x <= (int) (2.0 * MAXRADIUS); x++) {
                distanceFromCenter = Math.sqrt((2.0 * x / 4.0) * (2.0 * x / 4.0) + y * y);
                if (distanceFromCenter > MAXRADIUS) {
                    System.out.print(" ");
                } else {
                    currentAngle = Math.atan2(2.0 * x / 3.0, y); // atan2 returns arctan of 2x/3y
                    if (currentAngle < 0) { // (adjusting if y=0); 2*PI may be                    
                        currentAngle += 2 * PI;          // added to yield angles in [0,2*PI].
                    }
                    if (currentAngle <= angle[0]) {
                        System.out.print(MOECHAR);
                    } else if (currentAngle <= angle[1]) {
                        System.out.print(LARRYCHAR);
                    } else if (currentAngle <= angle[2]) {
                        System.out.print(CURLYCHAR);
                    } else {
                        System.out.print(SHEMPCHAR);
                    }
                }
            }
            System.out.println("");
        }
        return;
    }
//////////////////////////////////////////////////////////////
// A small legend is added below the pie chart to indicate  //
// which character is associated with which of the stooges. //
//////////////////////////////////////////////////////////////

    public static void outputLegend(double percent[]) {
        System.out.println("\t\t\t\t" + MOECHAR + " - Moe:   " + (percent[0] * 100) + "%");
        System.out.println("\t\t\t\t" + LARRYCHAR + " - Larry: " + (percent[1] * 100) + "%");
        System.out.println("\t\t\t\t" + CURLYCHAR + " - Curly: " + (percent[2] * 100) + "%");
        System.out.println("\t\t\t\t" + SHEMPCHAR + " - Shemp: " + (percent[3] * 100) + "%");
        System.out.println("");
    }

}