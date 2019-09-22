# mom-pop

This is the final project of EECS 4413 - Building E-Commerce Systems at York University. The project strictly followed the MVS design pattern and featured all basic functionalities of an online book-store such as:
<ul>
<li>An extensive database of books</li>
<li>Searching the database by keywords, book categories, authors</li>
<li>Applying price range, publication date, rating filters</li>
<li>Applying sorting py price, publication date, rating</li>
<li>Creating an account (with shipping and billing addresses), logging into existing account, logging out of account</li>
<li>Adding and removing items into shopping cart, adjusting the quantity of items in the shopping cart while updating the bill</li>
<li>Adding reviews for a given book</li>
<li>Checking out by providing credit card information (run under https, SSL)</li>

<li>Provides administrator functions on:
  <ul>
    <li>generating a report of books sold each month</li>
    <li>real-time analytics of 10 most popular books through listeners</li>
  </ul>
</li>

<li>Provides REST services py providing xml files on:
  <ul>
    <li>getting detailed product info</li>
    <li>getting orders by part number</li> 
  </ul>
</li>

</ul>

## Prerequisites
<ul>
<li>Java 8</li>
</ul>

## Installing
<ul>
<li>Download and install Eclipse IDE for Java Enterprise Developers</li>
<li>Download and unzip Apache Tomcat (v8.5)</li>
<li>Download and unzip Apache Derby 10*</li>
<li>Configure Eclipse with Tomcat by creating a new Web server, selecting Apache Tomcat 8.5, pointing to the directory where you unzipped Tomcat</li>
<li>Download the latest jstl.jar file from Apache and place it in your project's Web-INF->lib folder</li>
<li>Run the DBCreate.sql file under WebContent/res to populate the database</li>
</ul>

## Built With

* [Eclipse IDE for Java Enterprise Developers](https://www.eclipse.org/downloads/packages/release/2019-09/r/eclipse-ide-enterprise-java-developers/) - IDE
* [Apache Tomcat](https://tomcat.apache.org/index.html) - Open source implementation of the Java Servlet
* [Apache Derby](https://db.apache.org/derby/) - Open source relational DB
* [JSPX](http://jspx-bay.sourceforge.net/) - Open source Java web framework
* [JSTL](http://https://docs.oracle.com/javaee/5/tutorial/doc/bnake.html/) - Java standard tag library


## Authors

* **Baris Bagcilar**
* **Raymond Barakat**
* **Osama Malik**
