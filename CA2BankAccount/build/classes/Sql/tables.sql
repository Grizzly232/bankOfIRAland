drop table BankAccount;
drop table CurrentAccount;
drop table SavingsAccount;
drop table Client;
drop table ClientAcc;

drop sequence clientid;
create sequence clientid increment by 1 start with 1;

drop table BankAccount;

create table BankAccount(
    bid
);

drop table CurrentAccount;

create table CurrentAccount(
    caid number(3) primary key,
    interestRate float(3),
    lastTransaction date;
);


create table SavingsAccount(
    said number primary key,
    interestRate number, 
    monthlyTransactions number,
    lastTransaction date
);

drop table Client;

create table Client (
    cid number primary key check (cid > 0 AND cid < 1000),
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

create table ClientAcc(
    bid number,
    cid number,
    primary key(bid,cid),
    foreign key(bid) references BankAccount(bid) on delete cascade,
    foreign key(cid) references Client(cid) on delete cascade
);