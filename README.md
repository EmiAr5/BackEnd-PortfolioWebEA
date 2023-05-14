# BackEnd-PortfolioWebEA
Back End del trabajo integrador final de Argentina Programa.

# Descripción de su proyecto
El siguiente proyecto contiene el back end del portfolio web creado utilizando los conocimiento adquiridos en el curso de Argentina Programa.  Su objetivo fue integrar todo lo visto en cada uno de los módulos para finalizar con una página web funcional que pueda vincularse con el Back End, realizado utilizando SpringBoot, y con la base de datos, realizada en MySQL.  
El proyecto fue creado utilizando SpringBoot (Maven) y Java.
Se vincula con la base de datos creada en MySQL.

Consideraciones generales:
 - Para cada una de las clases se han generado todos los métodos principales aún cuando no vayan a ser aplicados desde el FronEnd.
 - No se establecen conexiones de Many to Many ya que el portfolio contendrá los datos de una sola persona por lo que toda la información cargada corresponderá solo a esa persona. 
 - Aunque solo se utiliza el rol de Admin, se establece también el rol de usuario por si en un futuro se decide expandir la aplicación del portfolio.
 - El método de crear usuario no se aplicará en el FrontEnd por lo que es aplicado desde Postman.

Este respositorio cuenta con:
  - Modelos, dto, repositorios y servicios vinculados a cada uno de los componentes que serán aplicados en el Front End.
  - Clases e Interfaz de seguridad para la implementación de creación de usuario, asignación de roles y logeo, utilización de Jwt.

Queda pendiente:
  - Depuramiento de los métodos para que solo queden establecidos aquellos que vayan a ser utilizados luego en el FrontEnd.

# Autora del Proyecto
Emiliana Arduzzo

