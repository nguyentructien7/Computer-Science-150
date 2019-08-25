/*
 Program 5
 Name: Tien Nguyen
 Date:April-29-2016
 Class:Computer Science 150
 Description: This program load a 250x250 grid of doubles from binary file. It must find 100 
 peaks(*) in the data, which mean the the number that is greater or equal to its 8 neighbors. 
Then find the top 100 peaks(**).
 */
package program5;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author tiennguyen
 */
public class Program5 {

    public static final String OUTPUT_FILE_NAME = "PeaksOutput.txt";

    public static void main(String[] args) throws FileNotFoundException, IOException {

        PrintWriter outputFileWriter = null;
        //create an array to store the datas
        double[][] dataNum = new double[250][250];
        //store * peaks
        double[][] peaks = new double[250][250];
        //store ** peaks
        double[][] maxPeaks = new double[250][250];
        
        //try to open binary and input it into a two demension array
        try (DataInputStream fileIn = new DataInputStream(new FileInputStream("datapoints.dat"))) {
            for (int i = 0; i < dataNum.length; i++) {
                for (int j = 0; j < dataNum.length; j++) {
                    dataNum[i][j] = fileIn.readDouble();
                }
            }           
            try {
                outputFileWriter = new PrintWriter(OUTPUT_FILE_NAME);

            } 
            catch (FileNotFoundException e) {
                System.err.println("Error opening the file " + OUTPUT_FILE_NAME);
                System.exit(1);
            }
           //for loops check for the 100 peaks
            for (int i = 0; i < dataNum.length; i++) {
                for (int j = 0; j < dataNum[i].length; j++) {
                    if ((i >= 1 && j >= 1 && i < dataNum.length - 1 && j < dataNum.length - 1)
                            && dataNum[i][j] >= dataNum[i - 1][j - 1]
                            && dataNum[i][j] >= dataNum[i][j - 1]
                            && dataNum[i][j] >= dataNum[i + 1][j - 1]
                            && dataNum[i][j] >= dataNum[i - 1][j]
                            && dataNum[i][j] >= dataNum[i + 1][j]
                            && dataNum[i][j] >= dataNum[i - 1][j + 1]
                            && dataNum[i][j] >= dataNum[i][j + 1]
                            && dataNum[i][j] >= dataNum[i + 1][j + 1]) {
                        peaks[i][j] = dataNum[i][j];
                        
                    }
                }
            }

            //read the contents of the peaks array into a one dim array for easy sorting
            double[] sort = new double[ 250 * 250 ];
            int count = 0;
            for (int i = 0; i < peaks.length; i++) {
                for (int j = 0; j < peaks[i].length; j++) {
                    sort[ count ] = peaks[i][j];
                    count++;
                }
            }
            //sorts in ascending order so start from the last value and work backwards
            Arrays.sort( sort );
            
            //find max 100 values from sorted array of peaks values and put into maxPeaks array 
            //this way the coordinated of the peaks are retained
            for (count = 1; count <= 100; count++) {
                for (int i = 0; i < peaks.length; i++) {
                    for (int j = 0; j < peaks[i].length; j++) {
                        if ( sort[ sort.length - count] == peaks[i][j] ) {
                            maxPeaks[i][j] = dataNum[i][j];                    
                        }
                    }
                }
            }
            
            
            //print
            for (int r = 0; r < dataNum.length; r++) {
                for (int f = 0; f < dataNum.length; f++) {
                    if (dataNum[r][f] == peaks[r][f] && peaks[r][f] == maxPeaks[r][f]) {
                        outputFileWriter.printf("%8.3f** ", dataNum[r][f]);
                    }
                    else if (dataNum[r][f] == peaks[r][f]) {
                        outputFileWriter.printf("%8.3f*  ", dataNum[r][f]);
                    } else {
                        outputFileWriter.printf("%8.3f   ", dataNum[r][f]);
                    }

                }
                //print new line
                outputFileWriter.println();
            }
        } catch (FileNotFoundException e) {

            System.err.println("Error opening the file " + OUTPUT_FILE_NAME);

            System.exit(1);

        }
        outputFileWriter.close();
    }
}

                      