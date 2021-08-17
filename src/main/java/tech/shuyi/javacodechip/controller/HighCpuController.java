package tech.shuyi.javacodechip.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ronald
 * @description
 * @date 2021/7/5
 */
@SpringBootApplication
@RestController
@RequestMapping("/api")
public class HighCpuController {
    @RequestMapping("/cpu")
    public String testCpu() {
        System.out.println("request cpu");
        while (true) {

        }
    }
}