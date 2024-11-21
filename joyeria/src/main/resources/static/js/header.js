const sessionInfo = JSON.parse(localStorage.getItem("customerData")) || {};
const roles = sessionInfo.roles || []

function toRegisterOrCustomerData() {
    if (roles.includes('USER')) {
        window.location.href = '/front/customerData'
    } else if (roles.includes('ADMIN')) {
        window.location.href = '/front/admin'
    } else {
        window.location.href = '/front/register'
    }
}

function toShoppingCart() {
    if (roles.includes('USER') || roles.includes('ADMIN')) {
        window.location.href = '/front/shoppingCart'
    } else {
        window.location.href = '/front/register'
    }
}
