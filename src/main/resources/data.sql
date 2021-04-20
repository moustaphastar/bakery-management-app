/* COUNTRY TABLE.
   Reads a csv file and inserts the data into Country table.
   Filename: countries.csv
   */
insert into COUNTRY(ID, ISO2, ISO3, NAME, CURRENCY) (select * from csvread('./src/main/resources/countries.csv'));
