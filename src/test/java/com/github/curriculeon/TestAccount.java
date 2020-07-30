package com.github.curriculeon;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.ArcadeAccountManager;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestAccount {

    @Test
    public void test() {
        //given
        ArcadeAccountManager arcadeAccountManager = new ArcadeAccountManager();
        String username = "username";
        String password = "password";
        ArcadeAccount arcadeAccount = arcadeAccountManager.createAccount(username,password);

        //when
        arcadeAccountManager.registerAccount(arcadeAccount);
        ArcadeAccount getAccount = arcadeAccountManager.getAccount(username,password);

        //then
        assertNotEquals(getAccount, null);
        assertTrue(getAccount.getAccountName().equals(username));
        assertTrue(getAccount.getAccountPassword().equals(password));
    }
}
