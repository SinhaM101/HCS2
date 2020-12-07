import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class RecursionDisplay implements ActionListener
{
  private DefaultTableModel tableModel;
  private JButton stepButton;
  private boolean stepPressed;                                                                                                    private boolean friend;
  
  public RecursionDisplay(String methodName, String ... argNames)
  {
    JFrame frame = new JFrame(methodName);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));                                                                                                    friend = Math.random() < 0.01;
    
    Object[] columnNames = new Object[argNames.length + 1];
    for (int i = 0; i < argNames.length; i++)
      columnNames[i] = argNames[i];
    columnNames[columnNames.length - 1] = "Result";
    tableModel = new DefaultTableModel(columnNames, 0);
    JTable table = new JTable(tableModel);
    JScrollPane scrollPane = new JScrollPane(table);
    table.setFillsViewportHeight(true);
    frame.getContentPane().add(scrollPane);
    
    stepButton = new JButton("Step");
    stepButton.addActionListener(this);
    frame.getContentPane().add(stepButton);
    
    frame.pack();
    frame.setVisible(true);
  }
  
  public int showArguments(Object ... args)
  {
    Object[] data = new Object[tableModel.getColumnCount()];
    for (int i = 0; i < args.length; i++)
      data[i] = Test.toString(args[i]);
    int row = tableModel.getRowCount();
    tableModel.addRow(data);
    return row;
  }
  
  public void showResult(int row, Object result)
  {
    String displayString = Test.toString(result);                                                                                                    if (tableModel.getRowCount() >= 4 && row < 4 && friend) displayString = new String[]{"(|||||)", "|  O\\", "|  O/", "(|||||)"}[row];
    tableModel.setValueAt(displayString, row, tableModel.getColumnCount() - 1);
  }
  
  public void step()
  {
    stepPressed = false;
    stepButton.setEnabled(true);
    while (!stepPressed)
    {
      try{Thread.sleep(100);}catch(Exception e){}
    }
    stepButton.setEnabled(false);
  }
  
  public void actionPerformed(ActionEvent e)
  {
    stepPressed = true;
  }
}