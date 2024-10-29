const customerData = JSON.parse(localStorage.getItem("customerData"));
console.log(customerData)

function logout() {
    console.log(localStorage.getItem("customerData"));
    localStorage.removeItem('customerData');
    window.location.href = "/login";
}

function showCustomerData() {
    if(customerData){
        //document.getElementById("#first_name").value = customerData.name;
        document.getElementById("#last_name").value = customerData.lastName;
        document.getElementById("#display_name").value = customerData.name;
        document.getElementById("#email").value = customerData.email;
    }
}

document.addEventListener("DOMContentLoaded", e => {
    showCustomerData();
});
