package com.summer.vshoppingcart.repository.data;

import org.springframework.data.repository.Repository;

import com.summer.vshoppingcart.domain.User;
import com.summer.vshoppingcart.repository.UserRepository;
import java.lang.String;
import java.util.List;

public interface UserJPARepository extends UserRepository, Repository<User, Integer> {

	//List<User> findByUserName(String username);

}
