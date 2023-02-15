-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-02-15 08:40:53.471

-- tables
-- Table: category
CREATE TABLE category (
                          id serial  NOT NULL,
                          name varchar(255)  NOT NULL,
                          status char(1)  NOT NULL,
                          CONSTRAINT category_pk PRIMARY KEY (id)
);

-- Table: city
CREATE TABLE city (
                      id serial  NOT NULL,
                      name varchar(255)  NOT NULL,
                      status char(1)  NOT NULL,
                      CONSTRAINT city_pk PRIMARY KEY (id)
);

-- Table: condition
CREATE TABLE condition (
                           id serial  NOT NULL,
                           name varchar(255)  NOT NULL,
                           status char(1)  NOT NULL,
                           CONSTRAINT condition_pk PRIMARY KEY (id)
);

-- Table: picture
CREATE TABLE picture (
                         id serial  NOT NULL,
                         data bytea  NOT NULL,
                         toy_id int  NOT NULL,
                         CONSTRAINT picture_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      name varchar(50)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: toy
CREATE TABLE toy (
                     id serial  NOT NULL,
                     user_id int  NOT NULL,
                     city_id int  NOT NULL,
                     condition_id int  NOT NULL,
                     category_id int  NOT NULL,
                     name varchar(255)  NOT NULL,
                     description varchar(255)  NOT NULL,
                     picture bytea  NOT NULL,
                     status char(1)  NOT NULL,
                     CONSTRAINT toy_pk PRIMARY KEY (id)
);

-- Table: toy_transaction
CREATE TABLE toy_transaction (
                                 id serial  NOT NULL,
                                 toy_id int  NOT NULL,
                                 seller_id int  NOT NULL,
                                 buyer_id int  NOT NULL,
                                 parcel_point varchar(255)  NOT NULL,
                                 status char(2)  NOT NULL,
                                 CONSTRAINT toy_transaction_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        role_id int  NOT NULL,
                        username varchar(255)  NOT NULL,
                        password varchar(255)  NOT NULL,
                        points int  NOT NULL,
                        mobile varchar(15)  NOT NULL,
                        status char(1)  NOT NULL,
                        CONSTRAINT id PRIMARY KEY (id)
);

-- foreign keys
-- Reference: picture_toy (table: picture)
ALTER TABLE picture ADD CONSTRAINT picture_toy
    FOREIGN KEY (toy_id)
        REFERENCES toy (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: toy_category (table: toy)
ALTER TABLE toy ADD CONSTRAINT toy_category
    FOREIGN KEY (category_id)
        REFERENCES category (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: toy_city (table: toy)
ALTER TABLE toy ADD CONSTRAINT toy_city
    FOREIGN KEY (city_id)
        REFERENCES city (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: toy_condition (table: toy)
ALTER TABLE toy ADD CONSTRAINT toy_condition
    FOREIGN KEY (condition_id)
        REFERENCES condition (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: toy_transaction_buyer (table: toy_transaction)
ALTER TABLE toy_transaction ADD CONSTRAINT toy_transaction_buyer
    FOREIGN KEY (buyer_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: toy_transaction_seller (table: toy_transaction)
ALTER TABLE toy_transaction ADD CONSTRAINT toy_transaction_seller
    FOREIGN KEY (seller_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: toy_transaction_toy (table: toy_transaction)
ALTER TABLE toy_transaction ADD CONSTRAINT toy_transaction_toy
    FOREIGN KEY (toy_id)
        REFERENCES toy (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: toy_user (table: toy)
ALTER TABLE toy ADD CONSTRAINT toy_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.

