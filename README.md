# hotel-booking
booking a hotel at phptravels

Requirement: To run this project, you need to have JAVA installed on your system, need Eclipse which is JAVA’s IDE, need Cucumber Eclipse plugin, need latest Chrome or Firefox browser depending upon your selection in the test script, few dependencies and jar files which I have explained below

Note: Below, I have explained how I have created this project. You just need to open the project and execute it. I have executed it with Junit

1.	Open Eclipse. Navigate to File > New > Other. Select Maven > Maven Project, click NEXT

2.	Enter Group Id, Artifact Id (any meaningful name for your project) and click Finish

3.	A new project will be created in left pane. You will get ‘pom.xml’ file too

4.	Get following four dependencies from internet. Create an opening and closing ‘dependencies’ tag in ‘pom.xml’ file and paste the following dependencies inside this tag:
cucumber-junit (version 1.2.2)
cucumber-java (version 1.2.2)
junit maven dependency (junit version 4.12)
selenium maven dependency
5.	Open pom.xml. By default, Overview tab is opened. Click on pom.xml tab to open the actual xml. Add one open and closing <dependencies> tags respectively, and add all the dependencies here.

6.	You will notice that Maven Dependencies folder is created with all external jar files in it

7.	Navigate to Help > Install New software and install ‘Cucumber eclipse plugin’. This will make feature files more meaningful by highlighting already defined tags

8.	Create a new folder named ‘Features’ and create a new file in it having extension as ‘.feature’. In this, we need to write our ‘Scenarios’ or ‘Scenario Outline’ for the respective feature. One feature file can contain multiple scenarios

9.	Now, inside src > test > java, create a new package named ‘runner’ and create a new file in it with extension as ‘.java’. Need to add code here so that cucumber feature files should be recognized by Junit

10.	Now, inside src > test > java, create a new package named ‘stepDefinition’ and create a new file in it with extension as ‘.java’

11.	If you execute your feature file, the steps for specific scenarios will be generated in ‘Console’ pane. Copy those steps and paste them in class file created in ‘stepDefinition’ folder, and then add your code specific to each method

12.	Put all the hardcode sendKeys values in feature files, and use those parameters in your code instead

13.	Also, create an application.properties file, and put all locators code in that, and use those parameters in your code instead. To make your script recognize the parameters of application.properties file, you need to add that ‘FileInputStream’ code in your script

14. You need to install chromedriver (in order to run this project in Chrome) or geckodriver (in order to run this code in latest version of Firefox)
