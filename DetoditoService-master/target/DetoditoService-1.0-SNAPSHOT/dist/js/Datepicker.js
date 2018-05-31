/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    var today = new Date();
    var TWeek = new Date(today.getTime()+(24*60*60*1000)*14);
    var dd = today.getDate();
    var mm = today.getMonth()+1; 
    var yyyy = today.getFullYear();
    if(dd<10){
        dd='0'+dd;
    } 
    if(mm<10){
        mm='0'+mm;
    } 
    today = yyyy+'-'+mm+'-'+dd;
    var Tdd = TWeek.getDate();
    var Tmm = TWeek.getMonth()+1;
    var Tyy = TWeek.getFullYear();
    
    if(Tdd<10){
        Tdd='0'+Tdd;
    } 
    if(Tmm<10){
        Tmm='0'+Tmm;
    } 
    var TwoWeek = Tyy+'-'+Tmm+'-'+Tdd;
    document.getElementById("datepicker").setAttribute("min", today);
    document.getElementById("datepicker").setAttribute("max", TwoWeek);

    
});
