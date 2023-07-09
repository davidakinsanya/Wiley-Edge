USE personaltrainer;

select c.firstname, c.lastname, l.clientid, l.emailaddress from client c
left join login l on c.clientid = l.clientid;

select c.firstname, c.lastname, l.clientid, l.emailaddress from client c
left join login l on c.clientid = l.clientid where l.emailaddress is null;

