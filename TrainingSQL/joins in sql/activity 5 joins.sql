USE personaltrainer;

select w.Name, c.FirstName, c.LastName from Client c
join ClientWorkout cw on c.clientid = cw.clientid  
join Workout w on cw.workoutid = w.workoutid 
where c.lastname like 'C%';




