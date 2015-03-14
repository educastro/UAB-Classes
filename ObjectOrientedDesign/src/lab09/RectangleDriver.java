package lab09;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class RectangleDriver {
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		JFrame jframe = new JFrame("Lab 7");
		jframe.setLayout(new FlowLayout());
		
		final LabeledRectangle rectangle = new LabeledRectangle(200, 210, 100, 30, "Hello World!!");
		
		JComponent jComponent = new JComponent() {
			public void paintComponent(Graphics g){
				rectangle.draw(g);
			}
		};
		
		jComponent.setPreferredSize(new Dimension(500,500));
		
		jframe.add(jComponent);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.pack();
		jframe.setVisible(true);
	}
}
