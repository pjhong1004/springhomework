package com.mycompany.springhomework.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD}) //어디에서 쓸건지 여러타겟을 정할 수 있어서 배열형태{ , }로 들어간다
public @interface Auth {
	public enum Role {USER, ADMIN};
	public Role value() default Role.USER;
}
