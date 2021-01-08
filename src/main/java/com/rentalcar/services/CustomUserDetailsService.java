package com.rentalcar.services;

import java.util.Arrays;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rentalcar.repositories.UtentiDao;
import com.rentalcar.entities.Utente;

@Service 
@Transactional
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UtentiDao utentiRepo;


	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
		Optional<Utente> user = utentiRepo.findByNome(nome);
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not Found: " + nome));
		return user.map(MyUserDetails::new).get();
	}

}
