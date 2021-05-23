package PrimeNumbers;
import java.util.Scanner;  // Import the Scanner class
import java.io.FileWriter;  // Import the FileWrite class
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors


class List // simple linked list
{
    public List() {}
    int value;
    List next;
}

public class Main
{

    public static void main(String[] args)
    {
        String input = "t";
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        while (!(input.equals("q"))) // menu for user
        {
            System.out.println("p: Display all Prime number below a Number.");
            System.out.println("b: Display all Prime number Between two Number.");
            System.out.println("c: Calculate PI.");
            System.out.println("q: Quit.");

            input = myObj.nextLine();

            switch(input) {
                case "p":
                    primeBelowNumber();
                    readFile();
                    break;
                case "b":
                    primeBetweenNumbers();
                    readFile();
                    break;
                case "c":
                    CalculatePI();
                    break;
                default:
                    ;
            }
        }
    }

    static void CalculatePI() // Calculate pi for using the odd numbers
    {
        double PI = 4.0;
        double sign = -1.0;

        for(int i = 2; i < 1000000000; i++)
        {
            if (sign == -1.0)
            {
                PI += (4.0 / ((i * 2.0) - 1.0)) * sign;
                sign = 1.0;
            }
            else
            {
                PI += 4.0 / ((i * 2.0) - 1.0) * sign;
                sign = -1.0;
            }
        }
        System.out.println("Value of PI = " + PI);


    }
    static void primeBetweenNumbers()
    {
        int low;
        int high;
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        do {    // this get the high value from the user
            System.out.println("What number 10 or above, do you want to find Prime number below?");

            if(myObj.hasNextInt()) {
                high = myObj.nextInt();
                if (high < 10)
                    System.out.println("Number must be greater than 10.");
            }
            else {
                System.out.println("Must be a number!");
                myObj.next();
            high = 0;  // this so it will loop from being not a number
            }
        }
        while(high < 10);

        do {    // this get the low value from the user
            System.out.println("What number 2 or higher but lower than " + high
                    + " you want to find Prime number for?");

            if(myObj.hasNextInt()) {
                low = myObj.nextInt();
                if (low < 2)
                    System.out.println("Number must be greater than 2.");
            }
            else {
                System.out.println("Must be a number!");
                myObj.next();
                low = 0;  // this so it will loop from being not a number
            }
        }
        while(low < 2);

        writeFile(low, high);


    }

    static void primeBelowNumber()
    {
        int number;
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        do {    // this get the high value from the user
            System.out.println("What number do you want to find Prime number below? ");

            if(myObj.hasNextInt()) {
                number = myObj.nextInt();
                if (number < 2)
                    System.out.println("Number must be greater than 2.");
            }
            else {
                System.out.println("Must be a number!");
                myObj.next();
                number = 0;  // this so it will loop from being not a number
            }
        }
        while(number < 2);
       writeFile(2, number);
    }
    static void writeFile(int low, int high) // this write to the file and save all the prime numbers
    {       // this value are from the low value to the high value
        List Prime = new List(); // this first create the linked list that have all the numbers in
        List tail;
        tail = Prime;
        Prime.value = 2;
        for(int i = 3; i < high; i++) {
            List p = new List();
            p.value = i;
            tail.next = p;
            tail = p;
        }
        List check = Prime;
        List point = Prime;
        while(point != null) {      // this remove all numbers that are not prime numbers
            while (check.next != null) {
                if ((check.next.value % point.value) == 0) {
                    check.next = check.next.next;
                } else {
                    check = check.next;

                }
            }
            point = point.next;
            check = point;
        }
        tail = Prime;


        try { // this try catch is the part that write all prime numbers to the file.
            FileWriter file = new FileWriter("PrimeNumbers.txt");
            while(tail.value < low)
                tail = tail.next;

            while(tail != null)
            {
                file.write(String.valueOf(tail.value) + " ");
                tail = tail.next;
            }
            file.close();
        } catch (IOException e) { // just in case there is an error writing to the file
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    static void readFile() // this read from the file
    {
        try { // this read from the file
            File read = new File("PrimeNumbers.txt");
            Scanner myReader = new Scanner(read);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (IOException e) { // if there and error this catch them
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

