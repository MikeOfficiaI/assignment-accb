CREATE TABLE IF NOT EXISTS test.customer (
  id BIGINT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  birth_date DATE,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS test.vehicles (
  id BIGINT NOT NULL AUTO_INCREMENT,
  brand VARCHAR(255),
  model VARCHAR(255),
  price INTEGER,
  vin VARCHAR(255),
  year INTEGER,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS test.contracts (
  id BIGINT NOT NULL AUTO_INCREMENT,
  contract_number BIGINT,
  monthly_rate INTEGER,
  fk_customer_id BIGINT,
  fk_vehicle_id BIGINT,
  details VARCHAR(255),
  PRIMARY KEY (id),
  FOREIGN KEY (fk_customer_id) REFERENCES customer(id),
  FOREIGN KEY (fk_vehicle_id) REFERENCES vehicles(id)
);