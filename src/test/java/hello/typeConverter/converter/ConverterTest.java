package hello.typeConverter.converter;

import hello.typeConverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class ConverterTest {

    @Test
    void ipPortTToString(){
        StringToIpPortConverter converter = new StringToIpPortConverter();
        String source = "127.0.0.1:8080";
        IpPort result = converter.convert(source);
        Assertions.assertThat(result).isEqualTo(new IpPort("127.0.0.1",8080)); //IP랑 PORT가 같으면 TRUE가 반환되게
    }
}
