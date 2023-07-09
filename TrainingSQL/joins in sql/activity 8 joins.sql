USE personaltrainer;

select l.clientid from client c
join login l on c.clientid = l.clientid 
where c.firstname = 'Romeo' and c.lastname = 'Seaward';

