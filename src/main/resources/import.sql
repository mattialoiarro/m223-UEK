INSERT INTO "Rollen" ("role") VALUES ('Mitglied');
INSERT INTO "Rollen" ("role") VALUES ('Admin');


INSERT INTO "Room" ("groesse","sitzplatz","officeart") VALUES ('123','4','Office mit Fenster');

INSERT INTO "User" ("email","password","prename","surname","role_id","isadmin") VALUES ('test@gmail.com','test','Mattia','Loiarro',2,true);
INSERT INTO "User" ("email","password","prename","surname","role_id","isadmin") VALUES ('beans@gmail.com','beans','Tobias','Bertschi',1, false);

INSERT INTO "Booking" ("buchungsnummer","date","ganzertag","status","text") VALUES ('1232832323928','2022-11-22',true,'wird noch aktzeptiert','test');

INSERT INTO "Equipment" ("name","preis") VALUES ('Bildschirm','45');