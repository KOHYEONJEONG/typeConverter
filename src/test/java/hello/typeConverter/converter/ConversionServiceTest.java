package hello.typeConverter.converter;

import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;
import static org.assertj.core.api.Assertions.*;

public class ConversionServiceTest {
    //컨버전 서비스
    //ㄴ 개발 컨버터를 모아두고 그것들을 묶어서 편리하게 사용하는 기능

    @Test
    void conversionService(){

        //등록
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());




    }
}
