drop table BankAccount;
drop table CurrentAccount;
drop table SavingsAccount;
drop table Client;
drop table ClientAcc;

drop sequence clientid;
create sequence clientid increment by 1 start with 1;
create table BankAccount(
    bid number primary key,
    balance number
    
);
create table SafetyDeposit(
    boxid number(10) primary key,
    itemDescription varchar2(255),
    quantity number(10),
    branchid number(10),
    foreign key(branchid) references Branch(branchid)
);
create table Branch(
    branchid number(10) primary key,
    branchAddress varchar2(255)
);
create table Client(
    clientid number(4) primary key,
    cfname varchar(255) not null,
    clname varchar(255) not null,
    caddress varchar(255)
);
create table ClientAcc(
    bid number,
    cid number,
    primary key(bid,cid),
    foreign key(bid) references BankAccount(bid) on delete cascade,
    foreign key(cid) references Client(cid) on delete cascade
);

insert into Client values(clientid.nextval,'John', 'Brown', 'Carrick');
insert into Client values(clientid.nextval, 'Jeff', 'Black', 'shup');

select * from client;