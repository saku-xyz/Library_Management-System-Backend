package lk.geeks.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.access.channel.ChannelProcessingFilter;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.builders.WebSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
////import org.springframework.security.web.access.channel.ChannelProcessingFilter;
////import org.springframework.security.web.firewall.DefaultHttpFirewall;
////import org.springframework.security.web.firewall.HttpFirewall;
////import org.springframework.security.web.firewall.StrictHttpFirewall;
//
////
@Configurable
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.addFilterBefore(new CrossFilter(), ChannelProcessingFilter.class);
        http
                .authorizeRequests().antMatchers("/").permitAll()
                .anyRequest().fullyAuthenticated().and().httpBasic().and().csrf().disable();


//                .csrf()
//                .disable()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and().httpBasic()
//                .realmName("Library.com");
//
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("library").password("{noop}library123").roles("MANAGER");
    }
}




//    @Bean
//    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
//     return new DefaultHttpFirewall();
////    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and().httpBasic();
//    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
//    }
