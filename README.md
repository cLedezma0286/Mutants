# Mutants
Challenge mutants 
Paso 1: Clonar el proyecto desde https://github.com/cLedezma0286/Mutants.git
  * En Eclipse/STS Open Git View -> Git repositories -> Clone a Git Repository -> Add parameters of Connection -> Select Branch -> Next -> Finish.

Paso 2: una vez clonado el proyecto en  STS o eclipse, se construye el proyecto con el comando: mvn clean install, esto nos generará un proyecto JAR que nos servira para poder instalarlo en AWS con especificacion ELASTIC BEANSTALK, para lo cual requerimos el artefacto generado. En caso de querer ejecutarlo en local, simplemente basta con dar clic derecho sobre el proyecto y seleccionar Run as -> Spring Boot App y esto levantara una instancia de Apache Tomcat en ambiente local.

Paso 3: Instalacion en AWS:
Loguearse en AWS -> Services -> Compute -> Elastic BeanStalk -> create Application -> Ingresar nombre de aplicacion -> Seleccionar tipo de plataforma (JAVA) -> Selecionar Coretto 11 64Bits Amazon Linux2 (JAVA 11 on Linux) -> Upload your code (JAR) -> Create application

Paso 4: Editar Propiedades de alta disponibilidad.

* Para el caso en que la demanda de peticiones sea alta, seleccionar el Ambiente donde se instalo la aplicacion -> Configuracion -> Capacity -> Instances -> MAX 10000 -> Apply.
* Para el caso del balanceador de carga, se pueden crear listeners asocicadas a procesos(instancias) para distribuir de manera homogenea las peticiones de entrada.


Paso 5: Probar los endpoints (API/rest:post)
  * AWS:  
        - http://mutants-env-1.eba-xhcsrxw4.us-east-2.elasticbeanstalk.com/stats
        - http://mutants-env-1.eba-xhcsrxw4.us-east-2.elasticbeanstalk.com/mutant
            {
              "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
            }
   * LOCAL:
        - http://localhost:8080/stats
        - http://localhost:8080/mutant
            {
              "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
            }






