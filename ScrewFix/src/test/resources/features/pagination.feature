@pagination
Feature: Pagination
	As a tester
	I want to execute a basic set of Pagination tests 
	So that i can confirm that the pagination functionality is working


Background:
	Given the diy landing page is displayed 
	And there are several pages of search results displayed from a user search
		
	@complete
	Scenario: user tests that they can move to the last page
		Given the last page button is enabled
		When they click on the last page icon
		Then validate that the pagination text states that the user in on the last page

	@complete
	Scenario: user tests that they can move to the first page
		Given the first page button is enabled
		When they click on the first page icon
		Then validate that the pagination text states that the user in on the first page

	@complete
	Scenario Outline: user tests that they can move over the pages using the next and previous page icons
		Given the default results page is displayed
		When they click on the "<Page>"
		Then validate that the pagination text states that the user in on the correct "<Page>"

		Examples:
		|Page     |
		|Next     |
		|Previous |

	@complete
	Scenario: user tests that the pagination pages are affected by the number of items per page
		Given the results are over several pages
		When the user increases the items per page to 24
		Then validate that the number of pagination pages are also reduced accordingly
		
	@complete
	Scenario: user tests that the pagination pages are affected by the number of items per page
		Given the results are over several pages
		When the user increases the items per page to 48
		Then validate that the number of pagination pages are also reduced accordingly
		
	@complete
	Scenario: user tests that the pagination pages are affected by the number of items per page
		Given the results are over several pages
		When the user increases the items per page to 96
		Then validate that the number of pagination pages are also reduced accordingly

	@complete
	Scenario: user tests that the pagination pages can change the sort by functionality
		Given the results are over several pages
		When the user changes the Sort By to "Price - low to high"
		Then validate that the pagination hasn't changed but the results are "LowToHigh"

	@complete
	Scenario Outline: user tests that the pagination pages can change the sort by functionality
		Given the results are over several pages
		When the user selects the Sort By for "<selectedSortBy>"
		Then validate that results are correct for the order selected by "<selectedSortBy>"

		Examples:
		|selectedSortBy        |
		|Price - low to high   |
		|Price - high to low   |
		|Rating - high to low  |

		