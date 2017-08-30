/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationnotepad;

/**
 *
 * @author Quang
 */

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NewClassAbout extends JDialog {

    JLabel jLabel;
    JLabel jLabelIcon;
    JLabel jLabelName;
    JLabel jLabelTitle;
    JLabel jLabelVersion;
    JPanel jPanelAboutAuthor;

    public NewClassAbout() {
        setTitle("About Notepad");
        setResizable(false);
        setLocation(500, 200);
        initComponents();
    }

    private void initComponents() {

        jLabelIcon = new JLabel();
        jLabelTitle = new JLabel();
        jPanelAboutAuthor = new JPanel();
        jLabelName = new JLabel();
        jLabelVersion = new JLabel();
        jLabel = new JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jLabelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplicationnotepad/1462276096_diagram-03.png"))); // NOI18N

        jLabelTitle.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(0, 0, 204));
        jLabelTitle.setText("NOTEPAD");

        jPanelAboutAuthor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelName.setForeground(new java.awt.Color(51, 51, 255));
        jLabelName.setText("Author: Nguyễn Đình Quang ");

        jLabelVersion.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelVersion.setForeground(new java.awt.Color(51, 51, 255));
        jLabelVersion.setText("Product Version: Notepad 1.0");

        jLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel.setForeground(new java.awt.Color(51, 51, 255));
        jLabel.setText("Written By: Java Language");
        javax.swing.GroupLayout jPanelAboutAuthorLayout = new javax.swing.GroupLayout(jPanelAboutAuthor);
        jPanelAboutAuthor.setLayout(jPanelAboutAuthorLayout);
        jPanelAboutAuthorLayout.setHorizontalGroup(
                jPanelAboutAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelAboutAuthorLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanelAboutAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabelVersion)
                .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel))
                .addContainerGap(49, Short.MAX_VALUE)));
        jPanelAboutAuthorLayout.setVerticalGroup(
                jPanelAboutAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelAboutAuthorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelName)
                .addGap(18, 18, 18)
                .addComponent(jLabelVersion)
                .addGap(18, 18, 18)
                .addComponent(jLabel)
                .addContainerGap(30, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabelIcon)
                .addGap(30, 30, 30)
                .addComponent(jLabelTitle))
                .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jPanelAboutAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanelAboutAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE)));

        pack();
    }
}

