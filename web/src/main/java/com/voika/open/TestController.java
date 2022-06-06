package com.voika.open;

import com.voika.infrastructure.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
//@RequiresAuthentication
public class TestController {

    @RequestMapping("/test")
    public JsonData test() {
        return JsonData.success("successfuly!!");
    }

}
