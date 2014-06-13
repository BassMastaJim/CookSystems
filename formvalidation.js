function init() {
   // make sure the page has loaded before displaying the submit button
   var submitButton = document.getElementById("submit").style.visibility = "visible";

}

function onSubmit() {
   var first = document.getElementById("fname").value;
   var last = document.getElementById("lname").value;
   var gender; // declare now, set value later for error handling
   var address = document.getElementById("address").value;
   var city = document.getElementById("city").value;
   var state = document.getElementById("state").value;

   // check values of all elements. If any information is missing, display error
   if(first == null || first.length == 0) {
      alert("First name is not valid");
   } else if (last == null || last.length == 0) {
      alert("Last name is not valid");
   } else if(address == null || address.length == 0) {
      alert("Address is not valid");
   } else if (city == null || city.length == 0) {
      alert("City is not valid");
   } else if (state == null || state.length == 0) {
      alert("State is not valid");
   } else {
      // check to make sure the gender element exists before declaring it, 
      // hiding the potential null error from the user
      if (document.getElementById("sex")) {
        gender = document.getElementById("sex").value;
        alert("Information received, thank you!");
      } else {
        alert("Gender must be selected");
      }
   }
}

// make some JQuery magik
$(document).ready(function(){
   $("input").focus(function() {
      $(this).addClass("highlight")
   });
   $("input").blur(function() {
      $(this).removeClass("highlight")
   });
});
