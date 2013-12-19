create table station 
(
   id                   int identity(1,1) primary key ,
   station_no           char(255)                      not null,
   ober_time            char(255)                      not null,
   lat                  char(255)                      not   null,
   lng                  char(255)                      not   null,
   statiion_altitude    char(255)                      not null,
   sensor_altitude      char(255)                      not null,
   ober_method          char(255)                      not null,
   quality_flag         char(255)                      not null,
   file_update_flag     char(255)                      not null
);
