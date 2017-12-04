drop table BankAccount;
drop table CurrentAccount;
drop table SavingsAccount;
drop table Client;
drop table ClientAcc;

drop sequence clientid;
create sequence clientid increment by 1 start with 1;

drop table BankAccount;

create table BankAccount(
    bid NUMBER(3) PRIMARY KEY,
    pin NUMBER(4) NOT NULL,
    type VARCHAR2(255) NOT NULL,
    lastWithdrawal DATE,
    lastDeposit DATE,
    balance NUMBER(10) NOT NULL,
    interestRate NUMBER(3),
    monthlyTransactions NUMBER(2)
);

INSERT INTO BankAccount VALUES (001, 0451, 'Current', TO_DATE('17/12/2015', 'DD/MM/YYYY'), TO_DATE('17/12/2015', 'DD/MM/YYYY'), 25000.00, 0.2, null);
INSERT INTO BankAccount VALUES (002, 9999, 'Savings', TO_DATE('17/12/2015', 'DD/MM/YYYY'), TO_DATE('17/12/2015', 'DD/MM/YYYY'), 10.50, 0.05, 5);
INSERT INTO BankAccount VALUES (003, 0214, 'Current', TO_DATE('17/12/2015', 'DD/MM/YYYY'), TO_DATE('17/12/2015', 'DD/MM/YYYY'), 250.00, 0.2, null);
INSERT INTO BankAccount VALUES (004, 0101, 'Savings', TO_DATE('17/12/2015', 'DD/MM/YYYY'), TO_DATE('17/12/2015', 'DD/MM/YYYY'), 1200.50, 0.02, 3);

SELECT * FROM BankAccount;

drop table Client;

create table Client (
    cid number(3) PRIMARY KEY,
    fname VARCHAR2(255) NOT NULL,
    lname VARCHAR2(255) NOT NULL,
    email VARCHAR2(255),
    phone VARCHAR2(255),
    address VARCHAR2(255) NOT NULL,
    age VARCHAR2(3) NOT NULL
);

INSERT INTO Client VALUES (01, 'Spurdo', 'Komurdo', 'spurko@spudmail.net', 06919895, '25 P. Sherman', 20);
INSERT INTO Client VALUES (02, 'Putch', 'Downer', 'putchyboy01@putchmail.com', 0610594, '26 P. Sherman', 40);
INSERT INTO Client VALUES (03, 'Buck', 'Chumply', 'chuckbumply@gmail.com', 911, 'The Collective', 70);
SELECT CID, address, age, email, fname, lname, phone FROM Client

SELECT * FROM Client;

drop table ClientAcc;

create table ClientAcc(
    bid number,
    cid number,
    primary key(bid,cid),
    foreign key(bid) references BankAccount(bid) on delete cascade,
    foreign key(cid) references Client(cid) on delete cascade
);

select * from client;