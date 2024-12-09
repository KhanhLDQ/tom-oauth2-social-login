package org.tommap.spring_oauth2_social_logins.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

import static org.tommap.spring_oauth2_social_logins.config.Constants.FACEBOOK_CLIENT_ID;
import static org.tommap.spring_oauth2_social_logins.config.Constants.FACEBOOK_CLIENT_SECRET;
import static org.tommap.spring_oauth2_social_logins.config.Constants.GITHUB_CLIENT_ID;
import static org.tommap.spring_oauth2_social_logins.config.Constants.GITHUB_CLIENT_SECRET;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(requests ->
                        requests
                                .requestMatchers("/secure").authenticated()
                                .anyRequest().permitAll()
                )
                .formLogin(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults());

        return httpSecurity.build();
    }

//    @Bean
//    ClientRegistrationRepository clientRegistrationRepository() {
//        ClientRegistration github = githubClientRegistration();
//        ClientRegistration facebook = facebookClientRegistration();
//
//        return new InMemoryClientRegistrationRepository(github, facebook);
//    }
//
//    //we should store our credentials in secure places like environment variables or vault
//    private ClientRegistration githubClientRegistration() {
//        return CommonOAuth2Provider.GITHUB
//                .getBuilder("github")
//                .clientId(GITHUB_CLIENT_ID)
//                .clientSecret(GITHUB_CLIENT_SECRET)
//                .build();
//    }
//
//    private ClientRegistration facebookClientRegistration() {
//        return CommonOAuth2Provider.FACEBOOK
//                .getBuilder("facebook")
//                .clientId(FACEBOOK_CLIENT_ID)
//                .clientSecret(FACEBOOK_CLIENT_SECRET)
//                .build();
//    }
}
