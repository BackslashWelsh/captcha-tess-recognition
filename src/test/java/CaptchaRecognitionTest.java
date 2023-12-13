import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.text.renderer.DefaultWordRenderer;
import net.sourceforge.tess4j.TesseractException;
import org.example.CaptchaRecognition;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CaptchaRecognitionTest {

    @Test
    void shouldRecognizeCaptcha() throws TesseractException {
        final var captcha = generateCaptcha();
        final var recognize = CaptchaRecognition.recognize(captcha);
        assertEquals(captcha.getAnswer(), recognize.trim());
    }

    static Captcha generateCaptcha() {
        var colors = new ArrayList<Color>();
        colors.add(Color.WHITE);

        var fonts = new ArrayList<Font>();
        fonts.add(new Font("Geneva", 2, 32));

        var wordRenderer = new DefaultWordRenderer(colors, fonts);

        return new Captcha.Builder(100, 50).addText(wordRenderer).build();
    }
}
