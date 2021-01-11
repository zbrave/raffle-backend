package com.mertaydar.rafflebackend.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mertaydar.rafflebackend.model.Account;
import com.mertaydar.rafflebackend.repository.AccountRepository;

@Configuration
public class DBLoader {

	private static final Logger log = LoggerFactory.getLogger(DBLoader.class);

	  @Bean
	  CommandLineRunner initDatabase(AccountRepository repository) {

	    return args -> {
	      log.info("Preloading " + repository.save(new Account("mrtydr", new String[] {"ref1","ref2", "ref3"})));
	      log.info("Preloading " + repository.save(new Account("mrtydr2", new String[] {"ref5","ref6", "ref7"})));
	    };
	  }
}
