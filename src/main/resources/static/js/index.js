var confirmButton = document.getElementById("confirm");
confirmButton.onclick = function(){
  
     if (confirm('Select OK to continue')) {
        var display = document.getElementById('cancelButton')
     } else return false;

   
};