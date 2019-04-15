4413 Final Project README file

Baris Bagcilar
Osama Malik
Raymond Barakat
-----------------

1. This application uses Derby for database communicatons. Therefore, user must have a Derby database
configured in order to run it.

2. The SQL file is located at: WebContent/res/DBCreate.sql

3. It is recommended that the user creates a connection and populates the database through scrapbook
using this file.

4. This application runs under https, SSL. For this configuration, user is advised to follow these steps:
	- generate keystore using keytool
	- under Servers -> Tomcat ... -> web.xml, include the following connector tag:
	
			<Connector
           protocol="org.apache.coyote.http11.Http11NioProtocol"
           port="8443" maxThreads="200"
           scheme="https" secure="true" SSLEnabled="true"
           keystoreFile="${user.home}/.keystore" keystorePass="password"
           clientAuth="false" sslProtocol="TLS"/>
		   
	- note that the password generated when the keystore is created should be entered for keystorePass
	- detailed instructions can be found on the following link:
		https://tomcat.apache.org/tomcat-8.5-doc/ssl-howto.html

5. Test cases should be run as follows:
	- Ensure the project is imported and runs properly
	- Start the web server so the project is up and running
	- Have the project running on the server. 
	- Go to the E-men_Test project. 
	- Go to the MultiThreaded.java class under Java reasources -> src folder -> Client package ->MultiThreaded.java
	- In main adjust N to be the number of clients you wish to request to the Website
	- run MultiThreaded.java as a java application. 
	- The output will be in the console in terms of response they recieved and the elapsed Time. 