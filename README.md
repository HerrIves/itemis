# Receipt

Hi there!

This is the core of small application
that calculates the tax on goods and issues a purchase receipt.<br>

This program is written in #Java 14,
as a builder was used #Maven, so you need it to build the project
or you can use maven-wraper, in root directory.
Just run<br>
<br>mvnw package      - in windows command line<br>
or<br>
./mvnw package    - for Linux<br>
<br>after success (i hope) building, go to the target directory and
run<br> java -jar itemis-taxes.jar<br> and the program will be started. Amazing!<br>
<br>Now input data with pattern:<br>
quantity name "at" price<br>
for example:<br>
1 red book at 10.00<br>
<br>that it. No currency, no country, nothing - that all will be found automatically. Really amazing, isn't it?
But input data carefully - there is no second chance
Well that it. Hope that helps! Now try

Our assumptions:
We assume(and you agree) that user will input data correctly (remember there is no second chance)
We also assume user will not go over integer limits for items quantity (2^32) and double limit for price(2^64)
And be careful with multiplication and division of price numbers - it could be dangerous because of floating numbers limitations

At the end of input use Vim-exit combination. Kidding! Just press enter one more time
