/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.checkdataformat;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author Bravo
 */
public class InputData {

    private List<Information> dataList;
    private Scanner sc = new Scanner(System.in);
    private CheckDataFormat runner = new CheckDataFormat();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public InputData() {
        this.dataList = new ArrayList<>();
    }

    public void Inputter() {
        String choice = null;
        do {
            System.out.println("====== Validate Progaram ======");
            System.out.print("Phone number: ");
            String phone = runner.checkInputPhone();
            System.out.print("");
            String dateStr = runner.InputDateCheck();
            try {
                Date date = dateFormat.parse(dateStr);
                System.out.print("Email: ");
                String email = runner.checkInputEmail();
                Information iF = new Information(phone, date, email);
                dataList.add(iF);
                System.out.println("do you want check more(Y/N)?");
                choice = sc.next();
                sc.nextLine();
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            }
        } while (choice.equalsIgnoreCase("Y"));
        if (choice == "N") {
            System.out.println("Done!!!");
        }
    }

}
