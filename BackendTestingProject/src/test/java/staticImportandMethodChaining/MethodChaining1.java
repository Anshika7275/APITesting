package staticImportandMethodChaining;

public class MethodChaining1 
{
	public MethodChaining1 a()
	{
		System.out.println("execute method a");
		return new MethodChaining1();
	}
	
	public MethodChaining1 b()
	{
		System.out.println("execute method b");
		return new MethodChaining1();
	}
	
	public MethodChaining1 c()
	{
		System.out.println("execute method c");
		return new MethodChaining1();
	}
	
	public MethodChaining2 d()
	{
		System.out.println("execute method c");
		return new MethodChaining2();
	}

}
