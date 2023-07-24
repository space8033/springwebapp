package com.mycompany.springwebapp.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mycompany.springwebapp.dto.Ch04Form2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch04Form2Validator implements Validator{
	
	//유효성을 검사할 객체인지 여부 판단하는 메소드. true인 경우 validate메소드 진행
	@Override
	public boolean supports(Class<?> clazz) {
		log.info("실행");
		boolean check = Ch04Form2.class.isAssignableFrom(clazz);
		
		return check;
	}
	
	//실제 유효성 검사 진행
	@Override
	public void validate(Object target, Errors errors) {
		log.info("실행");
		Ch04Form2 ch04form2 = (Ch04Form2) target;
		
		String param1 = ch04form2.getParam1();
		if(param1 == null || param1.equals("")) {
			log.info("비었따");
			errors.rejectValue("param1", "errors.form.required", "필수입력(D)");
		}else {
			String regExp = "\\d{2}([0]\\d|[1][0-2])([0][1-9]|[1-2]\\d|[3][0-1])[-]*[1-4][0-9]{6}";
			boolean result = Pattern.matches(regExp, param1);
			log.info("실행");
			if(result == false) {
				errors.rejectValue("param1", "errors.form.required", "필수입력(D)");	
			}
		}
	}	
}
