---
layout: page
title: User Guide
---

<div align="center"><img height="200" alt="ezFoodie Logo" src="images/Logo.png"></div>

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Introduction

Welcome to ezFoodie’s User Guide! 🤩

Have you faced issues when managing the members of your restaurant? ezFoodie is here!

ezFoodie is a desktop application that helps restaurants **keep track of their ever-growing list of members**. Restaurant managers and staffs can easily view and update member status (e.g. personal information, tier, reservation, transaction, etc.) to manage and analyze members.

ezFoodie is simple and user-friendly. It is optimized for using via a **Command Line Interface (CLI)** while still enjoying the benefits of a Graphical User Interface (GUI). If you can type fast, ezFoodie can get your member management tasks done faster than traditional GUI applications.

Continue reading to explore the wonders of ezFoodie and enhance the way you manage and analyze your restaurant's members 🤩

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer from [here](https://www.oracle.com/java/technologies/downloads/).

2. Download the latest `ezFoodie.jar` from [here](https://github.com/AY2122S1-CS2103T-F12-4/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your ezFoodie.

4. Double-click the file to start the application. The GUI similar to the one shown below should appear in a few seconds. The application comes preloaded with sample data to test its features.<br>
   ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `login 123456` : Changes user permissions from staff permissions to manager permissions.

   * `logout` : Logout of manager and change permissions to staff permissions.

   * `list -mem/` : Lists all members.

   * `add -mem/ -n/ John Doe -p/ 98765432 -e/ johndoe@gmail.com -a/ 112 Amoy Street, 069907, Singapore` : Adds a contact named `John Doe` to the member list.

   * `del -mem/ -i/ 3` : Deletes the member with index number 3 shown in the current list.
     
      **NOTE**: Only managers can delete members. Login as a manager before entering the delete command.

   * `add -txn/ -id/ 10001 -b/ 200.00` : add transaction with a bill $100.00 to member ID 10001 shown in the current list.

   * `add -rs/ -dt/ 2021-01-02 00:00 -rm/ 2 people -id/ 10001` : add a reservation for 2 people for 2021-01-01 00:00 to member ID 10001 shown in the current list 

   * `redeem -rd/ 100 -id/ 10006` : redeem 100 points from member id 10006 shown in the current list.

   * `summary` : View a summary of all the data in the application in one page (**e.g.** No. of members, Past transactions).
     
      **NOTE**: Only managers are allowed to view the summary of data. Login as a manager before entering the summary command.
      
   * `clear` : Clears the program.

   * `exit` : Exits the program.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `find -mem -n <NAME>`, `NAME` is a parameter which can be used as `find -mem -n John Doe`.

* Items in square brackets are optional.<br>
  e.g `list -mem [-pg <PAGE>]` can be used as `list -mem -pg 1` or as `list -mem`.

* The `list` and `find` only show top 50 records by default. Pagination can be used `[-pg <PAGE>]` as optional value to choose different pages.

* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  **e.g.** if you specify `-p 12341234 -p 56785678`, only `-p 56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `exit` and `clear`) will be ignored.<br>
  **e.g.** if the command specifies `help 123`, it will be interpreted as `help`.

* Meanings of shortcuts:

    * `-id/`: member ID or transaction ID

    * `-i/`: index number of the member list

    * `-mem/`: member

    * `-n/`: name

    * `-p/`: phone no.

    * `-e/`: email ID

    * `-a/`: address

    * `-txn/`: transaction

    * `-rs/`: reservation

    * `-dt/`: dateTime

    * `-d/`: date
    
    * `-c/`: credit

    * `-b/`: bill amount
  
    * `-rm/`: remark

    * `-rd/`: redeem

    * `-pass/`: pass

    * `-tag/`: tag

    **ONLY USED IN SORT COMMAND**

    * `-a/`: ascending

    * `-d/`: descending

</div>

### 1. Viewing help : `help`

Opens a new window to show how to use the commands, and a link to the User Guide.

![help message](images/helpMessage.png)

Format: `help`

### 2. Exiting the program : `exit`

Exits the program.

Format: `exit`

### 3. Logging in as a manager : `login`

Logs in as a manager.

Format: `login <PASSWORD>`

*Default Manager Password is `123456`*

Example: `login 123456`

### 4. Logging out as a manager : `logout`

Logs out as a manager.

Format: `logout`

Example: `logout`

### 5. Listing out a certain number of members : `list -mem/`

Lists out a certain number of members.

Format: `list -mem/`

Example: `list -mem/`

### 6. Adding a member : `add -mem/`

Adds a new member to the member list.

Format: `add -mem/ -n/ <NAME> -p/ <PHONE> -e/ <EMAIL> -a/ <ADDRESS>`

Example: `add -mem/ -n/ John Doe -p/ 98765432 -e/ johndoe@gmail.com -a/ 112 Amoy Street, 069907, Singapore`

### 7. Deleting a member : `del -mem/`

Deletes a member from the member list

**NOTE**: Only managers are allowed to delete transactions. Login as manager before entering command.

#### 7.1. Delete by ID

Deletes a member using member id

Format: `del -mem/ -id/ <MEMBER_ID>`

Example: `del -mem/ -id/ 10001`

#### 7.2. Delete by index number

Deletes a member using member index number from the list

Format: `del -mem/ -i/ <MEMBER_INDEX>`

Example: `del -mem/ -i/ 1`

### 8. Finding members : `find -mem/`

Finds members by different fields which contain any of the given keywords, show top 50 records by default.

* The find is case-insensitive. e.g `hans` will match `Hans`
* Only full words will be matched e.g. `Han` will not match `Hans`

#### 8.1. Finding member by member ID

Format: `find -mem/ -id/ <MEMBER_ID>`

Example: `find -mem/ -id/ 10001`

#### 8.2. Finding members by name

Format: `find -mem/ -n/ <NAME>`

Example: `find -mem/ -n/ John Doe`

#### 8.3. Finding members by phone

Format: `find -mem/ -p/ <PHONE>`

Example: `find -mem/ -p/ 98765432`

#### 8.4. Finding members by email

Format: `find -mem/ -e/ <EMAIL>`

Example: `find -mem/ -e/ johndoe@gmail.com`

#### 8.5. Finding members by registration date

Format: `find -mem/ -d/ <REGISTRATION_DATE yyyy-MM-dd>`

Example: `find -mem/ -d/ 2021-01-02`

### 9. Viewing member profile : `show -mem/`

Views member from member list by member ID.

Format: `show -mem/ -id/ <MEMBER_ID>`

Example: `show -mem/ -id/ 10001`

### 10. Editing a member : `edit -mem/`

Edits different fields in a member's profile, where the member is specified by member ID.

#### 10.1. Editing member name by member ID

Format: `edit -mem/ -id/ <MEMBER_ID> -n/ <NAME>`

Example: `edit -mem/ -id/ 10001 -n/ John Doe`

#### 10.2. Editing member phone by member ID

Format: `edit -mem/ -id/ <MEMBER_ID> -p/ <PHONE>`

Example: `edit -mem/ -id/ 10001 -p/ 98765432`

#### 10.3. Editing member email by member ID

Format: `edit -mem/ -id/ <MEMBER_ID> -e/ <EMAIL>`

Example: `edit -mem/ -id/ 10001 -e/ johndoe@gmail.com`

#### 10.4. Editing member address by member ID

Format: `edit -mem/ -id/ <MEMBER_ID> -a/ <ADDRESS>`

Example: `edit -mem/ -id/ 10001 -a/ 33 Benoi Crescent, 629979, Singapore`

#### 10.5. Editing member name by index number

Format: `edit -mem/ -i/ <INDEX> -n/ <NAME>`

Example: `edit -mem/ -i/ 1 -n/ John Doe`

#### 10.6. Editing member phone by index number

Format: `edit -mem/ -i/ <INDEX> -p/ <PHONE>`

Example: `edit -mem/ -i/ 1 -p/ 98765432`

#### 10.7. Editing member email by index number

Format: `edit -mem/ -i/ <INDEX> -e/ <EMAIL>`

Example: `edit -mem/ -i/ 1 -e/ johndoe@gmail.com`

#### 10.8. Editing member address by index number

Format: `edit -mem/ -i/ <INDEX> -a/ <ADDRESS>`

Example: `edit -mem/ -i/ 1 -a/ 33 Benoi Crescent, 629979, Singapore`

### 11. Adding transaction for members : `add -txn/`

Adds transaction amount corresponding to member ID.

Format: `add -txn/ -id/ <MEMBER_ID> -b/ <BILLING>`

Example: `add -txn/ -id/ 10001 -b/ 200.00`

### 12. Deleting transaction for members: `del -txn/`

Delete a transaction

**NOTE**: Only managers are allowed to delete transactions. Login as manager before entering command.

Format: `del -txn/ -id/ <MEMBER_ID + TRANSACTION_ID>`

Example: `del -txn/ -id/ 10001100001`

### 13. Editing transaction of a member: `edit -txn/`

Edit a members transaction

Format: `edit -txn/ -id/ <MEMBER_ID + TRANSACTION_ID> -b/ <BILL_AMMOUNT>`

Example: `edit -txn/ -id/ 10001100002 -b/ 10.00`

### 14. Adding a reservation: `add -rs/`

Add a reservation to a member

Format: `add -rs/ -dt/ <DATE_TIME yyyy-MM-dd HH:mm> -rm/ <REMARK> -id/ <MEMBER_ID>`

Example: `add -rs/ -dt/ 2021-01-02 00:00 -rm/ 2 people -id/ 10001`

### 15. Deleting a reservation: `del -rs/`

Deletes a reservation from a members reservation list

**NOTE**: Only managers are allowed to delete reservations. Login as manager before entering command.

Format: `del -rs/ -id/ <MEMBER_ID + RESERVATION_ID>`

Example: `del -rs/ -id/ 10001100001`

### 16. Editing a reservation: `edit -rs/`

Edit a members reservation details

Format: `edit -rs/ -id/ <MEMBER_ID + RESERVATION_ID> [-dt/ <DATE_TIME>][-rm/ <REMARK>]`

Example: `edit -rs/ -id/ 10001100001 -dt/ 2021-12-01 13:00 -rm/ 3 people`

### 17. Sorting members by credit : `sort -mem/`

#### 17.1. Sorting member by credit in ascending order

Format: `sort -mem/ -c/ -a/`

Example: `sort -mem/ -c/ -a/`

#### 17.2. Sorting member by credit in descending order

Format: `sort -mem/ -c/ -d/`

Example: `sort -mem/ -c/ -d/`

### 18. Redeeming point `redeem -f/`

#### 18.1. Redeeming point from a member: `redeem -f/ -id/`
Redeems point from a member by id.

Format: `redeem -rd/ <POINTS> -id/ <MEMBER_ID>`

Example: `redeem -rd/ 100 -id/ 10006`

#### 18.2. Redeeming point from a member by an index: `redeem -f/ -i/`

Redeems point from a member by an index.

Format: `redeem -rd/ <point> -i/ <INDEX>`

Example: `redeem -rd/ 100 -i/ 1`

### 19. Summary: `summary`

View a summary of all the data in the application

**NOTE**: Only managers are allowed to view summary. Login as manager before entering command.

Format: `summary`

### 20. Clearing the program : `clear`

Clears the program.

Format: `clear`

### 21. Saving the data

ezFoodie data are saved in the hard disk by JSON automatically after any command that changes the data. There is no need to save manually.

### 22. Editing the data file

ezFoodie data are saved as a JSON file `[JAR file location]/data/ezFoodie.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, ezFoodie will discard all data and start with an empty data file at the next run.
</div>

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the application in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous ezFoodie home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**View Help** | `help`
**Exit Program** | `exit`
**Login as Manager** | *Format* <br> `login <PASSWORD>` <br> *Example* <br> `login 123456`
**Logout as Manager** | `logout`
**List Members** | *Format* <br> `list -mem/` <br> *Example* <br> `list -mem/`
**Add New Member** | *Format* <br> `add -mem/ -n/ <NAME> -p/ <PHONE> -e/ <EMAIL> -a/ <ADDRESS>` <br> *Example* <br> `add -mem/ -n/ John Doe -p/ 98765432 -e/ johndoe@gmail.com -a/ 112 Amoy Street, 069907, Singapore`
**Delete Member by Member ID** | *Format* <br> `del -mem/ -id/ <MEMBER_ID>` <br> *Example* <br> `del -mem/ -id/ 10001` <br> **NOTE**: Only managers are allowed to delete members. Login as manager before entering command.
**Delete Member by Index Number** | *Format* <br> `del -mem/ -i/ <MEMBER_INDEX>` <br> *Example* <br> `del -mem/ -i/ 1` <br> **NOTE**: Only managers are allowed to delete members. Login as manager before entering command.
**Find Member by Member ID** | *Format* <br> `find -mem/ -id/ <MEMBER_ID>` <br> *Example* <br> `find -mem/ -id/ 10001`
**Find Members by Name** | *Format* <br> `find -mem/ -n/ <NAME>` <br> *Example* <br> `find -mem/ -n/ John Doe`
**Find Members by Phone** | *Format* <br> `find -mem/ -p/ <PHONE>` <br> *Example* <br> `find -mem/ -p/ 98765432`
**Find Members by Email** | *Format* <br> `find -mem/ -e/ <EMAIL>` <br> *Example* <br> `find -mem/ -e/ johndoe@gmail.com`
**Find Members by Registration Date** | *Format* <br> `find -mem/ -d/ <REGISTRATION_DATE yyyy-MM-dd>` <br> *Example* <br> `find -mem/ -d/ 2021-01-02`
**View Member Profile** | *Format* <br> `show -mem/ -id/ <MEMBER_ID>` <br> *Example* <br> `show -mem/ -id/ 10001`
**Edit Member Name by Member ID** | *Format* <br> `edit -mem/ -id/ <MEMBER_ID> -n/ <NAME>` <br> *Example* <br> `edit -mem/ -id/ 10001 -n/ John Doe`
**Edit Member Phone by Member ID** | *Format* <br> `edit -mem/ -id/ <MEMBER_ID> -p/ <PHONE>` <br> *Example* <br> `edit -mem/ -id/ 10001 -p/ 98765432`
**Edit Member Email by Member ID** | *Format* <br> `edit -mem/ -id/ <MEMBER_ID> -e/ <EMAIL>` <br> *Example* <br> `edit -mem/ -id/ 10001 -e/ johndoe@gmail.com`
**Edit Member Address by Member ID** | *Format* <br> `edit -mem/ -id/ <MEMBER_ID> -a/ <ADDRESS>` <br> *Example* <br> `edit -mem/ -id/ 10001 -a/ 33 Benoi Crescent, 629979, Singapore`
**Edit Member Name by Index Number** | *Format* <br> `edit -mem/ -i/ <INDEX> -n/ <NAME>` <br> *Example* <br> `edit -mem/ -i/ 1 -n/ John Doe`
**Edit Member Phone by Index Number** | *Format* <br> `edit -mem/ -i/ <INDEX> -p/ <PHONE>` <br> *Example* <br> `edit -mem/ -i/ 1 -p/ 98765432`
**Edit Member Email by Index Number** | *Format* <br> `edit -mem/ -i/ <INDEX> -e/ <EMAIL>` <br> *Example* <br> `edit -mem/ -i/ 1 -e/ johndoe@gmail.com`
**Edit Member Address by Index Number** | *Format* <br> `edit -mem/ -i/ <INDEX> -a/ <ADDRESS>` <br> *Example* <br> `edit -mem/ -i/ 1 -a/ 33 Benoi Crescent, 629979, Singapore`
**Add Transaction for Member** | *Format* <br> `add -txn/ -id/ <MEMBER_ID> -b/ <BILLING>` <br> *Example* <br> `add -txn/ -id/ 10001 -b/ 200.00`
**Delete Transaction for Member** | *Format* <br> `del -txn/ -id/ <MEMBER_ID + TRANSACTION_ID>` <br> *Example* <br> `del -txn/ -id/ 10001100001` <br> **NOTE**: Only managers are allowed to delete transactions. Login as manager before entering command.
**Edit Transaction** | *Format* <br> `edit -txn/ -id/ <MEMBER_ID + TRANSACTION_ID> -b/ <BILL_AMMOUNT>` <br> *Example* <br> `edit -txn/ -id/ 10001100002 -b/ 10.00`
**Add Reservation** | *Format* <br> `add -rs/ -dt/ <DATE_TIME yyyy-MM-dd HH:mm> -rm/ <REMARK> -id/ <MEMBER_ID>` <br> *Example* <br> `add -rs/ -dt/ 2021-01-02 00:00 -rm/ 2 people -id/ 10001`
**Delete Reservation** | *Format* <br> `del -rs/ -id/ <MEMBER_ID + RESERVATION_ID>` <br> *Example* <br> `del -rs/ -id/ 10001100001` <br> **NOTE**: Only managers are allowed to delete reservations. Login as manager before entering command.
**Edit Reservation** | *Format* <br> `edit -rs/ -id/ <MEMBER_ID + RESERVATION_ID> [-dt/ <DATE_TIME>][-rm/ <REMARK>]` <br> *Example* <br> `edit -rs/ -id/ 10001100001 -dt/ 2021-12-01 13:00 -rm/ 3 people`
**Sort Members by Credit in Ascending Order** | *Format* <br> `sort -mem/ -c/ -a/` <br> *Example* <br> `sort -mem/ -c/ -a/`
**Sort Members by Credit in Descending Order** | *Format* <br> `sort -mem/ -c/ -d/` <br> *Example* <br> `sort -mem/ -c/ -d/`
**Redeem Point from Member by Member Id** | *Format* <br> `redeem -rd/ <POINTS> -id/ <MEMBER_ID>` <br> *Example* <br> `redeem -rd/ 100 -id/ 10006`
**Redeem Point from Member by Member Index** | *Format* <br> `redeem -rd/ <point> -i/ <INDEX>` <br> *Example* <br> `redeem -rd/ 100 -i/ 1`
**Summary** | *Format* <br> `summary` <br> **NOTE**: Only managers are allowed to view summary. Login as manager before entering command.
**Clear Program** | `clear`
