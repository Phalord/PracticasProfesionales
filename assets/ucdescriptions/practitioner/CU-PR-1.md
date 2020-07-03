---
layout: page
title: "CU-PR-1: Solicitar Proyecto"
permalink: /design-specification/uc-descriptions/practitioner/cu-pr-1/
hide_hero: true
---
<style>
   a.disabled {
      color: #03989E;
      pointer-events: none;
      cursor: default;
   }
</style>

**ID:** CU-PR-18

**Nombre:** Solicitar Proyecto

**Autor:** Sandoval Bravo Alejandro

**Fecha de creación:** 20 de marzo de 2020

**Fecha de actualización:** 27 de junio de 2020

**Descripción:**  
El *Practicante* deberá poder seleccionar hasta tres **`PROJECT`** como opciones para enviar un **`PROJECT REQUEST`** y poder ser asignado a uno de los **`PROJECT`** seleccionados.

**Actor:**  
*Practicante*

**Disparador:**  
El *Practicante* da clic al botón "Solicitar Proyecto" en la vista [`View_ProjectSection`][VPSC].

**Precondiciones:**  
Pre-1. Debe haber, por lo menos, 1 **`PROJECT`** sin asignar en la Base de Datos.  
Pre-2. El Practicante no ha enviado su **`PROJECT REQUEST`**.   

**Flujo Normal:**
  1. El <a id="fn_1"></a> *SPP* recupera los nombres de los **`PROJECT`**, sin asignar, de la Base de Datos y los muestra en [`View_ProjectRequest`][VPRQ] con disposición cuadriculada; cada cuadro el nombre del proyecto y dos botones: "Visualizar" y "Seleccionar"; hasta abajo dos botones "Solicitar" y "Cancelar". <a href="#ex_1">EX-1.</a>
  2. El <a id="fn_2"></a> *Practicante* da clic al botón "Seleccionar" en los **`PROJECT`** que quiera marcar como opción y da clic al botón "Solicitar". <a href="#fa_1">FA-1</a> <a href="#fa_2">FA-2</a> <a href="#fa_4">FA-4</a> <a href="#fa_5">FA-5</a>
  3. El *SPP* verifica que haya, al menos, un proyecto seleccionado (<a href="#fa_6">FA-6</a>) muestra un diálogo [`Dialog_Confirmation`][DLCO] con los botones "Confirmar" y "No".
  4. El *Practicante* da clic al botón "Confirmar". <a href="#fa_3">FA-3</a>
  5. El <a id="fn_5"></a> *SPP* cierra el [`Dialog_Confirmation`][DLCO] y añade los **`PROJECT`** al **`PROJECT REQUEST`** y lo guarda en la Base de Datos; y muestra un [`Dialog_Success`][DLSU]. <a href="#ex_1"><i>EX-1</i></a>
  6. El *Practicante* da clic en "Aceptar"
  7. Termina el Caso de uso.

**Flujos Alternos:**
  1. <a id="fa_1" class="disabled"><i>Cancelar Caso de Uso</i></a>
     1. El *Practicante* da clic en el botón "Atrás".
     2. El *SPP* regresa a la [`View_ProjectSection`][VPSC] 
     3. Termina el Caso de Uso.
  2. <a id="fa_2" class="disabled"><i>Visualizar Proyecto</i></a>
     1. El *Practicante* da clic al botón "Visualizar".
     2. El *SPP* muestra la interfaz [`View_ProjectInformation`][VPIN] que recupera al **`PROJECT`** y que al final contiene un botón "Regresar". <a href="#ex_1">EX-1</a>
     3. El *Practicante* da clic en el botón "Regresar"
     4. El *SPP* cierra [`View_ProjectInformation`][VPIN].
  3. <a id="fa_3" class="disabled"><i>Cancelar Confirmación</i></a>
     1. El *Practicante* da clic en el botón "NO".
     2. El *SPP* cierra el [`Dialog_Confirmation`][DLCO] y regresa al <a href="#fn_2">FN-2</a>.
  4. <a id="fa_4" class="disabled"><i>Máxima cantidad de opciones alcanzadas</i></a>
     1. El *SPP* muestra el diálogo [`Dialog_MaxReached`][DLMR]. 
     2. El *Practicante* da clic en el botón Aceptar.
     3. El *SPP* cierra el diálogo y regresa al <a href="#fn_1">FN-1</a>.
  5. <a id="fa_5" class="disabled"><i>Quitar Proyecto</i></a>
     1. El *Practicante* da clic en el botón "Quitar".
     2. El *SPP* quita la selección de ese proyecto.
  6. <a id="fa_6" class="disabled"><i>No hay proyectos seleccionados</i></a>
     1. El *SSP* muestra un [`Dialog_NoOptionsSelected`][DLNS].
     2. El *Practicante* da clic en el botón "Aceptar".
     3. EL *SPP* cierra el diálogo.

**Excepciones:**
   1. <a id="ex_1" class="disabled"><i>Error al conectar con Base de Datos</i></a>
      1. El *SPP* muestra un [`Dialog_ConnectionError`][DLCE] con el botón "Aceptar".
      2. El *Practicante* da clic en el botón "Aceptar".
      3. El *SPP* cierra el [`Dialog_ConnectionError`][DLCE] y [<a href="#fn_1">FN-1</a>]: despliega la ventana sin los cuadros de los proyectos para solicitar; [<a href="#fn_5">FN-5</a>, <a href="#fa_2">FA-2</a>]: regresa al <a href="#fn_2">FN-2</a>.

**Postcondiciones:**  
Post-1. El **`PROJECT REQUEST`** se guardó correctamente en la Base de Datos.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.

[VPSC]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_ProjectSection.png "`View_ProjectSection` Prototype"
[VPRQ]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_ProjectRequest.png "`View_ProjectRequest` Prototype"
[VPIN]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_ProjectInformation.png "`View_ProjectInformation` Prototype"
[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[DLMR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_MaxReached.png "`Dialog_MaxReached` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"
[DLNS]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_NoOptionsSelected.png "`Dialog_NoOptionsSelected` Prototype"