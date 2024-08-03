CREATE OR REPLACE FUNCTION CalculateAge(
    p_dob IN DATE
) RETURN NUMBER IS
BEGIN
    RETURN FLOOR((SYSDATE - p_dob) / 365);
END CalculateAge;
/
