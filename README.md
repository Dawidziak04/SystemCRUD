📌 Opis projektu

OrderManagement to aplikacja webowa oparta na Spring Boot (REST API) oraz interfejsie użytkownika w HTML, CSS i JavaScript, umożliwiająca zarządzanie klientami i ich zamówieniami.
Użytkownicy mogą przeglądać, dodawać, edytować i usuwać klientów oraz zamówienia zarówno przez interfejs graficzny, jak i bezpośrednio przez API.

🚀 Funkcjonalności

- Pobieranie listy klientów i ich zamówień.
- Dodawanie, edytowanie, usuwanie klientów oraz zamówień.
- Wyszukiwanie klientów i zamówień po ID.
- Automatyczna nawigacja do szczegółów klienta.
- Frontend oparty na HTML, CSS i JavaScript.
- Logowanie użytkowników (Hasła szyfrowane Bcrypt'em).
- Autoryzacja dostępu do zasobów backendu.

🔐 Bezpieczeństwo

- Hasła użytkowników są szyfrowane za pomocą BCrypt.
- Endpointy REST chronione przez mechanizm uwierzytelniania i autoryzacji.
- Możliwość logowania użytkowników z poziomu formularza frontendowego (do rozbudowy).
- Ograniczenie dostępu do danych dla nieautoryzowanych żądań.

🛠 Technologie

Backend:
- Java 17+.
- Spring Boot 3+ (Spring Web, Spring Data JPA, Spring Validation, Spring Security).
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

![image](https://github.com/user-attachments/assets/3164ead7-d831-477e-aa32-5df787afc2ae)


![{C20ED09F-3E32-457B-B36E-78A74478AF6F}](https://github.com/user-attachments/assets/484494d5-0467-4ace-92b0-37cb80a63c42)

customer.html (Widok szczegółowy klienta):
- Wyświetlanie danych klienta.
- Lista jego zamówień.
- Przekierowanie do strony głównej.
- Przycisk edycji danych klienta.

![image](https://github.com/user-attachments/assets/88ec0605-c9cd-4c71-88b2-5c53b4e8b44c)


editOrder.html (Edycja zamówienia):
- Formularz do edycji szczegółów zamówienia.
- Możliwość zapisania zmian.

![image](https://github.com/user-attachments/assets/5c592327-1b2f-474d-8398-b57b840e25b8)


editCustomer.html (Edycja klienta):
- Formularz do edycji danych klienta.
- Możliwość zapisania zmian.

![image](https://github.com/user-attachments/assets/5524f8f9-7ecf-4788-9d85-30380ca07c56)



🎨 CSS

- Estetyczne przyciski i inputy
- Animacje przycisków (bounceInUp, bounce)
- Responsywność dla różnych ekranów

📂 Struktura projektu

```bash
com/pl/OrderManagement
├── config # Konfiguracja aplikacji
│   └── SpringSecurityConfiguration.java           # Konfiguracja zabezpieczeń aplikacji (Spring Security)
│
├── controller  # Warstwa kontrolerów obsługująca żądania HTTP
│   ├── AdministratorController.java               # Obsługuje endpointy związane z administratorem
│   ├── CustomerController.java                    # Obsługuje endpointy związane z klientami
│   └── OrderController.java                       # Obsługuje endpointy związane z zamówieniami
│
├── model # Klasy encji (JPA) i POJO
│   ├── Administrator.java                         # Encja administratora (JPA)
│   ├── AdministratorPrincipal.java                # Implementacja UserDetails dla administratora (autoryzacja)
│   ├── Customer.java                              # Encja klienta (JPA)
│   └── Order.java                                 # Encja zamówienia (JPA)
│
├── repository # Interfejsy (JPARepository)
│   ├── AdministratorRepository.java               # Interfejs JPA do operacji CRUD na administratorze
│   ├── CustomerRepository.java                    # Interfejs JPA do operacji CRUD na kliencie
│   └── OrderRepository.java                       # Interfejs JPA do operacji CRUD na zamówieniach
│
├── service # Logika aplikacji
│   ├── AdministratorService.java                  # Logika biznesowa dla administratora (np. rejestracja z haszowaniem)
│   ├── CustomerService.java                       # Logika biznesowa dla klienta
│   ├── CustomUserDetailsService.java              # Ładowanie danych użytkownika przy logowaniu (dla Spring Security)
│   └── OrderService.java                          # Logika biznesowa dla zamówień
│
└── OrderManagementApplication.java                # Główna klasa uruchamiająca aplikację Spring Boot
│
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
📌 Rejestrowanie nowych użytkowników (/register)
```sql
POST /register - Rejestruje nowego użytkownika
```
