function calculatePayAmount() {
     var workedHoursDuringWeek = parseFloat(document.getElementById("workedHoursDuringWeek").value);
     var hourlyPayRate = parseFloat(document.getElementById("hourlyPayRate").value);
     var overtimeHourlyPayRate = hourlyPayRate * 1.5;
     var regularPay = 0;
     var overTimePay = 0;
     var totalAmountToBePay = 0;

     regularPay = workedHoursDuringWeek * hourlyPayRate;

     if(workedHoursDuringWeek > 40){
          regularPay = hourlyPayRate * 40;
          var overTimeHour = workedHoursDuringWeek - 40;
          overTimePay = overtimeHourlyPayRate * overTimeHour;
          overTimePay = parseFloat(overTimePay.toFixed(2));
     } 

     regularPay = parseFloat(regularPay.toFixed(2));
     totalAmountToBePay = regularPay + overTimePay;
     totalAmountToBePay = parseFloat(totalAmountToBePay.toFixed(2));

     var outputPersonalInformation = '<h3>Personal Information Output</h3>' + '<p>' + document.getElementById("salutation").value + " " + document.getElementById("firstName").value + " " + document.getElementById("lastName").value + '<br>' + document.getElementById("streetAddress").value + '<br>' + document.getElementById("city").value + " - " + document.getElementById("state").value + " - " + document.getElementById("zipCode").value + '</p>';

     var outputPayment = '<h3>Payment Information Output</h3>' + '<p>' + "Regular Pay: $" + regularPay + '<br>' + "Overtime Pay: $" + overTimePay + '<br>' + "Total Pay: $" + totalAmountToBePay + '</p>';

     document.getElementById("outputPersonalInformation").innerHTML =  outputPersonalInformation;
     document.getElementById("outputPayment").innerHTML =  outputPayment;
}	
