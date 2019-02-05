-- Create User MA_STUDENT
CREATE USER MA_STUDENT IDENTIFIED BY KOLOBOK DEFAULT TABLESPACE USERS;
ALTER USER MA_STUDENT QUOTA UNLIMITED ON USERS;

-- Grant section 1
GRANT CREATE SESSION TO MA_STUDENT;
GRANT CREATE TABLE TO MA_STUDENT;
GRANT CREATE PROCEDURE TO MA_STUDENT;
GRANT CREATE TRIGGER TO MA_STUDENT;
GRANT CREATE VIEW TO MA_STUDENT;
GRANT CREATE SEQUENCE TO MA_STUDENT;
GRANT CREATE VIEW TO MA_STUDENT;

-- Grant section 2
GRANT DELETE ANY TABLE TO MA_STUDENT;
GRANT DROP ANY TABLE TO MA_STUDENT;
GRANT DROP ANY PROCEDURE TO MA_STUDENT;
GRANT DROP ANY TRIGGER TO MA_STUDENT;
GRANT DROP ANY VIEW TO MA_STUDENT;
GRANT DROP ANY SEQUENCE TO MA_STUDENT;

-- Grant section 3
GRANT ALTER ANY SEQUENCE TO MA_STUDENT;
GRANT ALTER ANY TABLE TO MA_STUDENT;
GRANT ALTER ANY PROCEDURE TO MA_STUDENT;
GRANT ALTER ANY TRIGGER TO MA_STUDENT;

COMMIT WORK;
alter user ma_student account unlock;
