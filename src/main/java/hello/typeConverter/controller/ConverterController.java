package hello.typeConverter.controller;

import hello.typeConverter.type.IpPort;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Locale;

@Slf4j
@Controller
public class ConverterController {

    //WebConfig.java에 등록하여 사용하는 컨버터와 포맷터를 예제이다.

    @GetMapping("/converter-view")
    public String converterView(Locale locale, Model model){

        //포맷터할때 Local(지역화)가 들어가는데 요청시 header에 있는 Accept-Language(웹 브라우저가 인식할 수 있는 언어)에 있는 ko가 들어간다.
        log.info("locale={}", locale);

        model.addAttribute("number", 10000);
        model.addAttribute("ipPort", new IpPort("127.0.0.1", 8080));

        //view단에서 ${{}}단을 실행하여 10000은 -> 10,000으로 포맷터 해준다.
        return "converter-view";
    }

    @GetMapping("/converter/edit")
    public String converterForm(Model model){

        IpPort ipPort = new IpPort("127.0.0.1",8080);
        Form form = new Form(ipPort);

        //IpPortToStringConverter 실행
        model.addAttribute("form", form);//view 템플릿에 보여질때는 객체를 문자로 (객체->문자_
        return "converter-form";

    }

    /**등록된 컨버전은 @ModelAttribute에서 사용해도 우선순위로 적용된다.*/
    @PostMapping("/converter/edit")
    public String converterEdit(@ModelAttribute Form form, Model model){
        //StringToIpPortConverter

        //문자가 객체로 넘어온다.
        IpPort ipPort = form.getIpPort();
        model.addAttribute("ipPort", ipPort);
        return "converter-view";
    }


    @Data
    static class Form{
        private IpPort ipPort;

        public Form(IpPort ipPort){
            this.ipPort = ipPort;
        }
    }
}
