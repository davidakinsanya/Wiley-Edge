USE vinylrecordshop;

LOAD DATA LOCAL INFILE 'C:\Users\david\Desktop\TrainingSQL\artist.csv'
INTO TABLE vinylrecordshop.artist 
FIELDS TERMINATED BY ',';

SELECT * FROM album;





