package hello.typeConverter.converter;

import hello.typeConverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class IpPortToStringConverter implements Converter<IpPort, String> {//둘에 위치가 중요함.

    @Override
    public String convert(IpPort source) {
        log.info("convert source={}", source);

        //IpPort 객체를 -> "127.0.0.1:8080" 문자로 변환해서~
        return source.getIp()+":"+source.getPort();
    }
}
