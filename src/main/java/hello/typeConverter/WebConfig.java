package hello.typeConverter;

import hello.typeConverter.converter.IpPortToStringConverter;
import hello.typeConverter.converter.StringToIpPortConverter;
import hello.typeConverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer { //WebMvcConfigurer 스프링에 무엇인가 등록할때 사용하는 클래스이다.

    //추가한 컨버터가 스프링의 무수한 기존 컨버터보다 먼저 실행되는 우선순위를 가진다.

    /** 컨버전 서비스 : 등록한 컨버터 및 포맷터를 관리, 스프링에서 일관성있게 사용하기 위해서 */
    @Override
    public void addFormatters(FormatterRegistry registry) {//Converter 및 포맷터를 등록하는 메서드
        //컨버터
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());

        //포맷터
        registry.addFormatter(new MyNumberFormatter());

    }
}
