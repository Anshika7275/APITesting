package runnerClassTestingPackage;

import static staticImportandMethodChaining.StaticMethodChaining.*;

import org.testng.annotations.Test;

import staticImportandMethodChaining.MethodChaining2;

public class RunnerClass_StaticMethodChaining {
	@Test
	public void StaticMethodChainingTest() {
		
		a().b().c().d().e();
	}

}
