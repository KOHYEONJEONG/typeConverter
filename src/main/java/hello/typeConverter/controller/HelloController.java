package hello.typeConverter.controller;

import hello.typeConverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request){
        String data = request.getParameter("data");//무조건 문자형으로 들어온다.
        Integer intValue = Integer.valueOf(data); //예전에는 int형으로 변환해서 바꿔줬었다.
        log.info("intValue = {}",intValue);


        return "ok";
    }

    /** http://localhost:8081/hello-v2?data=10,000
     *  ㄴ 등록한 포맷터가 실행되어 문자인 숫자를(쉼표가 있는 숫자) 숫자로 변환해준다.
     * */
    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data){

        log.info("data = {}",data);//10000
        return "ok";
    }


    @GetMapping("/ip-port")
    public String ipPort(@RequestParam IpPort ipPort) { //등록한 컨버터가 실행된다.

        //http://localhost:8081/ip-port?ipPort=127.0.0.1:8080

        System.out.println("ipPort IP = " + ipPort.getIp()); //ipPort IP = 127.0.0.1
        System.out.println("ipPort PORT = " + ipPort.getPort());//ipPort PORT = 8080

        return "ok";
    }
}
