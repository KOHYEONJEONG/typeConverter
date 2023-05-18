package hello.typeConverter.formatter;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Locale;


class MyNumberFormatterTest {

    MyNumberFormatter formatter = new MyNumberFormatter();

    @Test
    void parse() throws ParseException {

        Number result = formatter.parse("1,000", Locale.KOREA);    //text=1,000, local=ko_KR

        assertThat(result).isEqualTo(1000L);//Long 타입 주의
    }

    @Test
    void print() {

        String result = formatter.print(1000, Locale.KOREA);//10:44:45.657 [main] INFO hello.typeConverter.formatter.MyNumberFormatter - object=1000, local=ko_KR
        assertThat(result).isEqualTo("1,000");
    }
}