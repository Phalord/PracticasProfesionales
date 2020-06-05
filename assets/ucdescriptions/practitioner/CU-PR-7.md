--- 
layout: page 
title: "CU-PR-7: Generar autoevaluación" 
permalink: /design-specification/uc-descriptions/practicing/cu-pr-7/ 
hide_hero: true 
---
**ID:** CU-PR-7  

**Nombre:** Generar autoevaluación  

**Autor:** Victor Arturo Ruiz Cuervo  

**Fecha de creación:** 27 de Marzo de 2020  

**Fecha de actualización:** 05 de Junio de 2020  

**Descripción**  
El **Practicante** genera una ``SELF_APPRAISAL`` para ser impresa, firmada y finalmente subirla al sistema para ser revisada por el ``PROFESSOR`` y sumarlo a su calificación final.   

**Actor:** **Practicante**  

**Disparador**  
El **Practicante** da clic en el botón “Generar autoevaluación” de la ventana ``View_ProjectSection``.    

**Precondiciones**  
PRE-1. Debe haber al menos un ``PRACTICING`` en el sistema.  
PRE-2. El ``PRACTICING`` debió haber subido 2 ``REPORT`` parciales.   

**Flujo Normal:**  
1.	El SPP despliega la ventana ``View_SelfAppraisal`` la cual muestra una etiqueta de instrucción junto un listado de afirmaciones con cuadros de texto al lado y al final 2 botones “Generar autoevaluación” y “Cancelar”; y solicita ingresar un puntaje entre 0 y 5.
2.	El **Practicante** ingresa los valores solicitados para cada afirmación y selecciona la opción “Generar autoevaluación”. (Ver FA-1) 
3.	El SPP despliega un ``Dialog_Confirmation`` con las opciones “Confirmar” y “Cancelar”. 
4.	El **Practicante** da clic en la opción “Confirmar” (Ver FA-2) 
5.	El SPP genera un archivo PDF de la ``SELF_APPRAISAL``, se guarda tanto en el equipo del **Practicante** como en la base de datos y muestra un ``Dialog_Success`` con el botón "Aceptar". (Ver EX-1)
6.	El **Profesor** da clic en el botón "Aceptar".
7.	El SPP cierra el ``Dialog_Success``.
8.	Fin del caso de uso.

**Flujos Alternos (FA):**  
  1. *Cancelar acción*
	  1.	El **Practicante** da clic en el botón "Cancelar".
	  2.	El SPP muestra un ``Dialog_Confirmation`` con las opciones “Confirmar” y “Cancelar”. 
	  3.	El **Practicante** selecciona la opción “Confirmar” y el SSP termina el caso de uso, si no, selecciona la opción “Cancelar” y el SPP continúa con el flujo normal en el paso actual.
  2. *Seleccionar "Cancelar"*
	  1.	El **Practicante** hace clic en la opción "Cancelar".
	  2.	El SPP cierra el ```Dialog_Confirmation`` y retoma el flujo normal en el paso 2.

**Excepciones:**  
   1. *Error al conectar con la base de datos*
	   1.	El SPP muestra un ``Dialog_ConnectionError`` con el botón "Aceptar". 
	   2.	El **Practicante** da clic en el botón “Aceptar".
	   3.	El SPP cierra el ``Dialog_ConnectionError``y retoma el flujo normal desde el paso 4.

**Postcondiciones:**  
POST-1. El ``SELF_APPRAISAL`` creado se encuentra en la carpeta “Descargas” del equipo de ``PRACTICING``.  
POST-2. El ``SELF_APPRAISAL`` creado se encuentra en la base de datos en la tabla Autoevaluación.  

**Incluye (Relación Include):**  
No incluye.  

**Extiende (Relación Extend):**  
No extiende.  
