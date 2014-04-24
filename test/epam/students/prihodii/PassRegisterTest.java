package epam.students.prihodii;

import epam.students.prihodii.cardTypes.Card;
import epam.students.prihodii.cardTypes.CardWithTimeLimit;
import epam.students.prihodii.cardTypes.CardWithTravelsLimit;
import epam.students.prihodii.types.OwnerCardType;
import epam.students.prihodii.types.TimeCardType;
import epam.students.prihodii.types.TravelsLeftCardType;
import org.junit.*;

import java.util.Date;
import java.util.List;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

public class PassRegisterTest {

    static MainSystem mainSystem;
    static Turnstile turnstile;
    static Card validTimeLimitCard;
    static Card validTimeLimitCardMock;
    static Card invalidTimeLimitCard;
    static Card invalidTimeLimitCardMock;
    static Card validTravelsLeftCard;
    static Card invalidTravelsLeftCard;
    static Card invalidTravelsLeftCardMock;
    static Card validMoneyCard;
    static Card invalidMoneyCard;

    static List<String> actual;
    static List<String> actualTimeCards;
    static List<String> actualTravelsLeftCards;
    static List<String> actualMoneyCards;

    @BeforeClass
    public static void setUp() throws Exception {
        mainSystem = MainSystem.getInstance();
        turnstile = new Turnstile(mainSystem);

        validTimeLimitCard = mainSystem.createCard(OwnerCardType.STUDENT, TimeCardType.TEN_DAYS);
        validTimeLimitCardMock = spy(validTimeLimitCard);
        when(((CardWithTimeLimit)validTimeLimitCardMock).getExpDate()).thenReturn(new Date(Long.MAX_VALUE));


        invalidTimeLimitCard = mainSystem.createCard(OwnerCardType.STUDENT, TimeCardType.MONTH);
        invalidTimeLimitCardMock = spy(invalidTimeLimitCard);
        when(((CardWithTimeLimit)invalidTimeLimitCardMock).getExpDate()).thenReturn(new Date(0));

        validTravelsLeftCard = mainSystem.createCard(OwnerCardType.SCHOOL, TravelsLeftCardType.TEN);
        invalidTravelsLeftCard = mainSystem.createCard(OwnerCardType.SCHOOL, TravelsLeftCardType.FIVE);
        invalidTravelsLeftCardMock = spy(invalidTravelsLeftCard);
        when(((CardWithTravelsLimit) invalidTravelsLeftCardMock).getTravelsLeft()).thenReturn(0);

        validMoneyCard = mainSystem.createCard(100);
        invalidMoneyCard = mainSystem.createCard(0);

        turnstile.acceptCard(validTimeLimitCardMock);
        turnstile.acceptCard(invalidTimeLimitCardMock);
        turnstile.acceptCard(validTravelsLeftCard);
        turnstile.acceptCard(invalidTravelsLeftCardMock);
        turnstile.acceptCard(validMoneyCard);
        turnstile.acceptCard(invalidMoneyCard);

        actual = mainSystem.getPassRegister().getFullRegister();
        actualMoneyCards = mainSystem.getPassRegister().getMoneyCardPassRegister();
        actualTimeCards = mainSystem.getPassRegister().getTimeLeftCardPassRegister();
        actualTravelsLeftCards = mainSystem.getPassRegister().getTravelsLeftCardPassRegister();
    }

    @Test
    public void testGetFullRegister_validTimeLimitCardRecord() throws Exception {
        assertEquals("CARD_ID: 0 CARD_OWNER: STUDENT EXP_DATE: " +
                ((CardWithTimeLimit)validTimeLimitCardMock).getExpDate()+ " PASS: true", actual.get(0));
    }

    @Test
    public void testGetFullRegister_invalidTimeLimitCardRecord() throws Exception {
        assertEquals("CARD_ID: 1 CARD_OWNER: STUDENT EXP_DATE: " +
                ((CardWithTimeLimit)invalidTimeLimitCardMock).getExpDate() + " PASS: false", actual.get(1));
    }

    @Test
    public void testGetFullRegister_validTravelsLeftCardRecord() throws Exception {
        assertEquals("CARD_ID: 2 CARD_OWNER: SCHOOL TRAVELS_LEFT: 9 PASS: true", actual.get(2));
    }

    @Test
    public void testGetFullRegister_invalidTravelsLeftCardRecord() throws Exception {
        assertEquals("CARD_ID: 3 CARD_OWNER: SCHOOL TRAVELS_LEFT: 0 PASS: false", actual.get(3));
    }

    @Test
    public void testGetFullRegister_validMoneyCardRecord() throws Exception {
        assertEquals("CARD_ID: 4 CARD_OWNER: ADULT BALANCE: 95 PASS: true", actual.get(4));
    }

    @Test
    public void testGetFullRegister_invalidMoneyCardRecord() throws Exception {
        assertEquals("CARD_ID: 5 CARD_OWNER: ADULT BALANCE: 0 PASS: false", actual.get(5));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetFullRegister_invalidIndex() throws Exception {
        actual.get(6);
    }

    @Test
    public void testGetMoneyCardPassRegister() throws Exception {
        assertEquals("CARD_ID: 4 CARD_OWNER: ADULT BALANCE: 95 PASS: true", actualMoneyCards.get(0));
        assertEquals("CARD_ID: 5 CARD_OWNER: ADULT BALANCE: 0 PASS: false", actualMoneyCards.get(1));
    }

    @Test
    public void testGetTravelsLeftCardPassRegister() throws Exception {
        assertEquals("CARD_ID: 2 CARD_OWNER: SCHOOL TRAVELS_LEFT: 9 PASS: true", actualTravelsLeftCards.get(0));
        assertEquals("CARD_ID: 3 CARD_OWNER: SCHOOL TRAVELS_LEFT: 0 PASS: false", actualTravelsLeftCards.get(1));
    }

    @Test
    public void testGetTimeLeftCardPassRegister() throws Exception {
        assertEquals("CARD_ID: 0 CARD_OWNER: STUDENT EXP_DATE: " +
                ((CardWithTimeLimit)validTimeLimitCardMock).getExpDate()+ " PASS: true", actualTimeCards.get(0));
        assertEquals("CARD_ID: 1 CARD_OWNER: STUDENT EXP_DATE: " +
                ((CardWithTimeLimit)invalidTimeLimitCardMock).getExpDate() + " PASS: false", actualTimeCards.get(1));
    }
}
