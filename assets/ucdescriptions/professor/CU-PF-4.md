--- 
layout: page 
title: "CU-PF-4: Evaluar reporte mensual" 
permalink: /design-specification/uc-descriptions/professor/cu-pf-4/ 
hide_hero: true 
---

**ID:** CU-PF-4  

**Nombre:** Evaluar reporte mensual

**Autor:** Victor Arturo Ruiz Cuervo  

**Fecha de creación:** 27 de Marzo de 2020  

**Fecha de actualización:** 05 de Junio de 2020  

**Descripción:**  
El *Profesor* evalúa el `REPORT` mensual de un `PRACTICING` para posteriormente calcular una calificación final del `PRACTICING`.  

**Actor:**  
*Profesor*  

**Disparador:**  
El *Profesor* dar clic en la opción “Evaluar reporte mensual” de la ventana `View_EvaluateEvidenceSection`.  

**Precondiciones**  
PRE-1. Debe existir al menos un `PROFESSOR` en el sistema.  
PRE-2. Debe existir al menos un `REPORT` mensual por parte del `PRACTICING`.   

**Flujo Normal:**  
  1. El *SPP* despliega la ventana `View_MonthlyReport` la cual muestra una lista de `REPORT` mensuales entregados junto con el nombre del `PRACTICING`, la fecha que se entregó y al final un botón “Cancelar”.
  2. El *Profesor* selecciona un `REPORT` mensual para evaluar. (Ver FA-1). 
  3. El *SPP* despliega la ventana `View_RateReport`, muestra una vista previa del `REPORT` mensual junto con un cuadro de texto para asignar la calificación y su etiqueta; además de un apartado de observaciones del `REPORT` y los botones "Ver rúbrica", "Descargar", "Calificar" y "Cancelar".
  4. El *Profesor* asigna una calificación al `REPORT` mensual y da clic en el botón “Calificar”. (Ver FA-1, FA-2, FA-3 y FA-4). 
  5. El *SPP* muestra un `Dialog_Confirmation` con las opciones “Confirmar” y “Cancelar”.
  6. El *Profesor* selecciona la opción “Confirmar”. (Ver FA-5). 
  7. El *SPP* guarda la información registrada por el *Profesor* y despliega un `Dialog_Success` con el botón "Aceptar". (Ver EX-1).
  8. El *Profesor* da clic en el botón "Aceptar".
  9. El *SPP* cierra el `Dialog_Success`.
  10.	Fin del caso de uso.

**Flujos Alternos:**  
  1. *Cancelar acción*
	  1. El *Profesor* da clic en el botón "Cancelar".
	  2. El *SPP* muestra un `Dialog_Confirmation` con las opciones “Confirmar” y “Cancelar”. 
	  3. El *Profesor* selecciona la opción “Confirmar” y el *SPP* termina el caso de uso, si no, selecciona la opción “Cancelar” y el *SPP* continúa con el flujo normal en el paso actual.
  2. *Descargar documento*
	  1. El *Profesor* da clic en el botón “Descargar”.
	  2. El *SPP* descarga el archivo, lo guarda en el equipo del *Profesor* y despliega un `Dialog_Success` con el botón "Aceptar".
	  3. El *Profesor* da clic en el botón "Aceptar".
	  4. El *SPP* cierra el `Dialog_Success` y retoma el flujo normal del caso de uso.
  3. *Agregar observación*
	  1. El *Profesor* ingresa una observación en el campo de texto de observaciones.
	  2. El *SPP* guarda la observación ingresada y retoma el flujo normal en el paso 4.
  4. *Ver rúbrica*
	  1. El *Profesor* da clic en el botón "Ver rúbrica".
	  2. El *SPP* abre una ventana alterna donde se muestra la rúbrica de evaluación y retoma el flujo normal en el paso 4.	
  5. *Seleccionar botón alterno*
	  1. El *Profesor* da clic en el botón “Cancelar”.
	  2. El *SPP* cierra el `Dialog_Confirmation` y retoma el flujo normal en el paso 4. 

**Excepciones:**  
   1. *Error al conectar con la base de datos*
	   1. El *SPP* muestra un `Dialog_ConnectionError` con el botón "Aceptar". 
	   2. El *Profesor* da clic en el botón “Aceptar".
	   3. El *SPP* cierra el `Dialog_ConnectionError`y retoma el flujo normal desde el paso 4.

**Postcondiciones:** 
POST-1. La calificación del `REPORT` se guardó en la base de datos.   

**Incluye (Relación Include):**  
No incluye.  

**Extiende (Relación Extend):**  
No extiende.  
