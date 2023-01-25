package de.gothaer.game.nimspiel;

import de.gothaer.game.AbstractSpiel;
import de.gothaer.game.Spiel;
import de.gothaer.game.nimspiel.spieler.NimSpielende;
import de.gothaer.writer.Writer;

import java.util.ArrayList;
import java.util.List;

public class NimSpiel extends AbstractSpiel<Integer,Integer> {



    public NimSpiel(final Writer writer) {
        super(writer);
        setSpielbrett(23);
    }


    @Override
    protected void prepare() {
        write(getAktuellerSpieler().getName() + " ist am Zug");
    }

    protected boolean isZugGueltig() {
        return getZug() >=1 && getZug() <=3;
    }

    protected void updateBoard() {
        setSpielbrett(getSpielbrett() - getZug());
    }

    protected boolean isSpielende() {
        return getSpielbrett() < 1 || getMitspieler().isEmpty();
    }
}
