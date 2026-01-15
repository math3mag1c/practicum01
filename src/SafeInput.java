import java.util.Scanner;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do
        {
            System.out.println("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while(retString.length() == 0);
        return retString;
    }
    public static int getInt(Scanner pipe, String prompt) {
        boolean done = false;
        String trash;
        int result = 0; // user's input
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            if (pipe.hasNextInt()) {
                result = pipe.nextInt();
                done = true;
            }
            else {
                trash = pipe.nextLine();
                System.out.println("Your input of " + trash + " is invalid. Please input an integer.");
            }
        } while(!done);
        return result;
    }
    public static double getDouble(Scanner pipe, String prompt) {
        boolean done = false;
        String trash = "";
        double result = 0.0; // user's input
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            if (pipe.hasNextDouble()) {
                result = pipe.nextDouble();
                done = true;
            }
            else {
                trash = pipe.nextLine();
                System.out.println("Your input of " + trash + " is invalid. Please input a double.");
            }
        } while(!done);
        return result;
    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        boolean done = false;
        String trash;
        int result = 0; // user's input
        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: "); // show prompt add space
            if (pipe.hasNextInt()) {
                result = pipe.nextInt();
                if (result >= low && result <= high) {
                    done = true;
                }
                else {
                    System.out.println("Your input of " + result + " was out of the range [" + low + ", " + high + "]. Please try again with an in-range integer.");
                }
            }
            else {
                trash = pipe.nextLine();
                System.out.println("Your input of " + trash + " is invalid. Please input an in-range integer.");
            }
        } while(!done);
        return result;
    }
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        boolean done = false;
        String trash;
        double result = 0.0; // user's input
        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: "); // show prompt add space
            if (pipe.hasNextDouble()) {
                result = pipe.nextDouble();
                if (result >= low && result <= high) {
                    done = true;
                }
                else {
                    System.out.println("Your input of " + result + " was out of the range [" + low + ", " + high + "]. Please try again with an in-range double.");
                }
            }
            else {
                trash = pipe.nextLine();
                System.out.println("Your input of " + trash + " is invalid. Please input an in-range double.");
            }
        } while(!done);
        return result;
    }
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean done = false;
        String result = ""; // user's input
        do {
            System.out.println(prompt + ": "); // show prompt add space
            result = pipe.nextLine();
            if (result.equalsIgnoreCase("Y") || result.equalsIgnoreCase("N")) {
                done = true;
            }
            else {
                System.out.println("Your input of " + result + " is invalid. Please try again.");
            }
        } while(!done);
        if (result.equalsIgnoreCase("Y")) {
            return true;
        }
        else if (result.equalsIgnoreCase("N")) {
            return false;
        }
        return false;
    }
    public static String getRegExString(Scanner pipe, String prompt, String regExPattern) {
        boolean done = false;
        String result; // user's input
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            result = pipe.nextLine();
            if (result.matches(regExPattern)) {
                done = true;
            }
            else {
                System.out.println("Your input of " + result + " is invalid. Please try again with a valid input.");
            }
        } while(!done);

        return result;
    }
    public static void repeatedLine(int timesToRepeat, String repeatedChar, boolean newLine) {
        String line = "";
        if (newLine) {
            for (int i = 1; i <= timesToRepeat; i++) {
                line += repeatedChar;
            }
            System.out.println(line);
        }
        else {
            for (int i = 1; i <= timesToRepeat; i++) {
                line += repeatedChar;
            }
            System.out.print(line);
        }
    }

    public static void centeredMessage(Scanner pipe, String message) {
        repeatedLine(60, "*", true);
        int msgLen = message.length();
        repeatedLine(3, "*", false);
        if (msgLen % 2 == 0) {
            int numWhitespace = (54 - msgLen) / 2;
            repeatedLine(numWhitespace, " ", false);
            System.out.print(message);
            repeatedLine(numWhitespace, " ", false);
        }
        else {
            int numWhitespace = (54 - msgLen) / 2;
            repeatedLine(numWhitespace, " ", false);
            System.out.print(message);
            repeatedLine(numWhitespace + 1, " ", false);
        }
        repeatedLine(3, "*", true);
        repeatedLine(60, "*", false);
    }

}