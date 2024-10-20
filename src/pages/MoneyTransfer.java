package pages;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import components.Balance;

public class MoneyTransfer {
    
    public void updateDepositBalance(double depAmount, String username, boolean chequingSelected){// https://www.youtube.com/watch?v=C82HPlZ0ypw helped while making this secton
   
            ArrayList<String> usersList = new ArrayList<>();
            ArrayList<String> newUsersList = new ArrayList<>();
            boolean userFound= false;
            
            File users = new File("users.txt");
            Scanner scan = null;
            
            try{
                scan = new Scanner(users);
                while(scan.hasNextLine()){
                    usersList.add(scan.nextLine());
                }
                
            }catch(FileNotFoundException e){
                System.out.println("The file was not found and this is an error!");
            }
            
            //text file has now been copied into a String array list to analyze each individual line
            //the program will now search for the occurance of the inputted username to find the balance
            
            System.out.println();
            
            for(int i = 0; i < usersList.size();i+=8){
                if(usersList.get(i).equals(username)){
                    userFound=true;
                    if(chequingSelected){
                        double oldBal = Double.valueOf(usersList.get(i+1));
                        double newBal = oldBal+depAmount;//dep = deposit
                        usersList.set(i+1, Double.toString(newBal));
                        System.out.println("$"+depAmount+" has been deposited into " + username+"'s chequing account.");
                        System.out.println("Chequing account went from $"+oldBal+" to $"+usersList.get(i+1));
                    }else{
                        int savingsStrikes = Integer.valueOf(usersList.get(i+3));
                        savingsStrikes++;//add 1 to number of saving strikes
                        usersList.set(i+3, String.valueOf(savingsStrikes));
                        System.out.println("Strikes: "+usersList.get(i+3));
                        
                        double savingsPenalty=0;
                        if(savingsStrikes>3){
                            savingsPenalty = depAmount*(0.02*savingsStrikes);
                        }
                        double oldBal = Double.valueOf(usersList.get(i+2));
                        double newBal = oldBal+depAmount-savingsPenalty;
                        usersList.set(i+2, Double.toString(newBal));
                        
                        System.out.println("$"+depAmount+" has been deposited into " + username+"'s savings account.");
                        System.out.println("Savings account went from $"+oldBal+" to $"+usersList.get(i+2));   
                    }
                }
            }
            //now the balance has been updated within the ArrayList
            //All that is left is saving the ArrayList into the text file!
            
            try {
        FileWriter fw = new FileWriter("users.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        for (int i = 0; i < usersList.size(); i++) {
            String s = usersList.get(i);
            bw.write(s);
            bw.newLine();
        }
        System.out.println("SUCCESS! Successful deposit!");
        bw.close();
        fw.close();
    } catch (Exception e) {
        System.out.print(e);
    }
}
    
    
public void updateWithdrawBalance(double wdAmount, String username, boolean chequingSelected){// https://www.youtube.com/watch?v=C82HPlZ0ypw helped while making this secton
   Balance bal = new Balance();
            ArrayList<String> usersList = new ArrayList<>();
            ArrayList<String> newUsersList = new ArrayList<>();
            boolean userFound= false;
            
            File users = new File("users.txt");
            Scanner scan = null;
            
            try{
                scan = new Scanner(users);
                while(scan.hasNextLine()){
                    usersList.add(scan.nextLine());
                }
                
            }catch(FileNotFoundException e){
                System.out.println("The file was not found and this is an error!");
            }
            
            //text file has now been copied into a String array list to analyze each individual line
            //the program will now search for the occurance of the inputted username to find the balance
            
            System.out.println();
            
            for(int i = 0; i < usersList.size();i+=8){
                if(usersList.get(i).equals(username)){
                    userFound=true;
                    //usersList.set(i, );
                    if(chequingSelected){
                        double oldBal = Double.valueOf(usersList.get(i+1));
                        double newBal = oldBal-wdAmount;//wd = withdraw amount
                        usersList.set(i+1, Double.toString(newBal));
                        
                        Balance.currentCheque -= wdAmount;
                        bal.updateBalFile(true);
                        System.out.println("$"+wdAmount+" has been withdrawn from "+username+"'s chequing account.");
                        System.out.println("Chequing account went from $"+oldBal+" to $"+usersList.get(i+1));
                    }else{
                        int savingsStrikes = Integer.valueOf(usersList.get(i+3));
                        savingsStrikes++;
                        usersList.set(i+3, String.valueOf(savingsStrikes));
                        System.out.println("Strikes: "+usersList.get(i+3));
                        
                        double savingsPenalty=0;
                        if(savingsStrikes>3){
                            savingsPenalty = wdAmount*(0.02*savingsStrikes);
                        }
                        double oldBal = Double.valueOf(usersList.get(i+2));
                        double newBal = oldBal-wdAmount-savingsPenalty;//wd = withdraw amount
                        Balance.currentSaving = Balance.currentSaving- (int)wdAmount-(int)savingsPenalty;
                        bal.updateBalFile(false);
                        usersList.set(i+2, Double.toString(newBal));
                        
                        System.out.println("$"+wdAmount+" has been withdrawn from "+username+"'s savings account.");
                        System.out.println("Savings account went from $"+oldBal+" to $"+usersList.get(i+2));   
                    }
                }
            }
            //now the balance has been updated within the ArrayList
            //All that is left is saving the ArrayList into the text file!
            
            try {
        FileWriter fw = new FileWriter("users.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        for (int i = 0; i < usersList.size(); i++) {
            String s = usersList.get(i);
            bw.write(s);
            bw.newLine();
        }
        System.out.println("SUCCESS! Successful withdrawal!");
        bw.close();
        fw.close();
    } catch (Exception e) {
        System.out.print(e);
    }
}

public void sendMoney(double amountSent, String giver, String recipient, boolean chequingSelected){
    updateWithdrawBalance(amountSent,giver,chequingSelected);
    updateDepositBalance(amountSent,recipient,true);//chequing will always be selected as to not hinder strike count
    System.out.println("SUCCESS! Successful transaction!");
}

public boolean doesUserExist(String username){
        ArrayList<String> usersList = new ArrayList<>();
        ArrayList<String> newUsersList = new ArrayList<>();
        boolean userFound = false;

        File users = new File("users.txt");
        Scanner scan = null;

        try {
            scan = new Scanner(users);
            while (scan.hasNextLine()) {
                usersList.add(scan.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("The file was not found and this is an error!");
        }

        //text file has now been copied into a String array list to analyze each individual line
        //the program will now search for the occurance of the inputted username to find the balance
        System.out.println();
        
        for (int i = 0; i < usersList.size(); i+=8) {
            if(usersList.get(i).equals(username)){
                return true;
            }
        }
        return false;
    }

public void requestSomeMoney(double amount, String giver, String requester, String message){
    ArrayList<String> usersList = new ArrayList<>();
    ArrayList<String> newUsersList = new ArrayList<>();
    boolean userFound = false;

    File users = new File("users.txt");
    Scanner scan = null;

    try {
        scan = new Scanner(users);
        while (scan.hasNextLine()) {
            usersList.add(scan.nextLine());
        }

    } catch (FileNotFoundException e) {
        System.out.println("The file was not found and this is an error!");
    }
    
    //logic starts here
    
    for(int i = 0; i<usersList.size();i+=8){
        if(usersList.get(i).equals(giver)){
            usersList.set(i+4,requester);
            usersList.set(i+5, String.valueOf(amount));
            usersList.set(i+6, message);
            usersList.set(i+7,"1");//notification = true
        }
    }
    try {
        FileWriter fw = new FileWriter("users.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        for (int i = 0; i < usersList.size(); i++) {
            String s = usersList.get(i);
            bw.write(s);
            bw.newLine();
        }
        System.out.println("SUCCESS! Successful thingamabob!");
        bw.close();
        fw.close();
    } catch (Exception e) {
        System.out.print(e);
    }
}

public String[] getMyNotifs(String username){
    String[] myNotifs = new String[4];
    
    ArrayList<String> usersList = new ArrayList<>();

    File users = new File("users.txt");
    Scanner scan = null;

    try {
        scan = new Scanner(users);
        while (scan.hasNextLine()) {
            usersList.add(scan.nextLine());
        }

    } catch (FileNotFoundException e) {
        System.out.println("The file was not found and this is an error!");
    }
    
    //logic starts here
    
    for(int i = 0; i<usersList.size();i+=8){
        if(usersList.get(i).equals(username)){
            myNotifs[0]=usersList.get(i+4);
            myNotifs[1]=usersList.get(i+5);
            myNotifs[2]=usersList.get(i+6);
            myNotifs[3]=usersList.get(i+7);
        }
    }
    return myNotifs;
    
}

public void clearMyNotifs(String username){
    ArrayList<String> usersList = new ArrayList<>();

    File users = new File("users.txt");
    Scanner scan = null;

    try {
        scan = new Scanner(users);
        while (scan.hasNextLine()) {
            usersList.add(scan.nextLine());
        }

    } catch (FileNotFoundException e) {
        System.out.println("The file was not found and this is an error!");
    }
    for(int i = 0; i<usersList.size();i+=8){
        if(usersList.get(i).equals(username)){
            usersList.set(i+7,"0");
        }
    }
    try {
        FileWriter fw = new FileWriter("users.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        for (int i = 0; i < usersList.size(); i++) {
            String s = usersList.get(i);
            bw.write(s);
            bw.newLine();
        }
        System.out.println("SUCCESS! Successful thingamabob!");
        bw.close();
        fw.close();
    } catch (Exception e) {
        System.out.print(e);
    }
    
}


}