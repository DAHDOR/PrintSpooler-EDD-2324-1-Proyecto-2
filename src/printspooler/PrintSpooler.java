/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package printspooler;

/**
 *
 * @author Admin
 */
public class PrintSpooler extends javax.swing.JFrame {
    
    /**
     * Creates new form PrintSpooler
     */
    public PrintSpooler() {
        
        start = new gui.Start();
        
        fileChooser = new javax.swing.JFileChooser();
        filter = new javax.swing.filechooser.FileNameExtensionFilter("Archivos CSV", "csv");
        fileChooser.setFileFilter(filter);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(960, 540));
        setMinimumSize(new java.awt.Dimension(960, 540));
        setName("PrintSpooler");
        setResizable(false);
        
        start.getNewButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newQueueActionPerformed();
            }
        });
        
        start.getLoadButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadQueueActionPerformed();
            }
        });
        
        start();
    }
    
    private void start() {
        setContentPane(start);
        pack();
    }
    
    private void dashboard() {
        dashboard.getReturnButton().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainmenu();
            }
        });
        setContentPane(dashboard);
        pack();
    }
    
    private void mainmenu() {
        int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "¿Seguro que quieres volver?", "Confirmación", 0);
        if (confirm == 0) {
            start();
        }
    }
    
    private void newQueueActionPerformed() {
        dashboard = new gui.Dashboard(null);
        dashboard();
    }
    
    private void loadQueueActionPerformed() {
        int returnVal = fileChooser.showOpenDialog(null);

        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            dashboard = new gui.Dashboard(fileChooser.getSelectedFile().getPath());
            dashboard();
        }
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
            java.util.logging.Logger.getLogger(PrintSpooler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintSpooler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintSpooler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintSpooler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrintSpooler().setVisible(true);
            }
        });
    }
    
    private gui.Dashboard dashboard;
    private gui.Start start;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.filechooser.FileNameExtensionFilter filter;
}