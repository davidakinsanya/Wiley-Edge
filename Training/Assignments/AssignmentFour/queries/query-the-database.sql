use thewileyhotel;


-- Query 1
select g.fullname, r.roomno, r.startdate, r.enddate 
from guest g, reservation r
where r.enddate like '2023-07%' and 
g.guestid = r.guestid;


-- Query 2
select g.fullname, r.roomno, r.startdate, r.enddate 
from guest g join reservation r 
on g.guestid = r.guestid 
join room on room.roomno = r.roomno
where packageid = 1 or 
packageid = 3;


-- Query 3
select g.fullname, r.roomno, r.startdate, rd.noadults, rd.nochildren
from guest g join reservation r 
on g.guestid = r.guestid 
join reservationdetails rd
on r.reservationid = rd.reservationid
where g.fullname like 'Karie%';


-- Query 4
select all ro.roomno, r.reservationid, rd.TotalCost from 
reservation r join reservationdetails rd 
on r.reservationid = rd.reservationid 
join room ro 
on ro.roomno = r.roomno
order by (rd.reservationid) asc;



-- Query 5
select r.roomno, r.startdate from reservation r join reservationdetails rd 
on r.reservationid = rd.reservationid 
join room ro 
on ro.roomno = r.roomno
join roomdetails rod
on rod.roomno = ro.roomno
where rod.MaximumOccupancy > 3 
and r.StartDate like '2023-04%';


-- Query 6
select g.fullname, count(*) as 'Reservations' 
from reservation r join guest g
on g.guestid = r.guestid
group by (r.GuestID)
order by Reservations desc,
SUBSTRING_INDEX(fullname, ' ', -1);


-- Query 7
select g.fullname, g.phoneno, a.address from guest g
join address a on g.guestid = a.guestid where 
g.phoneno = '(814)485-2615';
