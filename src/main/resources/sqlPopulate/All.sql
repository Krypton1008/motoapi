insert into country (id, name) values ('1','Polska');
insert into country (id, name) values ('2','Niemcy');
insert into country (id, name) values ('3','Wegry');

insert into city (id, name, country, lat, lon) values ('1','Lodz','1','51.761422','19.484902');
insert into city (id, name, country, lat, lon) values ('2','Kielmina','1','51.866490','19.533357');
insert into city (id, name, country, lat, lon) values ('3','Zielona Gora','1','51.940485','15.505430');
insert into city (id, name, country, lat, lon) values ('4','Torun','1','53.011253','18.606331');
insert into city (id, name, country, lat, lon) values ('5','Wroclaw','1','51.110248','17.032011');
insert into city (id, name, country, lat, lon) values ('6','Nürburg','2','50.345444','6.953443');
insert into city (id, name, country, lat, lon) values ('7','Norymberga','2','49.446831','11.075582');
insert into city (id, name, country, lat, lon) values ('8','Hockenheim','2','49.325391','8.539521');
insert into city (id, name, country, lat, lon) values ('9','Oschersleben','2','52.029046','11.224818');
insert into city (id, name, country, lat, lon) values ('10','Klettwitz','2','51.540585','13.889407');
insert into city (id, name, country, lat, lon) values ('11','Mogyoród','3','47.601217','19.255235');
insert into city (id, name, country, lat, lon) values ('12','Ostffyasszonyfa','3','47.324459','17.034941');

insert into place (id, name, city, lat, lon) values ('1','Nürburgring Nordschleife','6','50.338385','6.950180');
insert into place (id, name, city, lat, lon) values ('2','Norisring','7','49.431556','11.124866');
insert into place (id, name, city, lat, lon) values ('3','Motorsport Arena Oschersleben','9','52.026563','11.278243');
insert into place (id, name, city, lat, lon) values ('4','Hockenheimring','8','49.329827','8.570965');
insert into place (id, name, city, lat, lon) values ('5','EuroSpeedway Lausitz','10','51.534337','13.928540');
insert into place (id, name, city, lat, lon) values ('6','Hungaroring','11','47.581617','19.250772');
insert into place (id, name, city, lat, lon) values ('7','Pannónia-Ring','12','47.304625','17.047381');
insert into place (id, name, city, lat, lon) values ('8','Gokart Arena','1','51.782109','19.466424');
insert into place (id, name, city, lat, lon) values ('9','Tor Kartingowy Le Mans','1','51.705152','19.412253');
insert into place (id, name, city, lat, lon) values ('10','TOR ŁÓDŹ','2','51.877313','19.533439');
insert into place (id, name, city, lat, lon) values ('11','Klub Żużlowy "Orzeł"','1','51.764882','19.429317');
insert into place (id, name, city, lat, lon) values ('12','Motoarena Toruń im. Mariana Rosego - MOSiR','4','53.018554','18.546762');
insert into place (id, name, city, lat, lon) values ('13','MotoPark Toruń','4','53.021034','18.547530');

insert into event_type (id,name) values ('1','Formuła 1');
insert into event_type (id,name) values ('2','Rajdy samochodowe');
insert into event_type (id,name) values ('3','Karting');
insert into event_type (id,name) values ('4','Drift');
insert into event_type (id,name) values ('5','Rajdy terenowe');
insert into event_type (id,name) values ('6','Żużel');
insert into event_type (id,name) values ('7','Motocross');

