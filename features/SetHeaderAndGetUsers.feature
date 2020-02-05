Feature: Set Query Header And Get Users List
  Scenario: Retrieving Employees List
	Given I set Headers and Parameters for request
	|KEY |VALUE|
	|page|2    |
	Then User hit the get employees http://dummy.restapiexample.com/api/v1
	And I print all the logs on Console
	Then The status code is 200
	Scenario: Create Employee
	Given I set Headers and Parameters for request
	|KEY |VALUE|
	|page|2    |
	Then User hit the get employees http://dummy.restapiexample.com/api/v1
	And I print all the logs on Console
	Then The status code is 200