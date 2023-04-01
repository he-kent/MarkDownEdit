package com.hwq;

import javax.swing.*;
import java.awt.*;

public class MarkdownHelpWindow extends JFrame {
private String link = "https://daringfireball.net/projects/markdown/syntax";

public MarkdownHelpWindow() {
initComponents();
}

private void initComponents() {
// 创建一个标签，用于显示官方链接
JLabel linkLabel = new JLabel("<html><a href='" + link + "'>Markdown 官方链接</a></html>");
linkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
linkLabel.addMouseListener(new java.awt.event.MouseAdapter() {
public void mouseClicked(java.awt.event.MouseEvent evt) {
try {
java.awt.Desktop.getDesktop().browse(java.net.URI.create(link));
} catch (Exception e) {
e.printStackTrace();
}
}
});
this.add(linkLabel, BorderLayout.NORTH);

// 创建一个文本框，用于显示Markdown语法
JTextPane textPane = new JTextPane();
textPane.setContentType("text/html");
textPane.setText("<html><body>" +
"<h1>Markdown 语法</h1>\n" +
"<p>Markdown是一种轻量级标记语言，它十分简单易学，可以快速方便地将文本转换为HTML格式。</p>\n" +
"<h2>基本语法</h2>\n" +
"<ul>\n" +
"<li>标题：用 #（1-6个）来定义 </li>\n" +
"<li>列表：使用 * 或 + 或 - 表示无序列表，数字表示有序列表</li>\n" +
"<li>引用：使用 > 表示引用</li>\n" +
"<li>粗体和斜体：使用 * 或 _ 来表示</li>\n" +
"<li>代码块：用 `` 来表示</li>\n" +
"</ul>\n" +
"</body></html>");
this.add(new JScrollPane(textPane), BorderLayout.CENTER);

// 设置窗口大小和可见性
this.setSize(600, 400);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//this.setVisible(true);
}

public static void main(String[] args) {
new MarkdownHelpWindow();
}
}