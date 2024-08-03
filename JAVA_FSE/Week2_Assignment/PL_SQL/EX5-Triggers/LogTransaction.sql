CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (TransactionID, ChangeDate, ChangeType)
    VALUES (:NEW.TransactionID, SYSDATE, 'INSERT');
END;
/
