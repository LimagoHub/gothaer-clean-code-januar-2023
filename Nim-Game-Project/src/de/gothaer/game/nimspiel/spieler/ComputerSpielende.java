package de.gothaer.game.nimspiel.spieler;

public class ComputerSpielende extends AbstractNimSpielende {

    private  static final String COMPUTER_MESSAGE = "Computer nimmt %s Steine";
    final int zuege[] = {3,1,1,2};
    public ComputerSpielende() {
    }

    public ComputerSpielende(final String name) {
        super(name);
    }


    @Override
    public Integer ziehen(final Integer steine) {




        final int zug = zuege[steine % 4];
        System.out.println(String.format(COMPUTER_MESSAGE,zug));
        return zug;
    }
}
