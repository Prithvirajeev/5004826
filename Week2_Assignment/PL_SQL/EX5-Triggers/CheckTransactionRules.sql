CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
BEGIN
    IF :NEW.TransactionType = 'Withdrawal' THEN
        DECLARE
            v_balance Accounts.Balance%TYPE;
        BEGIN
            SELECT Balance INTO v_balance
            FROM Accounts
            WHERE AccountID = :NEW.AccountID;

            IF v_balance < :NEW.Amount THEN
                RAISE_APPLICATION_ERROR(-20002, 'Insufficient funds for withdrawal.');
            END IF;
        END;
    ELSIF :NEW.TransactionType = 'Deposit' AND :NEW.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20003, 'Deposit amount must be positive.');
    END IF;
END;
/
