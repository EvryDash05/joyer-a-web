function addProducts(img) {

    const container = document.getElementById("container-best-sellers")

        container.innerHTML += `<div class="col">
                            <div class="card h-100 border-0 product-card">
                                <div class="position-relative">
                                    <img src="${img}" class="card-img-top product-image" alt="WATER BRACELET">
                                    <span class="position-absolute top-0 start-0 bg-danger text-white px-2 py-1 m-2 rounded-pill">-60%</span>
                                    <div class="product-overlay">
                                        <button class="btn btn-light rounded-circle me-2" aria-label="Quick view">
                                            <i class="bi bi-search"></i>
                                        </button>
                                        <button class="btn btn-light rounded-circle" aria-label="Add to wishlist">
                                            <i class="bi bi-heart"></i>
                                        </button>
                                    </div>
                                </div>
                                <div class="card-body text-center">
                                    <h5 class="card-title">WATER BRACELET</h5>
                                    <p class="card-text">
                                        <span class="text-danger">20.00$ - 40.00$</span>
                                    </p>
                                </div>
                            </div>
                        </div>
        `
}

function showProducts(){
    const images = ['/img/products/anillo_1.png', '/img/products/anillo_2.png', '/img/products/anillo_4.png', "/img/products/anillo_5.png"]
    images.map(img => addProducts(img))
}

showProducts()
