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

#Optional(2p+)
```
Create the necessary table(s) in order to store movie actors and directors in the database.
Create an object-oriented model of the data managed by the Java application.
Create a tool to import data from a real dataset: IMDb movies extensive dataset or The Movies Dataset or other.
For additional points, you may consider extending your model or generating suggestive HTML reports, based on the imported data.

First 3 tasks done.

OUTPUT:
0 [main] INFO optional.Main  - Movie table after insert some elements from dataset:
1 [main] INFO optional.Main  - Tables.Movie{id=5339, title='La vampira', date='1915-01-12 00:00:00', score=20, duration=67}
2 [main] INFO optional.Main  - Tables.Movie{id=5402, title='The Golden Chance', date='1915-12-30 00:00:00', score=10, duration=74}
2 [main] INFO optional.Main  - Tables.Movie{id=5529, title='Hævnens Nat', date='1916-09-25 00:00:00', score=7, duration=100}
2 [main] INFO optional.Main  - Tables.Movie{id=5557, title='The Italian', date='1915-01-01 00:00:00', score=13, duration=72}
2 [main] INFO optional.Main  - Tables.Movie{id=3, title='Test movie', date='2000-01-01 00:00:00', score=2, duration=100}
2 [main] INFO optional.Main  - Tables.Movie{id=4766, title='The Virginian', date='1914-09-07 00:00:00', score=12, duration=55}
4 [main] INFO optional.Main  - Genre table after insert some elements from dataset:
4 [main] INFO optional.Main  - Tables.Genre{id=5339, name='Drama'}
4 [main] INFO optional.Main  - Tables.Genre{id=5402, name='Drama'}
4 [main] INFO optional.Main  - Tables.Genre{id=5529, name='Crime, Drama, Horror'}
4 [main] INFO optional.Main  - Tables.Genre{id=5557, name='Drama'}
4 [main] INFO optional.Main  - Tables.Genre{id=4743, name='Drama'}
4 [main] INFO optional.Main  - Tables.Genre{id=4766, name='Western'}
4 [main] INFO optional.Main  - Tables.Genre{id=4825, name='Comedy, Drama'}
4 [main] INFO optional.Main  - Tables.Genre{id=4838, name='Drama, Romance'}
5 [main] INFO optional.Main  - Directors table after insert some elements from dataset:
5 [main] INFO optional.Main  - Tables.Director{id=50, name='Frank Powell, movie id='5339'}
6 [main] INFO optional.Main  - Tables.Director{id=51, name='Cecil B. DeMille, movie id='5402'}
6 [main] INFO optional.Main  - Tables.Director{id=52, name='Benjamin Christensen, movie id='5529'}
6 [main] INFO optional.Main  - Tables.Director{id=53, name='Reginald Barker, movie id='5557'}
6 [main] INFO optional.Main  - Tables.Director{id=40, name='William Robert Daly, movie id='4743'}
6 [main] INFO optional.Main  - Tables.Director{id=41, name='Cecil B. DeMille, movie id='4766'}
6 [main] INFO optional.Main  - Tables.Director{id=42, name='Maurice Tourneur, movie id='4825'}
6 [main] INFO optional.Main  - Tables.Director{id=43, name='Reginald Barker, movie id='4838'}
7 [main] INFO optional.Main  - Actors table after insert some elements from dataset:
7 [main] INFO optional.Main  - Tables.Actors{id=50, name='Runa Hodges, movie id='5339'}
7 [main] INFO optional.Main  - Tables.Actors{id=51, name='Cleo Ridgely, movie id='5402'}
7 [main] INFO optional.Main  - Tables.Actors{id=52, name='Benjamin Christensen, movie id='5529'}
7 [main] INFO optional.Main  - Tables.Actors{id=53, name='George Beban, movie id='5557'}
7 [main] INFO optional.Main  - Tables.Actors{id=40, name='Sam Lucas, movie id='4743'}
7 [main] INFO optional.Main  - Tables.Actors{id=41, name='Dustin Farnum, movie id='4766'}
8 [main] INFO optional.Main  - Tables.Actors{id=42, name='Vivian Martin, movie id='4825'}
8 [main] INFO optional.Main  - Tables.Actors{id=43, name='Sessue Hayakawa, movie id='4838'}

Process finished with exit code 0
```
