SystemCRUD - Spring Boot + MySQL + Mockito

📌 Opis projektu

SystemCRUD to aplikacja REST API do zarządzania klientami i zamówieniami w systemie sprzedaży. Umożliwia dodawanie, pobieranie i zarządzanie danymi klientów oraz ich zamówieniami. Projekt wykorzystuje Spring Boot, MySQL, JPA, Hibernate oraz Mockito do testowania logiki biznesowej.

🛠 Technologie

- Java 17+.
- Spring Boot 3+.
- Spring Data JPA.
- Spring Web.
- Spring Validation.
- MySQL + Hibernate.
- Mockito + JUnit 5.
- Docker (opcjonalnie).

Struktura projektu

📂 SystemCRUD/
│── src/main/java/com/pl/SystemCRUD/
│   ├── Controller/       # Kontrolery REST API
│   ├── Objects/          # Klasy encji JPA
│   ├── Repositories/     # Repozytoria JPA
│   ├── Service/          # Logika biznesowa
│   ├── SystemCrudApplication.java  # Punkt startowy aplikacji
│── src/test/java/com/pl/SystemCRUD/ # Testy jednostkowe (Mockito)
│── pom.xml               # Konfiguracja Maven
│── README.md             # Dokumentacja projektu


📦 Przykładowa konfiguracja docker'a

docker run --name SystemCRUD -e MYSQL_ROOT_PASSWORD=dawid -d -p 3306:3306 mysql

📦 Przykładowe dane do wstawienia do bazy danych (MySQL)

-- Wybór bazy danych
USE SystemCRUD;

-- Wstawianie przykładowych klientów
INSERT INTO customers (customerid, name, surname) VALUES
(1, 'Jan', 'Kowalski'),
(2, 'Anna', 'Nowak'),
(3, 'Piotr', 'Wiśniewski'),
(4, 'Katarzyna', 'Dąbrowska'),
(5, 'Marek', 'Lewandowski');

-- Wstawianie przykładowych zamówień
INSERT INTO orders (orderid, order_description, order_name, order_value, customer_id) VALUES
(1, 'Zakup laptopa', 'Laptop Dell', 4500.00, 1),
(2, 'Zakup telefonu', 'iPhone 13', 3800.00, 2),
(3, 'Zakup telewizora', 'Samsung 55"', 3200.00, 3),
(4, 'Zakup roweru', 'Rower górski', 2700.00, 4),
(5, 'Zakup konsoli', 'PlayStation 5', 3000.00, 5);



🚀 API Endpointy

GET /customers - Pobiera listę klientów
POST /customers - Dodaje nowego klienta
GET /customers/{id} - Pobiera klienta po ID
GET /orders - Pobiera listę zamówień
POST /orders - Tworzy nowe zamówienie
GET /orders/{id} - Pobiera zamówienie po ID
GET /orders/customer/{id} - Pobiera zamówienia klienta
