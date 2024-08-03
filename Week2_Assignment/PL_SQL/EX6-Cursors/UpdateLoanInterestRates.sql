DECLARE
    CURSOR c_loans IS
        SELECT LoanID, InterestRate
        FROM Loans;
    
    v_loan_id Loans.LoanID%TYPE;
    v_interest_rate Loans.InterestRate%TYPE;
BEGIN
    OPEN c_loans;
    LOOP
        FETCH c_loans INTO v_loan_id, v_interest_rate;
        EXIT WHEN c_loans%NOTFOUND;

        UPDATE Loans
        SET InterestRate = InterestRate + 0.5 -- Example adjustment
        WHERE LoanID = v_loan_id;
    END LOOP;
    CLOSE c_loans;
    COMMIT;
END;
/
