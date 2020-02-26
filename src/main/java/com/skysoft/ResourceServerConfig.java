package com.skysoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig  extends ResourceServerConfigurerAdapter{
	
	
	@Autowired
    private ResourceServerTokenServices tokenServices;
	
    @Value("${security.jwt.resource-ids}")
    private String resourceIds;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(resourceIds).tokenServices(tokenServices);
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
                http
                .requestMatchers()
                .and()
                .authorizeRequests() 
                .antMatchers("/suministro/**" ).authenticated()
                .antMatchers("/departamento/**" ).authenticated()
                .antMatchers("/proveedor/**" ).authenticated()
                .antMatchers("/procesos/**" ).authenticated()
                .antMatchers("/egreso/**" ).authenticated()
                .antMatchers("/equipo/**" ).authenticated()
                .antMatchers("/ingreso/**" ).authenticated()
                .antMatchers("/usuario/**" ).authenticated()
                .antMatchers("/home/**" ).authenticated()
                .antMatchers("/eliminado/**" ).authenticated()
                .antMatchers("/listar-ingresos/**" ).authenticated()
                .antMatchers("/listar-egresos/**" ).authenticated()
                .antMatchers("/suministro/**" ).authenticated();
    }

}
