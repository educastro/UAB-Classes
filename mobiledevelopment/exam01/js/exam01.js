function calculateLoan() {
     var balance = parseFloat(document.getElementById("loanAmount").value);
     var yearlyLoanInterestRate = parseFloat(document.getElementById("yearlyLoanInterestRate").value);
     var termOfTheLoanInYears = parseFloat(document.getElementById("termOfTheLoanInYears").value);

     var termOfTheLoanInMonths = termOfTheLoanInYears * 12;
     var totalLoanAmount = balance * yearlyLoanInterestRate * termOfTheLoanInYears;
     var rate = yearlyLoanInterestRate / 1200;
     var monthlyPayment = (rate + (rate/(Math.pow((1 + rate), termOfTheLoanInMonths) - 1))) * balance; 

     // Defines the initial structure for a table
     var resultTable = "<br><table border=1><tr><th>Month</th><th>Beggining Loan Amount</th><th>Monthly Payment</th><th>Amount Paid to Principal</th><th>Amount Paid to Interest</th><th>Ending Loan Amount</th></tr>"
     
     // Iterates to create the rest of the table following the quantity of expected meetings
     for(var count = 1; count <= termOfTheLoanInMonths; count++){
          // Calculates the next meeting date
          var amountPaidToInterest = balance * rate;
          var amountPaidToPrincipal = monthlyPayment - amountPaidToInterest;

          // Creates the line with the next meeting date
          resultTable += "<tr><td>" + count + "</td><td>" + balance.toFixed(2) + "</td><td>" + monthlyPayment.toFixed(2) + "</td><td>" + amountPaidToPrincipal.toFixed(2) + "</td><td>" + amountPaidToInterest.toFixed(2) + "</td>";

          balance = balance - amountPaidToPrincipal;
          if(balance < 0){
               balance = 0;
          }

          resultTable += "<td>" + balance.toFixed(2) + "</td></tr>";
     }

     // Closes the table
     resultTable += "</table>";

     // Inserts the table as HTML code inside the outputTableWithDates div
     document.getElementById("outputTable").innerHTML = resultTable;
}	
