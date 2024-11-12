
const ENDPOINT_REGISTER_PRODUCT = 'http://localhost:8080/v1/api/createProduct';

document.querySelector('#product-form').addEventListener('submit', async (e) => {
    e.preventDefault();

    const formData = new FormData();

    const data = {
        name: e.target.name.value,
        description: e.target.description.value,
        price: e.target.price.value,
        quantity: e.target.quantity.value
    };
    formData.append("product", JSON.stringify(data));

    const imgFile = e.target.img.files[0];
    formData.append("img", imgFile);

    try {
        const response = await fetch(ENDPOINT_REGISTER_PRODUCT, {
            method: 'POST',
            body: formData
        });

        if (response.ok) {
            document.getElementById('product-form').reset()
            console.log("Producto creado");
        } else {
            console.log("Error al crear el producto");
        }
    } catch (error) {
        console.error("Error en la solicitud:", error);
    }
});
