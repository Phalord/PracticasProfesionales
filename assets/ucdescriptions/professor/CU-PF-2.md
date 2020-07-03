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

**Fecha de actualización:** 30 de Junio de 2020  

**Descripción:**  
El *Profesor* sube la plantilla de presentación al sistema para que los **`PRACTICING`** puedan descargarla y manipularla.  

**Actor:**  
*Profesor*  

**Disparador:**  
El *Profesor* da clic en la opción “Subir formato de presentación” de la ventana [`View_ActivitySection`][VASE].   

**Precondiciones:**  
PRE-1. Debe existir al menos un **`PROFESSOR`** en el sistema.  
PRE-2. Debe haber al menos un **`ACTIVITY`** en el sistema.
PRE-3. El **`PROFESSOR`** debe tener asignado como mínimo un **`PRACTICING`**.   

**Flujo Normal:**  
  1. El *SPP* despliega la ventana [`View_UploadDocument`][VUDT] y muestra el nombre del archivo seleccionado y 3 botones “Seleccionar”, “Subir” y “Cancelar”. 
  2. El *Profesor* da clic en la opción “Seleccionar” (Ver <a href="#cancelar_accion">FA-1</a>). 
  3. El *SPP* abre el explorador de archivos del sistema operativo.
  4. El *Profesor* selecciona el documento.
  5. <a id="fn-5"><i></i></a>El *SPP* muestra el nombre del archivo seleccionado. 
  6. <a id="fn-6"><i></i></a>El *Profesor* da clic la opción “Subir”. (Ver <a href="#cancelar_accion">FA-1</a>).
  7. El *SPP* lanza un [`Dialog_Confirmation`][DLCO] con las opciones “Confirmar” y “Cancelar”. 
  8. El *Profesor* da clic en la opción “Confirmar”. (Ver <a href="#cancelar_confirm">FA-2</a>)
  9. El *SPP* guarda el documento en la base de datos y muestra un [`Dialog_Success`][DLSU] con el botón "Aceptar". (Ver <a href="#error_conect">EX-1</a>). 
  10. El *Profesor* da clic en el botón "Aceptar".
  11. El *SPP* cierra el [`Dialog_Success`][DLSU].
  12. Fin del caso de uso.

**Flujos Alternos:**  
  1. <a id="cancelar_accion"><i></i></a>*Cancelar acción*
	  1. El *Profesor* da clic en el botón “Cancelar”.
	  2. El *SPP* despliega la ventana [`View_ActivitySection`][VASE] y termina el caso de uso. 
  2. <a id="cancelar_confirm"><i></i></a>*Cancelar subida de archivo*
	  1. El *Profesor* da clic en el botón “Cancelar”.
	  2. El SPP cierra el [`Dialog_Confirmation`][DLCO] y regresa al <a href="#fn-5">FN-5</a>. 

**Excepciones:**  
   1. <a id="error_conect"><i></i></a>*Error al conectar con la base de datos*
	   1. El SPP muestra un [`Dialog_ConnectionError`][DLCE] con el botón "Aceptar". 
	   2. El *Profesor* da clic en el botón “Aceptar".
	   3. El SPP cierra el [`Dialog_ConnectionError`][DLCE] y retoma el proceso en el <a href="#fn-6">FN-6</a>.

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
