##Lab 8

```
Team: Avasiloae Alexandra and Petrescu Bianca, A2
```

#Compulsory(1p)

```
Create a relational database using any RDBMS (Oracle, Postgres, MySql, Java DB, etc.).
Write an SQL script that will create the following tables:
movies: id, title, release_date, duration, score
genres: id, name (for example: Action, Drama)
an associative (junction) table in order to store each movie genres
Update pom.xml, in order to add the database driver to the project libraries.
Create a singleton class in order to manage a connection to the database.
Create DAO classes that offer methods for creating movies and genres, and finding them by their ids and names;
Implement a simple test using your classes.


All tasks done!

OUTPUT:

"C:\Program Files\Java\jdk1.8.0_281\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2020.3.2\lib\idea_rt.jar=49997:C:\Program Files\JetBrains\IntelliJ IDEA 2020.3.2\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_281\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\rt.jar;C:\Users\Alexandra\IdeaProjects\lab8_java\target\classes;C:\Users\Alexandra\.m2\repository\log4j\log4j\1.2.15\log4j-1.2.15.jar;C:\Users\Alexandra\.m2\repository\javax\mail\mail\1.4\mail-1.4.jar;C:\Users\Alexandra\.m2\repository\javax\activation\activation\1.1\activation-1.1.jar;C:\Users\Alexandra\.m2\repository\com\oracle\ojdbc8\19.3\ojdbc8-19.3.jar" Main
0 [main] INFO Main  - Movie table before deletion:
2 [main] INFO Main  - Tables.Movie{id=3, title='titanic', date='2000-10-01 00:00:00.0', score=5, duration=120}
2 [main] INFO Main  - Tables.Movie{id=5, title='IT 2', date='2000-01-01 00:00:00.0', score=2, duration=100}
2 [main] INFO Main  - Tables.Movie{id=8, title='Gone with the wind', date='2000-01-01 00:00:00.0', score=2, duration=100}
2 [main] INFO Main  - Tables.Movie{id=6, title='Love Island', date='2000-10-01 00:00:00.0', score=5, duration=120}
2 [main] INFO Main  - Tables.Movie{id=10, title='Gone with the wind', date='2000-01-01 00:00:00.0', score=2, duration=100}
2 [main] INFO Main  - Tables.Movie{id=2, title='Gone with the wind', date='2000-01-01 00:00:00.0', score=2, duration=100}
4 [main] INFO Main  - Movie table after deletion:
5 [main] INFO Main  - Tables.Movie{id=3, title='titanic', date='2000-10-01 00:00:00.0', score=5, duration=120}
5 [main] INFO Main  - Tables.Movie{id=5, title='IT 2', date='2000-01-01 00:00:00.0', score=2, duration=100}
5 [main] INFO Main  - Tables.Movie{id=8, title='Gone with the wind', date='2000-01-01 00:00:00.0', score=2, duration=100}
5 [main] INFO Main  - Tables.Movie{id=6, title='Love Island', date='2000-10-01 00:00:00.0', score=5, duration=120}
5 [main] INFO Main  - Tables.Movie{id=10, title='Gone with the wind', date='2000-01-01 00:00:00.0', score=2, duration=100}
8 [main] INFO Main  - Genre table before deletion:
8 [main] INFO Main  - Tables.Genre{id=10, name='Romance'}
8 [main] INFO Main  - Tables.Genre{id=3, name='Romance'}
10 [main] INFO Main  - Genre table after deletion:
10 [main] INFO Main  - Tables.Genre{id=3, name='Romance'}

Process finished with exit code 0

```