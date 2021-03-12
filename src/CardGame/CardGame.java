package CardGame;
import javax.swing.*;
import java.util.*;

import static javax.swing.JComponent.setDefaultLocale;
import static javax.swing.JOptionPane.*;

/** ||==========================||
 *  || <Kind-of-ControllerKlass>||
 *  ||  ( Logik, programflöde)  ||
 *  ||==========================||*/
public class CardGame {
    private Player dealer;
    private Player player1;
    private Random rand;
    private int LIMIT = 21;
    private int MAX_VALUE = 12;
    private int dealerScore = 0;

/**||=====================||
 * ||     <Konstruktor>   ||
 * ||=====================||*/
    CardGame(){
        //Skapar medlemsobjekt, Create member objects
        this.dealer = dealer;
        this.player1 = player1;
        this.rand = rand;
        this.LIMIT = LIMIT;
        this.MAX_VALUE = MAX_VALUE;

        dealer = new Player("Dealer");
        player1 = new Player("Mr. Mapundo");
        rand = new Random();
    }


    public void startDealer() {
        dealer.reset();
        dealerScore = rand.nextInt(LIMIT) +1;
        dealer.setScore(dealerScore);
        if (dealerScore < 5) {
            this.dealerScore = dealerScore + 10;
        } else if (dealerScore < 10) {
            this.dealerScore = dealerScore + 6;
        }
    }
    public void startPlayer() {
        boolean done = false;
        String message = "";
        player1.reset();
        String strTitle = String.format("%s, welcome to this " +
                "special version of Black Jack!", player1.getName());
        if (JOptionPane.showConfirmDialog(null,
                "Start the game and draw a new card?", strTitle,
                JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
            done = true;
        } else {
            for (int i = 0; i < 30; i++) {
                int thisCard = rand.nextInt(MAX_VALUE) + 1;
                player1.addToScore(thisCard);
                player1.iAddToNumOfCards(1);
                message = String.format("New card: %s\nYour score: %s card, Sum: " +
                                "%s\nDealer's score: %s\nDraw a new card?", thisCard,
                        player1.getNumOfCards(), player1.getScore(), dealerScore);
                if (JOptionPane.showConfirmDialog(null, message,
                        strTitle, JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                    break;
                }
                if (player1.getScore() >= 21) {
                    break;
                }
            }
        }
    }
    public void startNewGame() {
        boolean done = false;

        do {
            startDealer();
            startPlayer();

            int playerScore = player1.getScore();
            int dealerScore = dealer.getScore();

            String message = "";

            if (playerScore > LIMIT)
                message = "You lost this game!!";
            else if (playerScore >= dealerScore)
                message = "You are a winner!!";

            message += "\nPlay again?";

            String strTitle = String.format("Game over for %s", player1.getName());
            if (JOptionPane.showConfirmDialog(null, message, strTitle, JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
                done = true;
        }
        while (!done);
    }
}





