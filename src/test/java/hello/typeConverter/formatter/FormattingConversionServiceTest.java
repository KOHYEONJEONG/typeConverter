package hello.typeConverter.formatter;

import hello.typeConverter.converter.IpPortToStringConverter;
import hello.typeConverter.converter.StringToIpPortConverter;
import hello.typeConverter.type.IpPort;
import static  org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;

public class FormattingConversionServiceTest {

    @Test
    void formattingConversionService(){

        //실제 등록할때는 WebConfig.java에 implements WebMvcConfigurer 를 사용해서 addFormtatter메서드를 이용하여 컨버터와 포맷터를 등록해서 사용한다.

        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();//DefaultFormattingConversionService는 컨버터와 포맷터 둘다 등록 가능하다.

        //컨버터 등록 (addConverter)
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        //포맷터 등록 (addFormatter)
        conversionService.addFormatter(new MyNumberFormatter());

        //컨버터 사용 (사용:convert)
        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));


        //포맷터 사용 (사용:convert)
        assertThat(conversionService.convert(1000, String.class)).isEqualTo("1,000");
        assertThat(conversionService.convert("1,000", Long.class)).isEqualTo(1000L);

    }


}
