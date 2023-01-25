package de.uebung.mittwoch.client;

import java.util.List;

public class ListClient<T> {

    private final List<T> data;

    public ListClient(List<T> data) {
        this.data = data;
    }

    public void go() {

        System.out.println(String.format("Do something with Array. Size=" + data.size()));
    }
}
