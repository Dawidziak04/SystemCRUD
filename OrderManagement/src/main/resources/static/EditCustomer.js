// Still in development
const API_URL = "http://localhost:8080";

const urlParams = new URLSearchParams(window.location.search);
const customerID = urlParams.get("id");

if (!customerID) {
    alert("Błąd: Brak ID klienta.");
    window.history.back();
} else {
    fetchCustomerDetails(customerID);
}

function fetchCustomerDetails(customerID) {
    fetch(`${API_URL}/customers/${customerID}`)
        .then(response => {
            if (!response.ok) throw new Error("Błąd pobierania klienta.");
            return response.json();
        })
        .then(customer => {

            // Showing data on the site
            document.getElementById("customer-id-display").textContent = customer.customerID;
            document.getElementById("customer-name-display").textContent = customer.name;
            document.getElementById("customer-surname-display").textContent = customer.surname;

            // Setting values to the form
            document.getElementById("customer-id").value = customer.customerID;
            document.getElementById("customer-name").value = customer.name;
            document.getElementById("customer-surname").value = customer.surname;
        })
        .catch(error => {
            console.error("Błąd:", error);
            alert("Nie udało się pobrać klienta.");
            window.history.back();
        });
}

document.getElementById("customer-form").addEventListener("submit", function(event) {
    event.preventDefault();

    const updatedCustomer = {
        customerID: parseInt(document.getElementById("customer-id").value),
        name: document.getElementById("customer-name").value,
        surname: document.getElementById("customer-surname").value
    };

    fetch(`${API_URL}/editCustomer`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(updatedCustomer)
    })
        .then(response => {
            if (!response.ok) throw new Error("Błąd aktualizacji klienta");
            return response.json();
        })
        .then(() => {
            alert("Dane klienta zostały zaktualizowane!");
            window.history.back();
        })
        .catch(error => {
            console.error("Błąd:", error);
            alert("Wystąpił problem z aktualizacją klienta.");
        });
});

