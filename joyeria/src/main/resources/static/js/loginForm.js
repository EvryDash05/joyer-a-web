const ENDPOINT_REGISTER_USER = 'http://localhost:8080/v1/api/auth/login'

document.querySelector('#login-form').addEventListener('submit', async (e) => {
    e.preventDefault();
    const data = Object.fromEntries(new FormData(e.target))

    try {
        const response = await fetch(ENDPOINT_REGISTER_USER, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })

        if (response.ok) {
            const customerData = await response.json();

            localStorage.setItem('customerData', JSON.stringify(customerData));

            alert("Login successfully");

            window.location.href = "/front/products";
        } else {
            alert("Error to login")
        }

    } catch (e) {
        alert("Error to login")
        console.error(e)
    }

})
