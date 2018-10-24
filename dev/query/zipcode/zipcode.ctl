LOAD DATA
INFILE "C:/Users/owner/SSangYoung/dev/query/zipcode/zipcode.csv"
INTO TABLE zipcode
INSERT
FIELDS TERMINATED BY ','
(
zipcode, sido, gugun, dong, bunji, seq
)