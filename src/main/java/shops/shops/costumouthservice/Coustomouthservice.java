package shops.shops.costumouthservice;

 /* import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import shops.shops.userentity.User;
import shops.shops.userrepository.UserRepository;
@Service
public class Coustomouthservice extends DefaultOAuth2UserService{
    @Autowired
    private UserRepository userrepository;

 @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String name = oAuth2User.getAttribute("name");
        String email = oAuth2User.getAttribute("email");

        userrepository.findByEmail(email)
                .orElseGet(() -> userrepository.save(new User(name, email)));

        return oAuth2User;
    }

    
}
 */