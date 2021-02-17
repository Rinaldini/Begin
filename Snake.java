import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Snake
{
	int r = 20;
	int x = 350;
	int y = 250;
	int snakelength = 5;
	int[] xMass = new int[snakelength];
	int[] yMass = new int[snakelength];	
	int direction = 4;
	boolean move = true;
	int delay = 100;

	public static void main(String[] args)
	{
		Snake mysnake = new Snake();		// constructor, create the object
		mysnake.game();				// call the metod for the object
	}

	public void game()
	{
		JFrame frame = new JFrame("Snake");
		frame.setVisible(true);
		frame.setSize(700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyDrawPanel drawPanel = new MyDrawPanel();	
		drawPanel.setFocusTraversalKeysEnabled(false);
		frame.add(drawPanel);				// put the panel for drawing on frame
		xMass[0] = x;
		yMass[0] = y;
		for (int i = 1; i < snakelength; i++) {xMass[i] = xMass[0] - i*r; yMass[i] = yMass[0];};

		while (move)
		{				

			frame.addKeyListener(new KeyAdapter()		// enable KeyListener on frame (all kind of key events was realized in KeyAdapter)
			{
				public void keyPressed(KeyEvent e)	// 
				{
					switch (e.getKeyCode())
					{
						case KeyEvent.VK_UP: direction = 1; break;
						case KeyEvent.VK_DOWN: direction = 2; break;
						case KeyEvent.VK_LEFT: direction = 3; break;
						case KeyEvent.VK_RIGHT: direction = 4; break;
						case KeyEvent.VK_SPACE: move = false; break;
					}
				}
			});

			for (int i = snakelength - 1; i > 0; i--)
				{
					int temp = xMass[i - 1];
					xMass[i] = temp;
					temp = yMass[i - 1];
					yMass[i] = temp;
				}

			switch (direction)
			{
				case 1: yMass[0] -= r; if ((yMass[0] <= 0) ) {yMass[0] = frame.getHeight();}; break;
				case 2: yMass[0] += r; if (yMass[0] >= frame.getHeight()) {yMass[0] = 0;}; break;
				case 3: xMass[0] -= r; if (xMass[0] <= 0) {xMass[0] = frame.getWidth();}; break;
				case 4: xMass[0] += r; if (xMass[0] >= frame.getWidth()) {xMass[0] = 0;}; break;

			}
			drawPanel.repaint();
			try {Thread.sleep(delay);} catch (Exception ex){};
		}

	}

	class MyDrawPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.setColor(Color.gray);
			for (int i = 0; i < snakelength; i++) {g.fillOval(xMass[i], yMass[i], r, r);};
		}

	}

}


