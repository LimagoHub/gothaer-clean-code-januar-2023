package de.gothaer.application;


import de.gothaer.GameClient;
import de.gothaer.game.AbstractSpiel;
import de.gothaer.game.Spiel;
import de.gothaer.game.nimspiel.NimSpiel;
import de.gothaer.game.nimspiel.spieler.ComputerSpielende;
import de.gothaer.game.nimspiel.spieler.MenschlicherSpielende;
import de.gothaer.game.nimspiel.spieler.Oma;
import de.gothaer.writer.ConsolenWriter;

public class Main {
    public static void main(String[] args) {
        AbstractSpiel spiel = new NimSpiel(new ConsolenWriter());
//        spiel.addiereSpieler(new MenschlicherSpielende());
//        spiel.addiereSpieler(new ComputerSpielende());
//        spiel.addiereSpieler(new Oma());
        spiel.addiereSpieler(new MenschlicherSpielende("Fritz"));
        spiel.addiereSpieler(new MenschlicherSpielende("Anna"));
        GameClient client = new GameClient(spiel);

        client.go();
    }
}