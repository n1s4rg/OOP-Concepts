
SQL*Plus: Release 11.2.0.2.0 Production on Mon Nov 9 17:00:49 2021

Copyright (c) 1982, 2014, Oracle.  All rights reserved.

SQL> connect
Enter user-name: sys as sysdba
Enter password:

Connected.

SQL> create user facultydb identified by 123;

User created.

SQL> connect
Enter user-name: facultydb
Enter password:

ERROR:
ORA-01045: user FACULTYDB lacks CREATE SESSION privilege; logon denied

Warning: You are no longer connected to ORACLE.

SQL> connect
Enter user-name: sys as sysdba
Enter password:

Connected.

SQL> grant connect, resource to facultydb;

Grant succeeded.


SQL> grant all privileges to facultydb;

Grant succeeded.


SQL> connect
Enter user-name: facultydb
Enter password:

Connected.

SQL> create table Department( Dept_Number number(2), Dept_Name varchar2(50));

Table created.


SQL> desc Department
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 DEPT_NUMBER                                         NUMBER(2)
 DEPT_NAME                                           VARCHAR2(50)
 

SQL> create unique index IDX_Department_Dept_Number on Department(Dept_Number);

Index created.


SQL> alter table Department Add constraint CK_Department_DeptNumber CHECK(Dept_Number IS NOT NULL);

Table altered.


SQL> desc Department
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 DEPT_NUMBER                                         NUMBER(2)
 DEPT_NAME                                           VARCHAR2(50)

SQL> desc Department
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 DEPT_NUMBER                                         NUMBER(2)
 DEPT_NAME                                           VARCHAR2(50)

SQL> insert into department values(1, 'fashion');

1 row created.

SQL> insert into department values(1, 'Music');
insert into department values(1, 'Music')
*
ERROR at line 1:
ORA-00001: unique constraint (FACULTYDB.IDX_DEPARTMENT_DEPT_NUMBER) violated


SQL> insert into department values(2, 'Music');

1 row created.

SQL> select * from Department;

DEPT_NUMBER DEPT_NAME
---------- --------------------------------------------------
         1 fashion
         2 Music

SQL> commit;

Commit complete.

SQL>