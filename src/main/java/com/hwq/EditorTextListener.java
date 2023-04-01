package com.hwq;

import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorTextListener implements DocumentListener {
    private JTextPane previewTextPane; // 预览文本框
    private JTextArea editorTextArea; // 编辑器文本框
    public EditorTextListener(){}
    public EditorTextListener(JTextPane previewTextPane,JTextArea editorTextArea){
        this.previewTextPane = previewTextPane;
        this.editorTextArea = editorTextArea;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateOutput();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateOutput();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        updateOutput();
    }

    // 将输入框中的Markdown语法渲染为HTML，并更新输出框的内容
    private void updateOutput() {
        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();

        Document doc = editorTextArea.getDocument();
        String input = "";
        try {
            input = doc.getText(0, doc.getLength());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String output = renderer.render(parser.parse(input));

        previewTextPane.setText(output);
    }
}
