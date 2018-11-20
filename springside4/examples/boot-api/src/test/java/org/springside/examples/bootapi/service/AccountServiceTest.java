package org.springside.examples.bootapi.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springside.examples.bootapi.domain.Account;
import org.springside.examples.bootapi.repository.AccountDao;

public class AccountServiceTest {

	private AccountDao accountDao;
	private AccountService accountService;

	@Before
	public void setup() {
		accountService = new AccountService();
		accountDao = Mockito.mock(AccountDao.class);
	}

	@Test
	public void hash() throws Exception {
		Account account = new Account(1);
		account.password="123";
		String str = accountService.login("test","123456");
		System.out.println("token:" + str);
		//accountDao.save(Mockito.any(AccountDao.class));
		//System.out.println("hashPassword:" + AccountService.hashPassword("springside"));*/
		//Mockito.when(accountDao.findOne(1L)).thenReturn(account);
		//Mockito.any(Account.class);
	}

}
