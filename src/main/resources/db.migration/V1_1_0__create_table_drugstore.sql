CREATE TABLE drugstore
(
    id          bigint,
    cnpj         bigint,
    name        VARCHAR(255)      NOT NULL,
    email       VARCHAR(255)      NOT NULL,
    phone       VARCHAR(255)      NOT NULL,
    address_id  bigint,

    CONSTRAINT address_fk FOREIGN KEY (address_id) REFERENCES address(id),
    CONSTRAINT drugstore_pk PRIMARY KEY (id)
);


