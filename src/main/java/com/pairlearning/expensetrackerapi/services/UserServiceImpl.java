package com.pairlearning.expensetrackerapi.services;

import com.pairlearning.expensetrackerapi.domain.User;
import com.pairlearning.expensetrackerapi.exception.EtAuthException;
import com.pairlearning.expensetrackerapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

/**
 * Spring @Service annotation is a specialization of @Component annotation. Spring Service annotation can be applied only to classes.
 * It is used to mark the class as a service provider.
 *
 * Spring @Service annotation is used with classes that provide some business functionalities.
 * Spring context will autodetect these classes when annotation-based configuration and classpath scanning is used.
 */

@Service
@Transactional

/**
 * Spring Transaction Management is one of the most widely used and important feature of Spring framework.
 * Transaction Management is a trivial task in any enterprise application.
 */
public class UserServiceImpl implements UserService {

    @Autowired

    /**
     * Spring @Autowired annotation is used for automatic dependency injection.
     * Spring framework is built on dependency injection and we inject the class dependencies through spring bean configuration file.
     */


            UserRepository userRepository;


    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        if(email != null) email = email.toLowerCase();
        return userRepository.findByEmailAndPassword(email, password);



    }

    @Override
    public User registerUsaer(String firstName, String lastName, String email, String password) throws EtAuthException {

        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (email != null) email = email.toLowerCase();
        if(!pattern.matcher(email).matches()){
            throw new EtAuthException("Invalid email format");
        }

        Integer count = userRepository.getCountByEmail(email);
        if (count > 0)
            throw new EtAuthException("Email already in use!");
        Integer userId = userRepository.create(firstName,lastName,email,password);
        return userRepository.findById(userId);

    }
}
