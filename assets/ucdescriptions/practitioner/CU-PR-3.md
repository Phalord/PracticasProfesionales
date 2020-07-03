---
layout: page
title: "CU-PR-3: Generar Reporte Parcial"
permalink: /design-specification/uc-descriptions/practitioner/cu-pr-3/
hide_hero: true
---
<style>
   a.disabled {
      color: #03989E;
      pointer-events: none;
      cursor: default;
   }
</style>

**ID:** CU-PR-20  

**Nombre:** Generar Reporte Parcial

**Autor:** Sandoval Bravo Alejandro

**Fecha de creación:** 19 de marzo de 2020

**Fecha de actualización:** 27 de junio de 2020

**Descripción:**  
El *Practicante* deberá poder generar su **`REPORT`** y registrar las **`ACTIVITY`** que haya realizado durante un tiempo determinado para que pueda ser consultado y calificado, posteriormente, por un *Profesor*.

**Actor:**  
*Practicante*

**Disparador:**  
El *Practicante* da clic al botón "Generar Reporte Parcial" en la vista [`View_GenerateDocumentation`][VGDN].

**Precondiciones:**  
Pre-1. El *Practicante* debe estar asignado a un **`PROJECT`**.
Pre-2. El *Practicante* debe tener asignada al menos 1 **`ACTIVITY`** sin completar.

**Flujo Normal:**
  1. El <a id="fn_1"></a> *SPP* recupera las **`ACTIVITY`** del *Practicante* y despliega la interfaz [`View_GeneratePartialReport`][VGPR] mostrando etiquetas de texto que señalan la información que deberá ser ingresada (NRC, Periodo Escolar, Periodo del Reporte, Horas Cubiertas, Número de Informe; y de las **`ACTIVITY`**: Tiempo Real Empleado) en el campo de texto adyacente. Debajo del último campo de texto, se encuentran los botones `Añadir Actividad` y, al final de la ventana, dos botones `Generar` `Cancelar`. <a href="#ex_1">EX-1</a>
  2. El <a id="fn_2"></a> *Practicante*, escribe la información solicitada por el *SPP* y da clic en el botón `Generar`. <a href="#fa_2">FA-1</a> <a href="#fa_3">FA-3</a>
  3. El *SPP* verifica que los campos de información sean válidos (<a href="#fa_4">FA-4</a>) y muestra un diálogo de alerta [`Dialog_Confirmation`][DLCO]
  4. El *Practicante* da clic en el botón "Confirmar". <a href="#fa_2">FA-2</a>
  5. El <a id="fn_5"></a> *SPP* guarda el **`REPORT`** en la base de datos y cierra el diálogo de Alerta; y muestra un [`Dialog_Succes`][DLSU]. <a href="#ex_1">EX-1</a>
  6. Termina el Caso de Uso.

**Flujos Alternos:**
  1. <a id="fa_1" class="disabled">Cancelar Caso de Uso</a>
     1. El *Practicante* da clic al botón "Atrás".
     2. El *SPP* regresa a la [`View_GenerateDocumentation`][VGDN].
     3. Termina el Caso de Uso.
  2. <a id="fa_2" class="disabled">Cancelar Confirmación</a>
     1. El *Practicante* da clic en el botón "Cancelar".
     2. El *SPP* cierra el diálogo de alerta y regresa al <a href="#fn_2">FN-2</a>.
  3. <a id="fa_3" class="disabled">Añadir Actividad</a>
     1. El *Practicante* da clic en botón "Añadir Actividad".
     2. El *SPP* repetirá los campos de la información de la **`ACTIVITY`** para ingresar una nueva.
  4. <a id="#fa_4" class="disabled">Información Inválida</a>
     1. El *SPP* muestra un [`Dialog_InvalidInformation`][DLII] y regresa al <a href="#fn_2">FN-2</a>.

**Excepciones:**
   1. <a id="ex_1" class="disabled">Error al conectar con Base de Datos</a>
      1. El *SPP* muestra un [`Dialog_ConnectionError`][DLCE] con el botón "Aceptar".
      2. El *Practicante* da clic en el botón "Aceptar".
      3. El *SPP* cierra el [`Dialog_ConnectionError`][DLCE] y [<a href="#fn_1">FN-1</a>]: despliega la ventana sin la los cuadros para solicitar; [<a href="#fn_5">FN-5</a>]: regresa al <a href="#fn_2">FN-2</a>.

**Postcondiciones:**  
Post-1. El **`REPORT`** se guardó exitosamente en la Base de Datos.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.

[VGDN]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_GenerateDocumentation.png "`View_GenerateDocumentation` Prototype"
[VGPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_GeneratePartialReport.png "`View_GeneratePartialReport` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"
[DLII]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_InvalidInformation.png "`Dialog_InvalidInformation` Prototype"