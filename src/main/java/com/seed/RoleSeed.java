package com.seed;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bean.RoleBean;
import com.repository.RoleRepository;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class RoleSeed {
	@Autowired
	RoleRepository roleRepo;

	@PostConstruct
	void createRoles() {

		RoleBean role = roleRepo.findByRoleName("user");
		if (role == null) {
			RoleBean role1 = new RoleBean();
			role1.setRoleName("user");
			roleRepo.save(role1);

			RoleBean role2 = new RoleBean();
			role2.setRoleName("admin");
			roleRepo.save(role2);
			System.out.println("Role Added.....");

		} else {
			log.info("all role set..........");
			System.out.println("Roled Already Added....");
		}
	}

}