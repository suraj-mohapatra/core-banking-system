package io.github.cbs.service;

public interface BaseService {
    String getServiceCode();
}


// I want a service code field in each service clas
// if I make this an interface I can't enforce a service code variable
// if I make this abstract class then all the concrete classes will lose their extensibility
// how should I enforce a developer to include a field in each case? should I write a test case or
// maven enforcer plugin can do this for all of them

// I still need to think and then I will seek help