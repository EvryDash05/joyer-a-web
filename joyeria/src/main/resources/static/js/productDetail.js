const cart = JSON.parse(localStorage.getItem('cart')) || []
const path = window.location.pathname
const productId = path.split('/').pop()

async function showProductDetail() {
    const END_POINT_PRODUCT_DETAIL = `http://localhost:8080/v1/api/getProductById/${productId}`;

    const response = await fetch(END_POINT_PRODUCT_DETAIL)
    const data = await response.json()
    console.log(data)
    insertDataIntoHTML(data)
}

function insertDataIntoHTML(product) {
    const base64Image = `data:image/*;base64,${product.img}`;
    document.getElementById('product-img').src = base64Image;
    document.getElementById('titleArticulo').innerText = product.name
    document.getElementById('price').innerText = `Precio: ${product.price}`;
    document.getElementById('description').innerText = `Descripción: ${product.description}`;
    document.getElementById('stock').innerText = `Stock: ${product.stock}`;
}

function createProductObject() {
    const productName = document.getElementById('titleArticulo').textContent
    const subtotal = document.getElementById('price').textContent.split(' ').pop()
    const price = Number(document.getElementById('price').textContent.split(' ').pop())
    const img = document.getElementById('product-img').src.split(',').pop()
    return {productId, productName, subtotal, price, quantity: 1, img}
}

function addProductCard() {

    const selectProduct = createProductObject()
    const findProduct = cart.find(p => p.productId === selectProduct.productId)

    if (findProduct) {
        findProduct.quantity += 1
        findProduct.price = selectProduct.price * findProduct.quantity
    } else {
        cart.push(selectProduct);
    }

    console.log(cart)
    localStorage.setItem('cart', JSON.stringify(cart))
    alert("Producto agregado al carrito")
}


document.addEventListener('DOMContentLoaded', async e => {
    await showProductDetail();
})
