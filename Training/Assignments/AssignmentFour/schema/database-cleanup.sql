use thewileyhotel;

delete from address where guestid = 0;
delete from reservationdetails where guestid = 0;
delete from  reservation where guestid = 0;
delete from  guest where guestid = 0;