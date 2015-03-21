function calculateNextDay() {
	// Get date and assign it to the following variable
	var initialMeetingDate = new Date(document.getElementById("initialMeetingDate").value); 
	// Get the number of days between meetings and assign it to the following variable
	var numberOfDaysBetweenMeetings = parseInt(document.getElementById("numberOfDaysBetweenMeetings").value);
	// Get the number of meetings and assign it to the following variable
	var numberOfFollowingMeetings = parseInt(document.getElementById("numberOfFollowingMeetings").value);
	// Defines the initial structure for a table
	var resultTable = "<br><table border=1><tr><th>Meeting Number</th><th>Meeting Date</th></tr>"
	
	// Creates the first line of the table
	resultTable += "<tr><td>1</td><td>" + initialMeetingDate.toDateString() + "</td></tr>";

	// Iterates to create the rest of the table following the quantity of expected meetings
	for(var count = 2; count <= numberOfFollowingMeetings; count++){
		// Calculates the next meeting date
		initialMeetingDate.setDate(initialMeetingDate.getDate() + numberOfDaysBetweenMeetings);
		// Creates the line with the next meeting date
		resultTable += "<tr><td>" + count + "</td><td>" + initialMeetingDate.toDateString() + "</td></tr>";
	}

	// Closes the table
	resultTable += "</table>";

	// Inserts the table as HTML code inside the outputTableWithDates div
	document.getElementById("outputTableWithDates").innerHTML = resultTable;
}