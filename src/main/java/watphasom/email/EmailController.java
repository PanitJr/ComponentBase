package watphasom.email;

import watphasom.user.User;
import watphasom.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

/**
 * Created by panit on 5/7/2016.
 */
@CrossOrigin
@RestController
public class EmailController {
        private final Logger logger = LoggerFactory.getLogger(EmailController.class);
        @Autowired
        private EmailSender smtpMailSender;
        @Autowired
        private UserService userService;

        @RequestMapping(value = "/passwordRecovery",method = RequestMethod.POST)
        public void sendMail(@RequestBody User user) throws MessagingException {
                 user = userService.findByEmail(user.getEmail());
                logger.info("email:"+user.getEmail());
                logger.info("user:"+user);
            smtpMailSender.send(user.getEmail(), "Watphasom Recovery", "Hello "+user.getUsername()
            +"<br/> you can reset your password <a href=\"http://localhost:3000/#/resetPassword/"+user.getId()+"\">here</a>");
        }
}
