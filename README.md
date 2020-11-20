# postgresql-data-exporter
JDK 8  
Eclipse IDE 2020-03  
Spring Boot 2.3.6 RELEASE  
Spring Boot DevTools  
Spring Web  
PostgreSQL Driver  
Spring Data JPA  
```xml
<!--Also need this dependencies-->
<dependency>
  <groupId>org.apache.poi</groupId>
  <artifactId>poi-ooxml</artifactId>
  <version>4.1.0</version>
</dependency>
<dependency>
  <groupId>com.github.librepdf</groupId>
  <artifactId>openpdf</artifactId>
  <version>1.3.8</version>
</dependency>
```

Run Application, then send GET request using any browser or postman  
To get data in XLSX format - http://localhost:8080/customers/export/excel  
To get data in PDF format - http://localhost:8080/customers/export/pdf
