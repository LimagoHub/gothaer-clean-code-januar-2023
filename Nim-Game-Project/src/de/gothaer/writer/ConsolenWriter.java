package de.gothaer.writer;

public class ConsolenWriter implements Writer{
    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
