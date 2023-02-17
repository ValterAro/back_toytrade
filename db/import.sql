INSERT INTO public.city (id, name, status) VALUES (DEFAULT, 'Tallinn', 'A');
INSERT INTO public.city (id, name, status) VALUES (DEFAULT, 'Tartu', 'A');
INSERT INTO public.city (id, name, status) VALUES (DEFAULT, 'Kuressaare', 'A');

INSERT INTO public.category (id, name, status) VALUES (DEFAULT, 'Autod','A');
INSERT INTO public.category (id, name, status) VALUES (DEFAULT, 'Nukud','A');
INSERT INTO public.category (id, name, status) VALUES (DEFAULT, 'Legod','A');
INSERT INTO public.category (id, name, status) VALUES (DEFAULT, 'Lauamängud','A');
INSERT INTO public.category (id, name, status) VALUES (DEFAULT, 'Klotsid','A');

INSERT INTO public.condition (id, name, status) VALUES (DEFAULT, 'Nagu uus', 'A');
INSERT INTO public.condition (id, name, status) VALUES (DEFAULT, 'Kulunud', 'A');
INSERT INTO public.condition (id, name, status) VALUES (DEFAULT, 'Räsitud', 'A');

INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'user');


INSERT INTO public."user" (id, role_id, username, password, points, mobile, status) VALUES (DEFAULT, 1, 'helar', '123', 3, '7', 'A');
INSERT INTO public."user" (id, role_id, username, password, points, mobile, status) VALUES (DEFAULT, 2, 'valter', '123', 3, '8', 'A');
INSERT INTO public."user" (id, role_id, username, password, points, mobile, status) VALUES (DEFAULT, 2, 'roby', '123', 3, '9', 'A');

INSERT INTO public.toy (id, user_id, city_id, condition_id, category_id, name, description, picture, status) VALUES (DEFAULT, 1, 1, 1, 1, 'Puldiauto Ferrari', '2-aastastele ideaalne puldiauto, isegi patareid on olemas', '1', 'P');
INSERT INTO public.toy (id, user_id, city_id, condition_id, category_id, name, description, picture, status) VALUES (DEFAULT, 1, 2, 2, 2, 'Barbie nukk', 'Natuke kurb, sest Ken on kadnunud', '2', 'A');
INSERT INTO public.toy (id, user_id, city_id, condition_id, category_id, name, description, picture, status) VALUES (DEFAULT, 2, 3, 3, 3, 'Legokomplekt Harry Potter', 'Paljukasutatud legokomplekt Harry Potteri võlumaailmast. Mõned klotsid puudu', '1', 'P');

INSERT INTO public.toy_transaction (id, toy_id, seller_id, buyer_id, timechanged, status, parcel_point) VALUES (DEFAULT, 1, 1, 2, '2005-10-19 10:23:54+02', 'Välja saadetud, ootab ostjani jõudmist', 'Tondi Selveri pakiautomaat');
INSERT INTO public.toy_transaction (id, toy_id, seller_id, buyer_id, timechanged,status, parcel_point) VALUES (DEFAULT, 3, 2, 1, '2004-10-19 10:23:54+02', 'Mänguasi ootab müüja poolt välja saatmist', 'Jõe Prisma pakiautomaat');



