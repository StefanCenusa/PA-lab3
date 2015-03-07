/**
 * Created by Stefan.
 */

import java.util.Scanner;

public class Console {
    public void printWelcome() {
        System.out.println("Bine ati venit!");
    }

    public String readCommand() {
        String line;

        Scanner scanIn = new Scanner(System.in);
        try {
            line = scanIn.nextLine();
            System.out.println(line);
            scanIn.close();
            return line;

        } catch (IllegalStateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void print(String data){
        System.out.println(data);
    }
}