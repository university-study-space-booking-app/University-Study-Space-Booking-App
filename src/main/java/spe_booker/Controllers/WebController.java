package spe_booker.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import spe_booker.Services.UserService;
import spe_booker.models.User;

import java.util.Optional;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(WebController.class);

    @Autowired
    private UserService userService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login");
        registry.addViewController("/terms");
    }

    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        Optional<User> user = userService.getCurrentUser();
        if (!user.isPresent()) {
            LOG.info("User not found");
            return "/";
        } else {
            if (user.get().getBlacklisted()) {
                model.addAttribute("blacklisted", true);
            } else {
                model.addAttribute("blacklisted", false);
            }
            return "home";
        }
    }





}