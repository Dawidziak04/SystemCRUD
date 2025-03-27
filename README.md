📌 Opis projektu

SystemCRUD to aplikacja webowa oparta na Spring Boot (REST API) oraz interfejsie użytkownika w HTML, CSS i JavaScript, umożliwiająca zarządzanie klientami oraz ich zamówieniami.
Użytkownicy mogą przeglądać, dodawać i usuwać klientów oraz zamówienia zarówno przez interfejs graficzny, jak i bezpośrednio przez API.

🚀 Funkcjonalności

✔️ Pobieranie listy klientów i ich zamówień.
✔️ Dodawanie, usuwanie klientów oraz zamówień.
✔️ Wyszukiwanie klientów po ID.
✔️ Automatyczna nawigacja do szczegółów klienta.
✔️ Frontend oparty na HTML, CSS i JavaScript.

🛠 Technologie

Backend:
- Java 17+.
- Spring Boot 3+ (Spring Web, Spring Data JPA, Spring Validation).
- MySQL + Hibernate.
- Mockito + JUnit 5.
- Docker (opcjonalnie).

Frontend:
- HTML5 + CSS3.
- JavaScript (Vanilla JS, Fetch API).

🎨 Frontend – Interfejs użytkownika

1️⃣ CustomerManagementUI.html
Strona główna aplikacji, zawiera:
✅ Pobieranie listy klientów i zamówień
✅ Dodawanie i usuwanie klientów oraz zamówień
✅ Wyszukiwanie klientów po ID

2️⃣ customer.html
Widok szczegółowy klienta:
✅ Wyświetlanie danych klienta
✅ Lista jego zamówień
✅ Przekierowanie do strony głównej

🎨 CSS

- Estetyczne przyciski i inputy
- Animacje przycisków (bounceInUp, bounce)
- Responsywność dla różnych ekranów

📂 Struktura projektu

   SystemCRUD/
│── src/main/java/com/pl/SystemCRUD/
│   ├── Controller/       # Kontrolery REST API
│   ├── Objects/          # Klasy encji JPA
│   ├── Repositories/     # Repozytoria JPA
│   ├── Service/          # Logika biznesowa
│   ├── SystemCrudApplication.java  # Punkt startowy aplikacji
│── src/main/resources/static/  # Pliki frontendowe
│   ├── CustomerManagementUI.html  # Strona główna interfejsu
│   ├── customer.html  # Szczegóły klienta i jego zamówień
│   ├── script.js  # Logika interakcji z API (klienci, zamówienia)
│   ├── customer.js  # Logika interakcji z API (szczegóły klienta)
│   ├── styles.css  # Stylizacja interfejsu
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

📌 Klienci (/customers)

GET /customers - Pobiera listę klientów
POST /customers - Dodaje nowego klienta
GET /customers/{id} - Pobiera klienta po ID
DELETE /deleteCustomer/{id} - Usuwa klienta po ID

📌 Zamówienia (/orders)

GET /orders - Pobiera listę zamówień
POST /orders - Tworzy nowe zamówienie
GET /orders/{id} - Pobiera zamówienie po ID
GET /orders/customer/{id} - Pobiera zamówienia klienta
DELETE /deleteOrder/{id} - Usuwa zamówienie po ID
