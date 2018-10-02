package duo.code.rest.webservices.resfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String HelloWorld() {
        return "Hello world!";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world-bean")
    public HelloWorldBean HelloWorldBean() {
        return new HelloWorldBean("Hello world!");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world/path-variable/{name}")
    public HelloWorldBean HelloWorldPathVariable (@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello world, %s", name));
    }

    @GetMapping("/hello-world-internationalized")
    public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required = false)Locale locale) {
        return messageSource.getMessage("good.morning.message", null, locale);
    }

}

