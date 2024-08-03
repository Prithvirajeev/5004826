DECLARE
    CURSOR c_accounts IS
        SELECT AccountID, Balance
        FROM Accounts;
    
    v_account_id Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
BEGIN
    OPEN c_accounts;
    LOOP
        FETCH c_accounts INTO v_account_id, v_balance;
        EXIT WHEN c_accounts%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - 50 -- Deduct annual fee
        WHERE AccountID = v_account_id;
    END LOOP;
    CLOSE c_accounts;
    COMMIT;
END;
/
