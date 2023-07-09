USE personaltrainer;

select w.name as 'Workout Name' from client c join clientgoal cg on c.clientid = cg.clientid 
join workoutgoal wg on cg.goalid = wg.goalid 
join workout w on wg.workoutid = w.workoutid
where levelid = 1 and c.firstname = 'Shell' and c.lastname = 'Creane';