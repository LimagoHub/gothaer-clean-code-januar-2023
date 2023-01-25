package de.gothaer.game.nimspiel.spieler;

import java.util.Scanner;

public class MenschlicherSpielende extends AbstractNimSpielende {

    private static final String USER_PROMPT = "Es gibt %s Steine. Bitte nehmen Sie 1, 2 oder 3.";
    private Scanner scanner = new Scanner(System.in);

    public MenschlicherSpielende() {
    }

    public MenschlicherSpielende(String name) {
        super(name);
    }

    @Override
    public Integer ziehen(Integer steine) {
        System.out.println(String.format(USER_PROMPT, steine));
        return scanner.nextInt();
    }
}
