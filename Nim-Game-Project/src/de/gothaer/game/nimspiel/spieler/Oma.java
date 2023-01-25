package de.gothaer.game.nimspiel.spieler;

import java.util.Random;

public class Oma extends AbstractNimSpielende{

    private Random random = new Random();
    public Oma() {
    }

    public Oma(String name) {
        super(name);
    }

    @Override
    public Integer ziehen(Integer integer) {
        final int zug = random.nextInt(4);
        System.out.println("Oma nimmt " + zug + " Steine.");
        return zug;
    }
}
