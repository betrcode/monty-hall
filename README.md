Demonstration of the Monty Hall problem
=======================================

Contains a fairly readable and maintainable solution to the Monty Hall problem.

Can certainly be written in a much more condense form, but as always, I prefer
readability and maintainability over short code.

# How to run

In IntelliJ: Run the App class by pressing the Run-button.

In command line:

```shell
$ mvn package
[INFO] Scanning for projects...
[INFO] 
...

[INFO] 
[INFO] --- maven-jar-plugin:3.2.0:jar (default-jar) @ monty-hall ---
[INFO] Building jar: /home/max/work/private/monty-hall/target/monty-hall-1.0-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.101 s
[INFO] Finished at: 2021-12-23T11:34:51+01:00
[INFO] ------------------------------------------------------------------------

$ java -jar ./target/monty-hall-1.0-SNAPSHOT.jar
Summary: Contestant wins in 66.0%
```

## Reference
https://en.wikipedia.org/wiki/Monty_Hall_problem
