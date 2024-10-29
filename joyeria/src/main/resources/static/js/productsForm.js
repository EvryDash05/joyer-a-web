
const ENDPOINT_REGISTER_PRODUCT = 'http://localhost:8080/v1/api/createProduct'

document.querySelector('#product-form').addEventListener('submit', async (e) => {
    e.preventDefault();

    const data = Object.fromEntries(new FormData(e.target));
    console.log(data);

    try {

        const response = await fetch(ENDPOINT_REGISTER_PRODUCT, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })

        console.log(response)
        alert("Product created successfully");
    } catch (e) {
        console.error(e);
        alert("Error to register a product")
    }

})
