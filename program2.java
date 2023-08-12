package practices.oop;

import java.util.*;
import java.io.*;

public class program2 {
    public static void main(String[] args) throws FileNotFoundException,IOException {
        File file = new File("C:\\Users\\Dell\\eclipse-workspace\\practices\\src\\practices\\oop\\data1.csv");

        FileReader fr = new FileReader(file);
        Scanner s = new Scanner(fr);  //to read file
        Scanner sc = new Scanner(System.in);  //to read input from console

        System.out.println("Find topper based on :");
        System.out.println("1. IA1");
        System.out.println("2. IA2");
        System.out.println("3. IA3");
        System.out.println("4. Sum of Best two IA's");
        System.out.println("5. CTA");
        System.out.println("6. CIE");
        System.out.print("Enter your choice : ");
        int choice = sc.nextInt();

        int index=0;
        switch (choice) {
            case 1:
                index = 2;
                break;
            case 2:
                index = 3;
                break;
            case 3:
                index = 4;
                break;
            case 4:
                index = 5;
                break;
            case 5:
                index = 6;
                break;
            case 6:
                index = 7;
                break;
            default:
                System.exit(0);
        }

        ArrayList<Integer> list = new ArrayList<Integer>();

        s.nextLine();
        while(s.hasNextLine()){
            String line = s.nextLine();
            String[] str = line.split(",");
            list.add(Integer.parseInt(str[index]));
        }

        int max = Collections.max(list);

        System.out.println("Maximum Marks : "+max+"\nObtained by :");
        fr.close();

        FileReader reader = new FileReader(file);
        Scanner sr = new Scanner(reader);

        sr.nextLine();
        while(sr.hasNextLine()){
            String line = sr.nextLine();
            String[] str = line.split(",");
            int num = Integer.parseInt(str[index]);
            if(num == max)
                System.out.println("Name : "+str[0]+" , USN : "+str[1]);
        }

        reader.close();
    }
}