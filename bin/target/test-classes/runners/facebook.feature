Feature: annotation


Background:
	Given User navigates to facebook
	
Scenario:
	When I enter username as "jpt"
	And I enter password as "jpt"
	Then login should fail
	But relogin should be available
	
	
Scenario Outline: login
	When I enter username as "<username>"
	And I enter password as "<password>"
	Then login should be successful	
	
	Examples:
		| username 					| password			|
		| binodcr 					| Fuse@	|
		| binodrajpandey@ioe.edu.np | Fuse@ 	|
		| 9851162081			    | Fuse@	|
			