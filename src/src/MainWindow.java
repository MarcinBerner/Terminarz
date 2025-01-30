package src;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.SpinnerDateModel;
import java.time.*;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import javax.swing.RowFilter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author marci
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form window
     */
    public MainWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        dayToday = new javax.swing.JLabel();
        addTaskButton = new java.awt.Button();
        rangeLabelTitle = new java.awt.Label();
        startLabel = new javax.swing.JLabel();
        endLabel = new javax.swing.JLabel();
        Calendar calendarStart = Calendar.getInstance();
        Date today = calendarStart.getTime();
        calendarStart.add(Calendar.YEAR, -31);
        Date minDateStart = calendarStart.getTime();
        calendarStart.add(Calendar.YEAR, 100);
        Date maxDateStart = calendarStart.getTime();
        SpinnerDateModel startDateModel = new SpinnerDateModel(today, minDateStart, maxDateStart,Calendar.DAY_OF_MONTH);
        SimpleDateFormat simpleModel = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        startDateSpinner = new javax.swing.JSpinner(startDateModel);
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.add(Calendar.YEAR, -31);
        Date minDateEnd = calendarEnd.getTime();
        calendarEnd.add(Calendar.YEAR, 100);
        Date maxDateEnd = calendarEnd.getTime();
        SpinnerDateModel endDateModel = new SpinnerDateModel(today, minDateEnd, maxDateEnd,Calendar.DAY_OF_MONTH);
        endDateSpinner = new javax.swing.JSpinner(endDateModel);
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jScrollPane1 = new javax.swing.JScrollPane();
        taskJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        removeTaskButton = new java.awt.Button();
        setFilterBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Terminarz");
        setName("mainFrame"); // NOI18N
        setResizable(false);

        title.setFont(new java.awt.Font("Segoe UI", 0, 72)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        title.setText("Termianarz");
        title.setMaximumSize(new java.awt.Dimension(300, 16));
        title.setPreferredSize(new java.awt.Dimension(300, 16));

        dayToday.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dayToday.setText("Dzisiaj mamy: " + LocalDate.now());
        dayToday.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        addTaskButton.setActionCommand("addTask");
        addTaskButton.setLabel("Dodaj zadanie");
        addTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTaskButtonActionPerformed(evt);
            }
        });

        rangeLabelTitle.setText("Zakres:");

        startLabel.setText("Od:");

        endLabel.setText("Do:");

        startDateSpinner.setEditor(new JSpinner.DateEditor(startDateSpinner, simpleModel.toPattern()));

        taskJTable.setModel(dtm);
        TableColumnModel columnModel = taskJTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(185);
        columnModel.getColumn(0).setMaxWidth(185);
        sorter.setComparator(0, new DateComperator());
        taskJTable.setRowSorter(sorter);

        DataBaseReader dataReader = new DataBaseReader();
        Task[] tasks;
        try
        {
            if(!db.exists())
            db.createNewFile();
            BufferedReader inS = new BufferedReader(new FileReader(db));
            tasks = dataReader.readTasks(inS);
            inS.close();
            for(int i = 0; i < tasks.length; i++)
            {
                dtm.addRow(new Object[]{tasks[i].date, tasks[i].taskText});
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        taskJTable.getRowSorter().toggleSortOrder(0);
        jScrollPane1.setViewportView(taskJTable);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ship.png"))); // NOI18N

        removeTaskButton.setActionCommand("removeTaskButton");
        removeTaskButton.setLabel("Usuń zadanie");
        removeTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeTaskButtonActionPerformed(evt);
            }
        });

        setFilterBtn.setText("Wybierz");
        setFilterBtn.setName("rowFilterBtn"); // NOI18N
        setFilterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setFilterBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rangeLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startDateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(endLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(endDateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(setFilterBtn))
                            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                        .addComponent(dayToday)))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(dayToday, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(rangeLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(startDateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(startLabel)
                                .addComponent(endLabel)
                                .addComponent(endDateSpinner)
                                .addComponent(setFilterBtn))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        title.getAccessibleContext().setAccessibleName("Title");
        dayToday.getAccessibleContext().setAccessibleName("");
        addTaskButton.getAccessibleContext().setAccessibleName("addTask");
        rangeLabelTitle.getAccessibleContext().setAccessibleName("chooseRangeLabelTitle");
        jLabel2.getAccessibleContext().setAccessibleName("imgLabel");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTaskButtonActionPerformed
        new AddTaskFrame(mainFrame).setVisible(true);

    }//GEN-LAST:event_addTaskButtonActionPerformed

    private void removeTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeTaskButtonActionPerformed
        int row = taskJTable.getSelectedRow();
        Date date = (Date) dtm.getValueAt(row, 0);
        String task  = (String) dtm.getValueAt(row, 1);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        String stringDate = formatter.format(date);
        TaskWriterHandler.deleteTask(stringDate, task, new File("db" + File.separator + "db.txt"));
        dtm.removeRow(row);
    }//GEN-LAST:event_removeTaskButtonActionPerformed

    private void setFilterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setFilterBtnActionPerformed
        newStartFilter();
        newEndFilter();
    }//GEN-LAST:event_setFilterBtnActionPerformed
     public static void addRowToJTable(Object[] dataRow)
    {
        DefaultTableModel model = (DefaultTableModel) taskJTable.getModel();
        model.addRow(dataRow);
    }
    private void newStartFilter() {
    RowFilter<DefaultTableModel, Object> rf = null;
    Date startDate = (Date) startDateSpinner.getValue();
    try {
        rf = RowFilter.dateFilter(RowFilter.ComparisonType.AFTER, startDate, 0);
    } catch (java.util.regex.PatternSyntaxException e) {
        return;
    }
    sorter.setRowFilter(rf);
} 
    private void newEndFilter() {
    RowFilter<DefaultTableModel, Object> rf = null;
    Date endDate = (Date) endDateSpinner.getValue();
    try {
        rf = RowFilter.dateFilter(RowFilter.ComparisonType.BEFORE, endDate, 0);
    } catch (java.util.regex.PatternSyntaxException e) {
        return;
    }
    sorter.setRowFilter(rf);
} 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
   
    }
    private JFrame mainFrame = this;
    public String[] tblHead={"Kiedy","Zadanie"};
    public DefaultTableModel dtm= new DefaultTableModel(tblHead,0);
    public TableRowSorter sorter = new TableRowSorter(dtm);
    public static File db = new File("db" + File.separator + "db.txt");
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button addTaskButton;
    private javax.swing.JLabel dayToday;
    private javax.swing.JSpinner endDateSpinner;
    private javax.swing.JLabel endLabel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label rangeLabelTitle;
    private java.awt.Button removeTaskButton;
    private javax.swing.JButton setFilterBtn;
    private javax.swing.JSpinner startDateSpinner;
    private javax.swing.JLabel startLabel;
    private static javax.swing.JTable taskJTable;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
