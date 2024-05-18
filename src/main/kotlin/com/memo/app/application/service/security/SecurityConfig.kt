package com.memo.app.application.service.security

import com.memo.app.application.service.AuthenticationService
import com.memo.app.application.service.MemoManagerUserDetailsService
import com.memo.app.presentation.handler.MemoAppAccessDeniedHandler
import com.memo.app.presentation.handler.MemoAppAuthenticationEntryPoint
import com.memo.app.presentation.handler.MemoAppAuthenticationFailureHandler
import com.memo.app.presentation.handler.MemoAppAuthenticationSuccessHandler
import org.apache.catalina.webresources.TomcatURLStreamHandlerFactory.disable
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@EnableWebSecurity
@Configuration
@EnableMethodSecurity
abstract class SecurityConfig(private val authenticationService: AuthenticationService) {

    @Bean
    fun SecurityFilterChain(http: HttpSecurity): SecurityFilterChain {

        http
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers("/login").permitAll()
                    .anyRequest().authenticated()
            }.formLogin { login ->
                login
                    .loginProcessingUrl("/login")
                    .usernameParameter("email")
                    .passwordParameter("pass")
                    .defaultSuccessUrl("/")
                    .failureUrl("/login?error")
                    .successHandler(MemoAppAuthenticationSuccessHandler())
                    .failureHandler(MemoAppAuthenticationFailureHandler())
                    .permitAll()
            }.logout { logout ->
                logout
                    .logoutSuccessUrl("/")
            }.csrf {
                disable()
            }.cors {
                cors -> cors.configurationSource(corsConfigurationSource())
            }.exceptionHandling{ exception ->
                exception
                    .authenticationEntryPoint(MemoAppAuthenticationEntryPoint())
                    .accessDeniedHandler(MemoAppAccessDeniedHandler())
            }


        return http.build()
    }

    @Bean
    fun authenticationManager(builder: AuthenticationManagerBuilder): AuthenticationManager {
        builder
            .userDetailsService(MemoManagerUserDetailsService(authenticationService))
            .passwordEncoder(BCryptPasswordEncoder())
        return builder.build()
    }

//    @Bean
//    fun SecurityFilterChain(auth: AuthenticationManagerBuilder): AbstractDaoAuthenticationConfigurer {
//        return auth.userDetailsService(MemoManagerUserDetailsService(authenticationService))
//            .passwordEncoder((BCryptPasswordEncoder()))
//
//    }

//    @Bean
//    fun userDetailsService(): UserDetailsService {
//
//        val userDetailsService = MemoManagerUserDetailsService(authenticationService.)
//
//        return InMemoryUserDetailsManager(user)
//    }

    private fun corsConfigurationSource(): CorsConfigurationSource {

        val corsConfiguration = CorsConfiguration()
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL)
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL)
        corsConfiguration.addAllowedOrigin("http://localhost:8081")
        corsConfiguration.allowCredentials = true

        val corsConfigurationSource = UrlBasedCorsConfigurationSource()
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration)

        return corsConfigurationSource
    }

}