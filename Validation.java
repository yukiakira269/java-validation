/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValidationTools;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Validation {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static boolean isLeapYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
    }

    public static boolean has31Days(int month) {
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 10:
                return false;
            default:
                return true;
        }
    }

    public static boolean IsValidDate(int year, int month, int day) {
        if (month == 2 && day <= 28 && !isLeapYear(year) && month >= 1 && day >= 1 && year >= 0) {
            return true;
        } else if (month == 2 && day <= 29 && isLeapYear(year) && month >= 1 && day >= 1 && year >= 0) {
            return true;
        } else if (month != 2 && has31Days(month) && day <= 31 && month >= 1 && day >= 1 && year >= 0) {
            return true;
        } else if (month != 2 && !has31Days(month) && day <= 30 && month >= 1 && day >= 1 && year >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean IsValidPhoneNUmber(String s) {
        return s.matches("^[0-9]{9,12}$");
    }

    public static boolean isValidEmail(String s) {
        return s.matches("^(.+)@(.+)\\.[a-zA-Z0-9]+$");
    }

    public static boolean isValidString(String s, String pattern) {
        return s.matches(pattern);
    }

    public static boolean isValidPassword(String s) {
        return s.matches("^(?=.*[0-9])(?=.*[a-z])(=?.*[A-Z])(?=.*[^@#$%&{}<>])(.*){8,12}$");
    }
    
    
    
    

    public static int InputInt() {
        Scanner sc = new Scanner(System.in);
        boolean cont = false;
        do {
            try {
                int temp = Integer.parseInt(sc.nextLine());
                cont = false;
                return temp;
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Invalid input! Please try again!" + ANSI_RESET);
                cont = true;
            }
        } while (cont);
        return 0;
    }
    
    public static int InputIntCond(int min, int max){
        int temp;
        boolean cont = false;
        do{
            try{
                temp = InputInt();
                cont = false;
                if(temp < min || temp > max){
                    throw new Exception(ANSI_RED + "Invalid input! Domain has been exceeded! Please try again!" + ANSI_RESET);
                }
                return temp;
            }catch(Exception e){
                System.out.println(e.getMessage());
                cont = true;
            } 
        }while(cont);
        return 0;
    }
    
    
    public static String InputString() {
        Scanner sc = new Scanner(System.in);
        boolean cont = false;
        do {
            try {
                String temp = sc.nextLine();
                if (temp.isBlank()) {
                    throw new Exception("Null string detected! PLease try again!");
                }
                return temp;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                cont = true;
            }
        } while (cont);
        return null;
    }
    
    public static String InputStringMatches(String pattern){
        boolean cont = false;
        do{
        String temp = InputString();
        if(isValidString(temp, pattern)){
            cont = false;
            return temp;
        }
        System.out.printf(ANSI_RED + "Invalid input! Please try again! Must be %s\n" + ANSI_RESET, pattern);
        cont = true;
        
        }while(cont);
        return null;
    }
    public static void BubbleString(String[] arr, int length) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    public static void BubbleInt(Integer[] arr, int length){
        for(int x = 0; x < length; x++){
            for(int y = 0; y < length - x - 1; y++){
                if(arr[y] > arr[y+1]){
                    int temp = arr[y];
                    arr[y] = arr[y+1];
                    arr[y+1] = temp;
                }
            }
        }
    }
    
    
    
    

}
