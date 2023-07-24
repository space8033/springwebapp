package com.mycompany.springwebapp.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mycompany.springwebapp.dto.JoinForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch04Form3Validator implements Validator{
	
	//유효성을 검사할 객체인지 여부 판단하는 메소드. true인 경우 validate메소드 진행
	@Override
	public boolean supports(Class<?> clazz) {
		log.info("실행");
		boolean check = JoinForm.class.isAssignableFrom(clazz);
		
		return check;
	}
	
	//실제 유효성 검사 진행
	@Override
	public void validate(Object target, Errors errors) {
		log.info("실행");
		JoinForm ch04form3 = (JoinForm) target;
		
		String mid = ch04form3.getMid();
		if(mid == null || mid.equals("")) {
			errors.rejectValue("mid", "errors.form.required", "필수 입력(D)");
		}else if(mid.length() < 8){
			errors.rejectValue("mid", "errors.form.minlength", new Object[] {8}, "최소 8자 이상 입력(D)");
		}else if(mid.length() > 15){
			errors.rejectValue("mid", "errors.form.maxlength", new Object[] {15}, "최대 15자 이하 입력(D)");
		}
		
		String mpassword = ch04form3.getMpassword();
		if(mpassword == null || mpassword.equals("")) {
			errors.rejectValue("mpassword", "errors.form.required", "필수 입력(D)");
		}else if(mid.length() < 8){
			errors.rejectValue("mpassword", "errors.form.minlength", new Object[] {8}, "최소 8자 이상 입력(D)");
		}else if(mid.length() > 15){
			errors.rejectValue("mpassword", "errors.form.maxlength", new Object[] {15}, "최대 15자 이하 입력(D)");
		}
		
		String memail = ch04form3.getMemail();
		
		if(memail == null || memail == "") {
			errors.rejectValue("memail", "errors.form.required", "필수 입력(D)");
		}else {
			String regExp = "([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)";
			boolean result = Pattern.matches(regExp, memail);
			
			if(result == false) {
				errors.rejectValue("memail", "errors.form.format", "이메일 형식에 맞지 않음(D)");
			}
		}
		
		String mtel = ch04form3.getMtel();
		
		if(mtel == null || mtel.equals("")) {
			errors.rejectValue("mtel", "errors.form.required", "필수 입력(D)");
		}else {
			String regExp = "(010|011)-[0-9]{3,4}-[0-9]{4}";
			boolean result = Pattern.matches(regExp, mtel);
			if(result == false) {
				errors.rejectValue("mtel", "errors.form.format", "전화번호 형식에 맞지 않음(D)");				
			}
		}
	}	
}
