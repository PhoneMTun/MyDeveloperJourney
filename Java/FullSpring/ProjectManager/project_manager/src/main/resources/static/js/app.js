
console.log("app.js loaded")
const inputFields = document.querySelectorAll('.inputs input');
    inputFields.forEach(input => {
        input.addEventListener('mouseover', () => {
            input.style.backgroundColor = "#f7f7f7";  
        });
        input.addEventListener('mouseout', () => {
            input.style.backgroundColor = "#ffffff";  
        });
    });


    inputFields.forEach(input => {
        input.addEventListener('blur', () => {
            if (!input.value.trim()) {
                input.style.borderColor = "red";  
                input.placeholder = "This field is required!";
            } else {
                input.style.borderColor = "#ccc";  
            }
        });
    });
