package utils.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardSymbolTest {

    @Test
    void stream() {
        assert CardSymbol.stream().filter(cardColor -> cardColor instanceof CardSymbol).toArray().length == CardSymbol.values().length;
    }

    @Test
    void getColor() {
        CardSymbol cardSymbol = CardSymbol.CLUBS;
        cardSymbol.setColor(CardColor.RED);
        assert cardSymbol.getColor().equals(CardColor.RED);
    }

    @Test
    void setColor() {
        CardSymbol cardSymbol = CardSymbol.CLUBS;
        cardSymbol.setColor(CardColor.BLACK);
        assert cardSymbol.getColor().equals(CardColor.BLACK);
    }
}