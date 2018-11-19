package view;

import Controller.MainController;
import java.util.Scanner;

public class MainView {

    public String selection = "";

    public void display() {
        while (!selection.toUpperCase().equals("Q")) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Which operation do you want to do?");
            System.out.println("----------------------------------");
            System.out.println("A) Print a page in the console");
            System.out.println("B) Download page");
            System.out.println("C) Get the status of a page");
            System.out.println("D) Get the page from a connection");
            System.out.println("Q) Quit");
            selection = scan.nextLine();

            switch (selection.toUpperCase()) {
                case "A":
                    MainController.printConsolePage();
                    break;
                case "B":
                    MainController.downloadPage();
                    break;
                case "C":
                    MainController.getStatusFromPage();
                    case "D":
                    MainController.getConnection();
                    break;
                default:
                    System.out.println("Please, choose a correct option");
            }
        }
    }

}
