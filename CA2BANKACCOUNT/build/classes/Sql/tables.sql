drop table BankAccount;
drop table CurrentAccount;
drop table SavingsAccount;
drop table Client;
drop table ClientAcc;

drop sequence clientid;
create sequence clientid increment by 1 start with 1;

create table BankAccount(
    bid number primary key check(bid>0 and bid<1000),
    balance double 
    
    
);
create table CurrentAccount(
    caid number primary key,
    interestRate number,
    lastTransaction date,
    

);
create table SavingsAccount(
    said number primary key,
    interestRate number, 
    monthlyTransactions number,
    lastTransaction date
);
create table Client(
    cid number primary key check (cid > 0 AND cid < 1000),
    fname VARCHAR2(255) NOT NULL,
    lname VARCHAR2(255) NOT NULL,
    email VARCHAR2(255),
    address VARCHAR2(255) NOT NULL,
    age number NOT NULL
);
create table ClientAcc(
    bid number,
    cid number,
    primary key(bid,cid),
    foreign key(bid) references BankAccount(bid) on delete cascade,
    foreign key(cid) references Client(cid) on delete cascade
);