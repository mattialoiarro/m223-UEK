# Applikation für die Buchungen von CoWorking Spaces über das Backend.
- Diese Applikation lässt Sie über die Rest-ENdpunkte Arbeitsplätze in einem CoWorking space buchen. Sie können auch wenn nötig extra Equipment buchen und spezifische Räume. Als Besucher kann man sich registrieren und Anmelden.Die Mitgleider können Buchungen durchführen. Der Admin kann Buchungen editieren, löschen, aktzeptiere, ablhenen oder auch Mitglieder verwalten.

# Projekt aufsetzten
- Das Projekt aus meinem GitHub klonen.
- Sicher stellen, dass Docker am laufen ist.
- Mit VS Code öffnen und dann untern rechts auf den Knopf klicken Reopen in Container.

# Projekt Starten
- Im Dev Container die Quarkus Extension herunterladen.
- Mit Quarkus: Debug current Quarkus Project die Appliaktion starten. Das kann gesucht werden mit der Tastenkombination: Ctrl + Shift + P oder in der Konsole: ./mvnw quarkus:dev

# Testdaten
- Die Testdaten befinden sich im resources Ordner unter dem Namen import.sql
- Die Testdaten werden direkt in der Applikation geladen.

# API testen

- Die API Dokumentation ist unter http://localhost:8080/q/swagger-ui/ zu finden.

# Logindaten
- Login Url: http://localhost:8080/session
- Admin: Benutzername = test@gmail.com Passwort: test
- Mitglied: Benutzername = beans@gmail.com Passwort: beans

# Datenbankadministration
- Über http://localhost:5050 ist PgAdmin4 erreichbar. Damit lässt sich die Datenbank komfortabel verwalten. Der Benutzername lautet zli@example.com und das Passwort zli*123. Die Verbindung zur PostgreSQL-Datenbank muss zuerst mit folgenden Daten konfiguriert werden:

- Host name/address: db
- Port: 5432
- Maintenance database: postgres
- Username: postgres
- Password: postgres


# Link zum Reposetory
- https://github.com/mattialoiarro/m223-UEK


