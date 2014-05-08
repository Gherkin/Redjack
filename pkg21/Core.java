
package pkg21;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;


public final class Core extends JPanel implements ActionListener {
    public JButton buttonHold, buttonHit;
    JButton[] aceButtons;
    Images images;
    
    Deck cards;
    Deck dealerCards;
    Deck deck;
    
    Boolean hold;
    
    Timer timer;
    
    int wins, losses;
    public Core() {
        wins = 0;
        losses = 0;
        
        buttonHit = new JButton("Hit me!");
        buttonHold = new JButton("Hold");
        add(buttonHit);
        add(buttonHold);
        buttonHit.addActionListener(this);
        buttonHold.addActionListener(this);
        aceButtons = new JButton[4];
        
        images = new Images();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource("");
        System.out.println(url);
        
        startGame();
    }
    
    @Override    
    public void paintComponent(Graphics g) {
        int i;
        super.paintComponent(g);
        g.drawString("you: " + cards.getValue(), 1, 10);
        g.drawString("dealer: " + dealerCards.getValue(), 1, 20);
        g.drawString("wins: " + wins, 80, 10);
        g.drawString("losses: " + losses, 80, 20);
        for(i = 0; i < cards.size(); i++) {
            if(cards.getCard(i).getRank() == 0) {
            }
                
            g.drawImage(images.cards[cards.getCard(i).getSuit()][cards.getCard(i).getRank()], i*84, 35, this);
        }
        if(hold == false) {
            g.drawImage(images.background, 0, 213, this);
            i = 1;
        }
        else
            i = 0;
        for(; i < dealerCards.size(); i++) {
            g.drawImage(images.cards[dealerCards.getCard(i).getSuit()][dealerCards.getCard(i).getRank()], i*84, 213, this);
        }
    }
    
    public void update() {
        this.repaint();
        if(cards.getValue() > 21 || (dealerCards.getValue() < 22 && hold == true && dealerCards.getValue() > cards.getValue())) {
            JOptionPane.showMessageDialog(Main.frame, "Fuck you, you lost!");
            losses += 1;
            startGame();
        }
        else
            if(hold == true) {
                timer.cancel();
                JOptionPane.showMessageDialog(Main.frame, "Fuck you, you won!");
                wins += 1;
                startGame();
            }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonHit && hold == false) {
            cards.addCard(deck.returnCard(true));
        }
        if(e.getSource() == buttonHold) {
            dealersPlay();
            hold = true;
        }       
    }
    
    public void dealersPlay()  {
        TimerTask task;
        task = new TimerTask() {
            @Override
            public void run() {
                if(dealerCards.getValue() <22 || dealerCards.getValue() <= cards.getValue())
                    dealerCards.addCard(deck.returnCard(true));
            }
        };
        timer = new Timer();
        timer.schedule(task, 400, 400);
    }
    public void startGame() {
        hold = false;
        deck = new Deck(true, 52);
        dealerCards = new Deck(11);
        cards = new Deck(11);
        
        cards.addCard(deck.returnCard(true));
        cards.addCard(deck.returnCard(true));
        
        dealerCards.addCard(deck.returnCard(true));
        dealerCards.addCard(deck.returnCard(true));
        
    }
}
