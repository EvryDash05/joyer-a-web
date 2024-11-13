const productsContainer = document.getElementById('products-container')
const cart = JSON.parse(localStorage.getItem('cart')) || []

function showCartProducts() {
    cart.map(p => insertProductsIntoHTML(p))
}

function insertProductsIntoHTML(product) {
    productsContainer.innerHTML += `
        <div class="card mb-3">
            <div class="card-body">
                <div class="row">
                    <div class="col-md-2">
                        <img src="data:image/*;base64,${product.img}" class="img-fluid rounded" alt="Joyita :u">
                    </div>
                    <div class="col-md-6">
                        <h5 class="card-title">Nombre: ${product.productName}</h5>
                        <p class="card-text">Cantidad: ${product.quantity}</p>
                    </div>
                    <div class="col-md-2 text-end">
                        <p class="fw-bold">Subtotal: S/.${product.subtotal}</p>
                        <p class="fw-bold">Precio Total: S/.${product.price}</p>
                        <button class="btn btn-sm btn-outline-danger">Eliminar</button>
                    </div>
                </div>
            </div>
        </div>
    `
}

function showPayment(){
    const subtotal = cart.map(p => p.price)
        .reduce((subtotal, price) =>  subtotal + price, 0)
    const total = subtotal + 10

    document.getElementById("total").innerHTML = total
    document.getElementById("subtotal").innerHTML = subtotal
}

function goToProducts(){
    window.location.href = '/front/products'
}

function goToPayment(){
    window.location.href = '/front/payment'
}

document.addEventListener('DOMContentLoaded', e => {
    showCartProducts()
    showPayment()
})
