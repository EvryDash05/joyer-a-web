
function addProductCard(prd) {
    const productsContainer = document.getElementById('product-container')
        productsContainer.innerHTML += `
            <div class="col">
                <div class="card h-100 product-card">
                    <span class="position-absolute top-0 start-0 badge m-2" style="background-color: #12171b; color: #fff;">HOT</span>
                        <img src="data:image/*;base64,${prd.img}" class="card-img-top product-image original-img" alt="Chicago Hoops">
                        <img src="/img/products/alt.png" class="card-img-top product-img-hover" alt="Chicago Hoops Hover">
                        <div class="card-body" style="background-color: #F6F0EE;">
                            <h5 class="card-title">${prd.name}</h5>
                            <p id="product-id" class="card-text">${prd.productId}</p>
                            <p class="card-text">S/.${prd.price}</p>
                        </div>
                    </div>
                    <button class="btn btn-primary" onclick="showProductDetails('${prd.productId}')">Ver producto</button>
               </div>
            </div>
        `

}

function showProductDetails() {
    const productId = document.getElementById('product-id').innerText
    window.location.href = `/front/productDetail/${productId}`
}

async function showProducts() {
    const response = await fetch('http://localhost:8080/v1/api/getProducts');
    const products = await response.json()
    products.map(prd => addProductCard(prd));
}

document.addEventListener('DOMContentLoaded', async () => {
    await showProducts()
})
