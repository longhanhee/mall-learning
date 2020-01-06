package com.macro.mall.config;


import com.macro.mall.dto.AdminUserDetails;
import com.macro.mall.mbg.model.UmsAdmin;
import com.macro.mall.mbg.model.UmsPermission;
import com.macro.mall.security.JwtAuthenticationTokenFilter;
import com.macro.mall.security.RestAuthenticationEntryPoint;
import com.macro.mall.security.RestfulAccessDeniedHandler;

import com.macro.mall.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()// Vì chúng tôi đang sử dụng JWT, chúng tôi không cần csrf ở đây.
                .disable()
                .sessionManagement()// Dựa trên mã thông báo, do đó không yêu cầu session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, // Cho phép truy cập trái phép vào tài nguyên tĩnh của trang web
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-resources/**",
                        "/v2/api-docs/**"
                )
                .permitAll()
                .antMatchers("/admin/login", "/admin/register", "/actuator/health", "/actuator")// Cho phép truy cập ẩn danh để đăng ký đăng nhập
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS)//Yêu cầu tên miền chéo trước tiên sẽ thực hiện một yêu cầu tùy chọn
                .permitAll()
//                .antMatchers("/**")//Chạy tất cả quyền truy cập trong khi thử nghiệm
//                .permitAll()
                .anyRequest()// Tất cả các yêu cầu ngoại trừ yêu cầu xác thực ở trên
                .authenticated();
        // Vô hiệu hóa bộ nhớ đệm
        httpSecurity.headers().cacheControl();
        // Thêm JWT filter
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //Thêm tùy chỉnh trái phép và không đăng nhập kết quả trả về
        httpSecurity.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        //Nhận thông tin người dùng đăng nhập
        return username -> {
            UmsAdmin admin = adminService.getAdminByUsername(username);
            if (admin != null) {
                List<UmsPermission> permissionList = adminService.getPermissionList(admin.getId());
                return new AdminUserDetails(admin,permissionList);
            }
            throw new UsernameNotFoundException("Tên đăng nhập hoặc mật khẩu không chính xác");
        };
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
