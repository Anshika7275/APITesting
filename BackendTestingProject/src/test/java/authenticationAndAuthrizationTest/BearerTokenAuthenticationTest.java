package authenticationAndAuthrizationTest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class BearerTokenAuthenticationTest {
		
	@Test
	public void bearerTokenAuthenticationTest() {
		
/****************************************** Use bearer token generate from NinzaHRM ******************************************/	
		given()
		      .auth().oauth2("eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJsZUN3YUNPai00RXVlbzJkTFFrTmZuLXh2M0F3Nm5ZdWZtS0pINXBFWkNNIn0.eyJleHAiOjE3MzgyNDA0NjcsImlhdCI6MTczODIzODcyNiwianRpIjoiZWY4OTVjY2QtMTA2NC00NjFmLWEwYTgtZTYwYzE5MjdlYjBhIiwiaXNzIjoiaHR0cDovLzQ5LjI0OS4yOC4yMTg6ODE4MC9hdXRoL3JlYWxtcy9uaW56YSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiI0ODVlYTJhYi1kY2MzLTQwOGItOTUxZi04NGMwM2JmZDAwMmYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJuaW56YS1jbGllbnQiLCJzZXNzaW9uX3N0YXRlIjoiNTA5MWU3YWEtMDEzOS00YzQ4LTliMmQtODY2NjcwMWMyMzQ0IiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwOi8vNDkuMjQ5LjI4LjIxODo4MDkxIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLW5pbnphIiwib2ZmbGluZV9hY2Nlc3MiLCJhZG1pbiIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJlbWFpbCBwcm9maWxlIiwic2lkIjoiNTA5MWU3YWEtMDEzOS00YzQ4LTliMmQtODY2NjcwMWMyMzQ0IiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJybWd5YW50cmEifQ.pAMsmI4t0xjs6AT3GT0H5PuYHJl7PGeP5Vpca6lXOtDdZBlO8O7GaOUmofJTAmzOxzKsM4e8HjDLi6a0oztuH9Fy1y6tBczYlTSt9ipoX5Dc3P2Od4LCnXR8h3g6GhG8b7wimSQd7nFiFvdd5O5YikBbwtizn31vKGqorXtan-Ooge6eaqetNfRMJhFMK3Bp67eztpdsncSHLmzX64NFZZl-DgTbgO2dvpLv4K7OP4PTKPKJnhFAE3xgWx32CcsXv2e8eVs6pKnYNOJSp5FRkdCi3oC3BNMntn9FWNnBmTdcSDVhxbKS6xwv1o0pCh-eZwnKiisRjBroWPpWYS5aaw")
			  .log().all()
			  
		.when()
		      .get("http://49.249.28.218:8091/projects")
		.then()
		      .log().all();
	}

}
