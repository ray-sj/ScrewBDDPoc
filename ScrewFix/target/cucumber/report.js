$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("BreadBox.feature");
formatter.feature({
  "line": 2,
  "name": "Breadbox functionality",
  "description": "As a tester\r\nI want to execute a basic set of tests against the breadbox\r\nSo that i can confirm that the functionality is working according to the ACs",
  "id": "breadbox-functionality",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@breadbox"
    }
  ]
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 9,
  "name": "the diy landing page is displayed",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "there are several pages of search results displayed from a user search",
  "keyword": "And "
});
formatter.match({
  "location": "PaginationSteps.java:36"
});
formatter.result({
  "duration": 292952872,
  "status": "passed"
});
formatter.match({
  "location": "PaginationSteps.java:41"
});
formatter.result({
  "duration": 5646564569,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "user tests that the breadbox is not present by default",
  "description": "",
  "id": "breadbox-functionality;user-tests-that-the-breadbox-is-not-present-by-default",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 12,
      "name": "@complete"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "the search results are displayed",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "results are confirmed",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "validate that the breadbox is not present",
  "keyword": "Then "
});
formatter.match({
  "location": "BreadBoxSteps.java:21"
});
formatter.result({
  "duration": 135658,
  "status": "passed"
});
formatter.match({
  "location": "BreadBoxSteps.java:26"
});
formatter.result({
  "duration": 72737,
  "status": "passed"
});
formatter.match({
  "location": "BreadBoxSteps.java:31"
});
formatter.result({
  "duration": 1423149883,
  "status": "passed"
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 9,
  "name": "the diy landing page is displayed",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "there are several pages of search results displayed from a user search",
  "keyword": "And "
});
formatter.match({
  "location": "PaginationSteps.java:36"
});
formatter.result({
  "duration": 134032925,
  "status": "passed"
});
formatter.match({
  "location": "PaginationSteps.java:41"
});
formatter.result({
  "duration": 7123556456,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "user tests that the breadbox is present",
  "description": "",
  "id": "breadbox-functionality;user-tests-that-the-breadbox-is-present",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 18,
      "name": "@wip"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "the search results are displayed",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "the user has selected a facet",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "validate that the breadbox is present",
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "that the selected facet is the only one present",
  "keyword": "And "
});
formatter.match({
  "location": "BreadBoxSteps.java:21"
});
formatter.result({
  "duration": 54888,
  "status": "passed"
});
formatter.match({
  "location": "BreadBoxSteps.java:37"
});
