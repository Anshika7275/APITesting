package runnerClassTestingPackage;

import org.testng.annotations.Test;

import staticImportandMethodChaining.MethodChaining1;

public class RunnerClass_MethodChaining {
	@Test
	public void methodChainingTest()
	{
		MethodChaining1 m= new MethodChaining1();
		
		m.a().b().c();                                        //same class object
		
		m.a().b().c().d().e();                               //Different class object
	}

}
