INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tallinn');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tartu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Kuressaare');

INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Autod');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Nukud');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Legod');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Lauamängud');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Klotsid');

INSERT INTO public.condition (id, name) VALUES (DEFAULT, 'Nagu uus');
INSERT INTO public.condition (id, name) VALUES (DEFAULT, 'Kulunud');
INSERT INTO public.condition (id, name) VALUES (DEFAULT, 'Räsitud');

INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'user');

INSERT INTO public."user" (id, role_id, username, password, points, mobile, status) VALUES (DEFAULT, 1, 'helar', '123', 3, '7', 'A');
INSERT INTO public."user" (id, role_id, username, password, points, mobile, status) VALUES (DEFAULT, 2, 'valter', '123', 3, '8', 'A');
INSERT INTO public."user" (id, role_id, username, password, points, mobile, status) VALUES (DEFAULT, 2, 'roby', '123', 3, '9', 'A');

INSERT INTO public.toy (id, user_id, city_id, condition_id, category_id, name, description, picture, status) VALUES (DEFAULT, 1, 1, 1, 1, 'Puldiauto Ferrari', '2-aastastele ideaalne puldiauto, isegi patareid on olemas', '1', 'A');
INSERT INTO public.toy (id, user_id, city_id, condition_id, category_id, name, description, picture, status) VALUES (DEFAULT, 1, 2, 2, 2, 'Barbie nukk', 'Natuke kurb, sest Ken on kadnunud', '2', 'A');
INSERT INTO public.toy (id, user_id, city_id, condition_id, category_id, name, description, picture, status) VALUES (DEFAULT, 2, 3, 3, 3, 'Legokomplekt Harry Potter', 'Paljukasutatud legokomplekt Harry Potteri võlumaailmast. Mõned klotsid puudu', '1', 'A');





