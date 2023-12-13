package org.example;

import cn.apiclub.captcha.Captcha;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class CaptchaRecognition {
    private CaptchaRecognition() {
    }

    public static String recognize(final Captcha captcha) throws TesseractException {
        final var tesseract = new Tesseract();
        tesseract.setDatapath("tessdata");
        final var image = captcha.getImage();
        return tesseract.doOCR(image);
    }
}
