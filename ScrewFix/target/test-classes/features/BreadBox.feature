@breadbox
Feature: Breadbox functionality
	As a tester
	I want to execute a basic set of tests against the breadbox
	So that i can confirm that the functionality is working according to the ACs


Background:
	Given the diy landing page is displayed 
	And there are several pages of search results displayed from a user search
		
	@complete
	Scenario: user tests that the breadbox is not present by default
		Given the search results are displayed
		When results are confirmed
		Then validate that the breadbox is not present

	@wip
	Scenario: user tests that the breadbox is present
		Given the search results are displayed
		When the user has selected a facet
		Then validate that the breadbox is present
		And that the selected facet is the only one present
		