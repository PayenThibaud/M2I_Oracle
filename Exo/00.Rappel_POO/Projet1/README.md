Ouvrir le terminal,

Naviguer dans le repertoire du projet

/!\ Si le Projet ne contient pas les .class mais uniquement des .java rentrer "javac Main.java" /!\

Et rentrer "java Main" pour lancer le projet java


 = = = = = = 
 Pour mettre les .class dans un bin 
 javac -d bin *.java 
 -d bin ./Projet/*.java 

 Verifie que le programme marche avec les .class dans le bin 
 java -cp bin Main 

 On creer un fichier MANIFEST.MF avec le main d indiquer Main-Class: Main 

 On creer notre propre bibliotheque .jar 
 jar cmf MANIFEST.MF MyApp.jar -C bin . 

 On peut l essayer 
 java -jar MyApp.jar 

Voir l interieure du fichier MyApp 
jar tf MyApp.jar

recevoir dans notre dossier le META-INF
jar xf MyApp.jar