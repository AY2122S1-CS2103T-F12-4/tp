---
layout: page
title: Zhang Zhiyao's Project Portfolio Page
---

### Introduction

This page serves to document my contributions to the project ezFoodie under NUS module CS2103T in AY21/22 semester 1.

### Project: ezFoodie

ezFoodie is a desktop application that helps restaurants **keep track of their ever-growing list of members**. 
Restaurant managers and staffs can easily view and update member status (e.g. personal information, tier, reservation, transaction, etc.) to manage and analyze members.
Restaurant managers and staffs interact with ezFoodie using a Command Line Interface (CLI), and has a Graphical User Interface (GUI) created with JavaFX.

It is written in Java, and has about 35 kLoC, of which I contributed about 10 kLoC.

Given below are my contributions to the project.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2122s1.github.io/tp-dashboard/?breakdown=true&search=holmesjj)

* **New Model**: Created the `Account` model to support implementing `login` and `logout` features as a manager. [\#74](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/74)
  * **What it does**: stores the `Account` information for the manager to `login`.
  * **Justification**: This model is essential, since some advanced features such as `delete` and `sort` are required the manager permission. It is a bridge between the staff and manager.
  * **Highlights**: This enhancement requires understanding on how `hash` works. The implementation was challenging as the `Account` information need to be hashed when it is storing in the file for the purpose of high security.

* **New Feature**: Added the ability to `login` as a manager [\#74](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/74)
  * **What it does**: allows the manager to `login` as a manager.
  * **Justification**: The staff and manager should not have the full permission to control the application. Some advanced features such as `delete` and `sort` should only be accessed by manager.

* **New Feature**: Added the ability to `logout` as a manager [\#72](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/72)
  * **What it does**: allows the manager to `logout` as a manager.
  * **Justification**: The manager should be able to `logout` the application to prevent the staff from operating the advanced features such as `delete` and `sort` that it should only be accessed by manager.

* **New Feature**: Added the ability to `edit` `Transaction` by `Transaction ID` [\#75](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/75), [\#112](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/112)
  * **What it does**: allows the staff and manager to `edit` `Transaction` by `Transaction ID`.
  * **Justification**: The staff and manager should be able to correct any accidental mistakes conveniently when he/she adds some incorrect `Transaction` records.
  * **Highlights**: This enhancement requires understanding on how polymorphism works and implement it so that the application will use Object-oriented programming (OOP) sufficiently. The implementation was challenging as the `EditCommand` need to be abstracted, and inherit `EditCommand` by `EditCommandPrefixParser`, and further inherit `EditCommandPrefixParser` by `EditTransactionCommand`. Similarly, the `EditCommandParser` also need to be abstracted, and inherit it with `EditTransactionCommandParser`.

* **New Feature**: Added the ability to `edit` `Reservation` by `Reservation ID` [\#114](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/114)
  * **What it does**: allows the staff and manager to `edit` `Reservation` by `Reservation ID`.
  * **Justification**: The staff and manager should be able to correct any accidental mistakes conveniently when he/she adds some incorrect `Reservation` records.
  * **Highlights**: This enhancement requires understanding on how polymorphism works and implement it so that the application will use Object-oriented programming (OOP) sufficiently. The implementation was challenging as the `EditCommand` need to be abstracted, and inherit `EditCommand` by `EditCommandPrefixParser`, and further inherit `EditCommandPrefixParser` by `EditReservationCommand`. Similarly, the `EditCommandParser` also need to be abstracted, and inherit it with `EditReservationCommandParser`.

* **New Feature**: Added the ability to `delete` `Member` by `Member ID` [\#77](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/77)
  * **What it does**: allows the manager to `delete` `Member` by `Member ID`.
  * **Justification**: This feature is essential, since the `Transaction` and `Reservation` is based on each member, it is necessary to use `Member ID` to identify the `Member` so that his/her `Transaction` and `Reservation` can be identified properly as well (Currently the application is using `Member ID` + `Transaction ID` to retrieve the `Transaction`, so is `Reservation`).

* **New Feature**: Added the ability to `delete` `Transaction` by `Transaction ID` [\#101](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/101)
  * **What it does**: allows the manager to `delete` `Transaction` by `Transaction ID`
  * **Justification**: This feature is essential, since each `Transaction` has its own `ID`, and the application is not able to list all the `Transactions`, it is impossible to `delete` `Transaction` by `Index`. Therefore, the `Transaction ID` is the only attribute to identify the `Transaction`.
  * **Highlights**: This enhancement requires understanding on how polymorphism works and implement it so that the application will use Object-oriented programming (OOP) sufficiently. The implementation was challenging as the `DeleteCommand` need to be abstracted, and inherit `DeleteCommand` by `DeleteCommandPrefixParser`, and further inherit `DeleteCommandPrefixParser` by `DeleteTransactionCommand`. Similarly, the `DeleteCommandParser` also need to be abstracted, and inherit it with `DeleteTransactionCommandParser`.

* **New Feature**: Added the ability to `sort` `Member` by `Credit` [\#79](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/79)
  * **What it does**: allows the manager to `sort` `Member` by `Credit`.
  * **Justification**: This feature improves the product significantly because the manager can formulate promotional strategies by analyzing the member data like how many credit the member has earned.
  * **Highlights**: This enhancement requires understanding on how `javafx.collections` package works. The implementation was challenging as it requires combining and synchronizing the object of the `FilteredList` and the `SortedList` so that data will not be messed up when the `find` or `sort` feature is called.

* **New Feature**: Added the ability to `retrieve` history commands [\#113](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/113)
  * **What it does**: allows the staff and manager to `retrieve` previous commands using up/down keys.
  * **Justification**: This feature improves the product significantly because the staff and manager can execute the similar commands much faster without retyping.

* **Enhancements to existing models**:
  * Updated the `AddressBook` to the `ezFoodie` [\#45](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/45)
  * Updated the `Person` model to the `Member` model [\#48](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/48)
  * Added the `ID` for the `Member` model so that the staff and manager can do operations based on the `Member ID` [\#51](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/51)
  * Added the `ID` for the `Transaction` model so that the staff and manager can do operations based on the `Transaction ID` [\#100](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/100)
  * Added the `Timestamp` for the `Member` model and `Transaction` model so that the application can record down the registration `Timestamp` of the `Member` and the payment `Timestamp` of the `Transaction` [\#59](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/59)
  * Added the `Credit` for the `Member` model so that the application can record down the `Credit` that the `Member` has earned. [\#79](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/79)
  * Added the `Tier` for the `Member` model so that the application can show the `Tier` of the `Member` based on his/her `Credit`. [\#81](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/81)

* **Enhancements to existing features**:
  * Updated the `add` feature so that it can supoort `add` member ID [\#55](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/55)
  * Updated the `list` feature so that it can supoort `list -mem` instead of `list` [\#78](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/78)
  * Updated the `find` feature so that it can supoort `find` `Member` by `Member ID`, `Name`, `Phone`, `Email` and `Registration Date` [\#64](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/64)

* **Project management**:
  * Maintained the [issues](https://github.com/AY2122S1-CS2103T-F12-4/tp/issues), [milestones](https://github.com/AY2122S1-CS2103T-F12-4/tp/milestones) and [projects](https://github.com/AY2122S1-CS2103T-F12-4/tp/projects)
  * Managed releases `v1.2.1`, `v1.3`, `v1.4` (3 [releases](https://github.com/AY2122S1-CS2103T-F12-4/tp/releases)) on GitHub

* **Documentation**:
  * index:
    * Fixed hyperlink bugs [\#89](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/89)
  * README:
    * Updated formats [\#42](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/42)
  * User Guide:
    * Added documentation for the features `find` and `sort` 
    [\#89](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/89)
    * Updated formats and fixed bugs 
    [\#40](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/40), 
    [\#41](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/41)
    * Updated formats for all commands [\#116](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/116)
  * Developer Guide:
    * Updated `Product scope`, `User stories`, `Use cases`, `Non-Functional Requirements`, `Glossary` 
    [\#24](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/24)
    * Added documentation for the features `find` and `sort` 
    [\#89](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/89)
  * About Us: 
    * Updated formats [\#43](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/43)

* **Community**:
  * PRs reviewed (with non-trivial review comments): 
  [\#46](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/46), 
  [\#52](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/52), 
  [\#56](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/56), 
  [\#69](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/69), 
  [\#71](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/71), 
  [\#102](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/102), 
  [\#103](https://github.com/AY2122S1-CS2103T-F12-4/tp/pull/103)
  * Contributed to forum discussions: 
  [\#12](https://github.com/nus-cs2103-AY2122S1/forum/issues/12), 
  [\#13](https://github.com/nus-cs2103-AY2122S1/forum/issues/13#issuecomment-899985208), 
  [\#24](https://github.com/nus-cs2103-AY2122S1/forum/issues/24#issuecomment-899953855), 
  [\#45](https://github.com/nus-cs2103-AY2122S1/forum/issues/45), 
  [\#50](https://github.com/nus-cs2103-AY2122S1/forum/issues/50), 
  [\#65](https://github.com/nus-cs2103-AY2122S1/forum/issues/65), 
  [\#109](https://github.com/nus-cs2103-AY2122S1/forum/issues/109#issuecomment-907304027), 
  [\#141](https://github.com/nus-cs2103-AY2122S1/forum/issues/141#issuecomment-910317016), 
  [\#160](https://github.com/nus-cs2103-AY2122S1/forum/issues/160#issuecomment-909923810), 
  [\#200](https://github.com/nus-cs2103-AY2122S1/forum/issues/200#issuecomment-914391124), 
  [\#203](https://github.com/nus-cs2103-AY2122S1/forum/issues/203#issuecomment-914375528), 
  [\#209](https://github.com/nus-cs2103-AY2122S1/forum/issues/209)
  * Reported bugs and suggestions for other teams in the class: 
  [\#1](https://github.com/holmesjj/ped/issues/1), 
  [\#2](https://github.com/holmesjj/ped/issues/2), 
  [\#3](https://github.com/holmesjj/ped/issues/3), 
  [\#4](https://github.com/holmesjj/ped/issues/4), 
  [\#5](https://github.com/holmesjj/ped/issues/5), 
  [\#6](https://github.com/holmesjj/ped/issues/6), 
  [\#7](https://github.com/holmesjj/ped/issues/7), 
  [\#8](https://github.com/holmesjj/ped/issues/8), 
  [\#9](https://github.com/holmesjj/ped/issues/9), 
  [\#10](https://github.com/holmesjj/ped/issues/10), 
  [\#11](https://github.com/holmesjj/ped/issues/11), 
  [\#12](https://github.com/holmesjj/ped/issues/12), 
  [\#13](https://github.com/holmesjj/ped/issues/13), 
  [\#14](https://github.com/holmesjj/ped/issues/14), 
  [\#15](https://github.com/holmesjj/ped/issues/15), 
  [\#16](https://github.com/holmesjj/ped/issues/16), 
  [\#17](https://github.com/holmesjj/ped/issues/17), 
  [\#18](https://github.com/holmesjj/ped/issues/18), 
  [\#19](https://github.com/holmesjj/ped/issues/19), 
  [\#20](https://github.com/holmesjj/ped/issues/20), 
  [\#21](https://github.com/holmesjj/ped/issues/21)
