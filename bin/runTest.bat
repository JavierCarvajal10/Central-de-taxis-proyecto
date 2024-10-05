@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogot� - Colombia)
REM Departamento de Ingenier�a de Sistemas y Computaci�n 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n4_runt
REM Autor: Camilo �lvarez Duran - 14-ago-2009
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

java -ea -classpath ../lib/taxis.jar;../test/lib/taxisTest.jar;../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.taxis.test.CentralDeTaxisTest 
java -ea -classpath ../lib/taxis.jar;../test/lib/taxisTest.jar;../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.taxis.test.TaxiTest
java -ea -classpath ../lib/taxis.jar;../test/lib/taxisTest.jar;../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.taxis.test.SolicitudTest

  