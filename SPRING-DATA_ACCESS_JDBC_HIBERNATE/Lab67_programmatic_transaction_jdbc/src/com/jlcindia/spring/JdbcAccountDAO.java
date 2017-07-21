package com.jlcindia.spring;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import com.jlcindia.spring.InsufficientFundsException;

public class JdbcAccountDAO implements AccountDAO {

	@Autowired
	JdbcTemplate jTemp;
	
	
	
	@Autowired
	PlatformTransactionManager txManager;
	
	@Override
	public double getBalance(int accno) {
		System.out.println("inside getbal");
		String sql="select bal from accounts where accno=?";
		System.out.println(sql);
		double cbal=jTemp.queryForObject(sql,Double.class,accno);
		System.out.println(cbal);
		
		return cbal;
	}
	
	
	
	public void deposit(int accno,double amt) {
		TransactionStatus ts=null;
		try {
			TransactionDefinition txDef=new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
			ts=txManager.getTransaction(txDef);
			System.out.println("inside deposit");
			String sql1="select bal from accounts where accno=?";
			System.out.println(sql1);
			
			double cbal=jTemp.queryForObject(sql1,Double.class,accno);
			
			System.out.println(cbal);
		cbal=cbal+amt;
		System.out.println(cbal);
		String sql2="update accounts set bal=? where accno=?";
			System.out.println(sql2);
		jTemp.update(sql2,cbal,accno);
			txManager.commit(ts);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			txManager.rollback(ts);
		}
		
	}
	
public void withdraw(int accno,double amt) {
		
	TransactionStatus ts=null;
	try {
		TransactionDefinition txDef=new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
	ts=txManager.getTransaction(txDef);
	System.out.println("inside withdraw");
	String sql1="select bal from accounts where accno=?";
	System.out.println(sql1);
	double cbal=jTemp.queryForObject(sql1,Double.class,accno);
	System.out.println(cbal);
	
	
	if(cbal>=1000+amt) {
	cbal=cbal-amt;
		String sql2="update accounts set bal=? where accno=?";
		jTemp.update(sql2,cbal,accno);
		
	}else {
		throw new InsufficientFundsException();
	}	
	}catch (Exception e) {
		e.printStackTrace();
		txManager.rollback(ts);
	}	
	
}//withdraw





public void fundsTransfer(int saccno,int daccno,double amt) {
	TransactionStatus ts=null;
	try {
		TransactionDefinition txDef=new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
	 ts=txManager.getTransaction(txDef);
	 System.out.println("inside funds transfer");
	 System.out.println("going to deposit");
	 deposit(daccno, amt);
	 System.out.println("going to withdraw"); 
	 withdraw(saccno, amt);
	 
	 txManager.commit(ts);
	 
	 }catch(Exception e) {
	
		e.printStackTrace();
		txManager.rollback(ts);
	}
}







}