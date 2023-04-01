package com.hwq;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class SaveActionListener extends JFrame implements ActionListener {
    private JTextPane previewTextPane;
    private JTextArea editorTextArea; // 编辑器文本框
    private String markdown;
    public SaveActionListener(JTextPane previewTextPane,JTextArea editorTextArea){
        this.previewTextPane = previewTextPane;
        this.editorTextArea = editorTextArea;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        updatePreviewPane(editorTextArea.getText());
    }
    private void updatePreviewPane(String mark) {

        String html = "";
        try {
            html = Marked.parse(mark);
            previewTextPane.setContentType("text/html");
            previewTextPane.setText(html);
//            new FileChoosesrDialog(editorTextArea).setVisible(true);
            // Open file chooser dialog and get selected file path
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(this);
            if (result != JFileChooser.APPROVE_OPTION) {
                return;
            }

// Write content to file
            File file = fileChooser.getSelectedFile();
            try (Writer writer = new FileWriter(file)) {
                writer.write(editorTextArea.getText());
                JOptionPane.showMessageDialog(this, "File saved successfully!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("解析完成");

        }
    }
}
