USE personaltrainer;

select FirstName, LastName, BirthDate, EmailAddress from Client c
join Login l on c.clientid = l.clientid where c.birthdate between '1990-01-01' and '2000-01-01';




