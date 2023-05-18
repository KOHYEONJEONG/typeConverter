package hello.typeConverter.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**특정 컨트롤러에만 적용하려면 스프링 컨트롤러 databinder로 검색해서 사용하자*/
@Slf4j
public class MyNumberFormatter implements Formatter<Number> { //Number 타입은 Integer , Long 과 같은 숫자 타입의 부모 클래스
    //String은 기본으로 변환되기 때문에, 변환할 자료형인 Number만 넣어주면된다.

    //포맷터는 컨버터의 특별한 버전으로 이해하면 된다
    //Formatter 는 문자에 특화(객체 문자, 문자 객체) + 현지화(Locale)

    @Override
    public Number parse(String text, Locale locale) throws ParseException {

        log.info("text={}, locale={}", text, locale);

        //자바에서 제공
        NumberFormat format = NumberFormat.getInstance(locale);

        //문자->숫자
        return format.parse(text);//"1,000" -> 1000
    }

    @Override
    public String print(Number object, Locale locale) {
        log.info("object={}, locale={}", object, locale);

        return NumberFormat.getInstance(locale).format(object);

    }



}
