package shops.shops.emailsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import shops.shops.userentity.User;
@Service
public class Emailsender {
     @Autowired
    private JavaMailSender emailsender;

    public void sendemail(User user ){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("kelvinaddogh86@gmail.com");
        message .setTo(user.getGmail());
        message.setSubject("welcome to our website");
        message.setText("hello " + user.getName() +"Welcome to our website! We're happy to have you here.\r\n" + //
                        "\r\n" + //
                        "Thank you for signing in with Google.\r\n" + //
                        "\r\n" + //
                        "Best regards,\r\n" + //
                        "The Team");

        emailsender.send(message);     
    }
    
}