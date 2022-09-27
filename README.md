# AeroSpyne Flight Management-Reservation System

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
This project uses file-based persistence, here I show you the base data for a better understanding:

```
Location: GUI_Java-AeroSpyne/AeroSpyne.text
```

For management how to administer use the following credentials:
```
Email: Admin
Password: Admin
```
AeroSpyne.text:
```
3 , Manuel , Garcia , manuelgracia@gmail.com , 12345678 , 23456723T , 698789345 , Samuel , Perez , a , a , 32476767A , 645234547 , Admin , Admim , Admin , Admin , Admin , Admin-645234547 , 
15 , Gran Canaria , Fuerteventura , 06 , 01 , 2022 , 07 , 00 , 06 , 01 , 2022 , 07 , 40 , 40 , 12.0 , 34562789 , Tenerife , Fuerteventura , 06 , 01 , 2022 , 07 , 00 , 06 , 01 , 2022 , 07 , 40 , 40 , 12.0 , 34262789 , Gran Canaria , Lanzarote , 08 , 01 , 2022 , 08 , 00 , 08 , 01 , 2022 , 09 , 00 , 60 , 13.0 , 323671008 , Gran Canaria , Madrid , 10 , 01 , 2022 , 07 , 30 , 10 , 01 , 2022 , 10 , 00 , 150 , 23.0 , 38828339 , París , Londres , 09 , 01 , 2022 , 07 , 00 , 09 , 01 , 2022 , 10 , 00 , 180 , 25.0 , 554476839 , Londres , París , 09 , 01 , 2022 , 22 , 00 , 10 , 01 , 2022 , 01 , 00 , 180 , 25.0 , 667344789 , Berlín , Múnich , 11 , 01 , 2022 , 12 , 00 , 11 , 01 , 2022 , 13 , 07 , 67 , 18.0 , 987654321 , Madrid , Barcelona , 11 , 01 , 2022 , 16 , 00 , 11 , 01 , 2022 , 17 , 20 , 80 , 25.0 , 674537591 , Barcelona , Madrid , 18 , 01 , 2022 , 08 , 00 , 18 , 01 , 2022 , 09 , 20 , 80 , 25.0 , 333222555 , Manchester , París , 14 , 01 , 2022 , 06 , 00 , 14 , 01 , 2022 , 08 , 00 , 120 , 28.0 , 112233344 , Londres ,  Manchester  , 13 , 01 , 2022 , 10 , 00 , 13 , 01 , 2022 , 11 , 10 , 70 , 16.0 , 887766445 , Barcelona , Oslo  , 21 , 01 , 2022 , 09 , 00 , 21 , 01 , 2022 , 12 , 30 , 210 , 40.0 , 112344865 , Lisboa , Bilbao  , 20 , 01 , 2022 , 17 , 00 , 20 , 01 , 2022 , 19 , 00 , 120 , 30.0 , 764184904 , Lanzarote , Sevilla  , 25 , 01 , 2022 , 14 , 00 , 25 , 01 , 2022 , 16 , 00 , 120 , 18.0 , 223456577 , Roma , Estambul  , 19 , 01 , 2022 , 19 , 00 , 19 , 01 , 2022 , 21 , 35 , 155 , 29.0 , 148469526 , 
1 , Work , Done! , 15 , 09 , 2022 , 15 , 32 , 23456723T , 7297 , 
4 , 0 , TotalTravel pack mini ,  ,  , 06 , 01 , 2022 , 07 , 00 , 06 , 01 , 2022 , 07 , 40 , 1 , Medical and health care: Up to € 300,000 
 Repatriation or medical transport of the wounded or sick: Unlimited 
 Repatriation or medical transport of companions: Unlimited (1 companion)  
 Early return due to hospitalization or death of a family member: Unlimited 
 Extension of stay in hotel by medical prescription: Up to € 750 
 Material losses: Up to € 1.500 
 Travel cancellation expenses (optional): Up to € 2.500 
 Loss of contracted services: X 
 Transportation accidents: Up to € 3.000 , 65743653 , Admin , 0 , TotalTravel medium pack  ,  ,  , 06 , 01 , 2022 , 07 , 00 , 06 , 01 , 2022 , 07 , 40 , 1 , Medical and health care: Up to € 1.000.000 
 Repatriation or medical transport of the wounded or sick: Unlimited 
 Repatriation or medical transport of companions: Unlimited (2 companions) 
 Early return due to hospitalization or death of a family member: Unlimited 
 Extension of stay in hotel by medical prescription: Up to € 1.200 
 Material losses: Up to € 2.500 
 Travel cancellation expenses (optional): Up to € 5.000 
 Loss of contracted services: € 300 
 Transportation accidents: Up to € 35.000 , 65743654 , Admin , 0 , TotalTravel premium pack  ,  ,  , 08 , 01 , 2022 , 08 , 00 , 08 , 01 , 2022 , 09 , 00 , 1 , Medical and health care: Up to € 1.500.000 
 Repatriation or medical transport of the wounded or sick: Unlimited
 Repatriation or medical transport of companions: Unlimited (2 companions)
 Early return due to hospitalization or death of a family member: Unlimited
 Extension of stay in hotel by medical prescription: Up to € 1.500 
 Material losses: Up to € 3.200 
 Travel cancellation expenses (optional): Up to € 6.000 
 Loss of contracted services: € 300 
 Transportation accidents: Up to € 50.000 , 65743655 , Admin , 1 , TotalTravel medium pack  , Gran Canaria , Fuerteventura , 06 , 01 , 2022 , 07 , 00 , 06 , 01 , 2022 , 07 , 40 , 2 , Medical and health care: Up to € 1.000.000 
 Repatriation or medical transport of the wounded or sick: Unlimited 
 Repatriation or medical transport of companions: Unlimited (2 companions) 
 Early return due to hospitalization or death of a family member: Unlimited 
 Extension of stay in hotel by medical prescription: Up to € 1.200 
 Material losses: Up to € 2.500 
 Travel cancellation expenses (optional): Up to € 5.000 
 Loss of contracted services: € 300 
 Transportation accidents: Up to € 35.000 , 1848 , 23456723T , 3490 , 
1 , 1 , 15 , 09 , 2022 , 15 , 31 , 2 , 3490 , 34562789 , 23456723T , 1848 , 
0 , 
```

