--- 
layout: page 
title: "CU-PF-2: Añadir formato de presentación" 
permalink: /design-specification/uc-descriptions/professor/cu-pf-2/ 
hide_hero: true 
---

**ID:** CU-PF-2  

**Nombre:** Añadir Formato de Presentación

**Autor:** Victor Arturo Ruiz Cuervo  

**Fecha de creación:** 27 de marzo de 2020  

**Fecha de actualización:** 05 de Junio de 2020  

**Descripción:**  
El *Profesor* sube la plantilla de presentación al sistema para que los `PRACTICING` puedan descargarla y manipularla.  

**Actor:**  
*Profesor*  

**Disparador:**  
El *Profesor* da clic en la opción “Subir formato de presentación” de la ventana [`View_ActivitySection`][VASE].   

**Precondiciones:**  
PRE-1. Debe existir al menos un `PROFESSOR` en el sistema.  
PRE-2. El `PROFESSOR` debe tener asignado como mínimo un `PRACTICING`.  
PRE-3. Debe haber al menos un `ACTIVITY` en el sistema.  

**Flujo Normal:**  
  1. El SPP despliega la ventana [`View_UploadDocument`][VUDT] y muestra el nombre del archivo seleccionado y 3 botones “Seleccionar”, “Subir” y “Cancelar”. 
  2. El *Profesor* da clic en la opción “Seleccionar” (Ver FA-1). 
  3. El SPP abre el explorador de archivos del sistema operativo.
  4. El *Profesor* selecciona el documento.
  5. El SPP muestra el nombre del archivo seleccionado. 
  6. El *Profesor* da clic la opción “Subir”. (Ver FA-1).
  7. El SPP lanza un [`Dialog_Confirmation`][DLCO] con las opciones “Confirmar” y “Cancelar”. 
  8. El *Profesor* da clic en la opción “Confirmar”. (Ver FA-2)
  9. El SPP guarda el documento en la base de datos y muestra un [`Dialog_Success`][DLSU] con el botón "Aceptar". (Ver EX-1). 
  10. El *Profesor* da clic en el botón "Aceptar".
  11. El SPP cierra el [`Dialog_Success`][DLSU].
  12. Fin del caso de uso.

**Flujos Alternos:**  
  1. *Cancelar acción*
	  1. El *Profesor* da clic en el botón “Cancelar”.
	  2. El SPP muestra un [`Dialog_Confirmation`][DLCO] con las opciones “Confirmar” y “Cancelar”. 
	  3. El *Profesor* selecciona la opción “Confirmar” y el SSP termina el caso de uso, si no, selecciona la opción “Cancelar” y el SPP continúa con el flujo normal en el paso actual.
  2. *Cancelar subida de archivo*
	  1. El *Profesor* da clic en el botón “Cancelar”.
	  2. El SPP cierra el [`Dialog_Confirmation`][DLCO] y regresa al paso 5 del flujo normal. 

**Excepciones:**  
   1. *Error al conectar con la base de datos*
	   1. El SPP muestra un [`Dialog_ConnectionError`][DLCE] con el botón "Aceptar". 
	   2. El *Profesor* da clic en el botón “Aceptar".
	   3. El SPP cierra el [`Dialog_ConnectionError`][DLCE] y retoma el flujo normal desde el paso 8.

**Postcondiciones:**  
POST-1. El formato de presentación se guardó en la base de datos en la tabla de `ACTIVITY`.  

**Incluye (Relación Include):**  
No incluye.  

**Extiende (Relación Extend):**  
No extiende.  

[VASE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/professor/View_ActivitySection.png "`View_ActivitySection` Prototype"
[VUDT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/View_UploadDocument.png "`View_UploadDocument` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"