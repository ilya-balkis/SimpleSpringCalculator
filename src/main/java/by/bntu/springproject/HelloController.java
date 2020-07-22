package by.bntu.springproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class HelloController {
    @GetMapping("/calculator")
    public String sayHello(HttpServletRequest request, Model model) {
        int a = Integer.valueOf(request.getParameter("a"));
        int b = Integer.valueOf(request.getParameter("b"));
        String action = request.getParameter("action");

        double result;

        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a / (double) b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "addition":
                result = a + b;
                break;
            default:
                result = 0;
                break;
        }

        model.addAttribute("answer", "Answer: " + result);

        return "first/calculator";
    }
}
