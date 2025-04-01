📌 Opis projektu

OrderManagement to aplikacja webowa oparta na Spring Boot (REST API) oraz interfejsie użytkownika w HTML, CSS i JavaScript, umożliwiająca zarządzanie klientami i ich zamówieniami.
Użytkownicy mogą przeglądać, dodawać, edytować i usuwać klientów oraz zamówienia zarówno przez interfejs graficzny, jak i bezpośrednio przez API.

🚀 Funkcjonalności

- Pobieranie listy klientów i ich zamówień.
- Dodawanie, edytowanie, usuwanie klientów oraz zamówień.
- Wyszukiwanie klientów i zamówień po ID.
- Automatyczna nawigacja do szczegółów klienta.
- Frontend oparty na HTML, CSS i JavaScript.

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

OrderManagement.html (Strona główna aplikacji):
- Pobieranie listy klientów i zamówień.
- Dodawanie i usuwanie klientów oraz zamówień.
- Wyszukiwanie klientów i zamówień po ID.
![{B72CC983-046C-4BEC-9A31-9271202CBD24}](https://github.com/user-attachments/assets/8107c752-6e47-4d98-8392-110947edfe61)
![{C20ED09F-3E32-457B-B36E-78A74478AF6F}](https://github.com/user-attachments/assets/484494d5-0467-4ace-92b0-37cb80a63c42)

customer.html (Widok szczegółowy klienta):
- Wyświetlanie danych klienta.
- Lista jego zamówień.
- Przekierowanie do strony głównej.
![{0560C48C-F045-4BA1-83AF-F036394E0348}](https://github.com/user-attachments/assets/b49cf59c-7755-48cd-bfe4-1019c34a0007)

editOrder.html (Edycja zamówienia):
- Formularz do edycji szczegółów zamówienia.
- Możliwość zapisania zmian.
![image](https://github.com/user-attachments/assets/5c592327-1b2f-474d-8398-b57b840e25b8)


editCustomer.html (Edycja klienta):
- Formularz do edycji danych klienta.
- Możliwość zapisania zmian.



🎨 CSS

- Estetyczne przyciski i inputy
- Animacje przycisków (bounceInUp, bounce)
- Responsywność dla różnych ekranów

📂 Struktura projektu

```bash
OrderManagement/
│── src/main/java/com/pl/OrderManagement/
│   ├── Controller/       # Kontrolery REST API
│   ├── Objects/          # Klasy encji JPA
│   ├── Repositories/     # Repozytoria JPA
│   ├── Service/          # Logika biznesowa
│   ├── OrderManagementApplication.java  # Punkt startowy aplikacji
│── src/main/resources/static/  # Pliki frontendowe
│   ├── OrderManagement.html  # Strona główna interfejsu
│   ├── customer.html  # Szczegóły klienta i jego zamówień
│   ├── editOrder.html  # Formularz edycji zamówienia
│   ├── editCustomer.html  # Formularz edycji klienta
│   ├── script.js  # Logika interakcji z API (klienci, zamówienia)
│   ├── customer.js  # Logika interakcji z API (szczegóły klienta)
│   ├── editOrder.js  # Logika interakcji z API (edycja zamówienia)
│   ├── editCustomer.js  # Logika interakcji z API (edycja klienta)
│   ├── styles.css  # Stylizacja interfejsu
│── src/test/java/com/pl/OrderManagement/ # Testy jednostkowe (Mockito)
│── pom.xml               # Konfiguracja Maven
│── README.md             # Dokumentacja projektu
```



📦 Przykładowa konfiguracja docker'a
```sql
docker run --name SystemCRUD -e MYSQL_ROOT_PASSWORD=dawid -d -p 3306:3306 mysql
```

📦 Przykładowe dane do wstawienia do bazy danych (MySQL)

-- Wybór bazy danych
USE SystemCRUD;

-- Wstawianie przykładowych klientów
```sql
INSERT INTO customers (customerid, name, surname) VALUES
(1, 'Jan', 'Kowalski'),
(2, 'Anna', 'Nowak'),
(3, 'Piotr', 'Wiśniewski'),
(4, 'Katarzyna', 'Dąbrowska'),
(5, 'Marek', 'Lewandowski');
```

-- Wstawianie przykładowych zamówień
```sql
INSERT INTO orders (orderid, order_description, order_name, order_value, customer_id) VALUES
(1, 'Zakup laptopa', 'Laptop Dell', 4500.00, 1),
(2, 'Zakup telefonu', 'iPhone 13', 3800.00, 2),
(3, 'Zakup telewizora', 'Samsung 55"', 3200.00, 3),
(4, 'Zakup roweru', 'Rower górski', 2700.00, 4),
(5, 'Zakup konsoli', 'PlayStation 5', 3000.00, 5);
```


🚀 API Endpointy

📌 Klienci (/customers)

```sql
GET /customers - Pobiera listę klientów
POST /customers - Dodaje nowego klienta
PUT /editCustomer - Edytuje istniejącego już klienta
GET /customers/{id} - Pobiera klienta po ID
DELETE /deleteCustomer/{id} - Usuwa klienta po ID
```
📌 Zamówienia (/orders)
```sql
GET /orders - Pobiera listę zamówień
POST /orders - Tworzy nowe zamówienie
PUT /editOrder - Edytuje istniujące już zamówienie
GET /orders/{id} - Pobiera zamówienie po ID
GET /orders/customer/{id} - Pobiera zamówienia klienta
DELETE /deleteOrder/{id} - Usuwa zamówienie po ID
```
