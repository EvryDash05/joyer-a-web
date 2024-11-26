const ENDPOINT_GET_PAYMENTS = 'http://localhost:8080/v1/api/getAllPayments';
const ENDPOINT_EDIT_PAYMENT = 'http://localhost:8080/v1/api/updatePayment/';
const ENDPOINT_DELETE_PAYMENT = 'http://localhost:8080/v1/api/deletePayment/';
const sessionInfo = JSON.parse(localStorage.getItem('customerData'));
const {token} = sessionInfo;

// JavaScript para cargar los pagos desde el servidor y actualizar la tabla
async function loadPayments() {
    try {
        const response = await fetch(ENDPOINT_GET_PAYMENTS, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            }
        });
        if (!response.ok) {
            throw new Error('Error al obtener los pagos');
        }
        const payments = await response.json();

        console.log(payments);

        const tableBody = document.getElementById('paymentsTableBody');
        tableBody.innerHTML = ''; // Limpiar tabla antes de cargar nuevos datos

        payments.forEach(payment => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${payment.payment_id}</td>
                <td>${payment.customer_id}</td>
                <td>${payment.paymentDate}</td>
                <td>${payment.payment_method}</td>
                <td>S/ ${parseFloat(payment.amount).toFixed(2)}</td>
                <td>
                    <button class="btn btn-warning btn-sm" onclick="openEditModal('${payment.payment_id}', '${payment.customer_id}', '${payment.payment_date}', '${payment.payment_method}', ${payment.amount})">Editar</button>
                    <button class="btn btn-danger btn-sm" onclick="deletePayment('${payment.payment_id}')">Eliminar</button>
                </td>
            `;
            tableBody.appendChild(row);
        });
    } catch (error) {
        console.error('Error al cargar los pagos:', error);
    }
}

// Abrir el modal para editar un pago
function openEditModal(paymentId, customerId, paymentDate, paymentMethod, amount) {
    document.getElementById('editPaymentId').value = paymentId;
    document.getElementById('editCustomerId').value = customerId;
    document.getElementById('editPaymentDate').value = paymentDate;
    document.getElementById('editPaymentMethod').value = paymentMethod;
    document.getElementById('editAmount').value = parseFloat(amount).toFixed(2);
    new bootstrap.Modal(document.getElementById('editPaymentModal')).show();
}

// Manejar la edición de un pago
document.getElementById('editPaymentForm').addEventListener('submit', async (e) => {
    e.preventDefault();
    const paymentId = document.getElementById('editPaymentId').value;
    const data = Object.fromEntries(new FormData(e.target));

    try {
        const response = await fetch(ENDPOINT_EDIT_PAYMENT + paymentId, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({...data, payment_id: paymentId})
        });

        if (response.ok) {
            alert('Pago editado con éxito');
            new bootstrap.Modal(document.getElementById('editPaymentModal')).hide();
            loadPayments();
        } else {
            alert('Error al editar el pago');
        }
    } catch (error) {
        console.error('Error al editar el pago:', error);
    }
});

// Manejar la eliminación de un pago
async function deletePayment(paymentId) {
    if (confirm('¿Está seguro de que desea eliminar este pago?')) {
        try {
            const response = await fetch(ENDPOINT_DELETE_PAYMENT + paymentId, {
                method: 'DELETE'
            });

            if (response.ok) {
                alert('Pago eliminado con éxito');
                loadPayments();
            } else {
                alert('Error al eliminar el pago');
            }
        } catch (error) {
            console.error('Error al eliminar el pago:', error);
        }
    }
}

// Cargar los pagos al cargar la página
window.onload = loadPayments;