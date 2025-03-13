package io.springboot.resume_portal;

import io.springboot.resume_portal.models.User;
import io.springboot.resume_portal.models.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
public class   HomeController {

    @Autowired
    UserProfileRepository userProfileRepository;


    @GetMapping("/")
    public String home() {
        return "Hello ";
    }
    @GetMapping("/edit")
    public String edit() {
        return "edit page ";
    }

    @GetMapping("/view/{userId}")
    public String view(@PathVariable String userId, Model model) {


        Optional<UserProfile> userProfileOptional  = userProfileRepository.findByUserName(userId);
        userProfileOptional.orElseThrow(() -> new RuntimeException("Not found: " + userId));

        model.addAttribute("userId", userId);
        UserProfile userProfile = userProfileOptional.get();
        model.addAttribute("userProfile", userProfile);
        return "profile-templates/" + userProfile.getId() + "/index";
    }
}

