ALTER TABLE customer DROP COLUMN username;
ALTER TABLE customer RENAME COLUMN firstName TO first_name;
ALTER TABLE customer RENAME COLUMN lastName TO last_name;