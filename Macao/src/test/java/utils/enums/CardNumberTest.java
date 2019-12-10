package utils.enums;

import org.junit.jupiter.api.Test;
import utils.constants.CardsValues;

import static org.junit.jupiter.api.Assertions.*;

class CardNumberTest {

    @Test
    void stream() {
        assert CardNumber.stream().filter(cardColor -> cardColor instanceof CardNumber).toArray().length == CardNumber.values().length;
    }

    @Test
    void getValue() {
        int cardValue = CardsValues.ACE;
        CardNumber cardNumber = CardNumber.ACE;
        cardNumber.setValue(cardValue);
        assert cardValue == cardNumber.getValue();
    }

    @Test
    void setValue() {
        int cardValue = CardsValues.ACE;
        CardNumber cardNumber = CardNumber.ACE;
        cardNumber.setValue(cardValue);
        assert cardValue == cardNumber.getValue();
    }
}