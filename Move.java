import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Move
{
	int r = 20;
	int x = 0;
	int y = 100;

	public static void main(String[] args)
	{
		Move animation = new Move();		// constructor, create the object
		animation.game();				// call the metod for the object
	}

	public void game()
	{
		JFrame frame = new JFrame("Control move");
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyDrawPanel drawPanel = new MyDrawPanel();	
		drawPanel.setFocusTraversalKeysEnabled(false);
		frame.add(drawPanel);				// put the panel for drawing at frame
		frame.setFocusTraversalKeysEnabled(false);
		frame.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				switch (e.getKeyCode())
				{
					case KeyEvent.VK_UP:
					y -= 20;
					if (y <= 0) {y = frame.getHeight();}
					break;

					case KeyEvent.VK_DOWN:
					y += 20;
					if (y == frame.getHeight()) {y = 0;}
					break;

					case KeyEvent.VK_LEFT:
					x -= 20;
					if (x <= 0) {x = frame.getWidth();}
					break;

					case KeyEvent.VK_RIGHT:
					x += 20;
					if (x == frame.getWidth()) {x = 0;}
					break;
				}
				drawPanel.repaint();
				try {Thread.sleep(10);} catch (Exception ex){}			
			}
		});

	}


	class MyDrawPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());

			g.setColor(Color.gray);
			g.fillOval(x, y, r, r);
		}

	}

}