package Bank_Application;

import java.util.Scanner;

//ini ga dipake mau dihapus aja kah
public class BankInfo 
{  
    private String accNo;  
    private String name;  
    private String accType;  
    private long balance;  
    
    
    public String getName() 
    {
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public long getBalance() 
	{
		return balance;
	}
	public void setBalance(long balance)
	{
		this.balance = balance;
	}
    
}
