package staticImportandMethodChaining;

public class StaticMethodChaining 
{
	
	public static StaticMethodChaining a()
	{
		System.out.println("execute method a");
		return new StaticMethodChaining();
	}
	
	public static StaticMethodChaining b()
	{
		System.out.println("execute method b");
		return new StaticMethodChaining();
	}
	
	public static StaticMethodChaining c()
	{
		System.out.println("execute method c");
		return new StaticMethodChaining();
	}
	
	public static MethodChaining2 d()
	{
		System.out.println("execute method d");
		return new MethodChaining2();
	}

}
