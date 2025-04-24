-- V2: Migration to add the rank column in the signup table
ALTER TABLE tb_sign_up
ADD COLUMN rank VARCHAR(255);