@jqueryui
Feature: To verify all the features on demospage

Background: Verify that user can move to Demos page
Given User is on jQueryUI Home Page
When User clicks on demos button
Then User is redirected to Jquery UI Demos page

@draggable
Scenario: To Verify draggable page redirection
Given User clicks on draggable hyperlink
Then User is redirected to draggable page

@droppable
Scenario: To Verify droppable page redirection
Given User clicks on droppable hyperlink
Then User is redirected to droppable page

@resizable
Scenario: To Verify resizable page redirection
Given User clicks on resizable hyperlink
Then User is redirected to resizable page

@selectable
Scenario: To Verify selectable page redirection
Given User clicks on selectable hyperlink
Then User is redirected to selectable page

@sortable
Scenario: To Verify sortable page redirection
Given User clicks on sortable hyperlink
Then User is redirected to sortable page