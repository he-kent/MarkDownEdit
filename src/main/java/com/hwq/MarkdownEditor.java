package com.hwq;

import javax.swing.*;
import java.awt.*;
/**
 * 编辑器主页面类
 * */
public class MarkdownEditor extends JFrame {
    private JTextArea editorTextArea; // 编辑器文本框
    private JTextPane previewTextPane; // 预览文本框
    private JScrollPane editorScrollPane; // 编辑器滚动条
    private JScrollPane previewScrollPane; // 预览滚动条
    private JToolBar toolBar; // 工具栏
    private  Dimension screenSize =null;
    public MarkdownEditor() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 获取屏幕大小
        initUI();
    }
    private void initUI() {
        setTitle("Markdown Editor");
        setSize(screenSize.width, screenSize.height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true); //窗口是否可以缩放
        setExtendedState(JFrame.MAXIMIZED_BOTH);//设置窗口全屏模式
//        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
//        device.setFullScreenWindow(this);
//        GraphicsConfiguration config = device.getDefaultConfiguration();
//        //获取窗口显示模式
//        DisplayMode currentMode = device.getDisplayMode();
//        //返回当前全屏窗口
//        Window fullScreenWindow = device.getFullScreenWindow();
        Insets insets = new Insets(10, 20, 10, 20); // 上、下、左、右四个方向的边距大小

        // 初始化编辑器文本框
        editorTextArea = new JTextArea();
        editorTextArea.setLineWrap(true);
        editorTextArea.setMargin(insets);

        // 初始化编辑器滚动条
        editorScrollPane = new JScrollPane(editorTextArea);
        editorScrollPane.setPreferredSize(new Dimension(this.getWidth()/2, this.getHeight()));
        editorScrollPane.setWheelScrollingEnabled(true);
        editorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        editorScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        // 初始化预览文本框
        previewTextPane = new JTextPane();
        previewTextPane.setMargin(insets);
        previewTextPane.setEditable(false);
        previewTextPane.setContentType("text/html");
        editorTextArea.getDocument().addDocumentListener(new EditorTextListener(previewTextPane,editorTextArea));
        // 初始化预览滚动条
        previewScrollPane = new JScrollPane(previewTextPane);
        previewScrollPane.setPreferredSize(new Dimension(this.getWidth()/2, this.getHeight()));
        previewScrollPane.setWheelScrollingEnabled(true);
        previewScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        previewScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        // 初始化工具栏
        toolBar = new JToolBar();
        JButton saveButton = new JButton("保存");
        saveButton.addActionListener(new SaveActionListener(previewTextPane,editorTextArea));
        toolBar.add(saveButton);

         JButton helpButton = new JButton("MarkDown语法帮助");
        helpButton.addActionListener(new HelpActionListener());
        toolBar.add(helpButton);
        // 布局
        setLayout(new BorderLayout());
        add(toolBar, BorderLayout.NORTH);
        add(editorScrollPane, BorderLayout.WEST);
        add(previewScrollPane, BorderLayout.CENTER);


    }

}
