package de.uebung.mittwoch;


import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Main {

    // Mit Klassen
    // Füllen mit Threads
    // messen der Füllgeschwindigkeit available Processors + 1 Threads



    public static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE / 2;

    public static void main(String[] args) {

//        for (int threadCount = 1; threadCount <= Runtime.getRuntime().availableProcessors() + 1; threadCount++) {
//            // jeweils die Füllzeit messen
//        }


        int feld[] = new int[MAX_ARRAY_SIZE];
        Random random = new Random();

        Instant start = Instant.now();
        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            feld[i] = random.nextInt();
        }
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Das Füllen des Arrays dauerte " + duration.toMillis() + " millis");

    }
}