REM   Script: Activity4
REM   Activity4

create table Salesman(salesman_ID int not null, salesman_name varchar2(20), salesman_city varchar2(20), commission int);
insert all 
into salesman values (5001,'James Hoog','New York',15) 
into salesman values (5002,'Nail Knite','Paris',13) 
into salesman values (5005,'Pit Alex','London',11) 
into salesman values (5006,'McLyon','Paris',14) 
into salesman values (5007,'Paul Adam','Rome',13) 
into salesman values (5003,'Lauson Hen','San Jose',12) 
select 1 from DUAL;

alter table salesman add grade int

update salesman set grade = 100

select * from salesman



