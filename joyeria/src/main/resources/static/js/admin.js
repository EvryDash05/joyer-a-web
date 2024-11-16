const sessionInfo = JSON.parse(localStorage.getItem("customerData"));
const {customerId, username, token, roles} = sessionInfo;
const role = roles[0]

function loadInfo() {
    document.getElementById("user-name").innerHTML = `Hola: ${username}`;
}

document.getElementById('options').addEventListener('click', (e) => {
    const clickedItem = e.target;
    if(role.includes('ADMIN')){
        if (clickedItem.tagName === 'A') {
            const option = clickedItem.textContent
            switch (option) {
                case 'Ventas':
                    window.location.href = '/front/pedidoAdmin'
                    break;
                case 'Productos':
                    window.location.href = '/front/productsAdmin'
                    break;
                case 'Pedidos':
                    window.location.href = '/front/ordersAdmin'
                    break;
            }
        }
    }
})

document.addEventListener('DOMContentLoaded', () => {
    loadInfo();
})