CREATE TABLE product
(
    id                  bigint,
    name                VARCHAR(255)      NOT NULL,
    brand               VARCHAR(255)      NOT NULL,
    quantity            bigint            NOT NULL,
    dosage              VARCHAR(255)      NOT NULL,
    type                VARCHAR(255)      NOT NULL,
    expiration_date     DATE              NOT NULL,

    CONSTRAINT product_pk PRIMARY KEY (id)
);


