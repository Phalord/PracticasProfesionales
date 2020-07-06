--- 
layout: page 
title: "CU-PF-15: Evaluar reporte mensual" 
permalink: /design-specification/uc-descriptions/professor/cu-pf-15/ 
hide_hero: true 
---

**ID:** CU-PF-15 

**Nombre:** Evaluar Reporte Mensual  

**Autor:** Victor Arturo Ruiz Cuervo  

**Fecha de creación:** 27 de Marzo de 2020  

**Fecha de actualización:** 30 de Junio de 2020  

**Descripción:**  
El *Profesor* evalúa el **`REPORT`** mensual de un **`PRACTICING`** para posteriormente calcular una calificación final del **`PRACTICING`**.  

**Actor:**  
*Profesor*  

**Disparador:**  
El *Profesor* dar clic en la opción “Evaluar reporte mensual” de la ventana [`View_EvaluateEvidenceSection`][VEES].  

**Precondiciones**  
PRE-1. Debe existir al menos un **`PROFESSOR`** en el sistema.  
PRE-2. Debe existir al menos un **`REPORT`** mensual por parte del **`PRACTICING`**.   

**Flujo Normal:**  
  1. <a id="fn-1"><i></i></a>El *SPP* despliega la ventana [`View_EvaluateMonthlyReport`][VMRE] la cual muestra una lista de **`REPORT`** mensuales entregados junto con el nombre del **`PRACTICING`**, la fecha que se entregó y al final un botón “Cancelar”. (Ver <a href="#error_conect">EX-1</a>)
  2. <a id="fn-2"><i></i></a>El *Profesor* selecciona un **`REPORT`** mensual para evaluar. (Ver <a href="#cancelar_accion">FA-1</a>). 
  3. <a id="fn-3"><i></i></a>El *SPP* despliega la ventana [`View_RateReport`][VRRE], muestra una vista previa del **`REPORT`** mensual junto con un cuadro de texto para asignar la calificación y su etiqueta; además de un apartado de observaciones del **`REPORT`** y los botones "Ver rúbrica", "Descargar", "Calificar" y "Cancelar". (Ver <a href="#error_conect">EX-1</a>)
  4. <a id="fn-4"><i></i></a>El *Profesor* asigna una calificación al **`REPORT`** parcial y da clic en el botón “Calificar”. (Ver <a href="#cancelar_accion">FA-1</a>, <a href="#download">FA-2</a>, <a href="#add_observation">FA-3</a> y <a href="#ver_rubrica">FA-4</a>). 
  5. El *SPP* muestra un [`Dialog_Confirmation`][DLCO] con las opciones “Confirmar” y “Cancelar”.
  6. El *Profesor* selecciona la opción “Confirmar”. (Ver <a href="#cancel_confirm">FA-5</a>). 
  7. <a id="fn-7"><i></i></a>El *SPP* guarda la información registrada por el *Profesor* y despliega un [`Dialog_Success`][DLSU] con el botón "Aceptar". (Ver <a href="#error_conect">EX-1</a>).
  8. El *Profesor* da clic en el botón "Aceptar".
  9. El *SPP* cierra el [`Dialog_Success`][DLSU].
  10.	Fin del caso de uso.

**Flujos Alternos:**  
  1. <a id="cancelar_accion"><i></i></a>*Cancelar acción*
	  1. El *Profesor* da clic en el botón "Cancelar".
	  2. El *SPP* despliega la ventana [`View_EvaluateEvidenceSection`][VEES] y termina el caso de uso si se tomó el flujo alterno en el <a href="#fn-2">FN-2</a>; si se tomó en el <a href="#fn-4">FN-4</a>, el *SPP* retoma el proceso en el <a href="#fn-2">FN-2</a>. 
  2. <a id="download"><i></i></a>*Descargar documento*
	  1. El *Profesor* da clic en el botón “Descargar”.
	  2. El *SPP* descarga el archivo, lo guarda en el equipo del *Profesor* y despliega un [`Dialog_Success`][DLSU] con el botón "Aceptar".
	  3. El *Profesor* da clic en el botón "Aceptar".
	  4. El *SPP* cierra el [`Dialog_Success`][DLSU] y retoma el <a href="#fn-4">FN-4</a>.
  3. <a id="add_observation"><i></i></a>*Agregar observación*
	  1. El *Profesor* ingresa una observación en el campo de texto de observaciones.
	  2. El *SPP* guarda la observación ingresada y retoma el <a href="#fn-4">FN-4</a>.
  4. <a id="ver_rubrica"><i></i></a>*Ver rúbrica*
	  1. El *Profesor* da clic en el botón "Ver rúbrica".
	  2. El *SPP* abre una ventana alterna donde se muestra la rúbrica de evaluación y retoma el <a href="#fn-4">FN-4</a>.	
  5. <a id="cancel_confirm"><i></i></a>*Seleccionar botón alterno*
	  1. El *Profesor* da clic en el botón “Cancelar”.
	  2. El *SPP* cierra el [`Dialog_Confirmation`][DLCO] y retoma el <a href="#fn-4">FN-4</a>. 

**Excepciones:**  
   1. <a id="error_conect"><i></i></a>*Error al conectar con la base de datos*
	   1. El *SPP* muestra un [`Dialog_ConnectionError`][DLCE] con el botón "Aceptar". 
	   2. El *Profesor* da clic en el botón “Aceptar".
	   3. El *SPP* cierra el [`Dialog_ConnectionError`][DLCE]. Si la excepción ocurre en el <a href="#fn-1">FN-1</a>, el *SPP* despliega la ventana [`View_MonthlyReport`][VMRE] sin los registros de **`REPORT`** mensuales; si ocurre en el <a href="#fn-3">FN-3</a>, despliega la ventana [`View_RateReport`][VRRE] sin la vista previa del **`REPORT`**;  y si ocurre en el <a href="#fn-7">FN-7</a>, retoma el proceso en el <a href="#fn-4">FN-4</a>.

**Postcondiciones:** 
POST-1. La calificación del `REPORT` se guardó en la base de datos.   

**Incluye (Relación Include):**  
No incluye.  

**Extiende (Relación Extend):**  
No extiende.  

[VEES]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/professor/View_EvaluateEvidenceSection.png "`View_EvaluateEvidenceSection` Prototype"
[VMRE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/professor/View_EvaluateMonthlyReport.png "`View_EvaluateMonthlyReport` Prototype"
[VRRE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/professor/View_RateReport.png "`View_RateReport` Prototype"
[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"
