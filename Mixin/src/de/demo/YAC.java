package de.demo;

public interface YAC<T> {

    boolean eq(T other);
    boolean lt(T other);
    default boolean le(T other) {
        return lt(other) || eq(other);
    }
}
