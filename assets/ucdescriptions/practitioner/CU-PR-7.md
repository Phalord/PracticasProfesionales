--- 
layout: page 
title: "CU-PR-7: Generar autoevaluación" 
permalink: /design-specification/uc-descriptions/practitioner/cu-pr-7/ 
hide_hero: true 
---

**ID:** CU-PR-7  

**Nombre:** Generar Autoevaluación  

**Autor:** Victor Arturo Ruiz Cuervo  

**Fecha de creación:** 27 de Marzo de 2020  

**Fecha de actualización:** 05 de Junio de 2020  

**Descripción:**  
El *Practicante* genera una **`SELF APPRAISAL`** para ser impresa, firmada y finalmente subirla al sistema para ser revisada por el **`PROFESSOR`** y sumarlo a su calificación final.   

**Actor:**  
*Practicante*  

**Disparador:**  
El *Practicante* da clic en el botón “Generar autoevaluación” de la ventana [`View_GenerateDocumentation`][VGDN].    

**Precondiciones:**  
PRE-1. Debe haber al menos un **`PRACTITIONER`** en el sistema.  
PRE-2. El **`PRACTITIONER`** debió haber subido 2 **`REPORT`** parciales.   

**Flujo Normal:**  
 1.	El *SPP* despliega la ventana [`View_SelfAppraisal`][VSAP] la cual muestra una etiqueta de instrucción junto un listado de afirmaciones con cuadros de texto al lado y al final 2 botones “Generar autoevaluación” y “Cancelar”; y solicita ingresar un puntaje entre 0 y 5.
 2.	El *Practicante* ingresa los valores solicitados para cada afirmación y selecciona la opción “Generar autoevaluación”. (Ver FA-1) 
 3.	El *SPP* despliega un [`Dialog_Confirmation`][DLCO] con las opciones “Confirmar” y “Cancelar”. 
 4.	El *Practicante* da clic en la opción “Confirmar” (Ver FA-2) 
 5.	El *SPP* genera un archivo PDF de la **`SELF APPRAISAL`**, se guarda tanto en el equipo del *Practicante* como en la base de datos y muestra un [`Dialog_Success`][DLSU] con el botón "Aceptar". (Ver EX-1)
 6.	El **Profesor** da clic en el botón "Aceptar".
 7.	El *SPP* cierra el [`Dialog_Success`][DLSU].
 8.	Fin del caso de uso.

**Flujos Alternos:**  
  1. *Cancelar acción*
	  1. El *Practicante* da clic en el botón "Cancelar".
	  2. El *SPP* muestra un [`Dialog_Confirmation`][DLCO] con las opciones “Confirmar” y “Cancelar”. 
	  3. El *Practicante* selecciona la opción “Confirmar” y el *SPP* termina el caso de uso, si no, selecciona la opción “Cancelar” y el *SPP* continúa con el flujo normal en el paso actual.
  2. *Seleccionar "Cancelar"*
	  1. El *Practicante* hace clic en la opción "Cancelar".
	  2. El *SPP* cierra el [`Dialog_Confirmation`][DLCO] y retoma el flujo normal en el paso 2.

**Excepciones:**  
   1. *Error al conectar con la base de datos*
	   1. El *SPP* muestra un [`Dialog_ConnectionError`][DLCE] con el botón "Aceptar". 
	   2. El *Practicante* da clic en el botón “Aceptar".
	   3. El *SPP* cierra el [`Dialog_ConnectionError`][DLCE] y retoma el flujo normal desde el paso 4.

**Postcondiciones:**  
POST-1. El **`SELF APPRAISAL`** creado se encuentra en la carpeta “Descargas” del equipo de **`PRACTITIONER`**.  
POST-2. El **`SELF APPRAISAL`** creado se encuentra en la base de datos en la tabla Autoevaluación.  

**Incluye (Relación Include):**  
No incluye.  

**Extiende (Relación Extend):**  
No extiende.  

[VGDN]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_GenerateDocumentation.png "`View_GenerateDocumentation` Prototype"
[VSAP]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_SelfAppraisal.png "`View_SelfAppraisal` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"