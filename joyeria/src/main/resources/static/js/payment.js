const addresses = JSON.parse(localStorage.getItem('addresses')) || []
const cart = JSON.parse(localStorage.getItem('cart')) || []
const sessionInfo = JSON.parse(localStorage.getItem('customerData'))
const REGISTER_ADDRESS_ENDPOINT = 'http://localhost:8080/v1/api/registerShipment'
const PROCESS_ORDER_ENDPOINT = 'http://localhost:8080/v1/api/processOrder'
const CUSTOMER_SHIPMENTS_ENDPOINT = 'http://localhost:8080/v1/api/findShipmentListByCustomerId/'

//Variables of purchase info
const subtotal = cart.map(p => p.price)
    .reduce((subtotal, price) => subtotal + price, 0)
const total = subtotal + 10
const totalProducts = cart.map(p => p.quantity)
    .reduce((total, quantity) => total + quantity, 0)

function showShipmentModal() {
    const modal = `
        <div class="modal fade" id="formModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Contáctanos</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <!-- Formulario -->
                            <div class="col-md-6">
                                <form id="addressForm">
                                    <div class="mb-3">
                                        <label for="address" class="form-label">Dirección: </label>
                                        <input type="text" class="form-control" id="address" name="address" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="city" class="form-label">Ciudad: </label>
                                        <input type="text" class="form-control" id="city" name="city" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="zipCode" class="form-label">Código postal: </label>
                                        <input class="form-control" id="zipCode" name="zipCode" required>
                                    </div>
                                    <button type="submit" class="btn btn-primary" onclick="addAddress()">Agregar dirección</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    `

    document.body.insertAdjacentHTML('beforeend', modal);

    const dynamicModal = new bootstrap.Modal(document.getElementById('formModal'))
    dynamicModal.show()
}

async function registerAddress(address) {
    const response = await fetch(REGISTER_ADDRESS_ENDPOINT, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            ...address,
            email: sessionInfo.email
        })
    }).catch(e => {
        console.log(e)
    })

    if (response.ok) {
        console.log(response.body)
    }

}

function getCartProducts() {
    return cart.map(product => ({
        productId: product.productId,
        quantity: product.quantity,
        price: product.price,
        unitPrice: product.unitPrice
    }))
}

async function processPurchase() {
    const shipmentId = document.getElementById('address-options').value
    const paymentMethod = document.getElementById('payment-methods').value
    const cartProducts = getCartProducts()
    const date = new Date().toISOString()

    const response = await fetch(PROCESS_ORDER_ENDPOINT, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            email: sessionInfo.email,
            shipmentId: shipmentId,
            paymentRequest: {
                email: sessionInfo.email,
                paymentDate: date,
                paymentMethod: paymentMethod
            },
            orderDate: date,
            items: cartProducts
        })
    }).catch(e => console.log(e))

    if (response.ok) {
        alert('Compra exitosa')
        window.location.href = '/front/home'
    }

}

function addAddress() {
    document.getElementById('addressForm').addEventListener('submit', async e => {
        e.preventDefault()
        const address = Object.fromEntries(new FormData(e.target))
        await registerAddress(address)
        addresses.push(address)
        localStorage.setItem('addresses', JSON.stringify(addresses))
    })
}

async function addAddressesOptions() {
    const {customerId} = sessionInfo
    const response = await fetch(CUSTOMER_SHIPMENTS_ENDPOINT + customerId)
    const addresses = await response.json()
    const addressesOptions = document.getElementById('address-options')
    addressesOptions.innerHTML = ''
    console.log(addresses)
    addresses.forEach((address) => {
        addressesOptions.innerHTML += `
                <option value="${address.shipmentId}">${address.address}</option>
        `
    })
}

function showPurchaseInfo() {
    document.getElementById("quantity").innerHTML = `Artículos: ${totalProducts}`
    document.getElementById("total").innerHTML = `S/.${total}.00`
    document.getElementById("subtotal").innerHTML = `S/.${subtotal}.00`
}

document.addEventListener('DOMContentLoaded', async e => {
    await addAddressesOptions()
    showPurchaseInfo()
})

