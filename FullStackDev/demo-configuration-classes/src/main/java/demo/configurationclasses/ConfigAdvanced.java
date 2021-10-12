package demo.configurationclasses;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigAdvanced {

	@Bean(name="cool-bean")
	public SimpleService mySimpleService1() {
		return new SimpleServiceImpl();
	}

	@Bean(name={ "subsystemA-bean", "subsystemB-bean", "subsystemC-bean" })
	public SimpleService mySimpleService2() {
		return new SimpleServiceImpl();
	}

	@Bean(name="bankservice-bean")
	public BankService myBankService() {
		return new BankServiceImpl(myBankRepository());
	}
	
	@Bean(name="bankrepository-bean")
	public BankRepository myBankRepository() {
		return new BankRepositoryImpl();
	}

	@Bean(name="proto-bean")
	@Scope("prototype")
	public SimpleService mySimpleService3() {
		return new SimpleServiceImpl();
	}

	@Bean(name="lazy-bean")
	@Lazy
	public SimpleService mySimpleService4() {
		return new SimpleServiceImpl();
	}
}
