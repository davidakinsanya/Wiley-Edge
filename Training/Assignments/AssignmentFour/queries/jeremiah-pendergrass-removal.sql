use thewileyhotel;

delete from reservationdetails where reservationdetails.guestid = 7;
delete from reservation where reservation.guestid = 7;
delete from address where address.guestid = 7;
delete from guest where guest.guestid = 7;
