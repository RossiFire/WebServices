package com.rentalcar.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.rentalcar.entities.Utente;

public class MyUserDetails implements UserDetails{

	private String nome;
	private String password;
	private List<GrantedAuthority> autorities;
	
	public MyUserDetails(Utente u) {
		this.nome = u.getNome();
		this.password = u.getPassword();
//		this.autorities = Arrays.stream(u.getTipoutente().getTipo().split(","))
//				.map(SimpleGrantedAuthority::new)
//				.collect(Collectors.toList());
		this.autorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_" + u.getTipoutente().getTipo()));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return autorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nome;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


}
