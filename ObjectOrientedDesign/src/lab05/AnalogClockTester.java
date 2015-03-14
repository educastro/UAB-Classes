package lab05;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class AnalogClockTester {

	public static void main(String[] args) {
		JFrame frame = new JFrame(); // initializing the frame
		AnalogClockIcon icon = new AnalogClockIcon(120, 40, 60, 70); // instantiating
																		// the
																		// AnalogClockIcon
																		// object

		final JLabel jLabel = new JLabel(icon);// adding clock as icon to the
												// label
		frame.setLayout(new FlowLayout());
		frame.add(jLabel); // adding the label to frame

		// the time object for calling the action listener in 1000 milliseconds
		// i.e. at each second
		Timer timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jLabel.repaint();
			}
		});
		// start the timer that triggers the action listener each 1 second
		timer.start();

		// setting some properties for the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
