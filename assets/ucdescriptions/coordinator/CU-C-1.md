--- 
layout: page 
title: "CU-C-1: Registrar Proyecto" 
permalink: /design-specification/uc-descriptions/coordinator/cu-c-1/ 
hide_hero: true 
---

**ID:** CU-C-7

**Nombre:** Registrar Proyecto

**Autor:** Victor Arturo Ruiz Cuervo

**Fecha de creación:** 27 de Marzo de 2020

**Fecha de actualización:** 05 de Junio de 2020

**Descripción:**  
El *Coordinador* registra un nuevo **`PROJECT`** en el sistema para que los **`PRACTITIONER`** puedan visualizar su información, evitando pérdidas de tiempo en comunicación presencial y que siempre esté disponible dicha información.   

**Actor:**  
*Coordinador*  

**Disparador:**  
El *Coordinador* da clic en el botón “Registrar proyecto” en la ventana [`View_ProjectSection`][VPSE].

**Precondiciones:**  
PRE-1. Debe haber al menos un **`COORDINATOR`** registrado en el sistema.  

**Flujo Normal (FN):**  
  1. <a id="fn-1"><i> </i></a>El *SPP* despliega la ventana [`View_AddProject`][VAPT] la cual muestra la primera sección llamada "Datos del proyecto" con las etiquetas Nombre, Descripción y Recursos donde cada una contiene una caja de texto al lado; tambien estan las secciones de "Empresa" y "Responsable del proyecto", éstas contienen un botón "Añadir" y un menú desplegable que contiene los registros existentes de cada sección recuperados de la base de datos; y al final, aparecen 2 botones “Registrar” y “Cancelar”. (Ver <a href="#error_conexion">EX-1</a>)
  2. <a id="fn-2"><i></i></a>El *Coordinador* procede a ingresar la información del **`PROJECT`**, seleccionar la **`RELATED COMPANY`** y **`PROJECT RESPONSIBLE`** correspondiente y da clic en el botón “Registrar”. (Ver <a href="#cancelar_accion">FA-1</a>, <a href="#añadir_empresa">FA-4</a>, <a href="#añadir_responsable">FA-5</a>). 
  3. El *SPP* despliega un [`Dialog_Confirmation`][DLCO] con los botones "Aceptar" y "Cancelar".
  4. El *Coordinador* da clic en la opción "Aceptar". (Ver <a href="#cancelar_confirm">FA-2</a>)
  5. <a id="fn-5"><i></i></a>El *SPP* valida la información ingresada por el *Coordinador* , guarda el **`PROJECT`** en la base de datos y despliega un [`Dialog_Success`][DLSU] con el botón "Aceptar" (Ver <a href="#info_invalida">FA-3</a>, <a href="#error_conexion">EX-1</a>).
  6. El *Coordinador* da clic en el botón "Aceptar".
  7. El *SPP* cierra el [`Dialog_Success`][DLSU].
  8. Fin del caso de uso.

