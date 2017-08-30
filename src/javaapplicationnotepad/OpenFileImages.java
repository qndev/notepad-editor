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

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class OpenFileImages extends javax.swing.JFrame {

    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenu;
    private java.awt.Panel panelPictures;
    private javax.swing.JMenuItem itmOpen, itmSave;
    String filename;
  
    JLabel jlabel;
  

    public OpenFileImages() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setTitle("Open Images");
        setSize(800, 600);
        panelPictures = new java.awt.Panel();
        // panelSave = new java.awt.Panel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        itmOpen = new javax.swing.JMenuItem();
        itmSave = new javax.swing.JMenuItem();
        panelPictures.setLayout(new java.awt.GridBagLayout());
        panelPictures.setBackground(Color.WHITE);
        jMenu.setText("File");
        itmOpen.setText("Open Image");
        itmSave.setText("Save Image");
        itmOpen.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmOpenActionPerformed(evt);
            }
        });
        itmSave.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmSaveActionPerformed(evt);
            }
        });
        jMenu.add(itmOpen);
        jMenu.add(itmSave);
        jMenuBar.add(jMenu);
        setJMenuBar(jMenuBar);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelPictures, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelPictures, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE));

        setLocationRelativeTo(null);
    }

    private void itmOpenActionPerformed(java.awt.event.ActionEvent evt) {

        JFileChooser jc = new JFileChooser();
        jc.setDialogTitle("Chọn ảnh:");
        jc.setMultiSelectionEnabled(true);
        jc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jc.setFileFilter(new FileTypeFilter(".png", "PNG"));
        jc.setFileFilter(new FileTypeFilter(".jpg", "JPG"));
        jc.setFileFilter(new FileTypeFilter(".gif", "GIF"));
        jc.setFileFilter(new FileTypeFilter(".jpeg", "JPEG"));
        try {
            if (jc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File[] pictures;
                pictures = jc.getSelectedFiles();
                for (File picture : pictures) {
                    JLabel JlabelPicture = new JLabel(new ImageIcon(picture.getAbsolutePath()));
                    panelPictures.add(JlabelPicture);
                }
                revalidate();
                repaint();
                filename = jc.getSelectedFile().getName();
                setTitle(filename = jc.getSelectedFile().getName());
            } else {
                JOptionPane.showMessageDialog(rootPane, "Cancelled by user! ");
            }
        } catch (Exception e) {
            
        } 

    }

    private void itmSaveActionPerformed(java.awt.event.ActionEvent evt) {
        Rectangle rec = panelPictures.getBounds();
        BufferedImage badge = new BufferedImage(rec.width, rec.height, BufferedImage.TYPE_INT_ARGB);
        panelPictures.paint(badge.getGraphics());
        JFileChooser jc = new JFileChooser();
        if (jc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File pictures = jc.getSelectedFile();
            try {
                ImageIO.write(badge, "png", pictures);
                ImageIO.write(badge, "gif", pictures);
                ImageIO.write(badge, "jpg", pictures);
                ImageIO.write(badge, "jpeg", pictures);
                JOptionPane.showMessageDialog(rootPane, "Đã lưu ảnh !", "Thành công!", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException | HeadlessException e) {
                JOptionPane.showMessageDialog(rootPane, "Chưa lưu được ảnh! ", "Lỗi!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Cancelled by user!");
        }
    }
}
