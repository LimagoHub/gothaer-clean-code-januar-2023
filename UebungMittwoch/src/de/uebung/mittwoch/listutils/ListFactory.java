package de.uebung.mittwoch.listutils;

import java.util.List;

public interface ListFactory<T> {

    List<T> createFilledList(final int size);
}
