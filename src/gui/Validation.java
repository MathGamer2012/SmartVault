/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Validation {

    public static ArrayList<String> username = new ArrayList<String>();
    public static ArrayList<String> pass = new ArrayList<String>();
    public static ArrayList<String> security = new ArrayList<String>();
    public static ArrayList<String> answer = new ArrayList<String>();
    public static ArrayList<String> face = new ArrayList<String>();
    public static String currentVal; 

    public Validation() {

    }

    public void getName(ArrayList<String> value) {
        username = value;
    }
    
    public void printName() {
        for (int i = 0; i < username.size(); i++) {
            System.out.println(username.get(i)); 
        }
    }

    public void getPass(ArrayList<String> value) {
        pass = value;

    }

    public void getSecurity(ArrayList<String> value) {
        security = value;

    }

    public void getAnswer(ArrayList<String> value) {
        answer = value;

    }

    public void getFace(ArrayList<String> value) {
        face = value;

    }
    
    public void getCurrentValue(String value) {
        currentVal = value; 
    }
    
    public String getValues() {
        int counter = 1;
        try {
            File myObj = new File("accounts.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) //continues to read until the line is null or doesn't contrain anything 
            {
                if (counter == 1) {
                    username.add(myReader.nextLine().toLowerCase().trim());
                }

                if (counter == 2) {
                    pass.add(myReader.nextLine());

                }

                if (counter == 3) {
                    security.add(myReader.nextLine());

                }

                if (counter == 4) {
                    answer.add(myReader.nextLine());
                }

                if (counter == 5) {
                    face.add(myReader.nextLine());
                    counter = 0;
                }
                counter++;
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        return "Values Created"; 
    }

}
