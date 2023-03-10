/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.management;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTable;
import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author .........
 */
public class AddBooking extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddBooking
     */
    String luser;
    public AddBooking(String loginuser) {
        initComponents();
        busSourceCBFillData();
        busDestinationCBFillData();
        this.luser=loginuser;
        
    }
    public void busSourceCBFillData()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/busm";
            Connection con = DriverManager.getConnection(databaseURL, "root", "");
            Statement stat = con.createStatement();    
            String selectQuery="select distinct(bus_source) as bus_source from bus_details";
            ResultSet rs=stat.executeQuery(selectQuery);
            while(rs.next())
            {
                sourceCB.addItem(rs.getString("bus_source"));
                
            }
                    
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void busDestinationCBFillData()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/busm";
            Connection con = DriverManager.getConnection(databaseURL, "root", "");
            Statement stat = con.createStatement();    
            String selectQuery="select distinct(bus_dest) as bus_dest  from bus_details";
            ResultSet rs=stat.executeQuery(selectQuery);
            while(rs.next())
            {
                destinationCB.addItem(rs.getString("bus_dest"));
                
            }
                    
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        busmPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("busmPU").createEntityManager();
        busBookingQuery = java.beans.Beans.isDesignTime() ? null : busmPUEntityManager.createQuery("SELECT b FROM BusBooking b");
        busBookingList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : busBookingQuery.getResultList();
        jLabel1 = new javax.swing.JLabel();
        sourceCB = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        destinationCB = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fromDP = new org.jdesktop.swingx.JXDatePicker();
        jLabel7 = new javax.swing.JLabel();
        toDP = new org.jdesktop.swingx.JXDatePicker();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Source");

        jLabel2.setText("Destination");

        jLabel3.setText("Starting From");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, busBookingList, jTable2);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${bookingId}"));
        columnBinding.setColumnName("Booking Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${bookingUser}"));
        columnBinding.setColumnName("Booking User");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${journeyDate}"));
        columnBinding.setColumnName("Journey Date");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${busNo}"));
        columnBinding.setColumnName("Bus No");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${seat}"));
        columnBinding.setColumnName("Seat");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idNo}"));
        columnBinding.setColumnName("Id No");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${firstName}"));
        columnBinding.setColumnName("First Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastName}"));
        columnBinding.setColumnName("Last Name");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jScrollPane2.setViewportView(jTable2);

        jLabel4.setText("Search Result.........");

        jLabel5.setText("Booking Details...............");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Add Booking Info");

        jLabel7.setText("Upto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sourceCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fromDP, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(toDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(destinationCB, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(406, 406, 406))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sourceCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(destinationCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(fromDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(toDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
 public void infoMessage(String message, String tittle) {
        JOptionPane.showMessageDialog(null, message, tittle, JOptionPane.INFORMATION_MESSAGE);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String source=(String)sourceCB.getSelectedItem();
        String destination=(String)destinationCB.getSelectedItem();
        java.util.Date fromDate=fromDP.getDate();
        java.util.Date toDate=toDP.getDate();
        
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String fromDateFormated=sdf.format(fromDate);
        String toDateFormated=sdf.format(toDate);
        
      
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/busm";
            Connection con = DriverManager.getConnection(databaseURL, "root", "");
            Statement stat = con.createStatement();    
            String selectQuery = "select * from bus_details where bus_source='"+source+"' and bus_dest='"+destination+"' and depart_date between '"+fromDateFormated+"' and '"+toDateFormated+"'";
            ResultSet rs=stat.executeQuery(selectQuery);
         
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
           
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int index =jTable1.getSelectedRow();
        TableModel model=jTable1.getModel();
        String bus_no=(String) model.getValueAt(index, 1);
        String movement=(String) model.getValueAt(index, 2);
        String bus_source=(String) model.getValueAt(index, 3);
        String bus_dest=(String) model.getValueAt(index, 4);
        String depart_date=model.getValueAt(index, 5).toString();  
        String depart_time=(String) model.getValueAt(index, 6);
        String price=(String) model.getValueAt(index, 7);
        String avail_seat=(String) model.getValueAt(index, 8);
        
        
        BookingFormFrame=new JFrame();
        BookingFormPanel=new JPanel();
        gl=new GridLayout(0,4);
        l1=new JLabel("Bus No");
        l11=new JLabel(bus_no);
        l2=new JLabel("Movement");
        l12=new JLabel(movement);
        l3=new JLabel("Bus Source");
        l13=new JLabel(bus_source);
        l4=new JLabel("Bus Dest");
        l14=new JLabel(bus_dest);
        l5=new JLabel("Depart Date");
        l15=new JLabel(depart_date);
        l6=new JLabel("Depart Time");
        l16=new JLabel(depart_time);
        l7=new JLabel("Price/seat");
        l17=new JLabel(price);
        l8=new JLabel("Available Seat");
        l18=new JLabel(avail_seat);
        seatnoL=new JLabel("Seat No");
        idnoL=new JLabel("ID No.");
        fnameL=new JLabel("First Name");
        lnameL=new JLabel("Last Name");
        t1=new JTextField(20);
        t2=new JTextField(20);
        t3=new JTextField(20);
        t4=new JTextField(20);
        
        BookingFormFrame.getContentPane().add(BookingFormPanel);
        BookingFormPanel.setLayout(gl);
        
        BookingFormPanel.add(l1);
        BookingFormPanel.add(l11);
        BookingFormPanel.add(l2);
        BookingFormPanel.add(l12);
        BookingFormPanel.add(l3);
        BookingFormPanel.add(l13);
        BookingFormPanel.add(l4);
        BookingFormPanel.add(l14);
        BookingFormPanel.add(l5);
        BookingFormPanel.add(l15);
        BookingFormPanel.add(l6);
        BookingFormPanel.add(l16);
        BookingFormPanel.add(l7);
        BookingFormPanel.add(l17);
        BookingFormPanel.add(l8);
        BookingFormPanel.add(l18);
        
        BookingFormPanel.add(seatnoL);
        BookingFormPanel.add(t1);
        BookingFormPanel.add(idnoL);
         BookingFormPanel.add(t2);
        BookingFormPanel.add(fnameL);
         BookingFormPanel.add(t3);
        BookingFormPanel.add(lnameL);
         BookingFormPanel.add(t4);
        
       int result = JOptionPane.showConfirmDialog(BookingFormFrame,BookingFormPanel,"Booking Form",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
        if(result==JOptionPane.OK_OPTION)
        {
            String booking_user=luser;
            String seatno=t1.getText();
            String idno=t2.getText();
            String first_tname=t3.getText();
            String last_name=t4.getText();
            try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/busm";
            Connection con = DriverManager.getConnection(databaseURL, "root", "");
            Statement stat = con.createStatement();    
            String selectQuery = "select * from bus_booking where bus_no ='"+bus_no+"' and journey_date='"+depart_date+"' and booking_user='"+booking_user+"' and id_no='"+idno+"'";
            System.out.println(selectQuery);
            ResultSet rs=stat.executeQuery(selectQuery);
         //   System.out.println(rs.next());
           if(rs.next())
           {
             infoMessage("Already Booked", "ALert !!");
            
           }
           else
           {
          String insertQuery = "insert into bus_booking values(null,'" + booking_user + "','" +depart_date  + "','" + bus_no + "','" + seatno + "','" + idno + "','" + first_tname + "','" + last_name + "')";
           
         int i= stat.executeUpdate(insertQuery);
         if(i==1)
         {
           
           int remaining_seat=Integer.parseInt(avail_seat)-Integer.parseInt(seatno);
           
           String updateQuery="update bus_details set total_seat='"+remaining_seat+"' where bus_no='"+bus_no+"' and movement='"+movement+"' and depart_date='"+depart_date+"'";
           int j=stat.executeUpdate(updateQuery);
           if(j==1)
           {
               
        String source=(String)sourceCB.getSelectedItem();
        String destination=(String)destinationCB.getSelectedItem();
        java.util.Date fromDate=fromDP.getDate();
        java.util.Date toDate=toDP.getDate();
        
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String fromDateFormated=sdf.format(fromDate);
        String toDateFormated=sdf.format(toDate);   
           infoMessage("Booking Done", "Alert !!");
           
             String selectQuery1 = "select * from bus_details where bus_source='"+source+"' and bus_dest='"+destination+"' and depart_date between '"+fromDateFormated+"' and '"+toDateFormated+"'";
            ResultSet rs1=stat.executeQuery(selectQuery1);
         
            jTable1.setModel(DbUtils.resultSetToTableModel(rs1));
            jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
           
           }
         }
          
               
           
        }
        }
        catch(Exception e)
                {
                    System.out.println(e);
                }
            
        }
     
        
       
             
    }//GEN-LAST:event_jTable1MouseClicked
    GridLayout gl;    
    public JFrame BookingFormFrame;
    public JPanel BookingFormPanel;
    public JLabel l1,l2,l3,l4,l5,l6,l7,l8,l11,l12,l13,l14,l15,l16,l17,l18,seatnoL,idnoL,fnameL,lnameL;
    public JComboBox seatCB;
    public JTextField t1,t2,t3,t4;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<bus.management.BusBooking> busBookingList;
    private javax.persistence.Query busBookingQuery;
    private javax.persistence.EntityManager busmPUEntityManager;
    private javax.swing.JComboBox<String> destinationCB;
    private org.jdesktop.swingx.JXDatePicker fromDP;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<String> sourceCB;
    private org.jdesktop.swingx.JXDatePicker toDP;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
