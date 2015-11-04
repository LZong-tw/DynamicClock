import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class DynamicClock extends JFrame {
    
  private StillClock clock = new StillClock();
  // Set the hour, minute, and seconds be shown in the message panel
  private MessagePanel messagePanel = new MessagePanel(clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond());
    
  public DynamicClock() {
    
    // Set the message panel
    messagePanel.setCentered(true);
    messagePanel.setForeground(Color.blue);
    messagePanel.setFont(new Font("Courie", Font.BOLD, 16));
    
    add(clock);
    add(messagePanel, BorderLayout.SOUTH);

    // Create a timer with delay 1000 ms
    Timer timer = new Timer(1000, new TimerListener());
    timer.start();
  }

  private class TimerListener implements ActionListener {
    @Override /** Handle the action event */
    public void actionPerformed(ActionEvent e) {
      // Set new time and repaint the clock to display current time
      clock.setCurrentTime();
      clock.repaint();
      messagePanel.setMessage(clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond());
    }
  }

  /** Main method */
  public static void main(String[] args) {
    JFrame frame = new DynamicClock();
    frame.setTitle("DynamicClock");
    frame.setSize(200, 200);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
