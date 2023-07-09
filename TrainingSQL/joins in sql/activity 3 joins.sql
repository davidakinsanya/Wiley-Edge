USE personaltrainer;

select e.name as 'ExerciseName', ec.name as 'ExerciseCategoryName' from exercisecategory ec
join exercise e
on ec.exercisecategoryid = e.exercisecategoryid
where ec.parentcategoryid is null;




