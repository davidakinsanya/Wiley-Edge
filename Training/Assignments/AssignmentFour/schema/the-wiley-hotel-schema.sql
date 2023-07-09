DROP DATABASE IF EXISTS thewileyhotel;

CREATE DATABASE thewileyhotel;

use thewileyhotel;

CREATE TABLE Guest (
  GuestID INT NOT NULL,
  PhoneNo VARCHAR(25) NOT NULL,
  FullName VARCHAR(50) NOT NULL,
  PRIMARY KEY(GuestID)
);

CREATE TABLE Address (
  GuestID INT NOT NULL,
  Address VARCHAR(50),
  City VARCHAR(25),
  State VARCHAR(5),
  Zip INT NOT NULL,
  FOREIGN KEY(GuestID) REFERENCES Guest(GuestID)
);

CREATE TABLE Ammenities(
  PackageID INT NOT NULL,
  Microwave INT NOT NULL,
  Refrigerator INT NOT NULL,
  Oven INT NOT NULL,
  Jacuzzi INT NOT NULL,
  PRIMARY KEY (PackageID)
);

CREATE TABLE Room(
  RoomNo INT NOT NULL,
  PackageID INT NOT NULL,
  Type VARCHAR(10) NOT NULL,
  BasePrice Decimal(19,2) NOT NULL,
  ExtraCost Decimal(19,2),
  PRIMARY KEY(RoomNo),
  FOREIGN KEY(PackageID) REFERENCES Ammenities(PackageID)
);

CREATE TABLE RoomDetails(
  RoomNo INT NOT NULL,
  isADAaccessible INT NOT NULL,
  StandardOccupancy INT NOT NULL,
  MaximumOccupancy INT NOT NULL,
  FOREIGN KEY(RoomNo) REFERENCES Room(RoomNo)
);

CREATE TABLE Reservation (
  ReservationID INT NOT NULL,
  GuestID INT NOT NULL,
  RoomNo INT NOT NULL,
  StartDate DATE NOT NULL,
  EndDate DATE NOT NULL,
  PRIMARY KEY (ReservationID),
  FOREIGN KEY(GuestID) REFERENCES Guest(GuestID)
);

CREATE TABLE ReservationDetails(
  ReservationID INT NOT NULL,
  GuestID INT NOT NULL,
  NoAdults INT NOT NULL,
  NoChildren INT NOT NULL,
  TotalCost Decimal(19,2) NOT NULL,
  PRIMARY KEY Reservation(ReservationID),
  FOREIGN KEY (GuestID) REFERENCES Reservation(GuestID)
);
