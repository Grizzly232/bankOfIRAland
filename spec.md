## PROGRAM SPEC

A bank account system. Clients and their personal information are stored on the system. A client is anyone who owns an account.
Clients are stored entirely just to store information on people who own accounts.
Bank accounts are an abstract class that savings account and current account inherit from.
Each bank account can be owned by a max of 3 people. The owners of an account is stored in an associative table.
Bank account owners are taken from the clients table. A client can have more than one bank account and a bank account 
can have more than one client
Each account has basic withdraw, deposit, change pin and delete methods.
