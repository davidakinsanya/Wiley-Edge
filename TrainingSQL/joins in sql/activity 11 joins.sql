USE personaltrainer;

select * from client c left join clientworkout cw on 
c.clientid = cw.clientid where cw.clientid is null;