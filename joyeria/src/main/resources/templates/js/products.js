
function addProductCard(prd) {
    const productsContainer = document.getElementById('product-container')

    console.log(prd)
        productsContainer.innerHTML += `
            <div class="col">
                <div class="card h-100 product-card">
                    <span class="position-absolute top-0 start-0 badge bg-primary m-2">HOT</span>
                        <img src="/img/products/${prd}" class="card-img-top product-image original-img" alt="Chicago Hoops">
                        <img src="/img/products/alt.png" class="card-img-top product-img-hover" alt="Chicago Hoops Hover">
                        <div class="card-body" style="background-color: #F6F0EE;">
                            <h5 class="card-title">HOPE ESMERALDA</h5>
                            <p class="card-text">40.00$ – 60.00$</p>
                        </div>
                        <button class="btn btn-link position-absolute top-0 end-0 m-2">
                            <i class="bi bi-heart"></i>
                        </button>
                    </div>
                </div>
            </div>
        `

}

async function showProducts() {
    const response = await fetch('http://localhost:8080/images')
    const products = await response.json()
    products.map(prd => addProductCard(prd));
}

document.addEventListener('DOMContentLoaded', async () => {
    await showProducts()
})
