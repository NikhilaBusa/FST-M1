package JUnitActivities;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Activity2Test {
    @Test
    public void notEnoughFunds()
    {
        BankAccount newBA = new BankAccount(10);
        assertThrows(NotEnoughFundsException.class, ()->newBA.withdraw(12));
    }
    @Test
    public void enoughFunds()
    {
        BankAccount newBA = new BankAccount(100);
        assertDoesNotThrow(()->newBA.withdraw(90));
    }
}
