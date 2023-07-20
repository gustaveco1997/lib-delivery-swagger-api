package br.com.luminaapps.transportlayer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class SwaggerController {

    @GetMapping("/api")
    public RedirectView getRedirectUrl() {
        return new RedirectView("/swagger-ui/");
    }
}
