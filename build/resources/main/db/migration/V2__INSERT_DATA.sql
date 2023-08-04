INSERT INTO test.customer (first_name, last_name, birth_date)
VALUES
  ('John', 'WInston', '1985-05-05'),
  ('Jack', 'Phillips', '1990-01-20'),
  ('Lynda', 'Smith', '1995-10-10');

INSERT INTO test.vehicles (brand, model, price, vin, year)
VALUES
  ('MB', 'GLS', 65000, 'ASD234DFG123DFGD', 2020),
  ('BMW', 'X5', 55000, 'DFG234SDF234DFHG', 2021),
  ('Porsche', '911', 60000, 'W234SDF345GGH23S', 2020);

INSERT INTO test.contracts (contract_number, monthly_rate, details, fk_customer_id, fk_vehicle_id)
VALUES
  ('645234654623', 233, 'after crash', 1, 1),
  ('867234123445', 123, null, 2, 2),
  ('567234675234', 321, 'red car', 3, 3);