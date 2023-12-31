/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import edd.*;
import java.io.IOException;
import javax.swing.SwingUtilities;

/**
 *
 * @author Admin
 */
public class Dashboard extends javax.swing.JPanel {

    /**
     * Creates new form Start
     * @param path
     */
    public Dashboard(String path) {
        
        initComponents();
        
        heap = new ColaPrioridad();
        
        users = new javax.swing.DefaultListModel();
        usersJList.setModel(users);
        usersJList.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersJListMouseClicked(evt);
            }
        });
        
        docs = new javax.swing.DefaultListModel();
        docsJList.setModel(docs);
        docsJList.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                docsJListMouseClicked(evt);
            }
        });
        
        queue = new javax.swing.DefaultListModel();
        queueJList.setModel(queue);
        queueJList.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                queueJListMouseClicked(evt);
            }
        });
        
        if (path != null) {
            heap.cargarUsuariosDesdeCSV(path);
            for (Usuario user : heap.getUsers()) {
                users.addElement(user.getName());
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addUserFrame = new javax.swing.JFrame();
        addUserPanel = new javax.swing.JPanel();
        usernameField = new javax.swing.JTextField();
        typeCombo = new javax.swing.JComboBox<>();
        usernameLabel = new javax.swing.JLabel();
        priorityLabel = new javax.swing.JLabel();
        okUserButton = new javax.swing.JButton();
        cancelUserButton = new javax.swing.JButton();
        addDocFrame = new javax.swing.JFrame();
        addDocPanel = new javax.swing.JPanel();
        docnameField = new javax.swing.JTextField();
        docnameLabel = new javax.swing.JLabel();
        sizeLabel = new javax.swing.JLabel();
        okDocButton = new javax.swing.JButton();
        cancelDocButton = new javax.swing.JButton();
        docsizeField = new javax.swing.JTextField();
        userMenu = new javax.swing.JPopupMenu();
        menuRemoveUser = new javax.swing.JMenuItem();
        docMenu = new javax.swing.JPopupMenu();
        menuRemoveDoc = new javax.swing.JMenuItem();
        menuQueueDoc = new javax.swing.JMenuItem();
        userAddMenu = new javax.swing.JPopupMenu();
        userAddMenuItem = new javax.swing.JMenuItem();
        docAddMenu = new javax.swing.JPopupMenu();
        docAddMenuItem = new javax.swing.JMenuItem();
        queueMenu = new javax.swing.JPopupMenu();
        queueRemoveMenu = new javax.swing.JMenuItem();
        usersLabel = new javax.swing.JLabel();
        docsLabel = new javax.swing.JLabel();
        queueLabel = new javax.swing.JLabel();
        heapLabel = new javax.swing.JLabel();
        usersPanel = new javax.swing.JScrollPane();
        usersJList = new javax.swing.JList<>();
        addUserButton = new javax.swing.JButton();
        docsPanel = new javax.swing.JScrollPane();
        docsJList = new javax.swing.JList<>();
        addDocButton = new javax.swing.JButton();
        listViewPanel = new javax.swing.JScrollPane();
        queueJList = new javax.swing.JList<>();
        heapViewPanel = new javax.swing.JPanel();
        returnButton = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        addUserFrame.setTitle("Agregar usuario");
        addUserFrame.setMaximumSize(new java.awt.Dimension(400, 160));
        addUserFrame.setMinimumSize(new java.awt.Dimension(400, 160));
        addUserFrame.setPreferredSize(new java.awt.Dimension(400, 160));
        addUserFrame.setResizable(false);

        addUserPanel.setMaximumSize(new java.awt.Dimension(380, 130));
        addUserPanel.setMinimumSize(new java.awt.Dimension(380, 130));
        addUserPanel.setPreferredSize(new java.awt.Dimension(380, 130));
        addUserPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameField.setText("Nombre");
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        addUserPanel.add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 200, -1));

        typeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alta", "Media", "Baja" }));
        addUserPanel.add(typeCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 130, -1));

        usernameLabel.setText("Nombre");
        addUserPanel.add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        priorityLabel.setText("Prioridad");
        addUserPanel.add(priorityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        okUserButton.setText("Aceptar");
        okUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okUserButtonActionPerformed(evt);
            }
        });
        addUserPanel.add(okUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

        cancelUserButton.setText("Cancelar");
        cancelUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelUserButtonActionPerformed(evt);
            }
        });
        addUserPanel.add(cancelUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        addUserFrame.getContentPane().add(addUserPanel, java.awt.BorderLayout.CENTER);

        addDocFrame.setTitle("Agregar documento");
        addDocFrame.setMaximumSize(new java.awt.Dimension(400, 160));
        addDocFrame.setMinimumSize(new java.awt.Dimension(400, 160));
        addDocFrame.setPreferredSize(new java.awt.Dimension(400, 160));
        addDocFrame.setResizable(false);

        addDocPanel.setMaximumSize(new java.awt.Dimension(380, 130));
        addDocPanel.setMinimumSize(new java.awt.Dimension(380, 130));
        addDocPanel.setPreferredSize(new java.awt.Dimension(380, 130));
        addDocPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        docnameField.setText("Nombre");
        docnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docnameFieldActionPerformed(evt);
            }
        });
        addDocPanel.add(docnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 200, -1));

        docnameLabel.setText("Nombre");
        addDocPanel.add(docnameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        sizeLabel.setText("Tamaño");
        addDocPanel.add(sizeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        okDocButton.setText("Aceptar");
        okDocButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okDocButtonActionPerformed(evt);
            }
        });
        addDocPanel.add(okDocButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

        cancelDocButton.setText("Cancelar");
        cancelDocButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelDocButtonActionPerformed(evt);
            }
        });
        addDocPanel.add(cancelDocButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        docsizeField.setText("Tamaño");
        addDocPanel.add(docsizeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 130, -1));

        addDocFrame.getContentPane().add(addDocPanel, java.awt.BorderLayout.CENTER);

        menuRemoveUser.setText("Eliminar usuario");
        menuRemoveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemoveUserActionPerformed(evt);
            }
        });
        userMenu.add(menuRemoveUser);

        menuRemoveDoc.setText("Eliminar documento");
        menuRemoveDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemoveDocActionPerformed(evt);
            }
        });
        docMenu.add(menuRemoveDoc);

        menuQueueDoc.setText("Enviar a la cola");
        menuQueueDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQueueDocActionPerformed(evt);
            }
        });
        docMenu.add(menuQueueDoc);

        userAddMenuItem.setText("Agregar usuario");
        userAddMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userAddMenuItemActionPerformed(evt);
            }
        });
        userAddMenu.add(userAddMenuItem);

        docAddMenuItem.setText("Agregar documento");
        docAddMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docAddMenuItemActionPerformed(evt);
            }
        });
        docAddMenu.add(docAddMenuItem);

        queueRemoveMenu.setText("Eliminar de la cola");
        queueRemoveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queueRemoveMenuActionPerformed(evt);
            }
        });
        queueMenu.add(queueRemoveMenu);

        setMaximumSize(new java.awt.Dimension(960, 540));
        setMinimumSize(new java.awt.Dimension(960, 540));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(960, 540));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usersLabel.setBackground(new java.awt.Color(255, 255, 255));
        usersLabel.setText("Usuarios");
        add(usersLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        docsLabel.setBackground(new java.awt.Color(255, 255, 255));
        docsLabel.setText("Documentos del usuario");
        add(docsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        queueLabel.setBackground(new java.awt.Color(255, 255, 255));
        queueLabel.setText("Cola de impresión (lista)");
        add(queueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, -1, -1));

        heapLabel.setBackground(new java.awt.Color(255, 255, 255));
        heapLabel.setText("Cola de impresión (árbol)");
        add(heapLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, -1));

        usersJList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        usersPanel.setViewportView(usersJList);

        add(usersPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 220, 450));

        addUserButton.setText("Agregar usuario");
        addUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserButtonActionPerformed(evt);
            }
        });
        add(addUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 220, -1));

        docsJList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        docsPanel.setViewportView(docsJList);

        add(docsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 240, 140));

        addDocButton.setText("Agregar documento");
        addDocButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDocButtonActionPerformed(evt);
            }
        });
        add(addDocButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 240, -1));

        queueJList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listViewPanel.setViewportView(queueJList);

        add(listViewPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 240, 260));
        add(heapViewPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 400, 450));

        returnButton.setText("Salir al menú principal");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });
        add(returnButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 490, 400, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/shadows.png"))); // NOI18N
        add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 540));
    }// </editor-fold>//GEN-END:initComponents

    private void addUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserButtonActionPerformed
        addUserFrame.setVisible(true);
    }//GEN-LAST:event_addUserButtonActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void okUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okUserButtonActionPerformed
        while(true) {
            try {
                switch (typeCombo.getSelectedItem().toString()) {
                    case "Alta" -> heap.agregarUsuario(usernameField.getText(), "prioridad_alta");
                    case "Media" -> heap.agregarUsuario(usernameField.getText(), "prioridad_media");
                    case "Baja" -> heap.agregarUsuario(usernameField.getText(), "prioridad_baja");
                }
                users.addElement(usernameField.getText());
                addUserFrame.setVisible(false);
                break;
            } catch(IOException ex) {
                javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
                break;
            }
        }
        
    }//GEN-LAST:event_okUserButtonActionPerformed

    private void cancelUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelUserButtonActionPerformed
        addUserFrame.setVisible(false);
    }//GEN-LAST:event_cancelUserButtonActionPerformed

    private void docnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_docnameFieldActionPerformed

    private void okDocButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okDocButtonActionPerformed
        while(true) {
            try {
                lSelectedUser.agregarDocumento(docnameField.getText(), Integer.parseInt(docsizeField.getText()), lSelectedUser.getType());
                docs.addElement(docnameField.getText());
                addDocFrame.setVisible(false);
                break;
            } catch(IOException ex) {
                javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());   
                break;
            } catch(NumberFormatException ex) {
                javax.swing.JOptionPane.showMessageDialog(null, "Solo números enteros en el tamaño");   
                break;
            }
        }
    }//GEN-LAST:event_okDocButtonActionPerformed

    private void cancelDocButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelDocButtonActionPerformed
        addDocFrame.setVisible(false);
    }//GEN-LAST:event_cancelDocButtonActionPerformed

    private void addDocButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDocButtonActionPerformed
        if (lSelectedUser == null) {
            javax.swing.JOptionPane.showMessageDialog(null, "Seleccione un usuario");
        } else {
            addDocFrame.setVisible(true);
        }
    }//GEN-LAST:event_addDocButtonActionPerformed

    private void menuRemoveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemoveUserActionPerformed
        int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar este usuario?", "Confirmación", 0);

        if (confirm == 0) {
            heap.getUsers().remove(rSelectedUser);
            users.removeElement(rSelectedUser.getName());
        }
    }//GEN-LAST:event_menuRemoveUserActionPerformed

    private void menuRemoveDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemoveDocActionPerformed
        int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar este documento?", "Confirmación", 0);

        if (confirm == 0) {
            lSelectedUser.getDocumentos().remove(rSelectedDoc);
            docs.removeElement(rSelectedDoc.getName());
        }
    }//GEN-LAST:event_menuRemoveDocActionPerformed

    private void menuQueueDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQueueDocActionPerformed
        heap.agregarDocumento(lSelectedUser.getName(), rSelectedDoc.getName(), rSelectedDoc.getSize(), lSelectedUser.getType());
        queue.clear();
        for (Documento doc : heap.getDocs()) {
            queue.addElement(doc.getName());
        }
    }//GEN-LAST:event_menuQueueDocActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_returnButtonActionPerformed

    private void userAddMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userAddMenuItemActionPerformed
        addUserFrame.setVisible(true);
    }//GEN-LAST:event_userAddMenuItemActionPerformed

    private void docAddMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docAddMenuItemActionPerformed
        if (lSelectedUser == null) {
            javax.swing.JOptionPane.showMessageDialog(null, "Seleccione un usuario");
        } else {
            addDocFrame.setVisible(true);
        }
    }//GEN-LAST:event_docAddMenuItemActionPerformed

    private void queueRemoveMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queueRemoveMenuActionPerformed
        int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar este documento de la cola?", "Confirmación", 0);

        if (confirm == 0) {
            heap.eliminarDocumento(rSelectedDoc.getName());
            queue.clear();
            for (Documento doc : heap.getDocs()) {
                queue.addElement(doc.getName());
            }
        }
    }//GEN-LAST:event_queueRemoveMenuActionPerformed
    
    private void usersJListMouseClicked(java.awt.event.MouseEvent evt) {
        if (usersJList.locationToIndex(evt.getPoint()) != -1) {
            if (SwingUtilities.isRightMouseButton(evt)) {
                rSelectedUser = heap.getUser(users.get(usersJList.locationToIndex(evt.getPoint())).toString());
                userMenu.show(usersJList, evt.getX(), evt.getY());
            } else if (SwingUtilities.isLeftMouseButton(evt)) {
                lSelectedUser = heap.getUser(users.get(usersJList.locationToIndex(evt.getPoint())).toString());
                docs.clear();
                for (Documento doc : lSelectedUser.getDocumentos()) {
                    docs.addElement(doc.getName());
                }
            }
        } else {
            if (SwingUtilities.isRightMouseButton(evt)) {
                userAddMenu.show(usersJList, evt.getX(), evt.getY());
            }
        }
    }
    
    private void docsJListMouseClicked(java.awt.event.MouseEvent evt) {
        if (docsJList.locationToIndex(evt.getPoint()) != -1) {
            if (SwingUtilities.isRightMouseButton(evt)) {
                rSelectedDoc = lSelectedUser.getDoc(docs.get(docsJList.locationToIndex(evt.getPoint())).toString());
                docMenu.show(docsJList, evt.getX(), evt.getY());
            }
        } else {
            if (SwingUtilities.isRightMouseButton(evt)) {
                docAddMenu.show(docsJList, evt.getX(), evt.getY());
            }
        }
    }
    
    private void queueJListMouseClicked(java.awt.event.MouseEvent evt) {
        if ((queueJList.locationToIndex(evt.getPoint()) != -1) && (SwingUtilities.isRightMouseButton(evt))) {
            rSelectedDoc = lSelectedUser.getDoc(docs.get(docsJList.locationToIndex(evt.getPoint())).toString());
            queueMenu.show(queueJList, evt.getX(), evt.getY());
        }
    }
    
    public javax.swing.JButton getReturnButton() {
        return returnButton;
    }
    
    private ColaPrioridad heap;
    private Usuario rSelectedUser;
    private Usuario lSelectedUser;
    private Documento rSelectedDoc;
    private javax.swing.DefaultListModel users;
    private javax.swing.DefaultListModel docs;
    private javax.swing.DefaultListModel queue;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDocButton;
    private javax.swing.JFrame addDocFrame;
    private javax.swing.JPanel addDocPanel;
    private javax.swing.JButton addUserButton;
    private javax.swing.JFrame addUserFrame;
    private javax.swing.JPanel addUserPanel;
    private javax.swing.JLabel bg;
    private javax.swing.JButton cancelDocButton;
    private javax.swing.JButton cancelUserButton;
    private javax.swing.JPopupMenu docAddMenu;
    private javax.swing.JMenuItem docAddMenuItem;
    private javax.swing.JPopupMenu docMenu;
    private javax.swing.JTextField docnameField;
    private javax.swing.JLabel docnameLabel;
    private javax.swing.JList<String> docsJList;
    private javax.swing.JLabel docsLabel;
    private javax.swing.JScrollPane docsPanel;
    private javax.swing.JTextField docsizeField;
    private javax.swing.JLabel heapLabel;
    private javax.swing.JPanel heapViewPanel;
    private javax.swing.JScrollPane listViewPanel;
    private javax.swing.JMenuItem menuQueueDoc;
    private javax.swing.JMenuItem menuRemoveDoc;
    private javax.swing.JMenuItem menuRemoveUser;
    private javax.swing.JButton okDocButton;
    private javax.swing.JButton okUserButton;
    private javax.swing.JLabel priorityLabel;
    private javax.swing.JList<String> queueJList;
    private javax.swing.JLabel queueLabel;
    private javax.swing.JPopupMenu queueMenu;
    private javax.swing.JMenuItem queueRemoveMenu;
    private javax.swing.JButton returnButton;
    private javax.swing.JLabel sizeLabel;
    private javax.swing.JComboBox<String> typeCombo;
    private javax.swing.JPopupMenu userAddMenu;
    private javax.swing.JMenuItem userAddMenuItem;
    private javax.swing.JPopupMenu userMenu;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JList<String> usersJList;
    private javax.swing.JLabel usersLabel;
    private javax.swing.JScrollPane usersPanel;
    // End of variables declaration//GEN-END:variables
}
