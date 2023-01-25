package de.gothaer;

import de.gothaer.game.Spiel;

public class GameClient {

    private final Spiel spiel;

    public GameClient(final Spiel spiel) {
        this.spiel = spiel;
    }

    public void go() {
        spiel.spielen();
    }
}
