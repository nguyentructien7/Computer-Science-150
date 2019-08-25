/*
 Program 3
 Name: Tien Nguyen
 Date:Mar-29-2016
 Class:Computer Science 150
 Description: This program is about reading the files and drawing in javafx.
                Then create a new drawing by writing a new file.
 */
package program3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.scene.shape.Ellipse;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javafx.stage.Stage;

/**
 *
 * @author tiennguyen
 */
public class Program3 extends Application {

    //declare the files

    private Object borderPane;
    public static final String readCreeper = "Creeper.txt";
    public static final String readSun = "Sun.txt";
    public static final String readFile = "Creativity.txt";

    @Override
    public void start(Stage firstStage) {

        //first stage
        Pane image = new Pane();
        Scene scene = new Scene(image, 675, 675);
        firstStage.setTitle("Graphics Displayer");
        firstStage.setScene(scene);
        firstStage.show();

        //second stage
        //
        VBox paneForRadioButtons = new VBox(20);
        Stage secondStage = new Stage();
        Scene scene1 = new Scene(paneForRadioButtons, 200, 135);
        secondStage.setTitle("RadioButton");
        secondStage.setScene(scene1);
        secondStage.show();
        firstStage.setOnCloseRequest(e -> Platform.exit());

        //set the background color
        paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5));
        paneForRadioButtons.setStyle("-fx-border-color: green");
        paneForRadioButtons.setStyle("-fx-border-width: 2px; -fx-border-color: green");

        //create new buttons
        RadioButton creeper = new RadioButton("Creeper");
        RadioButton sun = new RadioButton("Sun");
        RadioButton drawing = new RadioButton("Your Drawing");

        //display the buttons
        paneForRadioButtons.getChildren().addAll(creeper, sun, drawing);
        //this makes sure the user can only click on one button.
        ToggleGroup group = new ToggleGroup();
        creeper.setToggleGroup(group);
        sun.setToggleGroup(group);
        drawing.setToggleGroup(group);
        //This handler change the title. Clear the scene and open the file and draw the picture.
        creeper.setOnAction(e -> {

            if (creeper.isSelected()) {
                firstStage.setTitle("Creeper");
                image.getChildren().clear();
                readFile(readCreeper, image);

            }
        });

        sun.setOnAction(e -> {

            if (sun.isSelected()) {
                firstStage.setTitle("Sun");
                image.getChildren().clear();
                readFile(readSun, image);

            }
        });
        drawing.setOnAction(e -> {

            if (drawing.isSelected()) {
                firstStage.setTitle("Creativity");
                image.getChildren().clear();
                readFile(readFile, image);

            }
        });
        //exit both stages at the same time
        secondStage.setOnCloseRequest(e -> Platform.exit());

    }

    public Pane readFile(String file, Pane photo) {
        Scanner documents = null;

        // Open the file and tell user if the it couldnt find the file
        try {
            documents = new Scanner(new File(file));

        } catch (FileNotFoundException e) {
            System.err.println("Error opening file: " + file);
            System.exit(1);
        }
        //go through the file
        //while loop read through the files. line by line.
        Color color = null;
        while (documents.hasNext()) {
            String typeOfShapes = documents.next();
            //array for the color
            double[] pigment = new double[3];
            //array for the shape
            int[] structure = new int[4];
             //if-else checks for what to draw and what to color.
            // The shapes and color stored in the new object.
            if (typeOfShapes.equalsIgnoreCase("COLOR")) {
                for (int i = 0; i < 3; i++) {
                    pigment[i] = documents.nextDouble();
                }
                color = Color.color(pigment[0], pigment[1], pigment[2]);

            } else if (typeOfShapes.equalsIgnoreCase("LINE")) {

                for (int i = 0; i < 4; i++) {
                    structure[i] = documents.nextInt();
                }
                Line line = new Line(structure[0], structure[1], structure[2], structure[3]);
                line.setStroke(color);
                photo.getChildren().add(line);

            } else if (typeOfShapes.equalsIgnoreCase("OVAL")) {

                for (int i = 0; i < 4; i++) {
                    structure[i] = documents.nextInt();
                }
                Ellipse oval = new Ellipse(structure[0], structure[1], structure[2], structure[3]);
                oval.setFill(Color.TRANSPARENT);
                oval.setStroke(color);
                photo.getChildren().add(oval);

            } else if (typeOfShapes.equalsIgnoreCase("FILLEDOVAL")) {

                for (int i = 0; i < 4; i++) {
                    structure[i] = documents.nextInt();
                }
                
                Ellipse filledOval = new Ellipse(structure[0], structure[1], structure[2], structure[3]);
                filledOval.setStroke(Color.TRANSPARENT);
                filledOval.setFill(color);

                photo.getChildren().add(filledOval);

            } else if (typeOfShapes.equalsIgnoreCase("RECTANGLE")) {
                for (int i = 0; i < 4; i++) {
                    structure[i] = documents.nextInt();
                }

                Rectangle rectangle = new Rectangle(structure[0], structure[1], structure[2], structure[3]);
                rectangle.setFill(Color.TRANSPARENT);
                rectangle.setStroke(color);
                photo.getChildren().add(rectangle);

            } else if (typeOfShapes.equalsIgnoreCase("FILLEDRECTANGLE")) {
                for (int i = 0; i < 4; i++) {
                    structure[i] = documents.nextInt();
                }

                Rectangle filledRectangle = new Rectangle(structure[0], structure[1], structure[2], structure[3]);
                filledRectangle.setFill(color);
                filledRectangle.setStroke(Color.TRANSPARENT);
                photo.getChildren().add(filledRectangle);

            }

        }
        //return to pane inorder to print the picture
        return photo;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
