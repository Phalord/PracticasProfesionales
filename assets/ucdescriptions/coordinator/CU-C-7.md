--- 
layout: page 
title: "CU-C-7: Actualizar proyecto" 
permalink: /design-specification/uc-descriptions/coordinator/cu-c-7/ 
hide_hero: true 
---
**ID:** CU-C-13

**Nombre:** Actualizar Proyecto  

**Autor:** Victor Arturo Ruiz Cuervo  

**Fecha de creación:** 27 de Marzo de 2020  

**Fecha de actualización:** 30 de Junio de 2020  

**Descripción:**  
El *Coordinador* actualiza la información de un **`PROJECT`** ya existente en el sistema para que los **`PRACTICING`** no se encuentren desactualizados en cuanto a la información del **`PROJECT`**.   

**Actor:**  
*Coordinador*  

**Disparador**  
El *Coordinador* da clic en el botón “Actualizar proyecto” de la ventana [`View_ProjectSection`][VPSE]

**Precondiciones:**  
PRE-1. Debe haber al menos un **`COORDINATOR`** en el sistema.    
PRE-2. Debe de haber al menos un **`PROJECT`** en la base de datos.    

**Flujo Normal (FN):**    
  1. <a id="fn-1"><i></i></a>El *SPP* despliega la ventana [`View_ChooseProject`][VCPT] la cual muestra una lista de los **`PROJECT`** almacenados junto con un botón “Cancelar”. Además de la instrucción de seleccionar un **`PROJECT`** en una etiqueta. (Ver <a href="#error_conect">EX-1</a>)
  2. <a id="fn-2"><i></i></a>El *Coordinador* selecciona el `PROJECT` que quiere editar. (Ver <a href="#cancelar_accion">FA-1</a>)
  3. <a id="fn-3"><i></i></a>El *SPP* despliega la ventana [`View_AddProject`][VAPT] *(Ver caso de uso <a href="https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/ucdescriptions/coordinator/CU-C-1.md">CU-C-1</a>, <a href="#error_conect">EX-1</a>). 
  4. <a id="fn-4"><i></i></a>El *Coordinador* ingresa la información actualizada en los cuadros de texto o selecciona la **`RELATED COMPANY`** o **`PROJECT RESPONSIBLE`** nuevo  y da clic en el botón “Registrar”. (Ver <a href="#cancelar_accion">FA-1</a>) 
  5. El *SPP* muestra un [`Dialog_Confirmation`][DLCO] junto con los botones “Confirmar” y “Cancelar”. 
  6. El *Coordinador* selecciona la opción “Confirmar”. (Ver <a href="#cancelar_confirm">FA-2</a>)
  7. <a id="fn-7"><i></i></a>El *SPP* valida la información ingresada, actualiza y guarda la información modificada; y muestra un [`Dialog_Success`][DLSU] con el botón "Aceptar". (Ver <a href="#info_invalida">FA-3</a>, <a href="#error_conect">EX-1</a>).
  8. El *Coordinador* da clic en la opción "Aceptar".
  9. El *SPP* cierra el [`Dialog_Success`][DLSU] y despliega la ventana [`View_ChooseProject`][VCPT].
  10. Fin del caso de uso.

**Flujos Alternos (FA):**  
  1. <a id="cancelar_accion"><i></i></a>*Cancelar acción*
	  1. El *Coordinador* da clic en el botón “Cancelar”.
	  2. El *SPP* despliega la ventana [`View_ProjectSection`][VPSE] y termina el caso de uso si se tomó el flujo alterno en el <a href="#fn-2">FN-2</a>; si se tomó en el <a href="#fn-4">FN-4</a>, el *SPP* retoma el proceso en el <a href="#fn-2">FN-2</a>. 
  2.  <a id="cancelar_confirm"><i></i></a>*Cancelar confirmación*
	  1. El *Coordinador* da clic en el botón "Cancelar".
	  2. El *SPP* cierra el [`Dialog_Confirmation`][DLCO] y retoma el proceso en el <a href="#fn-4">FN-4</a>.
  3. <a id="info_invalida"><i></i></a>*Información inválida*
	  1. El *SPP* despliega un [`Dialog_InvalidInformation`][DLII] con el botón "Aceptar".
	  2. El *Coordinador* hace clic en el botón "Aceptar".
	  3. El *SPP* cierra el [`Dialog_InvalidInformation`][DLII] y regresa al <a href="#fn-4">FN-4</a>.

**Excepciones (EX):**  
  1. <a id="error_conect"><i></i></a>*Error al conectar con la base de datos*
	   1. El *SPP* muestra un [`Dialog_ConnectionError`][DLCE] con el botón "Aceptar". 
	   2. El *Coordinador* da clic en el botón “Aceptar".
	   3. El *SPP* cierra el [`Dialog_ConnectionError`][DLCE]. Si la excepción ocurrió en el <a href="#fn-1">FN-1</a>, el *SPP* despliega la ventana [`View_ChooseProject`][VCPT] sin los registros de **`PROJECT`**; si ocurrió en el <a href="#fn-3">FN-3</a>, despliega la ventana [`View_AddProject`][VAPT] sin los registros de **`RELATED COMPANY`** o **`PROJECT RESPONSIBLE`**; y si ocurre en el <a href="#fn-7">FN-7</a>, retoma el proceso en el <a href="#fn-4">FN-4</a>. 

**Postcondiciones:**  
POST-1. El `PROJECT` se guardó en la base de datos y se cambió su estado a “Activo”.   

**Incluye (Relación Include):**  
No incluye.  

**Extiende (Relación Extend):**  
No extiende.  

[VPSE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_ProjectSection.png "`View_ProjectSection` Prototype"
[VCPT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_ChooseProject.png "`View_ChooseProject` Prototype"
[VAPT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_AddProject.png "`View_AddProject` Prototype"
[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"
[DLII]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_InvalidInformation.png "`Dialog_InvalidInformation` Prototype"
