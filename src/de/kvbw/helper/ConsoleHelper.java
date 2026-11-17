package de.kvbw.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    // static methods
    // readInteger
    // readString
    // readDouble
    private ConsoleHelper() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static Object ampel = new Object(); // für Sync
    private static ConsoleHelper instance = null;

    public static ConsoleHelper getInstance() {
        synchronized (ampel) { // Nur ein Thread darf
            if (instance == null) {
                instance = new ConsoleHelper();
            }
            return instance;
        }
    }

    private BufferedReader reader;

    public int readInteger(String prompt) {
        return readInteger(prompt,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int readInteger(String prompt, int min, int max) {
        String eingabe = null;
        int zahl = 0;
        while (true) {
            try {
                System.out.print(prompt + ": ");
                eingabe = reader.readLine();
                zahl = Integer.parseInt(eingabe);
                if (zahl >= min && zahl <= max) {
                    return zahl;
                } else {
                    System.out.printf("Bitte eine Zahl im Bereich %d .. %d eingeben\n", min, max);
                }
            } catch (IOException e) {
                System.out.println("Reader-Problem: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Bitte eine Zahl eingeben!!! Ihre Eingabe: " + eingabe);
            }
        }
    }

    public double readDouble(String prompt) {
        return readDouble(prompt,Double.MIN_VALUE,Double.MAX_VALUE);
    }

    public double readDouble(String prompt, double min, double max) {
        String eingabe = null;
        double zahl = 0.0;
        while (true) {
            try {
                System.out.print(prompt + ": ");
                eingabe = reader.readLine();
                zahl = Double.parseDouble(eingabe);
                if (zahl >= min && zahl <= max) {
                    return zahl;
                } else {
                    System.out.printf("Bitte eine Zahl im Bereich %f .. %f eingeben\n", min, max);
                }
            } catch (IOException e) {
                System.out.println("Reader-Problem: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Bitte eine Zahl eingeben!!! Ihre Eingabe: " + eingabe);
            }
        }
    }


    public String readString(String prompt) {
        String eingabe = null;
        while (true) {
            try {
                System.out.print(prompt + ": ");
                eingabe = reader.readLine();
                if(eingabe.length()>0) {
                    return eingabe;
                }
            } catch (IOException e) {
                System.out.println("Reader-Problem: " + e.getMessage());
            }
        }
    }


}
