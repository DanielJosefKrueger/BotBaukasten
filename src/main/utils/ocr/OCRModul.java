package main.utils.ocr;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.ocr.TesseractOCRConfig;
import org.apache.tika.parser.pdf.PDFParserConfig;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.*;

public class OCRModul {


    private final String tesseractPath;

    public OCRModul(String tesseractPath){
        this.tesseractPath = tesseractPath;
    }



    public String getOCROfImage(final BufferedImage image) throws IOException, TikaException, SAXException {


        final Parser parser = new AutoDetectParser();
        final BodyContentHandler handler = new BodyContentHandler(Integer.MAX_VALUE);
        final TesseractOCRConfig tesseractOCRConfig = new TesseractOCRConfig();
        tesseractOCRConfig.setTesseractPath(tesseractPath);
        tesseractOCRConfig.setLanguage("deu");

        final PDFParserConfig pdfConfig = new PDFParserConfig();
        pdfConfig.setExtractInlineImages(true);
        pdfConfig.setExtractUniqueInlineImagesOnly(false); // set to false if


        // pdf contains
        // multiple images.
        final ParseContext parseContext = new ParseContext();
        parseContext.set(TesseractOCRConfig.class, tesseractOCRConfig);
        parseContext.set(PDFParserConfig.class, pdfConfig);
        // need to add this to make sure recursive parsing happens!
        parseContext.set(Parser.class, parser);
        final Metadata metadata = new Metadata();

        try(ByteArrayOutputStream os = new ByteArrayOutputStream()){
             ImageIO.write(image, "jpg", os);
             try(InputStream is = new ByteArrayInputStream(os.toByteArray())){
                 parser.parse(is, handler, metadata, parseContext);
             }
        }
        return handler.toString();
    }




    public String getOCROfFile(final File pdf) throws IOException, TikaException, SAXException {
        final Parser parser = new AutoDetectParser();
        final BodyContentHandler handler = new BodyContentHandler(Integer.MAX_VALUE);
        final TesseractOCRConfig tesseractOCRConfig = new TesseractOCRConfig();
        tesseractOCRConfig.setTesseractPath(tesseractPath);
        //tesseractOCRConfig.setLanguage(configuration.getOcrPacket());

        final PDFParserConfig pdfConfig = new PDFParserConfig();
        pdfConfig.setExtractInlineImages(true);
        pdfConfig.setExtractUniqueInlineImagesOnly(false); // set to false if






        // pdf contains
        // multiple images.
        final ParseContext parseContext = new ParseContext();
        parseContext.set(TesseractOCRConfig.class, tesseractOCRConfig);
        parseContext.set(PDFParserConfig.class, pdfConfig);
        // need to add this to make sure recursive parsing happens!
        parseContext.set(Parser.class, parser);
        final FileInputStream stream = new FileInputStream(pdf);
        final Metadata metadata = new Metadata();
        parser.parse(stream, handler, metadata, parseContext);
        return handler.toString();
    }

}
