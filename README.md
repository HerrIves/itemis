# Receipt

Hi there!

This is the core of small application
that calculates the tax on goods and issues a purchase receipt.

This program is written in #Java 14,
as a builder was used #Maven, so you need it to build the project
or you can use maven-wraper, in root directory.
Just run
mvnw package      - in windows command line
or
./mvnw package    - for Linux
after success (i hope) building, go to the target directory and
run java -jar itemis-taxes.jar and the program will be started. Amazing!
Now input date with pattern:
quantity name "at" price
for example:
1 red book at 10.00
that it. No currency, no country, nothing - that all will be found automatically. Really amazing, isn't it?
But input date carefully - there is no second chance
Well that it. Hope that helps! Now try

