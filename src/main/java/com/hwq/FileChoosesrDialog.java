package com.hwq;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FileChoosesrDialog extends JFrame implements ActionListener {
    // GUI components
    private JButton btnSave;
    private JTextField txtFileName;
    private JTextArea editorTextArea; // 编辑器文本框
    private JTextPane previewTextPane; // 预览文本框

    public FileChoosesrDialog(JTextArea editorTextArea) {
// Set window properties
        setTitle("File Save Example");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.editorTextArea = editorTextArea;
// Create components

        txtFileName = new JTextField(20);


        btnSave = new JButton("Save");
        btnSave.addActionListener(this);

// Add components to layout
        JPanel panel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout());

        topPanel.add(txtFileName);
        panel.add(topPanel, BorderLayout.NORTH);

        panel.add(btnSave, BorderLayout.SOUTH);
        setContentPane(panel);
    }

    public void actionPerformed(ActionEvent e) {
// Handle button click event
        if (e.getSource() == btnSave) {
            saveFile();
        }
    }

    private void saveFile() {
// Get file name and content
        String fileName = txtFileName.getText().trim();
        String content = editorTextArea.getText();

// Validate file name and content
        if (fileName.isEmpty() || content.isEmpty()) {
            JOptionPane.showMessageDialog(this, "File name and content cannot be empty!");
            return;
        }

// Open file chooser dialog and get selected file path
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);
        if (result != JFileChooser.APPROVE_OPTION) {
            return;
        }

// Write content to file
        File file = fileChooser.getSelectedFile();
        try (Writer writer = new FileWriter(file)) {
            writer.write(content);
            JOptionPane.showMessageDialog(this, "File saved successfully!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
        }
    }


}
