package com.myshop.security.oauth;

import com.myshop.common.entity.AuthenticationType;
import com.myshop.common.entity.Customer;
import com.myshop.customer.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OAuth2LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private CustomerService customerService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
           CustomerOAuth2User customerOAuth2User = (CustomerOAuth2User) authentication.getPrincipal();

           String name = customerOAuth2User.getName();
           String email = customerOAuth2User.getEmail();
           String countryCode = request.getLocale().getCountry();
           String clientName = customerOAuth2User.getClientName();

        System.out.println("OAuth2LoginSuccessHandler: " + name + " | " + email);
        System.out.println("Client Name: " + clientName);
        AuthenticationType authenticationType  = getAuthenticationType(clientName);

       Customer customer = customerService.getCustomerByEmail(email);
       if(customer == null){
           customerService.addNewCustomerUponOAuthLogin(name, email, countryCode, authenticationType);

       } else {
           customerService.updateAuthenticationType(customer, authenticationType);
       }

            super.onAuthenticationSuccess(request, response, authentication);
    }
    private AuthenticationType getAuthenticationType(String clientName){
        if(clientName.equals("GOOGLE")){
            return AuthenticationType.GOOGLE;
        } else if(clientName.equals("FACEBOOK")){
            return AuthenticationType.FACEBOOK;
        }else return AuthenticationType.DATABASE;
    }
}
