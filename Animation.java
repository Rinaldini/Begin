import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Animation
{
	int r = 20;
	int x = 0;
	int y = 100;
	int direction;
	public static void main(String[] args)
	{
		Animation animation = new Animation();		// constructor, create the object
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
		while (true)
		{
			frame.addKeyListener(new KeyAdapter()
			{
				public void keyPressed(KeyEvent e)
				{
					switch (e.getKeyCode())
					{
						case KeyEvent.VK_UP: direction = 1; break;	//
						case KeyEvent.VK_DOWN: direction = 2; break;	//	the selection of moving direction 
						case KeyEvent.VK_LEFT: direction = 3; break;	//
						case KeyEvent.VK_RIGHT: direction = 4; break;	//
						
					}

				}
			});

			switch (direction)
			{
				case 1: y -= 20; if (y <= 0) {y = frame.getHeight();}; break;
				case 2: y += 20; if (y >= frame.getHeight()) {y = 0;}; break;
				case 3: x -= 20; if (x <= 0) {x = frame.getWidth();}; break;
				case 4: x += 20; if (x >= frame.getWidth()) {x = 0;}; break;
			}

			drawPanel.repaint();
			try {Thread.sleep(50);} catch (Exception ex){}
		}
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