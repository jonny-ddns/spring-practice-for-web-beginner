package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.AlreadyExistingMemberException;
import spring.ChangePasswordService;
import spring.IdPasswordNotMatchingException;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.VersionPrinter;

public class MainForSpring {
	
	//스프링으로 의존성 주입
	private static ApplicationContext ctx = null;
	
	private static void printHelp() {
		System.out.println("명령어 형식을 확인해주세요");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재PW 새로운PW");
	}
	
	//회원가입처리
	private static void processNewCommand(String[] arg) {
		if(arg.length != 5) {
			printHelp();
			return;
		}
		
		//객체 가져오기
		//자바 - 직접 객체를 생성하는 방식
		//스프링 - 외부 설정파일(xml 등)을 이용해 생성할 객체와 의존주입 대상을 지정하는 방식 
//		MemberRegisterService memberRegisterService = assembler.getMemberRegisterService();
		MemberRegisterService memberRegisterService = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		
		RegisterRequest request = new RegisterRequest();
		request.setEmail(arg[1])
				.setName(arg[2])
				.setPassword(arg[3])
				.setConfirmPw(arg[4]);		

		if(!request.isPwEqualToConfirmPw()) {
			System.out.println("비밀번호 <-> 확인이 일치하지 않습니다");
			return;
		}
				
		try {
			memberRegisterService.regist(request);
			System.out.println("신규 등록 완료");
		} catch (AlreadyExistingMemberException aeme) {
			System.out.println("이미 존재하는 이메일입니다");
		}
	}
	
	//회원변경 처리
	private static void processChangeCommand(String[] arg) {
		if(arg.length != 4) {
			printHelp();
			return;
		}		
		
//		ChangePasswordService changePasswordService = assembler.getChangePwService();
		ChangePasswordService changePasswordService = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		try {
			changePasswordService.changePw(arg[1], arg[2], arg[3]);
			System.out.println("암호 변경 완료");
		} catch (MemberNotFoundException mnfe) {
			System.out.println("존재하지 않는 이메일입니다");
		} catch (IdPasswordNotMatchingException nme) {
			System.out.println("이메일과 암호가 일치하지 않습니다");
		}
	}
	
	private static void processListCommand() {
		MemberListPrinter memberListPrinter = ctx.getBean("memberListPrinter", MemberListPrinter.class);
		memberListPrinter.printAll();		
	}
	
	private static void processInfoCommand(String[] arg) {
		if(arg.length != 2) {
			printHelp();
			return;
		}
		MemberInfoPrinter memberInfoPrinter = ctx.getBean("memberInfoPrinter", MemberInfoPrinter.class);
		memberInfoPrinter.printMemberInfo(arg[1]);
	}
	
	private static void processVersionCommand() {
		VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
		versionPrinter.print();
	}
	
	/*----------------------------------------------------------------------------------------------------*/
	public static void main(String[] args) throws IOException {		
		
		//xml 참조
//		ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		//설정파일이 다수인 경우
		//방법1
		String[] config = {"classpath:config1.xml", "classpath:config2.xml"};
		ctx = new GenericXmlApplicationContext(config);

		//방법2		
//		ctx = new GenericXmlApplicationContext("classpath:config1.xml", "classpath:config2.xml");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("명령어 입력 : ");
			String command = reader.readLine();

			if(command.equalsIgnoreCase("exit")) {
				System.out.println("프로그램 종료");
				break;
			}
			
			//명령어 입력
			if(command.startsWith("new")) {
				processNewCommand(command.split(" "));
				continue;
			}
			else if(command.startsWith("change")) {
				processChangeCommand(command.split(" "));
				continue;
			}	
			else if(command.startsWith("list")) {
				processListCommand();
				continue;
			}	
			else if(command.startsWith("info")) {
				processInfoCommand(command.split(" "));
				continue;
			}	
			else if(command.startsWith("version")) {
				processVersionCommand();
				continue;
			}	
			printHelp();
		}
	}
}
