@echo off

set configFile=application.properties

:BEGIN
cd .\addressbook-selenium-tests\
java -cp bin;..\xstream-distribution-1.4.8-bin\xstream-1.4.8\lib\xstream-1.4.8.jar;..\xstream-distribution-1.4.8-bin\xstream-1.4.8\lib\xpp3_min-1.1.4c.jar;..\xstream-distribution-1.4.8-bin\xstream-1.4.8\lib\xstream\xmlpull-1.1.3.1.jar;..\xstream-distribution-1.4.8-bin\xstream-1.4.8\lib\xstream\kxml2-2.3.0.jar;..\selenium-server-standalone-2.47.1.jar -DconfigFile=%configFile% org.testng.TestNG testng-customsuite.xml > ..\testrun.log
:END

