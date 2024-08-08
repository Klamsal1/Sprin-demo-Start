package Ektha.Bench;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

          @GetMapping ("/")
       public  String Welcome(){

           return " Welcome to java";
       }
}
