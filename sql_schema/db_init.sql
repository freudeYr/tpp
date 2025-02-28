CREATE TABLE City (
    city_id SERIAL PRIMARY KEY,
    city_name VARCHAR(100) NOT NULL
);

CREATE TABLE Street (
    street_id SERIAL PRIMARY KEY,
    city_id INT REFERENCES City(city_id),
    street_name VARCHAR(100) NOT NULL
);

CREATE TABLE House (
    house_id SERIAL PRIMARY KEY,
    street_id INT REFERENCES Street(street_id),
    house_number VARCHAR(10) NOT NULL
);

CREATE TABLE Apartment (
    apartment_id SERIAL PRIMARY KEY,
    house_id INT REFERENCES House(house_id),
    apartment_number INT NOT NULL
);

-- Ініціалізація

INSERT INTO City (city_name) VALUES 
('Kyiv'), 
('Lviv'), 
('Odesa');

INSERT INTO Street (city_id, street_name) VALUES 
(1, 'Khreshchatyk'), 
(1, 'Shevchenka'), 
(2, 'Halytska Square'), 
(3, 'Deribasivska');

INSERT INTO House (street_id, house_number) VALUES 
(1, '12'), 
(1, '24A'), 
(2, '7'), 
(3, '5B');

INSERT INTO Apartment (house_id, apartment_number) VALUES 
(1, 101), 
(1, 102), 
(2, 201), 
(3, 302), 
(4, 401);