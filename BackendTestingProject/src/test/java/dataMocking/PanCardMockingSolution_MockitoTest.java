package dataMocking;

import org.mockito.Mockito;

class PanCard
{
	public String isvalid(String panCard)
	{
		if(panCard.matches("[A-Z]{5}[0-9]{4}[A-Z]")==true)
		{
			return "is valid pan";
		}
		else
		{
			return "is not valid pan";
		}
	}
	
	public static PanCard getMockObject()
	{
		PanCard macObj=Mockito.mock(PanCard.class);
		Mockito.when(macObj.isvalid("ABSDG3434A")).thenReturn("is valid Pancard");
		Mockito.when(macObj.isvalid("ABSDG3434I")).thenReturn("is valid Pancard");
		Mockito.when(macObj.isvalid("ABSDG3434N")).thenReturn("is valid Pancard");
		Mockito.when(macObj.isvalid("ABSDG3434")).thenReturn("is not valid Pancard");
		
		return macObj;
		
	}
}

public class PanCardMockingSolution_MockitoTest {

	public static void main(String[] args) 
	{
		PanCard obj = PanCard.getMockObject();
		System.out.println(obj.isvalid("ABSDG3434A"));
		System.out.println(obj.isvalid("ABSDG3434I"));
		System.out.println(obj.isvalid("ABSDG3434N"));
		System.out.println(obj.isvalid("ABSDG3434"));
		

	}

}
