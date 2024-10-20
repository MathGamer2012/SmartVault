/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Balance {

    public static ArrayList<String> usernames = new ArrayList<String>();

    public static ArrayList<String> cheques = new ArrayList<String>();

    public static ArrayList<String> savings = new ArrayList<String>();
    

    public static String username;
    public static int currentCheque; //used for updating within system 
    public static int currentSaving; //used for updating within system 
    public static int cheque = 0; //file IO
    public static int saving = 0; //file IO
    public static boolean firstOpen = true;

    public Balance() {

    }
    
    public ArrayList<String> getUsernames(){
        return usernames;
    }
    
    

    public void getUser() { // gets current user's username from text file
        try {
            File myObj = new File("currentLogin.txt"); //retreving info from text file 
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                username = myReader.nextLine();
                System.out.println(username);
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public boolean Exsist(String potentialUser) { // does a user exist? - yes or no

        ArrayList<String> user = new ArrayList<String>();
        ArrayList<String> trash = new ArrayList<String>();

        try {
            File myObj = new File("users.txt"); //retreving info from text file 
            Scanner myReader = new Scanner(myObj);
            int counter = 1;
            while (myReader.hasNextLine()) {
                if (counter == 1) {
                    user.add(myReader.nextLine());
                }

                if (counter > 1 && counter <8) {
                    trash.add(myReader.nextLine());
                }

                if (counter == 8) {
                    trash.add(myReader.nextLine());
                    counter = 0;
                }

                counter++;
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        if (user.contains(potentialUser)) {
            return false; //inidatces to not update file
        } else {
            return true;
        }
    }

    public void updateFile() { // used for new user signup
        try {

            //Find index of currentusername in the arraylist of users 
            FileWriter writer = new FileWriter("users.txt", true);
            writer.write(username + "\n");
            writer.write(cheque + "\n");
            writer.write(saving + "\n");
            writer.write(0 + "\n");
            writer.write("N" + "\n");
            writer.write(0 + "\n");
            writer.write("N" + "\n");
            writer.write(0 + "\n");
            
            System.out.println("DONE");

            writer.close();

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void getInfo() { // updates private variable lists
        try {
            File myObj = new File("users.txt"); //retreving info from text file 
            Scanner myReader = new Scanner(myObj);
            ArrayList<String> awooga = new ArrayList<String>();
            while (myReader.hasNextLine()) {

                    awooga.add(myReader.nextLine());
                
            }
            myReader.close();

            int aS = awooga.size();
            

            for(int i = 0 ; i < aS ; i+=8){
                usernames.add(awooga.get(i));
                cheques.add(awooga.get(i+1));
                savings.add(awooga.get(i+2));

            }


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Done setting info.");
    }

    public void getBalances(String user) {
        int index = usernames.indexOf(user);
        System.out.println("Index good(method): " + index);

        currentCheque = Integer.valueOf(cheques.get(index));
        System.out.println("Current Chequing Bal(method): "+currentCheque);
        currentSaving = Integer.valueOf(savings.get(index));
        System.out.println("Current Savings Bal(method): " + currentSaving);

    }

    public void updateBalFile(boolean chequingUsed) { // updates file - not instance variables
        
        ArrayList<String> userInfoList = new ArrayList<String>();
        
        try{
        File abc = new File ("users.txt");
        Scanner scanMe = new Scanner(abc);
        while(scanMe.hasNextLine()){
            userInfoList.add(scanMe.nextLine());
        }
        
            //copied info user list
            scanMe.close();
        int index = 0;
        for(int i = 0 ; i<usernames.size()-1 ; i++){
           if(usernames.get(i).equals(username)){
               index = i;
               break;
           }
        }
        
        userInfoList.set(index+1, String.valueOf(currentCheque));
        userInfoList.set(index+2, String.valueOf(currentSaving));
        
        System.out.println("Current Chequing (IN LIST): " + userInfoList.get(index+1));
        System.out.println("Current Savings (IN LIST): " + userInfoList.get(index+2));

        if(chequingUsed==false){
            String savingsUsagesString = userInfoList.get(index+3);
            int newSavingsUsages = Integer.valueOf(savingsUsagesString);
            
        userInfoList.set(index+3,String.valueOf((newSavingsUsages+1)));
        }
        
        }catch(IOException ex){
            System.out.print(ex);
        }
        
        try{
            FileWriter fw = new FileWriter("users.txt");

            for(int i = 0 ; i < userInfoList.size() ; i++){
                fw.write(userInfoList.get(i)+"\n");
            }
            fw.close();
        }catch(IOException ex){
            System.out.print(ex);
        }
        
        
    }

}
