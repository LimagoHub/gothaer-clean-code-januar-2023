package de.gothaer.application;

public interface Liste<T> {

    void append(T value);
    T get();
    default void clear(){
        while(remove());
    }
    boolean remove();
    default boolean moveFirst(){
        if(isEmpty()) return false;
        while(movePrevious());
        return true;
    }
    default boolean moveLast(){
        if(isEmpty()) return false;
        while(moveNext());
        return true;
    }
    boolean moveNext();
    boolean movePrevious();
    boolean isEmpty();
    boolean isBeginOfList();
    boolean isEndOfList();
}
