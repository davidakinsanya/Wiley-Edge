USE thewileyhotel;

LOAD DATA LOCAL INFILE 'C:/Users/david/Desktop/Training/AssignmentFour/csv/Guest.csv'
INTO TABLE thewiLeyhotel.Guest 
FIELDS TERMINATED BY ',';

LOAD DATA LOCAL INFILE 'C:/Users/david/Desktop/Training/AssignmentFour/csv/Ammenities.csv'
INTO TABLE thewiLeyhotel.Ammenities
FIELDS TERMINATED BY ',';

 LOAD DATA LOCAL INFILE 'C:/Users/david/Desktop/Training/AssignmentFour/csv/Address.csv'
 INTO TABLE thewileyhotel.Address
 FIELDS TERMINATED BY ',';

 LOAD DATA LOCAL INFILE 'C:/Users/david/Desktop/Training/AssignmentFour/csv/Room.csv'
 INTO TABLE thewileyhotel.Room
 FIELDS TERMINATED BY ',';

 LOAD DATA LOCAL INFILE 'C:/Users/david/Desktop/Training/AssignmentFour/csv/RoomDetails.csv'
 INTO TABLE thewileyhotel.RoomDetails
 FIELDS TERMINATED BY ',';

 LOAD DATA LOCAL INFILE 'C:/Users/david/Desktop/Training/AssignmentFour/csv/Reservation.csv'
 INTO TABLE thewileyhotel.Reservation
 FIELDS TERMINATED BY ',';

 LOAD DATA LOCAL INFILE 'C:/Users/david/Desktop/Training/AssignmentFour/csv/ReservationDetails.csv'
 INTO TABLE thewileyhotel.ReservationDetails
 FIELDS TERMINATED BY ',';



