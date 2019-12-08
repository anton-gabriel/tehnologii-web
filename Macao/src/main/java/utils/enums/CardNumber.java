package utils.enums;

import utils.constants.CardsValues;

import java.util.stream.Stream;

/**
 * The enum Card number.
 */
public enum CardNumber {
    /**
     * Ace card number.
     */
    ACE(CardsValues.ACE),
    /**
     * Two card number.
     */
    TWO(CardsValues.TWO),
    /**
     * Three card number.
     */
    THREE(CardsValues.THREE),
    /**
     * Four card number.
     */
    FOUR(CardsValues.FOUR),
    /**
     * Five card number.
     */
    FIVE(CardsValues.FIVE),
    /**
     * Six card number.
     */
    SIX(CardsValues.SIX),
    /**
     * Seven card number.
     */
    SEVEN(CardsValues.SEVEN),
    /**
     * Eight card number.
     */
    EIGHT(CardsValues.EIGHT),
    /**
     * Nine card number.
     */
    NINE(CardsValues.NINE),
    /**
     * Ten card number.
     */
    TEN(CardsValues.TEN),
    /**
     * Jack card number.
     */
    JACK(CardsValues.JACK),
    /**
     * Queen card number.
     */
    QUEEN(CardsValues.QUEEN),
    /**
     * King card number.
     */
    KING(CardsValues.KING);

    private int value;

    CardNumber(int value) {
        this.value = value;
    }

    /**
     * Stream stream.
     *
     * @return the stream
     */
    public static Stream<CardNumber> stream() {
        return Stream.of(CardNumber.values());
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(int value) {
        this.value = value;
    }

}
