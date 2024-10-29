const ENDPOINT_REGISTER_USER = 'http://localhost:8080/v1/api/register';

document.querySelector('#login-form').addEventListener('submit', async (e) => {
    e.preventDefault();
    const data = Object.fromEntries(
        new FormData(e.target)
    );
    console.log(data);

    try {
        const response = await fetch(ENDPOINT_REGISTER_USER, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })

        if (response.ok) {
            alert("User created successfully");
        } else {
            alert("Error to create a user")
        }

    } catch (e) {
        console.error(e);
    }

})


