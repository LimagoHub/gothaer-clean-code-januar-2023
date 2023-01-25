package de.gothaer.game;


import de.gothaer.game.spieler.Spieler;
import de.gothaer.writer.Writer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractSpiel<BOARD, MOVE> implements Spiel{

    private static final String ERROR_MESSAGE = "ungueltiger Zug";
    private BOARD spielbrett;
    private MOVE zug;


    private Spieler<BOARD,MOVE> aktuellerSpieler;

    private List<Spieler<BOARD,MOVE>> mitspieler = new ArrayList<>();

    private final Writer writer;
    public void addiereSpieler(Spieler<BOARD,MOVE> spieler) {
        mitspieler.add(spieler);
    }
    public void entferneSpieler(Spieler<BOARD,MOVE> spieler) {
        mitspieler.remove(spieler);
    }

    protected List<Spieler<BOARD, MOVE>> getMitspieler() {
        return Collections.unmodifiableList(mitspieler);
    }

    protected Spieler<BOARD, MOVE> getAktuellerSpieler() {

        return aktuellerSpieler;
    }

    protected BOARD getSpielbrett() {


        return spielbrett;
    }

    protected void setSpielbrett(BOARD spielbrett) {
        this.spielbrett = spielbrett;
    }

    protected MOVE getZug() {
        return zug;
    }

    protected void setZug(MOVE zug) {
        this.zug = zug;
    }

    private void setAktuellerSpieler(Spieler<BOARD, MOVE> aktuellerSpieler) {
        this.aktuellerSpieler = aktuellerSpieler;
    }

    protected AbstractSpiel(final Writer writer) {
        this.writer = writer;
    }

    @Override
    public void spielen() {
        while ( ! isSpielende())   spieleRunde();

    }

    private void spieleRunde() {
        for( var spieler : mitspieler) bereiteEinzelnenZugVor(spieler);

    }

    private void bereiteEinzelnenZugVor(Spieler<BOARD, MOVE> spieler) {
       setAktuellerSpieler(spieler);
       spieleEinzelnenZug();
    }

    private void spieleEinzelnenZug() {

        if(initiiereZug()) return ;

        fuehreSpielerzugAus();

        beendeZug( );
    }

    private boolean initiiereZug() {
        prepare();
        return isSpielende();
    }


    private void fuehreSpielerzugAus() {
        do { fuehreKonkretenZugDesAktuellenSpielersAus(); }  while(zugIstNichtGueltig());
    }

    private void beendeZug( ) {
        updateBoard();
        schreibeSpielEndeNachrichtWennSpielZuEndeIst();
    }

    private void fuehreKonkretenZugDesAktuellenSpielersAus() {

        zug = aktuellerSpieler.ziehen(spielbrett);
    }
    private boolean zugIstNichtGueltig() {

        if(isZugGueltig()) return false;
        write(ERROR_MESSAGE);
        return true;
    }

    private void schreibeSpielEndeNachrichtWennSpielZuEndeIst() {
        if(isSpielende())  write(String.format("Spieler %s hat verloren", aktuellerSpieler.getName()));

    }

    protected void write(String message) {
        writer.write(message);
    }

    protected void prepare() {
        // NOP
    }

    protected abstract boolean isSpielende();
    protected abstract  boolean isZugGueltig();

    protected  abstract void updateBoard();

}
