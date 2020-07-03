--- 
layout: page 
title: "CU-PF-1: Generar actividad" 
permalink: /design-specification/uc-descriptions/professor/cu-pf-1/ 
hide_hero: true 
---

**ID:** CU-PF-14  

**Nombre:** Generar actividad  

**Autor:** Victor Arturo Ruiz Cuervo  

**Fecha de creación:** 27 de Marzo de 2020  

**Fecha de actualización:** 30 de Junio de 2020  

**Descripción:**  
El *Profesor* podrá generar una **`ACTIVITY`** y se le notificará a los **`PRACTICING`** para que sea realizada en un plazo que el *Profesor* elija.  

**Actor:**  
*Profesor*  

**Disparador:**  
El *Profesor* da clic en la opción “Generar actividad” de la ventana [`View_ActivitySection`][VASE].  

**Precondiciones**  
PRE-1. Debe existir al menos un **`PROFESSOR`** en el sistema.  
PRE-2. El **`PROFESSOR`** debe tener asignado como mínimo un **`PRACTICING`**.   

**Flujo Normal:**  
  1. El *SPP* despliega la ventana [`View_AddActivity`][VAAC] y muestra 3 etiquetas: Titulo, Descripción y Fecha de entrega. Las primeras dos etiquetas tienen campos de texto a sus costados mientras que la última tiene un `DatePicker` debajo donde se puede seleccionar una fecha en específico. Por último, se muestran 2 botones “Publicar” y “Cancelar”. 
  2. <a id="fn-2"><i></i></a>El *Profesor* ingresa un título y descripción para la **`ACTIVITY`**, selecciona una fecha límite de entrega haciendo clic en un día cualquiera y da clic el botón “Publicar”. (Ver <a href="#cancelar_accion">FA-1</a>).
  3.  El *SPP* muestra un [`Dialog_Confirmation`][DLCO] junto con los botones “Confirmar” y “Cancelar”. 
  4. El *Profesor* selecciona la opción “Confirmar”. (Ver <a href="#cancelar_confirm">FA-2</a>)
  5. El *SPP* valida los datos ingresados, publica en el área de actividades la nueva **`ACTIVITY`**, la guarda en la base de datos y muestra un [`Dialog_Success`][DLSU] con el botón "Aceptar". (Ver <a href="#info_invalida">FA-3</a> y <a href="#error_conect">EX-1</a>) 
  6. El *Profesor* da clic en el botón "Aceptar".
  7. El *SPP* cierra el [`Dialog_Success`][DLSU].
  8. Fin del caso de uso.

**Flujos Alternos:**    
  1. <a id="cancelar_accion"><i></i></a>*Cancelar acción*
	  1. El *Profesor* da clic en el botón “Cancelar”.
	  2. El *SPP* despliega la ventana [`View_ActivitySection`][VASE] y termina el caso de uso. 
  2. <a id="cancelar_confirm"><i></i></a>*Cancelar confirmación*
	  1. El *Profesor* da clic en el botón "Cancelar".
	  2. El *SPP* cierra el [`Dialog_Confirmation`][DLCO] y retoma el proceso en el <a href="#fn-2">FN-2</a>.
  3. <a id="info_invalida"><i></i></a>*Información inválida*
	  1. El *SPP* despliega un [`Dialog_InvalidInformation`][DLII] con el botón "Aceptar".
	  2. El *Profesor* hace clic en el botón "Aceptar".
	  3. El *SPP* cierra el [`Dialog_InvalidInformation`][DLII] y regresa al <a href="#fn-2">FN-2</a>.

**Excepciones:**    
   1. <a id="error_conect"><i></i></a>*Error al conectar con la base de datos*
	   1. El *SPP* muestra un [`Dialog_ConnectionError`][DLCE] con el botón "Aceptar". 
	   2. El *Profesor* da clic en el botón “Aceptar".
	   3. El *SPP* cierra el [`Dialog_ConnectionError`][DLCE] y retoma el proceso desde el <a href="#fn-2">FN-2</a>.

**Postcondiciones:**  
POST-1. La `ACTIVITY` se encuentra en el sistema en estado “Activo”.  

**Incluye (Relación Include):**  
No incluye.  

**Extiende (Relación Extend):**    
No extiende.    

[VASE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/professor/View_ActivitySection.png "`View_ActivitySection` Prototype"
[VAAC]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/professor/View_AddActivity.png "`View_AddActivity` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLII]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_InvalidInformation.png "`Dialog_InvalidInformation` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"
