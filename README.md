# dictionary-kotlin-springboot
a dictionary service written in kotlin and spring boot
Use pattern matching to find words

For example try entering the url 
http://0.0.0.0:8080//word/like/in_e_i%25a%25ce

Build with `mvn clean package`, which packages all the dependencies + an embedded web server into a runnable JAR.

Then in production, just run the JAR, with any command line parameters you'd want. They match the `application.yml`
settings.
