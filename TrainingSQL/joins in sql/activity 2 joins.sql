USE personaltrainer;

select e.name, ec.name from exercisecategory ec
join exercise e
on ec.exercisecategoryid = e.exercisecategoryid
where ec.parentcategoryid is null;




