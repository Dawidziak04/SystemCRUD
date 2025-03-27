const API_URL = "http://localhost:8080";

const urlParams = new URLSearchParams(window.location.search);
const customerID = urlParams.get("id");



function redirectToCustomerManagement() {
    window.location.href = "CustomerManagementUI.html";
}


function fetchCustomerDetails() {
    if (!customerID || isNaN(customerID)) {
        document.getElementById("customer-info").innerHTML = "<p>Błąd: Niepoprawne ID klienta.</p>";
        return;
    }

    fetch(`${API_URL}/customers/${customerID}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Nie znaleziono klienta.");
            }
            return response.json();
        })
        .then(customer => {
            document.getElementById("customer-info").innerHTML =
                `<h2>${customer.name} ${customer.surname}</h2><p>ID: ${customer.customerID}</p>`;
        })
        .catch(() => {
            document.getElementById("customer-info").innerHTML = "<p>Błąd: Nie znaleziono klienta.</p>";
        });

    fetch(`${API_URL}/customerOrders/${customerID}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Nie udało się pobrać zamówień.");
            }
            return response.json();
        })
        .then(orders => {
            const orderList = document.getElementById("order-list");
            orderList.innerHTML = "";

            if (orders.length === 0) {
                document.getElementById("no-orders").style.display = "block";
            } else {
                document.getElementById("no-orders").style.display = "none";
                orders.forEach(order => {
                    const li = document.createElement("li");
                    li.innerHTML = `
                        <strong>Zamówienie #${order.orderID}</strong><br>
                        <strong>Nazwa:</strong> ${order.orderName}<br>
                        <strong>Opis:</strong> ${order.orderDescription}<br>
                        <strong>Wartość:</strong> ${order.orderValue} PLN
                    `;
                    orderList.appendChild(li);
                });
            }
        })
        .catch(() => {
            document.getElementById("no-orders").style.display = "block";
        });
}

fetchCustomerDetails();
