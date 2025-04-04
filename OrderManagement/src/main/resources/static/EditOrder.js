const API_URL = "http://localhost:8080";

const urlParams = new URLSearchParams(window.location.search);
const orderID = urlParams.get("id");

if (!orderID) {
    alert("Błąd: Brak ID zamówienia.");
    window.history.back();
} else {
    fetchOrderDetails(orderID);
}

function fetchOrderDetails(orderID) {
    fetch(`${API_URL}/orders/${orderID}`)
        .then(response => {
            if (!response.ok) throw new Error("Błąd pobierania zamówienia.");
            return response.json();
        })
        .then(order => {

            // Showing data on the site
            document.getElementById("order-id-display").textContent = order.orderID;
            document.getElementById("ordered-by-display").textContent =
                `Zamówione przez (ID): ${order.orderedBy.customerID}, Imię: ${order.orderedBy.name}, Nazwisko: ${order.orderedBy.surname}`;
            document.getElementById("order-name-display").textContent = order.orderName;
            document.getElementById("order-description-display").textContent = order.orderDescription;
            document.getElementById("order-value-display").textContent = order.orderValue;

            // Setting a values to the forms
            document.getElementById("order-id").value = order.orderID;
            document.getElementById("ordered-by").value = order.orderedBy.customerID;
            document.getElementById("ordered-by-name").value = order.orderedBy.name;
            document.getElementById("ordered-by-surname").value = order.orderedBy.surname;
            document.getElementById("order-name").value = order.orderName;
            document.getElementById("order-description").value = order.orderDescription;
            document.getElementById("order-value").value = order.orderValue;
        })
        .catch(error => {
            console.error("Błąd:", error);
            alert("Nie udało się pobrać zamówienia.");
            window.history.back();
        });
}

document.getElementById("order-form").addEventListener("submit", function(event) {
    event.preventDefault();

    const updatedOrder = {
        orderID: parseInt(document.getElementById("order-id").value),
        orderedBy: {
            customerID: parseInt(document.getElementById("ordered-by").value),
            name: document.getElementById("ordered-by-name").value,
            surname: document.getElementById("ordered-by-surname").value
        },
        orderName: document.getElementById("order-name").value,
        orderDescription: document.getElementById("order-description").value,
        orderValue: parseFloat(document.getElementById("order-value").value)
    };


    fetch(`${API_URL}/editOrder`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(updatedOrder)
    })
        .then(response => {
            if (!response.ok) throw new Error("Błąd aktualizacji zamówienia");
            return response.json();
        })
        .then(() => {
            alert("Zamówienie zostało zaktualizowane!");
            window.location.href = `OrderManagement.html`;
        })
        .catch(error => {
            console.error("Błąd:", error);
            alert("Wystąpił problem z aktualizacją zamówienia.");
        });
});
