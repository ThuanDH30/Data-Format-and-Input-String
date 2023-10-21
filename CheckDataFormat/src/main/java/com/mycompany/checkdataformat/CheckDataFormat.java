/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.checkdataformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Bravo
 */
public class CheckDataFormat {

    private static final Scanner in = new Scanner(System.in);
    private static final String PHONE_VALID = "^[0-9]{10}$";
    private static final String EMAIL_VALID = "^[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";

    public CheckDataFormat() {
    }

    public String checkInputString() {
        //loop until user input true value
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public String checkInputPhone() {
        while (true) {
            try {
                int phoneCheck = Integer.parseInt(in.nextLine());
                String resultCheck = String.valueOf(phoneCheck);
                if (!resultCheck.matches(PHONE_VALID)) {
                    System.err.println("Phone number must be 10 digits");
                } else {
                    return resultCheck;
                }
            } catch (NumberFormatException ex) {
                System.out.print("Phone number: ");
                System.err.println("Phone number must be number");
            }
        }
    }

    public String InputDateCheck() {
    Date inputDate = getDateInRightFormat("enter a date in the format [dd/MM/yyyy]: ");
    
    if (inputDate != null) {
        String dayOfWeekWithInputDate = getDate("Your day is ", inputDate);
        display(dayOfWeekWithInputDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(inputDate);
    } else {
        System.out.println("Invalid input date.");
        return null; 
    }
}

    private static Date getDateInRightFormat(String dateInput) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        Date inputDate = null;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(dateInput);
            String str = sc.nextLine();

            try {
                inputDate = dateFormat.parse(str);
                validInput = true;
            } catch (ParseException ex) {
                System.out.println("Doesnt exist. Please try again!");
            }
        }

        return inputDate;
    }

    private static String getDate(String getDate, Date checkDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(checkDate);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String[] arr = {
            "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
        };
        return getDate + arr[dayOfWeek - 1];
    }

    private static void display(String dayOfWeekWithInputDate) {
        System.out.println(dayOfWeekWithInputDate);
    }

    public String checkInputEmail() {
        while (true) {
            String emailCheck = checkInputString();
            if (!emailCheck.matches(EMAIL_VALID)) {
                System.err.println("Email must be correct format");
                System.out.print("Email: ");
            } else {
                return emailCheck;
            }
        }
    }

}
