package com.github.curriculeon.arcade;
import java.util.*;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class ArcadeAccountManager {
    List<ArcadeAccount> arcadeAccounts;

    public ArcadeAccountManager() {
        arcadeAccounts = new ArrayList<>();
    }
    /**
     * @param accountName name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public ArcadeAccount getAccount(String accountName, String accountPassword) {
        for(ArcadeAccount a: arcadeAccounts) {
            if(a.getAccountName().equals(accountName) && a.getAccountPassword().equals(accountPassword))
                return a;
        }
        return null;
    }

    /**
     * logs & creates a new `ArcadeAccount`
     * @param accountName name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public ArcadeAccount createAccount(String accountName, String accountPassword) {
        ArcadeAccount newAccount = new ArcadeAccount(accountName, accountPassword);
        return newAccount;
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     * @param arcadeAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(ArcadeAccount arcadeAccount) {
        arcadeAccounts.add(arcadeAccount);
    }

    public List<ArcadeAccount> getArcadeAccountList(){
        return arcadeAccounts;
    }
}
