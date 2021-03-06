# README

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/84668d10e2c741e387d0509ea629472e)](https://app.codacy.com/manual/korrobka15/employee-portal?utm_source=github.com&utm_medium=referral&utm_content=anastaklo/employee-portal&utm_campaign=Badge_Grade_Dashboard)

This is a web application for employees. It allows users to view some information about their colleagues, to work with their calendars, manage their vacations, send newsletters \(i.e. e-mailing about new colleagues, birthday reminders\).

`[insert here a gif with some usage]`

For more detailed information see [Employee portal documentation](https://anastaklo.gitbook.io/employee-portal/)

## Installation guide

`[add docker installation guide]`

## Architecture

It's an example of hexagonal style architecture.

`[add sequence diagrams]`

## **TODO**

1. Sick list processing
2. A calendar event “Absence without a reason”. There should be a kind of warning for employee's manager.
3. JIRA - working hours tracking \(JTT\)
4. Calendar hierarchy: country specific calendar \(for holiday event\) + employee calendar; add permission for adding country holiday event
5. Think up request types besides vacation request \(i.e. “position change”, “dismiss employee”, “business trip”\). Don’t forget to add permissions for these actions
6. Add employees’ documents \(passports, diplomas, sick lists, etc.\)
7. Expandable office map with precise location in personal tab
8. Add employee’s position history
9. Add user photo preview to Search page
10. Add possibility to edit approved vacation
11. Validation for vacation \(length, division by working/non-working days, 2-week vacation, deadlines for vacation in year\)

## Contributors

![](documentation/.gitbook/assets/ak.png)

Anastasiia Klochkova - architecture design, backend dev, devops, documentation

