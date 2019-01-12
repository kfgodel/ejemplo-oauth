package info.kfgodel.oauthtest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller que muestra datos del usuario logueado como json
 * Date: 12/01/19 - 16:49
 */
@RestController
public class IndexController {

  @GetMapping("/")
  public Authentication index(){
    return SecurityContextHolder.getContext().getAuthentication();
  }
}
