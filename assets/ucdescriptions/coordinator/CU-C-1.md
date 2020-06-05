--- 
layout: page 
title: "CU-C-1: Registrar Proyecto" 
permalink: /design-specification/uc-descriptions/coordinator/cu-c-1/ 
hide_hero: true 
---

**ID:** CU-C-1

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
PRE-1. Debe haber al menos un **`COORDINATOR`** en el sistema.  
PRE-2. Debe de haber al menos un **`PROJECT RESPONSIBLE`** que siga laborando en la **`RELATED COMPANY`**

**Flujo Normal:**  
  1. El *SPP* despliega la ventana [`View_AddProject`][VAPT] la cual muestra la primera sección llamada “Datos de empresa” la cual contiene las etiquetas: Nombre de empresa, Dirección, Ciudad, Estado y Teléfono. Después, está la sección “Datos del responsable del proyecto” y contiene las etiquetas: Nombre, Cargo y Correo electrónico; y por último, la sección "Datos del proyecto" con las etiquetas Nombre, Descripción y Recursos. Cada una de las etiquetas contiene una caja de texto al lado y al final, aparecen 2 botones “Registrar” y “Cancelar”.
  2. El *Coordinador* procede a ingresar la información solicitada por el *SPP* y da clic en el botón “Registrar”. (Ver FA-1). 
  3. El *SPP* valida la información ingresada por el *Coordinador* , guarda el **`PROJECT`** en la base de datos y despliega un [`Dialog_Success`][DLSU] con el botón "Aceptar"(Ver FA-2, EX-1). 
  4. El *Coordinador* da clic en el botón "Aceptar".
  5. El *SPP* cierra el [`Dialog_Success`][DLSU].
  6. Fin del caso de uso.

**Flujos Alternos:**
  1. *Cancelar acción*
	  1. El *Coordinador* da clic en el botón “Cancelar”.
	  2. El *SPP* muestra un [`Dialog_Confirmation`][DLCO] junto con los botones “Confirmar” y “Cancelar”.
	  3. El *Coordinador* selecciona la opción “Confirmar” y el *SPP* termina el caso de uso, si no, selecciona la opción “Cancelar” y el *SPP* continúa con el proceso en el paso 2 del flujo normal.
  2. *Información inválida*
	  4. El *SPP* despliega un [`Dialog_InvalidInformation`][DLII] con el botón "Aceptar".
	  5. El *Coordinador* hace clic en el botón "Aceptar".
	  6. El *SPP* cierra el [`Dialog_InvalidInformation`][DLII] y regresa al paso 2 del flujo normal.

**Excepciones:**  
   1. *Error al conectar con la base de datos*
	   1.	El *SPP* muestra un [`Dialog_ConnectionError`][DLCE] con el botón "Aceptar".
	   2.	El *Coordinador* da clic en el botón “Aceptar".
	   3.	El *SPP* cierra el [`Dialog_ConnectionError`][DLCE] y retoma el flujo normal desde el paso 2.

**Postcondiciones:**  
POST-1. El **`PROJECT`** se guardó en la base de datos y se cambió su estado a “Activo”.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.

[VAPT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_AddProject.png "`View_AddProject` Prototype"
[VPSE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_PractitionerSection.png "`View_PractitionerSection` Prototype"
[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"
[DLII]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_InvalidInformation.png "`Dialog_InvalidInformation` Prototype"