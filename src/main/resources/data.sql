CREATE TABLE kommune (
    id long auto_increment primary key,
    kommunekode long not null,
    navn varchar(250) not null
);

CREATE TABLE sogne(
    id long auto_increment primary key,
    sognekode long not null,
    navn varchar(250) not null,
    kommune varchar(250) not null,
    smittetryk long not null,
    nedlukningsdato date not null
);

INSERT INTO kommune (id, kommunekode, navn)
VALUES ('1', '1', 'Frederiksberg');