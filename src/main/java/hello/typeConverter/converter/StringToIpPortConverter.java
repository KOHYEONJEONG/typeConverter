package hello.typeConverter.converter;


import hello.typeConverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;//이걸로 import 해야함!!!

@Slf4j
public class StringToIpPortConverter implements Converter<String, IpPort> {//둘에 위치가 중요함.

    @Override
    public IpPort convert(String source) {
        log.info("convert source={}", source);

        //"127.0.0.1:8080"
        String[] split = source.split(":");
        String ip = split[0];
        int port = Integer.parseInt(split[1]);
        
        //문자를 객체로 변환
        return new IpPort(ip, port);
    }
}
