# employer-worker-registration-system
An accounting program that contains employee and employer information and records of relationships between them.

---

## Homepage
<p align="center"><strong>Overall Interface</strong></p>
<p align="center"><img src="https://github.com/AcoranGonzalezMoray/GUI_Java-AeroSpyne/blob/master/more/Modelo_1%20(1).png"></p>

| **Login**            | **User register**|  **Filter**
:------------------------:|:------------------------:|:-------------------------:
![2-login](https://github.com/AcoranGonzalezMoray/GUI_Java-AeroSpyne/blob/master/more/login.png) | ![3-new_employer](https://github.com/AcoranGonzalezMoray/GUI_Java-AeroSpyne/blob/master/more/signup.png)  |  ![3-new_worker](https://github.com/AcoranGonzalezMoray/GUI_Java-AeroSpyne/blob/master/more/filter.png)

---

<p align="center"><strong>User Interface</strong></p>
<p align="center"><img src="https://github.com/AcoranGonzalezMoray/GUI_Java-AeroSpyne/blob/master/more/Modelo_2%20(1).png"></p>


| **Booking**  | **Travel Insurance** | **Payment**
:----------------:|:-------------------------:|:-------------------------:
![5-view_worker](https://github.com/AcoranGonzalezMoray/GUI_Java-AeroSpyne/blob/master/more/reserva.png) | ![7-new_record_optionpane](https://github.com/AcoranGonzalezMoray/GUI_Java-AeroSpyne/blob/master/more/travel_insurance.png)| ![7-new_record_optionpane](https://github.com/AcoranGonzalezMoray/GUI_Java-AeroSpyne/blob/master/more/payment.png)

| **Booking History**  | **Modifications** | **Booking Details**
:----------------:|:-------------------------:|:-------------------------:
![5-view_worker](https://github.com/AcoranGonzalezMoray/GUI_Java-AeroSpyne/blob/master/more/myreservation.png) | ![7-new_record_optionpane](https://github.com/AcoranGonzalezMoray/GUI_Java-AeroSpyne/blob/master/more/reservation%20update.png)| ![7-new_record_optionpane](https://github.com/AcoranGonzalezMoray/GUI_Java-AeroSpyne/blob/master/more/reservation_info.png)

| **Booking History**  | **Modifications** | **Booking Details**
:----------------:|:-------------------------:|:-------------------------:
![5-view_worker](https://github.com/AcoranGonzalezMoray/GUI_Java-AeroSpyne/blob/master/more/complaint.png) | ![7-new_record_optionpane](https://github.com/AcoranGonzalezMoray/GUI_Java-AeroSpyne/blob/master/more/my_%20complaint.png)| ![7-new_record_optionpane](https://github.com/AcoranGonzalezMoray/GUI_Java-AeroSpyne/blob/master/more/my_insurance.png)

---


<p align="center"><strong>Admin Interface</strong></p>
<p align="center"><img src="https://github.com/AcoranGonzalezMoray/GUI_Java-AeroSpyne/blob/master/more/menu_admin.png"></p>

## Requirements
Postgresql is used in this program. You can find the necessary jar file for postgresql java connection here:

> https://jdbc.postgresql.org/download.html

Or you can use a different database but for this to work, change:
```
DriverManager.getConnection("jdbc:database://host:port/database-name", "user-name", "password");
```
for postgresql:
```
DriverManager.getConnection("jdbc:postgresql://localhost:5432/db", "postgres", "password");
```
---

**And finally, in order not to get a database error, you should add the following tables to the database:**
```
CREATE TABLE admin(id smallserial primary key not null, username varchar, password varchar);
CREATE TABLE employer(employer_id serial primary key not null, name varchar not null, surname varchar not null, business varchar, phonenumber varchar);
CREATE TABLE employer(employer_id serial primary key not null, name varchar not null, surname varchar not null, business varchar, phonenumber varchar);
CREATE TABLE worker(worker_id serial primary key not null, name varchar not null, surname varchar not null, phone_number varchar);
CREATE TABLE worker_record(worker_record_id serial primary key not null, worker_id integer references worker(worker_id), employer_id integer references employer(employer_id), date varchar(10) not null, wage smallint not null);
CREATE TABLE employer_record(employer_record_id serial primary key not null, employer_id integer references employer(employer_id), date varchar(10) not null, note varchar(255), number_worker smallint not null, wage smallint not null);
CREATE TABLE worker_payment(worker_payment_id serial primary key not null, worker_id integer references worker(worker_id), employer_id integer references employer(employer_id), date varchar(10), not null, paid integer not null);
CREATE TABLE employer_payment(employer_payment_id serial primary key not null, employer_id integer references employer(employer_id), date varchar(10) not null, paid integer not null);
```

