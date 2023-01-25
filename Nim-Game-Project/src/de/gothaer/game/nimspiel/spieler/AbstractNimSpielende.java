package de.gothaer.game.nimspiel.spieler;



public abstract class AbstractNimSpielende implements NimSpielende {

    private String name = this.getClass().getSimpleName();

    protected AbstractNimSpielende() {

    }

    protected AbstractNimSpielende(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }


}
