package com.xjw.springboot.admin.util;

import com.aspose.words.Document;
import com.aspose.words.FontSettings;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * aspose组件word转PDF
 * <p>需导入aspose-words-14.9.0-jdk16.jar、license.xml</p>
 */

public class AsposeWordPDF {

    private static Logger log = LoggerFactory.getLogger(AsposeWordPDF.class);

    /**
     * Word文档转换PDF
     * <p>支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换</p>
     *
     * @param docFile    word文件
     * @param outPdfFile 输入pdf文件
     */

    public static void word2pdf(String docFile, String outPdfFile){
        log.info("输入合同DOC文件路径：【{}】", docFile);
        log.info("输出合同PDF文件路径: 【{}】", outPdfFile);
        // 验证License
        if (!getLicense()) {
            return;
        }
        FileOutputStream os = null;
        try {
            File file = new File(outPdfFile);
            File pathFile = new File(file.getParent());
            if (!pathFile.exists()) {
                pathFile.mkdirs();
            }
            os = new FileOutputStream(file);
            // 线上这里报异常 com.aspose.words.FileCorruptedException: The document appears to be corrupted and cannot be loaded.
            Document doc = new Document(docFile);
            // 设置一个字体目录
            String path = AsposeWordPDF.class.getClassLoader().getResource("fonts").getPath();
            FontSettings.setFontsFolder(path, false);
            doc.save(os, SaveFormat.PDF);
            log.info("word转pdf成功,word文件:【{}】; PDF文件:【{}】", docFile, outPdfFile);
        } catch (Exception e) {
            log.error("word转pdf异常, word文件:【{}】", docFile, e);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    log.error("word转pdf关闭流异常", e);
                }
            }
        }
    }

    public static void html2word(String htmlFile, String outDocFile) {
        // 验证License
        if (!getLicense()) {
            return;
        }
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(outDocFile);
            Document html = new Document(htmlFile);
            html.save(os, SaveFormat.HTML);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    log.error("html转word关闭流异常", e);
                }
            }
        }
    }


    /**
     * 获取license
     *
     * @return
     */
    public static boolean getLicense() {
        boolean result = false;
        InputStream is = null;
        try {
            is = AsposeWordPDF.class.getClassLoader().getResourceAsStream("license.xml");
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            log.error("asp许可证认证失败", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    log.error("获取license关闭流异常", e);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String docFile = "E:\\交接文档.docx";
        String pdfFilePath = docFile.substring(0, docFile.lastIndexOf(".")) + "." + "pdf";
        word2pdf(docFile, pdfFilePath);
    }
}

