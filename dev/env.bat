rem path - Ư�����α׷�(javac.exe, java.exe)�� ��ġ�� ��ο� ������� ����ϱ����� path
rem xxx_home - ���α׷����� ��θ� �����ϱ� ���� �����ϴ� path
rem classpath - Ư�� class, library, Framework ���� ��ο� ������� ����ϱ����� �����ϴ� path

set dev_home=C:\Users\owner\youngRepositories\SSangYoung\dev
set java_home=%dev_home%\Java\jdk1.8.0_191
set eclipse_home=%dev_home%\eclipse
set catalina_home=%dev_home%\apache-tomcat-8.5.37

set path=%java_home%\bin;%eclipse_home%;%catalina_home%\bin

rem classpath�� �����ϸ� ������ Ŭ������ �ν��ϰԵȴ�.
rem JVM�� ����Ǵ� ������Ű���� Ŭ������ �ν��ϰ� �Ҷ����� "."�� ����Ѵ�.
set classpath=.;%dev_home%\drivers\ojdbc6.jar