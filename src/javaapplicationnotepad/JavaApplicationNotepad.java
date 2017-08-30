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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class JavaApplicationNotepad extends JFrame {

    JTextArea mainarea;
    JMenuBar mbar;
    JMenu mnuFile, mnuEdit, mnuFormat, mnuHelp;
    JMenuItem itmNew, itmOpen, itmSave, itmSaveas, itmExit, itmCut, itmCopy, itmPaste,
            itmFontColor, itmFont, itmhelpAbout, itmOpenFileimages;
    JButton btnNew, btnOpen, btnSave, btnCopy, btnCut, btnPaste, btnFont;
    String filename;
    JFileChooser jc;
    String fileContent;
    JCheckBoxMenuItem wordWrap;
    FontHelper font;
    NewClassAbout aH;
    OpenFileImages openImg;
    JToolBar toolbar;

    public JavaApplicationNotepad() {

        initComponent();

        itmSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
        itmSaveas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAs();
            }
        });
        itmOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                open();
            }
        });
        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                open();
            }
        });
        itmNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                open_new();
            }
        });
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                open_new();
            }
        });
        itmExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ask = JOptionPane.showConfirmDialog(JavaApplicationNotepad.this, "Are you sure you want to exit " + getTitle() + " ?");
                if (ask == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        itmCut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainarea.cut();
            }
        });
        btnCut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainarea.cut();
            }
        });
        itmCopy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainarea.copy();
            }
        });
        btnCopy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainarea.copy();
            }
        });
        itmPaste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainarea.paste();
            }
        });
        btnPaste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainarea.paste();
            }
        });
        mainarea.setLineWrap(true);
        wordWrap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (wordWrap.isSelected()) {
                    mainarea.setWrapStyleWord(true);
                } else {
                    mainarea.setWrapStyleWord(false);
                }
            }
        });

        itmFontColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = JColorChooser.showDialog(rootPane, "Choose Font Color", Color.GRAY);
                mainarea.setForeground(c);

            }
        });

        itmFont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font.setVisible(true);
            }
        });
        btnFont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font.setVisible(true);
            }
        });

        font.getOk().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainarea.setFont(font.font());
                font.setVisible(false);
            }
        });
        font.getCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font.setVisible(false);
            }
        });

        itmhelpAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aH.setVisible(true);
            }
        });
        itmOpenFileimages.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openImg.setVisible(true);
            }
        });

    }

    private void initComponent() {

        jc = new JFileChooser(".");
        mainarea = new JTextArea();
        font = new FontHelper();
        aH = new NewClassAbout();
        openImg = new OpenFileImages();
        toolbar = new JToolBar();
        getContentPane().add(toolbar, BorderLayout.NORTH);
        getContentPane().add(mainarea);
        getContentPane().add(new JScrollPane(mainarea), BorderLayout.CENTER);
        setTitle("Untitled Notepad");
        setSize(500, 400);

        //menu bar
        mbar = new JMenuBar();

        //menu
        mnuFile = new JMenu("File");
        mnuEdit = new JMenu("Edit");
        mnuFormat = new JMenu("Format");
        mnuHelp = new JMenu("Help");

        ImageIcon newIcon = new ImageIcon(getClass().getResource("/img/IconNew.png/"));
        ImageIcon newOpen = new ImageIcon(getClass().getResource("/img/IconOpen.png"));
        ImageIcon newSave = new ImageIcon(getClass().getResource("/img/IconSave.png"));
        ImageIcon newCut = new ImageIcon(getClass().getResource("/img/IconCut.png"));
        ImageIcon newCopy = new ImageIcon(getClass().getResource("/img/IconCopy.png"));
        ImageIcon newPaste = new ImageIcon(getClass().getResource("/img/IconPaste.png"));
        ImageIcon newFont = new ImageIcon(getClass().getResource("/img/IconFont.png"));

        btnNew = new JButton(newIcon);
        toolbar.add(btnNew);
        btnOpen = new JButton(newOpen);
        toolbar.add(btnOpen);
        btnSave = new JButton(newSave);
        toolbar.add(btnSave);
        btnCut = new JButton(newCut);
        toolbar.add(btnCut);
        btnCopy = new JButton(newCopy);
        toolbar.add(btnCopy);
        btnPaste = new JButton(newPaste);
        toolbar.add(btnPaste);
        btnFont = new JButton(newFont);
        toolbar.add(btnFont);

        //menu item
        itmNew = new JMenuItem("New", newIcon);
        itmOpen = new JMenuItem("Open", newOpen);
        itmSave = new JMenuItem("Save", newSave);
        itmSaveas = new JMenuItem("Save As");
        itmExit = new JMenuItem("Exit");
        itmCut = new JMenuItem("Cut", newCut);
        itmCopy = new JMenuItem("Copy", newCopy);
        itmPaste = new JMenuItem("Paste", newPaste);
        wordWrap = new JCheckBoxMenuItem("Word Wrap");
        itmFontColor = new JMenuItem("FontColor");
        itmFont = new JMenuItem("Font...", newFont);
        itmhelpAbout = new JMenuItem("About Notepad");
        itmOpenFileimages = new JMenuItem("Open File Images");

        //add shortcut
        itmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        itmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        itmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        itmCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        itmCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        itmPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

        //add menu item
        mnuFile.add(itmNew);
        mnuFile.add(itmOpen);
        mnuFile.add(itmSave);
        mnuFile.add(itmSaveas);
        mnuFile.addSeparator();
        mnuFile.add(itmExit);
        mnuEdit.add(itmCut);
        mnuEdit.add(itmCopy);
        mnuEdit.add(itmPaste);
        mnuEdit.addSeparator();
        mnuEdit.add(wordWrap);
        mnuFormat.add(itmFontColor);
        mnuFormat.add(itmFont);
        mnuFormat.addSeparator();
        mnuFormat.add(itmOpenFileimages);
        mnuHelp.add(itmhelpAbout);

        //add menu item to menu bar
        mbar.add(mnuFile);
        mbar.add(mnuEdit);
        mbar.add(mnuFormat);
        mbar.add(mnuHelp);

        // add menu bar to frame
        setJMenuBar(mbar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void save() {
        PrintWriter fout = null;

        try {
            if (filename == null) {
                saveAs();
            } else {
                fout = new PrintWriter(new FileWriter(filename));
                String s = mainarea.getText();
                StringTokenizer st = new StringTokenizer(s, System.getProperty("line.separator"));
                while (st.hasMoreElements()) {
                    fout.println(st.nextToken());
                }
                JOptionPane.showMessageDialog(rootPane, "File Saved");
                fileContent = mainarea.getText();
            }

        } catch (IOException e) {
        } finally {
            if (fout != null) {
                fout.close();
            }

        }
    }

    private void saveAs() {
        PrintWriter fout = null;
        int retval = -1;
        try {
            retval = jc.showSaveDialog(this);
            if (retval == JFileChooser.APPROVE_OPTION) {
                fout = new PrintWriter(new FileWriter(jc.getSelectedFile()));
            }

            String s = mainarea.getText();
            StringTokenizer st = new StringTokenizer(s, System.getProperty("line.separator"));
            while (st.hasMoreElements()) {
                fout.println(st.nextToken());
            }
            //show dialog box after save file 
            JOptionPane.showMessageDialog(rootPane, "File Saved");
            fileContent = mainarea.getText();

            // add name of file after save on topboxtitle
            filename = jc.getSelectedFile().getName();
            setTitle(filename = jc.getSelectedFile().getName());
        } catch (IOException e) {
        } finally {
            fout.close();
        }
    }

    private void open() {
        try {
            int retval = jc.showOpenDialog(this);
            if (retval == JFileChooser.APPROVE_OPTION) {
                mainarea.setText(null);
                FileReader in = new FileReader(jc.getSelectedFile());
                char[] buff = new char[100000];
                int nch;
                while ((nch = in.read(buff, 0, buff.length)) != -1) {
                    mainarea.append(new String(buff, 0, nch));
                }
                filename = jc.getSelectedFile().getName();
                setTitle(filename = jc.getSelectedFile().getName());
            }

        } catch (IOException e) {
        }
    }

    private void open_new() {
        if (!mainarea.getText().equals("") && !mainarea.getText().equals(fileContent)) {
            if (filename == null) {
                int option = JOptionPane.showConfirmDialog(rootPane, "Do you want to save changes to Untitled?");
                if (option == 0) {
                    saveAs();
                    clear();
                } else if (option == 2) {
                } else {
                    clear();
                }
            } else {
                int option = JOptionPane.showConfirmDialog(rootPane, "Do you want to save changes to Untitled?");
                if (option == 0) {
                    save();
                    clear();
                } else if (option == 2) {
                } else {
                    clear();
                }
            }
        } else {
            clear();
        }
    }

    private void clear() {
        mainarea.setText(null);
        setTitle("Untitled Notepad");
        filename = null;
        fileContent = null;
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JavaApplicationNotepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JavaApplicationNotepad jn = new JavaApplicationNotepad();
            }
        });
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                OpenFileImages openFileImages = new OpenFileImages();
            }
        });

    }
}
