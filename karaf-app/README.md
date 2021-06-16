First of all you need to build project in maven:
```
mvn clean install
```
Then register repository in Karaf
```
feature:repo-add mvn:org.apache.karaf.examples/karaf-rest-example-features/4.3.2/xml 
```
Then install blueprint feature
```
karaf-rest-example-blueprint 
```
URL to access:
```
http://localhost:8181/cxf/weather/{CityName}
```