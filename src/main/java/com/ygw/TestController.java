package com.ygw;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rto.TestRTO;

import javax.validation.Valid;

@Controller
@RequestMapping("api")
public class TestController {
    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public TestRTO test(@RequestBody @Valid TestRTO testRTO)  {
        return testRTO;
    }
}