package com.whalex.webflux;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class DemoController {

    @RequestMapping("/demo")
    public Mono<String> demo(){
        return Mono.just("demo");
    }

}
