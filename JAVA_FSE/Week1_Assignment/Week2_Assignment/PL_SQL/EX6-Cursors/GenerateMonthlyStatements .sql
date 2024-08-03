DECLARE
    CURSOR c_transactions IS
        SELECT AccountID, TransactionDate, Amount, TransactionType
        FROM Transactions
        WHERE EXTRACT(MONTH FROM TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM TransactionDate) = EXTRACT(YEAR FROM SYSDATE);
    
    v_account_id Transactions.AccountID%TYPE;
    v_transaction_date Transactions.TransactionDate%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_transaction_type Transactions.TransactionType%TYPE;
BEGIN
    OPEN c_transactions;
    LOOP
        FETCH c_transactions INTO v_account_id, v_transaction_date, v_amount, v_transaction_type;
        EXIT WHEN c_transactions%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Statement for Account ' || v_account_id || ': Date: ' || v_transaction_date || ', Amount: ' || v_amount || ', Type: ' || v_transaction_type);
    END LOOP;
    CLOSE c_transactions;
END;
/
