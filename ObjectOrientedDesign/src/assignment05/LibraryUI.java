package assignment05;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;

public class LibraryUI {

	final static int FIELD_WIDTH = 20;
	static Library library = new Library();

	public static void main(String[] args){

		// Declaration for the frame
		JFrame frame = new JFrame();

		// Declaration for the buttons
		JButton newStudentButton = new JButton("New Student");
		JButton newBookButton = new JButton("New Book");
		JButton newDvdButton = new JButton("New Dvd");
		JButton newLoanButton = new JButton("New Loan");
		JButton seeStudentInfoButton = new JButton("See Student Information");

		// Defines what the newStudentButton will do if pressed
		newStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Calls the method that will create a new JFrame
				newStudentPanel();
			}
		});

		// Defines what the newBookButton will do if pressed
		newBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Calls the method that will create a new JFrame
				newBookPanel();
			}
		});

		// Defines what the newBookButton will do if pressed
		newDvdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Calls the method that will create a new JFrame
				newDvdPanel();
			}
		});

		// Defines what the newBookButton will do if pressed
		newLoanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Calls the method that will create a new JFrame
				newLoanPanel();
			}
		});

		// Defines what the seeStudentInfoButton will do if pressed
		seeStudentInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Calls the method that will create a new JFrame
				seeStudentPanel();
			}
		});

		// Sets the Layout for this frame
		frame.setLayout(new FlowLayout());

		// Add the following components
		frame.add(newStudentButton);
		frame.add(newBookButton);
		frame.add(newDvdButton);
		frame.add(newLoanButton);
		frame.add(seeStudentInfoButton);

		// Defines what the program should do if the close button is pressed
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.pack();

		// Sets the frame to visible state
		frame.setVisible(true);
	}

	public static void newLoanPanel() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("New Loan");
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Declaration for the buttons
		JButton okButton = new JButton("Save");
		JButton closeButton = new JButton("Close");

		Object[] studentList = library.getStudentList();
		JList listOfStudents = new JList(studentList);

		Object[] bookList = library.getBookList();
		JList listOfBooks = new JList(bookList);

		Object[] dvdList = library.getDvdList();
		JList listOfDvds= new JList(dvdList);

		frame.add(new JLabel("Students:"));
		frame.add(new JScrollPane(listOfStudents));

		frame.add(new JLabel("Books:"));
		frame.add(new JScrollPane(listOfBooks));

		frame.add(new JLabel("Dvds:"));
		frame.add(new JScrollPane(listOfDvds));

		// Adds buttons to the frame
		frame.add(okButton);
		frame.add(closeButton);

		// Defines what the okButton will do if pressed
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Collect data from the textfields and put it into variables
				String studentId = listOfStudents.getSelectedValue().toString();
				String itemId = listOfBooks.getSelectedValue().toString();

				// create a student into the library with the previous variables as parameters 
				try {
					library.checkOutItem(studentId, itemId);
					listOfBooks.clearSelection();
					listOfStudents.clearSelection();
				} catch (StudentNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BookLimitReachedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		// Defines what the closeButton will do if pressed
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Closes the frame but doesnt finish the program
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);	
	}		

	public static void seeStudentPanel() {
		// Declaration for the frame
		JFrame frame = new JFrame();

		// Declaration for the text area
		JTextArea studentInformationTextField = new JTextArea(20, 40);
		// Set the text for this component as the return from the listAllStudentsAsString. Basically shows a String.
		studentInformationTextField.setText(library.listAllStudentsAsString());

		// Declaration for the button
		JButton closeButton = new JButton("Close");

		// Defines the layout for the frame
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		// Add the components
		frame.add(new JLabel("Students:"));
		frame.add(studentInformationTextField);
		frame.add(closeButton);

		// Defines what the closeButton will do if pressed
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Closes the frame but doesnt finish the program
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);		
	}	

	public static void newDvdPanel() {
		// Declaration for the frame
		JFrame frame = new JFrame();

		// Declaration for the text fields
		JTextField titleTextField = new JTextField(FIELD_WIDTH);
		JTextField authorTextField = new JTextField(FIELD_WIDTH);


		// Declaration for the buttons
		JButton okButton = new JButton("Save");
		JButton closeButton = new JButton("Close");

		// Sets the layout
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		// Add a email label and puts its textfield to the frame
		frame.add(new JLabel("Title:"));
		frame.add(titleTextField);

		// Add an email label and puts its textfield to the frame
		frame.add(new JLabel("Author:"));
		frame.add(authorTextField);

		// Adds buttons to the frame
		frame.add(okButton);
		frame.add(closeButton);

		// Defines what the okButton will do if pressed
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Collect data from the textfields and put it into variables
				String title = titleTextField.getText();
				String author = authorTextField.getText();
				String category = "dvd";

				assert title != null && author != null && (category != "dvd" || category != "book")
						: "Precondition violation : invalid null data";

				// create a student into the library with the previous variables as parameters 
				try {
					library.addItem(title, author, category);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// erases the contents from all the textfields
				titleTextField.setText(null);
				authorTextField.setText(null);
			}
		});

		// Defines what the closeButton will do if pressed
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Closes the frame but doesnt finish the program
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);	
	}

	public static void newBookPanel() {
		// Declaration for the frame
		JFrame frame = new JFrame();

		// Declaration for the text fields
		JTextField titleTextField = new JTextField(FIELD_WIDTH);
		JTextField authorTextField = new JTextField(FIELD_WIDTH);


		// Declaration for the buttons
		JButton okButton = new JButton("Save");
		JButton closeButton = new JButton("Close");

		// Sets the layout
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		// Add a email label and puts its textfield to the frame
		frame.add(new JLabel("Title:"));
		frame.add(titleTextField);

		// Add an email label and puts its textfield to the frame
		frame.add(new JLabel("Author:"));
		frame.add(authorTextField);

		// Adds buttons to the frame
		frame.add(okButton);
		frame.add(closeButton);

		// Defines what the okButton will do if pressed
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Collect data from the textfields and put it into variables
				String title = titleTextField.getText();
				String author = authorTextField.getText();
				String category = "book";

				assert title != null && author != null && (category != "dvd" || category != "book")
						: "Precondition violation : invalid null data";

				// create a student into the library with the previous variables as parameters 
				try {
					library.addItem(title, author, category);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// erases the contents from all the textfields
				titleTextField.setText(null);
				authorTextField.setText(null);
			}
		});

		// Defines what the closeButton will do if pressed
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Closes the frame but doesnt finish the program
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);	
	}

	public static void newStudentPanel() {
		// Declaration for the frame
		JFrame frame = new JFrame();

		// Declaration for the text fields
		JTextField uidTextField = new JTextField(FIELD_WIDTH);
		JTextField nameTextField = new JTextField(FIELD_WIDTH);
		JTextField emailTextField = new JTextField(FIELD_WIDTH);
		JTextField classificationTextField = new JTextField(FIELD_WIDTH);

		// Declaration for the buttons
		JButton okButton = new JButton("Save");
		JButton closeButton = new JButton("Close");

		// Sets the layout
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		// Add an UID label and puts its textfield to the frame
		frame.add(new JLabel("UID:"));
		frame.add(uidTextField);

		// Add a email label and puts its textfield to the frame
		frame.add(new JLabel("Name:"));
		frame.add(nameTextField);

		// Add an email label and puts its textfield to the frame
		frame.add(new JLabel("Email:"));
		frame.add(emailTextField);

		// Add an classification label and puts its textfield to the frame
		frame.add(new JLabel("Classification:"));
		frame.add(classificationTextField);

		// Adds buttons to the frame
		frame.add(okButton);
		frame.add(closeButton);

		// Defines what the okButton will do if pressed
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Collect data from the textfields and put it into variables
				String uid = uidTextField.getText();
				String name = nameTextField.getText();
				String email = emailTextField.getText();
				String classification = classificationTextField.getText();
				
				if(classification == "undergraduate"){
					// create a student into the library with the previous variables as parameters 
					try {
						library.addStudent(uid, name, email, classification);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// erases the contents from all the textfields
					uidTextField.setText(null);
					emailTextField.setText(null);
					nameTextField.setText(null);
					classificationTextField.setText(null);
				}
			}

		});

		// Defines what the closeButton will do if pressed
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Closes the frame but doesnt finish the program
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);	
	}
}
