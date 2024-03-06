INSERT INTO benefit_category("category_name")
VALUES
    ('Food and drinks'),
    ('Recreation'),
    ('Education'),
    ('Culture'),
    ('Traveling'),
    ('Shopping');

INSERT INTO benefit_entity("name","benefit_category_id")
VALUES
    ('Restaurant',1),('Coffee shops',1),
    ('Fitness',2),('Sauna',2),('Yoga',2),
    ('Courses',3),('Books',3),('Conferences',3),
    ('Cinema',4),('Museum,',4),('Theater',4),
    ('Fuel',5),('Plane',5),('Train',5),('Bus tickets',5),('Taxi',5),
    ('Shopping',6);

INSERT INTO company_entity("name")
VALUES ('Vega'),('Levi9'),('Nethermind');

INSERT INTO company_benefit("company_id","benefit_id","discount")
VALUES
    (1,2,0.1),
    (1,3,0.15),
    (1,5,0.3);
INSERT INTO payment_card_entity("balance","card_type")
VALUES
    (1000, 'PREMIUM'),
    (2000, 'PLATINUM'),
    (1500, 'STANDARD');

INSERT INTO user_entity("first_name","last_name","email","company_id","payment_card_id")
VALUES
    ('Marko','Markovic','marko@gmail.com',1,1),
    ('Petar','Peric','petar@gmail.com',1,2),
    ('Ivo','Ban','ivo@gmail.com',1,3);
