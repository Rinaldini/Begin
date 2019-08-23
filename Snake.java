import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Animation implements KeyListener
{
	int r = 20;
	int x = 0;
	int y = 100;
//	boolean anyKey = true;
	public static void main(String[] args)
	{
		Animation animation = new Animation();		// constructor, create the object
		animation.game();				// call the metod for the object
	}

	public void game()
	{
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyDrawPanel drawPanel = new MyDrawPanel();	
		frame.add(drawPanel);				// put the panel for drawing on frame
//		frame.addKeyListener(this);
//		frame.setFocusTraversalKeysEnabled(false)
		for (int i = 0; i <40; i++)
		{
			drawPanel.repaint();
			try {Thread.sleep(50);} catch (Exception ex){}
			x += 20;
			if (x == frame.getWidth()) {x = 0;}
		}

/********************************************************************************		
*				equivalent for cycle 				*
*										*
*				movement going on until press key		*
*********************************************************************************

		while (anyKey)
		{
			drawPanel.repaint();
			try {Thread.sleep(50);} catch (Exception ex){}
			x += 20;
			if (x == frame.getWidth()) {x = 0;}
		}

*********************************************************************************/

	}

	public void keyPressed(KeyEvent e)
	{
		e.getKeyCode();
		KeyEvent.VK_UP
		anyKey = false;
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


