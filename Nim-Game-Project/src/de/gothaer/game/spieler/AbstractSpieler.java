package de.gothaer.game.spieler;

public abstract class AbstractSpieler <BOARD,MOVE> implements Spieler<BOARD,MOVE>{
    private String name = this.getClass().getSimpleName();

    public AbstractSpieler() {

    }

    public AbstractSpieler(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
