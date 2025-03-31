const API_URL = "http://localhost:8080";

function fetchCustomers() {
    fetch('http://localhost:8080/customers')
        .then(response => {
            if (!response.ok) {
                throw new Error("Nie udało się pobrać klientów.");
            }
            return response.json();
        })
        .then(customers => {
            console.log(customers);
            const customerList = document.getElementById("customer-list");
            customerList.innerHTML = "";

            const noCustomersElement = document.getElementById("no-customers");

            if (customers.length === 0) {
                if (noCustomersElement) {
                    noCustomersElement.style.display = "block";
                }
            } else {
                if (noCustomersElement) {
                    noCustomersElement.style.display = "none";
                }

                customers.forEach(customer => {
                    const li = document.createElement("li");
                    li.innerHTML = `<a href="customer.html?id=${customer.customerID}">ID: ${customer.customerID} - ${customer.name} ${customer.surname}</a>`;
                    customerList.appendChild(li);
                });
            }
        })
        .catch(error => {
            console.error("Błąd:", error);
            const noCustomersElement = document.getElementById("no-customers");
            if (noCustomersElement) {
                noCustomersElement.style.display = "block";
            }
        });
}


function addCustomer() {
    const name = document.getElementById("customer-name").value;
    const surname = document.getElementById("customer-surname").value;
    fetch(`${API_URL}/postCustomer`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, surname })
    })
        .then(response => response.json())
        .then(() => fetchCustomers())
        .catch(error => console.error("Błąd:", error));
}

function deleteCustomer() {
    const id = document.getElementById("customer-id").value;
    fetch(`${API_URL}/deleteCustomer/${id}`, { method: "DELETE" })
        .then(() => fetchCustomers())
        .catch(error => console.error("Błąd:", error));
}

function searchCustomer() {
    const customerID = document.getElementById("customer-ID").value;

    if (!customerID || isNaN(customerID)) {
        alert("Proszę wpisać poprawne ID klienta!");
        return;
    }

    window.location.href = `customer.html?id=${customerID}`;
}

function fetchOrders() {
    fetch('http://localhost:8080/orders')
        .then(response => {
            if (!response.ok) {
                throw new Error("Nie udało się pobrać zamówień.");
            }
            return response.json();
        })
        .then(orders => {
            console.log(orders);
            const orderList = document.getElementById("order-list");
            orderList.innerHTML = "";

            const noOrdersElement = document.getElementById("no-orders");
            if (orders.length === 0) {
                if (noOrdersElement) {
                    noOrdersElement.style.display = "block";
                }
            } else {
                if (noOrdersElement) {
                    noOrdersElement.style.display = "none";
                }

                orders.forEach(order => {
                    const li = document.createElement("li");
                    li.innerHTML = `
                        <strong>Zamówienie #${order.orderID}</strong><br>
                        <strong>Nazwa:</strong> ${order.orderName}<br>
                        <strong>Opis:</strong> ${order.orderDescription}<br>
                        <strong>Wartość:</strong> ${order.orderValue} PLN
                    `;

                    li.addEventListener('click', () => {
                        //li.style.cursor = "pointer";
                        window.location.href = `EditOrder.html?id=${order.orderID}`;
                    });

                    orderList.appendChild(li);
                });
            }
        })
        .catch(error => {
            console.error("Błąd:", error);
            const noOrdersElement = document.getElementById("no-orders");
            if (noOrdersElement) {
                noOrdersElement.style.display = "block";
            }
        });

}

function addOrder() {
    const orderedBy = document.getElementById("ordered-by").value;
    const orderName = document.getElementById("order-name").value;
    const orderDescription = document.getElementById("order-description").value;
    const orderValue = parseFloat(document.getElementById("order-value").value);

    if (!orderedBy || !orderName || !orderDescription || isNaN(orderValue)) {
        alert("Proszę uzupełnić wszystkie pola.");
        return;
    }

    const order = {
        orderedBy: {
            customerID: orderedBy
        },
        orderName: orderName,
        orderDescription: orderDescription,
        orderValue: orderValue
    };

    fetch('http://localhost:8080/postOrder', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(order)
    })
        .then(response => response.json())
        .then(() => fetchOrders())
        .catch((error) => {
            console.error('Błąd:', error);
            alert('Wystąpił błąd podczas dodawania zamówienia.');
        });
}

function deleteOrder() {
    const id = document.getElementById("order-id").value;
    fetch(`${API_URL}/deleteOrder/${id}`, { method: "DELETE" })
        .then(() => fetchOrders())
        .catch(error => console.error("Błąd:", error));
}





