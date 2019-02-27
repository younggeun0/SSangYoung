rem path - 특정프로그램(javac.exe, java.exe)를 설치된 경로에 상관없이 사용하기위한 path
rem xxx_home - 프로그램끼리 경로를 참조하기 위해 설정하는 path
rem classpath - 특정 class, library, Framework 등을 경로에 상관없이 사용하기위해 설정하는 path

set dev_home=C:\Users\owner\youngRepositories\SSangYoung\dev
set java_home=%dev_home%\Java\jdk1.8.0_191
set eclipse_home=%dev_home%\eclipse
set catalina_home=%dev_home%\apache-tomcat-8.5.37

set path=%java_home%\bin;%eclipse_home%;%catalina_home%\bin

rem classpath를 설정하면 설정된 클래스만 인식하게된다.
rem JVM이 실행되는 하위패키지내 클래스를 인식하게 할때에는 "."을 사용한다.
set classpath=.;%dev_home%\drivers\ojdbc6.jar