package epam.students.prihodii;

import epam.students.prihodii.cardTypes.Card;
import epam.students.prihodii.cardTypes.CardWithTimeLimit;
import epam.students.prihodii.cardTypes.CardWithTravelsLimit;
import epam.students.prihodii.types.OwnerCardType;
import epam.students.prihodii.types.TimeCardType;
import epam.students.prihodii.types.TravelsLeftCardType;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

public class PassRegisterTest {

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

        turnstile.acceptCard(validTimeLimitCard);
        turnstile.acceptCard(invalidTimeLimitCardMock);
        turnstile.acceptCard(validTravelsLeftCard);
        turnstile.acceptCard(invalidTravelsLeftCardMock);
        turnstile.acceptCard(validMoneyCard);
        turnstile.acceptCard(invalidMoneyCard);
    }

    @Test
    public void testGetFullRegister() throws Exception {
        List<String> actual = mainSystem.getPassRegister().getFullRegister();
        assertEquals("CARD_ID: 0 CARD_OWNER: STUDENT EXP_DATE: " +
                ((CardWithTimeLimit)validTimeLimitCard).getExpDate() + " PASS: true", actual.get(0));
    }

    @Test
    public void testGetMoneyCardPassRegister() throws Exception {

    }

    @Test
    public void testGetTravelsLeftCardPassRegister() throws Exception {

    }

    @Test
    public void testGetTimeLeftCardPassRegister() throws Exception {

    }
}
