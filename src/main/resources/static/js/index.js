var confirmButton = document.getElementById("confirm");
confirmButton.onclick = function(){
    console.log("test");
    var userResponse = confirm('Here is our confirm box!')
    var display = document.getElementById('confirmResponse')
    var displayMessage = '';
    if (userResponse) {
        displayMessage += "you  clicked OK!";
    } else {
        displayMessage += "you  clicked Cancel!";
    }

    display.innerHTML = displayMessage;
};