package oa.amazon.vo;

import java.util.Random;

public class PorkerDeck {
    private static final int NUM_IN_EACH_DECK = 13;
    Card[] cardDeck;
    PorkerDeck(){
        cardDeck = new Card[52];
        initDeck();
    }
    private void initDeck(){
        for (CardType type : CardType.values()){
            for (int i = 1; i <= NUM_IN_EACH_DECK; i++) {
                int index = (type.type - 1) * NUM_IN_EACH_DECK + i;
                cardDeck[index - 1] = new Card(type.type, i);
            }
        }
    }

    public void shuffle(){
        Random random = new Random();
        int max = NUM_IN_EACH_DECK * 4;
        int min = 1;
        for (int i = 0; i < max; i++) {
            int index = random.nextInt(52);
//            int index = random.nextInt(max - min + 1) + min;
            Card tmp = cardDeck[index];
            cardDeck[index] =  cardDeck[i];
            cardDeck[i] = tmp;
        }
    }

    //not using sort, swap O(n)
    public void unShaffle() {
        for (int i = 0; i < cardDeck.length; i++) {
            Card card = cardDeck[i];
            int index = getPosition(card);
            while (i != index) {
                swap(i, index);
                card = cardDeck[i];
                index = getPosition(card);
            }
        }
    }

    private void swap(int i, int index) {
        Card tmp = cardDeck[index];
        cardDeck[index] = cardDeck[i];
        cardDeck[i] = tmp;
    }

    private int getPosition(Card card) {
        return (card.type - 1) * 13 + card.number - 1;
    }

    public Card[] getCardDeck() {
        return cardDeck;
    }

    public static void main(String[] args) {
        PorkerDeck porkerDeck = new PorkerDeck();
        Card[] card = porkerDeck.getCardDeck();
        porkerDeck.shuffle();
        card = porkerDeck.getCardDeck();
        porkerDeck.unShaffle();
        card = porkerDeck.getCardDeck();
    }
}

enum CardType{
    HEART(1),
    CLUB(2),
    DIAMOND(3),
    SPADE(4);

    int type;
    CardType(){}
    CardType(int type){
        this.type = type;
    }
}

class Card{
    int type;
    int number;
    Card() {}
    Card(int type, int number) {
        this.type = type;
        this.number = number;
    }
}
