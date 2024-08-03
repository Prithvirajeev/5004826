CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01) -- 1% interest rate
    WHERE AccountType = 'Savings';

    COMMIT;
END ProcessMonthlyInterest;
/
