package de.gothaer.game.spieler;

public interface Spieler<BOARD, MOVE> {
    String getName();
    MOVE ziehen(final BOARD board);
}
