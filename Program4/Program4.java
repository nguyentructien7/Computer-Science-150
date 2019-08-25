/*
 Program 4
 Name: Tien Nguyen
 Date:April-20-2016
 Class:Computer Science 150
 Description: Reading file containing stats.The 6 stats are: Strength, 
 Constitution, Intelligence, Wisdom, Dexterity, and Charisma.There are six 
 professions: Fighter, Ranger, Mage, Cleric, Rogue, and Bard. 
 Read binary and sort it.Then convert the binary to int.
 */
package program4;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Scanner;

/**
 *
 * @author tiennguyen
 */
public class Program4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //array for class
        ArrayList<Gamer> sort;
        //loads 10 stat blocks from a binary
        try (DataInputStream fileIn = new DataInputStream(new FileInputStream("CharacterStats.dat"))) {
            sort = new ArrayList<>();

            //Go through the file
            while (fileIn.available() > 0) {
                Gamer players = new Gamer();
                int compare = 0;
                // Go throgh the list and compare the int
                while (compare < 6) {
                    int x = fileIn.readInt();

                    if (compare == 0) {
                        players.setStrength(x);
                    }
                    if (compare == 1) {
                        players.setConstitution(x);
                    }
                    if (compare == 2) {
                        players.setIntelligence(x);
                    }
                    if (compare == 3) {
                        players.setWisdom(x);
                    }
                    if (compare == 4) {
                        players.setDexterity(x);
                    }
                    if (compare == 5) {
                        players.setCharisma(x);
                    }
                    compare++;

                }
                sort.add(players);
            }
        }
        //print the calculation of the profession and the quality of a stat block.
        sort.stream().forEach((chars) -> {
            chars.formula();
        });
        //Display the 10 stat blocks followed by their rating for each profession.
        sort.stream().forEach((chars2) -> {
            System.out.println(chars2.toString());
        });

        Scanner keyboard = new Scanner(System.in);
        String option;

        // print all the stats and profession
        do {

            System.out.println("1 : Strength");
            System.out.println("2 : Constitution");
            System.out.println("3 : Intelligence");
            System.out.println("4 : Wisdom");
            System.out.println("5 : Dexterity");
            System.out.println("6 : Charisma");
            System.out.println("7 : Fighter");
            System.out.println("8 : Ranger");
            System.out.println("9 : Mage");
            System.out.println("10 : Cleric");
            System.out.println("11 : Rouge");
            System.out.println("12 : Bard");
            System.out.println("Q : Quit Program");
            System.out.print("Your Choice?  ");
            option = keyboard.next();

            //Check for number the user input and print out the stats,profession and calculation.
           if ("1".equals(option))
                    System.out.println("Sorted by Strength: ");
                    Collections.sort(sort, Collections.reverseOrder(Gamer.strengthComp));
                    sort.stream().forEach((str) -> {
                        System.out.println(str);
                    }
                    else if ("2".equals(option)){ 
                    System.out.println("Sorted by Constitution: ");
                    Collections.sort(sort, Collections.reverseOrder(Gamer.constitutionComp));
                    sort.stream().forEach((str) -> {
                        System.out.println(str);
                    }
                else if ("3".equals(option)){ 
                    System.out.println("Sorted by Intelligence: ");
                    Collections.sort(sort, Collections.reverseOrder(Gamer.intelligenceComp));
                    sort.stream().forEach((str) -> {
                        System.out.println(str);
                    }
                 else if ("4".equals(option)){ 
                    System.out.println("Sorted by Wisdom: ");
                    Collections.sort(sort, Collections.reverseOrder(Gamer.wisdomComp));
                    sort.stream().forEach((str) -> {
                        System.out.println(str);
                    }
                else if ("5".equals(option)){ 
                    System.out.println("Sorted by Dexterity: ");
                    Collections.sort(sort, Collections.reverseOrder(Gamer.dexterityComp));
                    sort.stream().forEach((str) -> {
                        System.out.println(str);
                    }
              else if ("6".equals(option)){ 
                    System.out.println("Sorted by Charisma: ");
                    Collections.sort(sort, Collections.reverseOrder(Gamer.charismaComp));
                    sort.stream().forEach((str) -> {
                        System.out.println(str);
                    }
                 else if ("7".equals(option)){ 
                    System.out.println("Sorted by Fighter rating: ");
                    Collections.sort(sort, Collections.reverseOrder(Gamer.fighterComp));
                    sort.stream().forEach((str) -> {
                        System.out.println(str);
                    }
                 else if ("8".equals(option)){ 
                    System.out.println("Sorted by ranger rating: ");
                    Collections.sort(sort, Collections.reverseOrder(Gamer.rangerComp));
                    sort.stream().forEach((str) -> {
                        System.out.println(str);
                    }
                else if ("9".equals(option)){ 
                    System.out.println("Sorted by Mage rating: ");
                    Collections.sort(sort, Collections.reverseOrder(Gamer.mageComp));
                    sort.stream().forEach((str) -> {
                        System.out.println(str);
                    }
                 else if ("10".equals(option)){ 
                    System.out.println("Sorted by Cleric rating: ");
                    Collections.sort(sort, Collections.reverseOrder(Gamer.clericComp));
                    sort.stream().forEach((str) -> {
                        System.out.println(str);
                    }
                else if ("11".equals(option)){ 
                    System.out.println("Sorted by Rouge rating: ");
                    Collections.sort(sort, Collections.reverseOrder(Gamer.rougeComp));
                    sort.stream().forEach((str) -> {
                        System.out.println(str);
                    }
                 else if ("12".equals(option)){ 
                    System.out.println("Sorted by Bard rating: ");
                    Collections.sort(sort, Collections.reverseOrder(Gamer.bardComp));
                    sort.stream().forEach((str) -> {
                        System.out.println(str);
                    }
            }
            //allows the user to quick when they want
        } while (!"Q".equals(option));
        if ("Q".equals(option)) {
            System.out.println("GoodBye");
            System.exit(0);
        }

    }}
                         

