package com.assemble.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
/* UserDetailsService가 별도의 인증/권한 체크를 하는 이유는 JSP등에서 단순히 사용자 아이디(스프링 시큐리티에서는 username)가
 * 아닌 이메일이나 사용자 이름과 같은 추가적인 정보를 이용하기 위해서 이다.
 */

}
