drop table BankAccount;
drop table CurrentAccount;
drop table SavingsAccount;
drop table Client;

create sequence clientid increment by 1 start with 1;

create table BankAccount(
    b_id number primary key check(bid>0 and id<1000),
    balance double 
    c_id number
    
);
create table CurrentAccount(
    ca_id number primary key,
    interestRate number,
    lastTransaction date,
    

);
create table SavingsAccount(
    sa_id number primary key,
    interestRate number, 
    monthlyTransactions number,
    lastTransaction date
);
create table Client(
    c_id number primary key check,
    c_fname varchar(255) not null,
    c_lname varchar(255) not null,
    c_address varchar(255)
);
create table ClientAcc(
    b_id number,
    c_id number,
    primary key(bid,cid),
    foreign key(bid) references BankAccount(b_id) on delete cascade,
    foreign key(cid) references Client(c_id) on delete cascade
);
