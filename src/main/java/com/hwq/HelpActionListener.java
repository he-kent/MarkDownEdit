package com.hwq;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpActionListener implements ActionListener {
    private MarkdownHelpWindow markdownHelpWindow=null;
    public HelpActionListener(){
        markdownHelpWindow= new MarkdownHelpWindow();
        markdownHelpWindow.setResizable(true);
        markdownHelpWindow.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(markdownHelpWindow.isShowing()){
            //如果窗口已经显示，将窗口显示在其他窗口之上
            markdownHelpWindow.toFront();
        }
        if(!markdownHelpWindow.isVisible()){
            markdownHelpWindow.setVisible(true);
        }

    }
}
