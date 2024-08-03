DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, DOB, InterestRate
        FROM Loans
        JOIN Customers ON Loans.CustomerID = Customers.CustomerID;
    
    v_customer_id Loans.CustomerID%TYPE;
    v_dob Customers.DOB%TYPE;
    v_interest_rate Loans.InterestRate%TYPE;
BEGIN
    OPEN c_customers;
    LOOP
        FETCH c_customers INTO v_customer_id, v_dob, v_interest_rate;
        EXIT WHEN c_customers%NOTFOUND;

        IF (SYSDATE - v_dob) / 365 > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = v_customer_id;
        END IF;
    END LOOP;
    CLOSE c_customers;
    COMMIT;
END;
/
