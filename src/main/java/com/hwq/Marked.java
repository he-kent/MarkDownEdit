package com.hwq;

import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import javax.swing.*;

public class Marked {
    /**
     * 使用CommonMark 解析markdown 语法，并生成html
     * */
    public static String parse(String markdown){

        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String html = renderer.render(parser.parse(markdown));

        return html;
    }

}
