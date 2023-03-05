// A table
// if object exists CURRENTSCHEMA.ALL_DATATYPES
drop table all_datatypes;
// end if
create table all_datatypes(number1 bigint, number2 numeric(4,0), number3 bit(2), number4 smallint,
number5 decimal(8,2), number6 smallmoney, number7 int, number8 tinyint, number9 money, float1 float, real1 real,
varchar1 varchar(10), char1 char(5), text1 text, varchar2 nvarchar(10), char2 nchar(5), text2 ntext, binary1 binary, binary2 varbinary(10), image1 image,
date1 date, date2 datetimeoffset, date3 datetime2, date4 smalldatetime, date5 datetime, time1 time(7),
variant1 sql_variant, hierarchyid1 hierarchyid, uniqueidentifier1 uniqueidentifier, xml1 xml, 
geometry1 geometry, geography1 geography, rowversion1 rowversion);
insert into all_datatypes values ( 1234, 34.32, 01, 23, 3.14, 123, 1234, 12, 3.14, 3.14, 3.14,
'ABCDEFG', 'ABCD', 'sedfe', 'ABCDEFG', 'ABCD', 'sedfe', 'AC01', 'AC02', 'AC03',
'2017-01-01', '2017-01-01 13:00:00 -04:00', '2017-01-01 13:00:00', '2017-01-01 13:00:00', '2017-01-01 13:00:00', '13:00:00',
1234, '/1/', '6F9619FF-8B86-D011-B42D-00C04FC964FF', '<x>abc</x>'
geometry::STGeomFromText('LINESTRING (100 100, 20 180, 180 180)', 0), geography::STGeomFromText('LINESTRING(-122.360 47.656, -122.343 47.656 )', 4326) );
