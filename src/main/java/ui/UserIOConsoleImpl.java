package ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO{
    private Scanner scanner = new Scanner(System.in);

    public void print(String message) {
        System.out.println(message);
    }

    public String readString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public int readInt(String prompt) {
        System.out.println(prompt);
        return scanner.nextInt();
    }

    public int readInt(String prompt, int min, int max) {
        boolean inRange;
        int input;
        do {
            System.out.println(prompt);
            input = scanner.nextInt();
            inRange = input >= min && input <= max;
        } while (!inRange);
        return input;
    }

    public double readDouble(String prompt) {
        System.out.println(prompt);
        return scanner.nextDouble();
    }

    public double readDouble(String prompt, double min, double max) {
        boolean inRange;
        double input;
        do {
            System.out.println(prompt);
            input = scanner.nextDouble();
            inRange = input >= min && input <= max;
        } while (!inRange);
        return input;
    }

    public float readFloat(String prompt) {
        System.out.println(prompt);
        return scanner.nextFloat();
    }

    public float readFloat(String prompt, float min, float max) {
        boolean inRange;
        float input;
        do {
            System.out.println(prompt);
            input = scanner.nextFloat();
            inRange = input >= min && input <= max;
        } while (!inRange);
        return input;
    }

    public long readLong(String prompt) {
        System.out.println(prompt);
        return scanner.nextLong();
    }

    public long readLong(String prompt, long min, long max) {
        boolean inRange;
        long input;
        do {
            System.out.println(prompt);
            input = scanner.nextLong();
            inRange = input >= min && input <= max;
        } while (!inRange);
        return input;
    }
}
