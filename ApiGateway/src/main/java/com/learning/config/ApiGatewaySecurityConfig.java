package com.learning.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import com.learning.utils.ApiGatewayUtils;

@Configuration
@EnableWebFluxSecurity
public class ApiGatewaySecurityConfig {

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		return http.csrf(ServerHttpSecurity.CsrfSpec::disable)
				.cors(cors -> cors.configurationSource(corsConfigurationSource()))
				.authorizeExchange(auth -> auth.anyExchange().permitAll()).build();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(List.of(ApiGatewayUtils.UI_FRONTEND_SERVICE_URL));
		config.setAllowedMethods(List.of(ApiGatewayUtils.ASTERISK));
		config.setAllowedHeaders(List.of(ApiGatewayUtils.ASTERISK));

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration(ApiGatewayUtils.SLASH_ASTERISK, config);
		return source;
	}
}
