import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;



public class gameGUI implements Runnable{
	
	
	static JFrame frame;
	int myX = 80;
	int myY = 400;
	Canvas canvas;
	BufferStrategy bufferStrategy;
	boolean running = true;
	
	public gameGUI() {
		frame = new JFrame("Prototype of Game");
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setPreferredSize(new Dimension(500, 500));
		panel.setLayout(null);
		canvas = new Canvas();
		canvas.setBounds(0, 0, 500, 500);
		
		JOptionPane.showMessageDialog(null,"Your friend came out to you as bisexual, how do you react?\n"+
				"a. Tell your other friends about it because they also deserve to know\n"+
				"b. Say that what they did was very brave and you will always support them\n"+
				"c. Questions their sexuality (Are you sure you’re bi? You act straight.)");
		String x = (JOptionPane.showInputDialog(null, "Input Answer "));
		if (x.equals("b")) {
			JOptionPane.showMessageDialog(null,"Good job!");
		}else {
			JOptionPane.showMessageDialog(null,"The was not the right thing to do was to\n"+
		"Say that what they did was very brave and you will always support them\n"+
		"because they put themselves in a vulnerable situation and should have your encouragement");
		}
		
		
		canvas.setIgnoreRepaint(true);
		panel.add(canvas);
		canvas.addKeyListener(new KeyAdapter() {
		
		@Override
		public void keyPressed(KeyEvent evt) {
		moveIt(evt);
		}
		
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		canvas.createBufferStrategy(2);
		bufferStrategy = canvas.getBufferStrategy();
		canvas.requestFocus();
		
		
	}
	
	
	
	
	public void run() {
		while (running) {
			Paint();
			
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
			}
		}
	}

	public static void main(String[] args) {
		
		gameGUI ex = new gameGUI();
		new Thread(ex).start();
		

	}
	
	
	
	public void Paint() {	
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		g.clearRect(0, 0, 500, 500);
		Paint(g);
		bufferStrategy.show();
	}

	protected void Paint(Graphics2D g) {
		g.fillOval(myX, myY, 50, 50);
	}
	
	public void moveIt(KeyEvent evt) {
	switch (evt.getKeyCode()) {
		case KeyEvent.VK_DOWN:
		myY += 5;
		break;
		case KeyEvent.VK_UP:
		myY -= 5;
		break;
		case KeyEvent.VK_LEFT:
		myX -= 5;
		break;
		case KeyEvent.VK_RIGHT:
		myX += 5;
		break;
		}
	}

	

}
