# TestNG testing framework

Getting started with TestNG testing framework


## Assumptions/Pre-requisites

### Hardware
Laptop with at least 8 Gb memory (recommended 16 Gb, ideally 32 Gb)

### Software

1. The Web-based Hello World case study
* Instructions to install here: 
https://github.com/acapozucca/helloworld

**Note**: the case study has to be running. 


2. Chrome browser. This tutorial was made using version is 81.0 (Official Build) (64-bit).

**Notes**:  

* The project comes with the chromedriver version corresponding to the used Chrome browser.
In case, you have installed a different version, please download the right driver version, and place it into the directory:
```
~/<git_root_folder>/TestNG/product.helloworld.testing.testng/lib
```

* [Chromium](https://www.chromium.org/) browser is also an alternative. 



3. An IDE of your choice is installed (e.g. [Eclipse](https://www.eclipse.org/downloads/), [IntellJ IDEA](https://www.jetbrains.com/idea/)). 

**Notes**: 

* This tutorial relies on Eclipse as IDE. However, it has proven to work on IntellJ.

* If you use IntellJ, then you do not need to install the TestNG plugin, as it's already installed.




## Installing TestNG in Eclipse



1. Launch the Eclipse IDE and from Help menu, click “Install New Software”.

2. Click “Add” button.

3. Type “TestNG” as name and enter as location:
```
https://dl.bintray.com/testng-team/testng-eclipse-release/
```

4. Follow the installation process until the end. This includes accepting the terms of the license agreement, and restarting Eclipse.



## Set local working environment

1. Clone this repo.

2. Import the given project into Eclipse.


**Note**: the project is ready to be imported on the Eclipse IDE as an existen Maven project.






## Run the TestNG test cases

The TestNG test cases are placed in the directory:

```
~/<git_root_folder>/TestNG/product.helloworld.testing.testng/src/test/java/
```

There are 3 TestNG test cases. They are:

```
TestFirstServlet.java	
TestLandingPage.java	
TestStaticPage.java

```

These test cases are aimed at validating the content of several pages of the Web-based Hello World case study.
Each test case is manually run from with Eclipse, using the TestNG plug-in's features. 

Next, are the steps to run the test case "TestLandingPage.java". The other test cases are run doing exactly the same steps.

1. Navigate your project until you find the test case "TestLandingPage.java". 
Remember, it is placed into `src/test/java` folder, and into package TestNG.

2. Make right-click on top of "TestLandingPage.java".

3. Select "Run as" -> "TestNG Test".

4. Running this test case results in a browser being automatically open, displaying the page:
```
http://192.168.33.14:8080/helloworld
```
and checking that the page's content is
```
You have reached some content here. Congratulations!
```

If the page can be loaded, and its content corresponds with the expected content, then the test case passes.

5. Once the test case has finished its execution, its results are shown in the TestNG view.



## Running the test cases using Maven

1.  Get to the directory

```
cd ~/<git_root_folder>/TestNG/product.helloworld.testing.testng
```


2.  Run the commands
```
mvn clean
mvn test
```

3. The expected outcome has to contain the following information:
```
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 7.869 sec

Results :

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0

``` 

The test cases run are those specified in the file "TestNG.xml". This file is placed into the directory:
```
~/<git_root_folder>/TestNG/product.helloworld.testing.testng/src/main/resources
```

and the content of the file is:
```
<?xml version="1.0" encoding="UTF-8"?>
<suite name="Test Suite for Hello World case study" verbose="1">
  <test name="TestNG-TestCases">
    <classes>

         <class name="testNG.TestLandingPage" />
         <class name="testNG.TestStaticPage" />
   <!--       <class name="testNG.TestFirstServlet" /> --> 
    </classes>

  </test>
</suite>
```

**Exercise 1**: uncomment the line
```
   <!--       <class name="testNG.TestFirstServlet" /> --> 
```
and:

1. run again the test cases.
2. check the results
3. analyse why there are now 4 test cases being run, and why there is a failure. 

**Exercise 2**: enlarge Web-based Hello World's test coverage by adding test cases for API DB servlets "select" and "insert".



## Final remarks

These guidelines explain how to use TestNG:

- to run user acceptance test cases (UATs), 
- to run these test cases from within an IDE, and
- to run these test ases from the console using Maven (very important to automate the test case execution).


## Exercise
* Rely on Maven to parametrise the test cases such that the value to stored in the attribute "serverBaseURL" it is not hardcoded.

