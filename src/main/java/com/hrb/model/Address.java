package com.hrb.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created  on 02/03/2016.
 * http://www.concretepage.com/spring/spring-bean-scope-example-using-scope-annotation-and-xml-for-singleton-prototype-request-session-global-session-and-application-scope-with-scoped-proxy
 * http://www.javabeat.net/spring-bean-scopes-request-session-global-session-example/
 * http://tuhrig.de/making-a-spring-bean-session-scoped/
 */
//@Component
@Getter
@Setter
@ToString
//@Scope(value="globalSession", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Address {
    private String street;
    private String city;
    private String country;
}
