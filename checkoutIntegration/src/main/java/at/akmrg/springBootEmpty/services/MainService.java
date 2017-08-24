package at.akmrg.springBootEmpty.services;

import org.springframework.stereotype.Service;

/**
 * Created by alex on 4/21/17.
 */
@Service
public class MainService {

    MainService(){
        System.out.println("I have been created!");
    }

    public String test(){
        return "you asked for a new session";
    }
}
