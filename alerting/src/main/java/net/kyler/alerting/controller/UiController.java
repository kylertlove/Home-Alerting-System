package net.kyler.alerting.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class UiController {

    static List<String> searchResults =
        List.of("one", "two", "three", "four", "five");
    
    @GetMapping("/")
    public String getMethodName(Model model) {
        return "index";
    }

    @GetMapping("/search")
    public String search(String q, Model model) {
        var filtered = searchResults
                .stream()
                .filter(s -> s.startsWith(q.toLowerCase()))
                .toList();
        model.addAttribute("results", filtered);
        return "search :: results";
    }

    @PostMapping("/clicked")
    public String clicked(Model model) {
        model.addAttribute("now", LocalDateTime.now().toString());
        return "clicked :: result";
    }

    @PostMapping("/findCustomer")
    @ResponseBody
    public String findCustomer(@RequestParam("customerLookup") String customerLookup) {
        
        return customerLookup;
    }
    
    
}
