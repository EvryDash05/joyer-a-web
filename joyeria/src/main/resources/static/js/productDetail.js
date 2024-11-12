async function showProductDetail() {
    const path = window.location.pathname
    const productId = path.split('/').pop()
    const END_POINT_PRODUCT_DETAIL = `http://localhost:8080/v1/api/getProductById/${productId}`;

    const response = await fetch(END_POINT_PRODUCT_DETAIL)
    const data = await response.json()
    console.log(data)
    insertDataIntoHTML(data)
}

function insertDataIntoHTML(product) {
    const base64Image = `data:image/*;base64,${product.img}`;
    document.getElementById('product-img').src = base64Image;
    document.getElementById('price').innerText = `Precio: ${product.price}`;
    document.getElementById('description').innerText = `Descripción: ${product.description}`;
    document.getElementById('stock').innerText = `Stock: ${product.stock}`;
}

document.addEventListener('DOMContentLoaded', async e => {
    await showProductDetail();
})
