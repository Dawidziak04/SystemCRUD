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


📦 Konfiguracja bazy danych (MySQL)

docker run --name SystemCRUD -e MYSQL_ROOT_PASSWORD=dawid -d -p 3306:3306 mysql



🚀 API Endpointy

GET /customers - Pobiera listę klientów
POST /customers - Dodaje nowego klienta
GET /customers/{id} - Pobiera klienta po ID
GET /orders - Pobiera listę zamówień
POST /orders - Tworzy nowe zamówienie
GET /orders/{id} - Pobiera zamówienie po ID
GET /orders/customer/{id} - Pobiera zamówienia klienta
