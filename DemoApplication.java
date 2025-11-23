package gov.om.tra.rest.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
    @RestController
    public class HelloController {

        @GetMapping
        public String nothing() {
            return "Please add a path";
        }

        @GetMapping("/hello")
        public String hello(@RequestParam (required = false, defaultValue = "Guest") String name) {

            return "Hello " + name;
        }

        @GetMapping("/sum")
        public String sum(@RequestParam int a, @RequestParam int b) {
            return "sum = " + (a + b);
        }
        @GetMapping("/info")
        public Map <String, String> info(){
            Map<String, String> data = new HashMap<>();
            data.put("name", "Ali");
            data.put("city", "Muscat");
            data.put("language", "Java");
            return data;
        }
        @GetMapping("/greet")
        public String greet(@RequestParam String name) {
            return "Greetings, " + name;
        }
        @GetMapping("/upper")
        public String upper(@RequestParam String text) {
            return text.toUpperCase();
        }
        @GetMapping("/random")
        public int random() {
            return (int) (Math.random() * 100) + 1 ;
        }
    }
}