insert into news (id,title,date,article,event_type) values ('7','Zagar wygrywa w turniej w Debreczynie.','2020-08-21 16:00','Na torze w węgierskim Debreczynie odbył się turniej indywidualny o 45. Wielką Nagrodę Miasta Debreczyna. W zawodach zwyciężył Matej Zagar.','6');
insert into news (id,title,date,article,event_type) values ('6','Jonas Jeppesen wypożyczony do Arged Malesa TŻ Ostrovii.','2020-08-21 15:00','Arged Malesa TŻ Ostrovia Ostrów Wlkp. postanowiła wzmocnić swój skład. Do ostrowskiego klubu w ramach wypożyczenia trafił Jonas Jeppesen, który związał się przed sezonem z RM Solar Falubazem Zielona Góra.','6');
insert into news (id,title,date,article,event_type) values ('5','Jakub Stojanowski zadebiutuje w RzTŻ Rzeszów!','2020-08-21 14:00','Jak informuje oficjalny fanpage Rzeszowskiego Towarzystwa Żużlowego, w domowym pojedynku z drużyną SpecHouse PSŻ Poznań w ramach rozgrywek 2 Ligi Żużlowej pod numerem 14 wystąpi - Jakub Stojanowski. Będzie to dla niego debiut w rozgrywkach ligowych.','6');
insert into news (id,title,date,article,event_type) values ('4','DMPJ: ESV Sparta najlepsza w Łodzi.','2020-08-20 23:00','Dziś na łódzkiej Moto Arenie odbyła się druga runda Drużynowych Mistrzostw Polski Juniorów. Najlepsi okazali się młodzieżowcy ESV Sparty Wrocław. Drugie miejsce zajęła Arged Malesa TŻ Ostrovia Ostrów Wielkopolski, trzecie Bocar Włókniarz Częstochowa.','6');
insert into news (id,title,date,article,event_type) values ('3','Liga rosyjska: Wostok - Mega Łada 50:42.','2020-08-20 22:45','W dzisiejszym pojedynku ligi rosyjskiej na stadionie w Ussuryjsku ponownie zmierzyły się drużyny Wostoka Władywostok i Mega-Łady Togliatti. Tym razem spotkanie padło łupem gospodarzy, którzy pokonali gości z obwodu samarskiego w stosunku 50:42.','6');
insert into news (id,title,date,article,event_type) values ('2','DMPJ: Łotysze wygrywają w Rybniku.','2020-08-20 21:53','W drugiej rundzie Drużynowych Mistrzostw Polski Juniorów rozegranej w Rybniku najlepsi okazali się zawodnicy SK Lokomotiv Jauniba Daugavpils, których liderem był Francis Gusts, zdobywca 14 punktów.','6');
insert into news (id,title,date,article,event_type) values ('1','Rybnik nadal w czerwonej strefie, mecz bez kibiców.','2020-08-20 21:00','Powiat Rybnik nadal pozostaje w czerwonej strefie, zakażeń koronawirusem, co oznacza, że najbliższy niedzielny mecz PGG ROW-u Rybnik z Motorem Lublin odbędzie się bez udziału publiczności. ','6');

insert into event (id,begin_date,name,event_type,place,description) values ('1','2020-09-05 17:00','Orzeł Łódź vs Zdunek Wybrzeże Gdańsk','6','11','Runda 10 eWinner 1. Ligi Żużlowej 2020.');
insert into event (id,begin_date,name,event_type,place,description) values ('2','2020-09-05 10:00','Mistrzostwa Polski driftu','4','13','Runda kwalifikacyjna mistrzostw Polski w drifcie.');
insert into event (id,begin_date,name,event_type,place,description) values ('3','2020-09-12 17:00','eWinner Apator Toruń vs Lokomotiv Daugavpils','6','12','Runda 11 eWinner 1. Ligi Żużlowej 2020.');
insert into event (id,begin_date,name,event_type,place,description) values ('4','2020-09-18 18:00','Turniej "KartChamp"','3','8','Runda kwalifikacyjna amatorskiego turnieju kartingowego.');
insert into event (id,begin_date,name,event_type,place,description) values ('5','2020-09-19 18:00','Turniej "KartChamp"','3','8','Półfinały amatorskiego turnieju kartingowego.');
insert into event (id,begin_date,name,event_type,place,description) values ('6','2020-08-22 17:00','Orzeł Łódź vs Unia Tarnów','6','11','Runda 8 eWinner 1. Ligi Żużlowej 2020.');
insert into event (id,begin_date,name,event_type,place,description) values ('7','2020-09-12 10:00','Mistrzostwa Polski driftu','4','13','Półfinał misrzostw Polski w drifcie.');
insert into event (id,begin_date,name,event_type,place,description) values ('8','2020-09-20 18:00','Turniej "KartChamp"','3','8','Finał amatorskiego turnieju kartingowego.');
insert into event (id,begin_date,name,event_type,place,description) values ('9','2020-09-19 17:00','Orzeł Łódź vs eWinner Apator Toruń ','6','11','Runda 12 eWinner 1. Ligi Żużlowej 2020.');
insert into event (id,begin_date,name,event_type,place,description) values ('10','2020-09-26 17:00','Orzeł Łódź vs Abramczyk Polonia Bydgoszcz','6','11','Runda 13 eWinner 1. Ligi Żużlowej 2020.');
