drop table exchange_value if exists;
create table exchange_value(
    ID BIGINT PRIMARY KEY,
    CURRENCY_FROM VARCHAR NOT NULL,
    CURRENCY_TO VARCHAR NOT NULL,
    CONVERSION_MULTIPLE NUMERIC NOT NULL,
    PORT INT NULL
);