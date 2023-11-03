/**
 * 
 */
console.log("app.js loaded")
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