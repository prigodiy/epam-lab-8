package epam.students.prihodii;

import epam.students.prihodii.cardTypes.Card;
import epam.students.prihodii.cardTypes.CardWithTimeLimit;
import epam.students.prihodii.cardTypes.CardWithTravelsLimit;
import epam.students.prihodii.types.OwnerCardType;
import epam.students.prihodii.types.TimeCardType;
import epam.students.prihodii.types.TravelsLeftCardType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

public class TurnstileTest {

    MainSystem mainSystem;
    Turnstile turnstile;
    Card validTimeLimitCard;
    Card invalidTimeLimitCardMock;
    Card validTravelsLeftCard;
    Card invalidTravelsLeftCardMock;
    Card validMoneyCard;
    Card invalidMoneyCard;

    @Before
    public void setUp() throws Exception {
        mainSystem = MainSystem.getInstance();
        turnstile = new Turnstile(mainSystem);

        validTimeLimitCard = mainSystem.createCard(OwnerCardType.STUDENT, TimeCardType.MONTH);
        invalidTimeLimitCardMock = mock(CardWithTimeLimit.class);
        when(((CardWithTimeLimit)invalidTimeLimitCardMock).getExpDate()).thenReturn(new Date(0));

        validTravelsLeftCard = mainSystem.createCard(OwnerCardType.SCHOOL, TravelsLeftCardType.FIVE);
        invalidTravelsLeftCardMock = mock(CardWithTravelsLimit.class);
        when(((CardWithTravelsLimit) invalidTravelsLeftCardMock).getTravelsLeft()).thenReturn(0);

        validMoneyCard = mainSystem.createCard(100);
        invalidMoneyCard = mainSystem.createCard(0);
    }

    @After
    public void tearDown() throws Exception {
        turnstile = null;
        mainSystem = null;
    }

    @Test
    public void testAcceptCard_nullCard_expectedFalse() throws Exception {
        assertFalse(turnstile.acceptCard(null));
    }

    @Test
    public void testAcceptCard_validTimeLimitCard_expectedTrue() throws Exception {
        assertTrue(turnstile.acceptCard(validTimeLimitCard));
    }

    @Test
    public void testAcceptCard_invalidTimeLimitCard_expectedFalse() throws Exception {
        assertFalse(turnstile.acceptCard(invalidTimeLimitCardMock));
    }

    @Test
    public void testAcceptCard_validTravelsLimitCard_expectedTrue() throws Exception {
        assertTrue(turnstile.acceptCard(validTravelsLeftCard));
    }

    @Test
    public void testAcceptCard_invalidTravelsLimitCard_expectedFalse() throws Exception {
        assertFalse(turnstile.acceptCard(invalidTravelsLeftCardMock));
    }

    @Test
    public void testAcceptCard_validMoneyLimitCard_expectedTrue() throws Exception {
        assertTrue(turnstile.acceptCard(validMoneyCard));
    }

    @Test
    public void testAcceptCard_invalidMoneyLimitCard_expectedFalse() throws Exception {
        assertFalse(turnstile.acceptCard(invalidMoneyCard));
    }
}
