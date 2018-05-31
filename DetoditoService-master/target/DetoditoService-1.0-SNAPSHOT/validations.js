/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function ValidateLogin() {
    return (ValidateUsername() && ValidatePassword());
}
function ValidateUsername() {
    if (document.getElementById("txUsuarioLogin").value === "") {
        document.getElementById("validateUsername").innerHTML = "This field is required";
    } else {
        document.getElementById("validateUsername").innerHTML = "";
        return true;
    }
    return false;
}
function ValidatePassword() {
    if (document.getElementById("txtPassLogin").value === "") {
        document.getElementById("validatePassword").innerHTML = "This field is required";
    } else {
        document.getElementById("validatePassword").innerHTML = "";
        return true;
      }
    return false;
}

function ValidateRegisterService() {
    return (ValidateRegisterDNI());
}
function ValidateRegisterDNI() {
      
    var dni = $('#txtCodigoDocumento').val() ;                 
    if(dni.length !== 8 || dni === "00000000" || (parseInt(dni)%1) !== 0) {
       alert('El campo debe contener solo 8 dígitos , ser mayor a cero y ser entero');
       $('#txtCodigoDocumento').val("");
       return false;
    }else {
        document.getElementById("validateDni").innerHTML = "";
        return true;
      }         
    return false;
    
}
