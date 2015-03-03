drop table cardpayment ;
create table CardPayment (paymentId bigint primary key  , paymentAmount bigint  , paymentCurrency varchar (30), payingAccountNumber varchar(30), transferringBankName varchar(30));
drop table cashpayment;
create table CashPayment(paymentId bigint primary key , paymentAmount bigint  , paymentCurrency varchar (30), payerName varchar(30));
drop table student;
create table Student(studentId bigint primary key , firstName varchar(30)  , lastName varchar(30));

drop table Node;
create table Node(Id bigint primary key);
drop table BinOpNode;
create table BinOpNode(Id bigint primary key, op varchar(5), leftNode_Id bigint, rightNode_Id bigint);
drop table IntegerConstantNode;
create table IntegerConstantNode(Id bigint primary key, value bigint);
drop table VariableNameNode;
create table VariableNameNode(Id bigint primary key, name varchar(30));
drop table VariableNode;
create table VariableNode(Id bigint primary key , name varchar(30));