**Flujos Alternos (FA):**
  1. <a id="cancelar_accion"><i></i></a>*Cancelar acción*
	  1. El *Coordinador* da clic en el botón “Cancelar”.
	  2. El *SPP* despliega la ventana [`View_ProjectSection`][VPSE] y termina el caso de uso.
  2. <a id="cancelar_confirm"><i></i></a>*Cancelar confirmación*
	  1. El *Coordinador* da clic en el botón "Cancelar".
	  2. El *SPP* cierra el [`Dialog_Confirmation`][DLCO] y retoma el proceso en el <a href="#fn-2">FN-2</a>.
  3. <a id="info_invalida"><i></i></a>*Información inválida*
	  1. El *SPP* despliega un [`Dialog_InvalidInformation`][DLII] con el botón "Aceptar".
	  2. El *Coordinador* hace clic en el botón "Aceptar".
	  3. El *SPP* cierra el [`Dialog_InvalidInformation`][DLII]. Si se tomó el flujo alterno en el <a href="#fn-5">FN-5</a>, retoma el proceso en el <a href="#fn-2">FN-2</a>; si se toma en el <a href="#añadir_empresa">FA-4</a> o <a href="#añadir_responsable">FA-5</a>, se vuelve a tomar el paso donde ocurrió hasta tener éxito.
  4. <a id="añadir_empresa"><i></i></a>*Agregar empresa*
	  1. El *Coordinador* hace clic en el botón "Agregar" de la sección Empresa.
	  2. El *SPP* despliega la ventana [`View_AddCompany`][VACY] la cual contiene una etiqueta con la leyenda "Datos de la empresa", otras etiquetas y cuadros de texto para ingresar información de la **`RELATED COMPANY`** (Nombre, direccion, ciudad, estado, sector, correo electronico...); al final, se encuentran los botones "Registrar" y "Cancelar".
	  3. El *Coordinador* completa todos los campos y da clic en "Registrar" y el *SPP* registra la nueva **`RELATED COMPANY`** en la base de datos, despliega un [`Dialog_Success`][DLSU], despliega la ventana [`View_AddProject`][VAPT] y continua el proceso en el <a href="#fn-2">FN-2</a>; si el *Coordinador* selecciona la opción "Cancelar", el *SPP* solo despliega la ventana [`View_AddProject`][VAPT] y continua el proceso en el <a href="#fn-2">FN-2</a>. (Ver <a href="#info_invalida">FA-3</a>, <a href="#error_conexion">EX-1</a>)
  5. <a id="añadir_responsable"><i></i></a>*Agregar responsable del proyecto*
	  1. El *Coordinador* hace clic en el botón "Agregar" de la sección Responsable del proyecto.
	  2. El *SPP* despliega la ventana [`View_AddResponsible`][VARE] la cual contiene una etiqueta con la leyenda "Datos del responsable del proyecto", otras etiquetas y cuadros de texto para ingresar información del **`PROJECT RESPONSIBLE`** (Nombre, correo electronico y teléfono); al final, se encuentran los botones "Registrar" y "Cancelar". 
	  3. El *Coordinador* completa todos los campos y da clic en "Registrar" y el *SPP* registra el nuevo **`PROJECT RESPONSIBLE`** en la base de datos, despliega un [`Dialog_Success`][DLSU], despliega la ventana [`View_AddProject`][VAPT] y continua el proceso en el <a href="#fn-2">FN-2</a>; si el *Coordinador* selecciona la opción "Cancelar", el *SPP* solo despliega la ventana [`View_AddProject`][VAPT] y continua el proceso en el <a href="#fn-2">FN-2</a>. (Ver <a href="#info_invalida">FA-3</a>, <a href="#error_conexion">EX-1</a>)

**Excepciones (EX):**  
   1. <a id="error_conexion"><i></i></a>*Error al conectar con la base de datos*
	   1.	El *SPP* muestra un [`Dialog_ConnectionError`][DLCE] con el botón "Aceptar".
	   2.	El *Coordinador* da clic en el botón “Aceptar".
	   3.	El *SPP* cierra el [`Dialog_ConnectionError`][DLCE]. Si la excepción ocurrió en el <a href="#fn-1">FN-1</a>, el *SPP* despliega la ventana [`View_AddProject`][VAPT] sin los registros de la base de datos en los menú desplegables; si ocurrió en el <a href="#fn-5">FN-5</a>, <a href="#añadir_empresa">FA-4</a> o <a href="#añadir_responsable">FA-5</a>, retoma el proceso en el <a href="#fn-2">FN-2</a>.

**Postcondiciones:**  
POST-1. El **`PROJECT`** se guardó en la base de datos y se cambió su estado a “Activo”.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.

[VAPT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_AddProject.png "`View_AddProject` Prototype"
[VPSE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_ProjectSection.png "`View_ProjectSection` Prototype"
[VACY]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_AddCompany.png "`View_AddCompany` Prototype"
[VARE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_AddResponsible.png "`View_AddResponsible` Prototype"
[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"
[DLII]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_InvalidInformation.png "`Dialog_InvalidInformation` Prototype"
