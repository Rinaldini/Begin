/*
 *	Программа подсчета времени, затраченного на работу. Результаты сохраняются в текстовый файл в том же каталоге, где лежит файл Worktimer.
 *	Program for calculating the time spent on work. The results are saved to a text file in the same directory as the Worktimer file
 *	
 * 	сделать / todo: запоминание введённого файла(предлагать выбор) / memorizing the entered file(offer a choice)
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.time.*;
import java.text.*;
import java.lang.*;
import java.io.*;

public class Worktimer extends JPanel implements ActionListener
{
 public JFrame frame;
 public JPanel panel;
 public JButton buttonStart, buttonStop, buttonSaveWorkTime; //buttonOk
 public JLabel labelStart, labelStop, labelWorktime, labelMissFile;
 public long workTime;
 public Calendar dateStart, dateStop;
 public String workType[] = {"cutting   ", "nesting   ", "stylization"};
 public String work;
 public JComboBox<String> listWork;
 public JTextField fileName;

 public Worktimer()
 {
  frame = new JFrame("Worktimer");
  panel = new JPanel();
  frame.setLayout(new FlowLayout());
  buttonStop = new JButton("End");
  buttonStart = new JButton("Begin");
  listWork = new JComboBox<String>(workType);
  labelStart = new JLabel("");
  labelStop = new JLabel("");
  labelWorktime = new JLabel("working time");
  fileName = new JTextField(15);

/*
 *	прослушка/listening
 */

  buttonStart.addActionListener(this);
  buttonStop.addActionListener(this);
  listWork.addActionListener(this);

/*
 *	добавление на форму ГИП/adding to form GUI
 */

  frame.add(fileName);
  fileName.setToolTipText("Input file name, please");
  frame.add(listWork);
  panel.add(buttonStart);
  panel.add(buttonStop);
  frame.add(panel, BorderLayout.CENTER);
  frame.add(labelStart);
  frame.add(labelStop);
  frame.add(labelWorktime);
  frame.setVisible(true);
  frame.setSize(220, 190);
  frame.setResizable(false);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }

 public void actionPerformed(ActionEvent ae)
 {
  if (ae.getSource() == listWork)
  {
   JComboBox cb = (JComboBox)ae.getSource();

   work = (String)cb.getSelectedItem(); 
  }
  else
  if (ae.getSource() == buttonStart)
  {
   dateStart = Calendar.getInstance();
   labelStart.setText(dateStart.getTime().toString());
  }
  else
  if (ae.getSource() == buttonStop)
  {

   if (fileName.getText().equals(""))
   {
    JOptionPane.showMessageDialog(frame, "Input file name, please");
    return;
   }

   dateStop = Calendar.getInstance();
   labelStop.setText(dateStop.getTime().toString());
   workTime = dateStop.getTimeInMillis() - dateStart.getTimeInMillis();
   labelWorktime.setText(getStringTime(getWorkTimeHours(workTime)) + "h " + getStringTime(getWorkTimeMinutes(workTime)) + "min");

/*
 *	method for saving working time to file
 */

   try (FileWriter fw = new FileWriter(fileName.getText()+".txt", true))
   {
    fw.write(labelStart.getText() + " \t" + labelWorktime.getText() + "  \t" + work + "\t" + workTime + "\r\n");
   }
   catch(IOException e) {JOptionPane.showMessageDialog(frame, "Error"); System.out.println("Error");}
  }
 }


 int getWorkTimeHours(long time)
 {
  int hours = 0;
  time = dateStop.getTimeInMillis() - dateStart.getTimeInMillis();
  if (time / 3600000 >= 1) {hours = (int) time / 3600000;}
  else {hours = 0;}
  return hours;
 }

 int getWorkTimeMinutes(long time)
 {
  int hours = 0;
  int minutes = 0;
  time = dateStop.getTimeInMillis() - dateStart.getTimeInMillis();
  if (time / 3600000 < 1) {minutes = (int) time / 60000;}
  else
  {minutes = (int) ((time - getWorkTimeHours(time)*3600000) / 60000);}
  return minutes; 
 }

 String getStringTime(int intTime)
 {
  String strTime = Integer.toString(intTime);
  return strTime;
 }
	
 public static void main(String[] args)
 {
  SwingUtilities.invokeLater(new Runnable()
  {
   public void run() {new Worktimer1();}
  });
 }
}


