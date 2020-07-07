---
layout: page
title: Especificación de Diseño
permalink: /design-specification/
toc: true
toc_title: "Índice"
---

## Datos escolares
**Docente:** Dr. Jorge Octavio Ocharán Hernández

**Experiencia Educativa:** Principios de Diseño de Software

**Dev Team:**
  * Ruiz Cuervo Victor Arturo
  * Sandoval Bravo Alejandro
  * Tapia Cruz Abner Jeffrey

## 1. Introducción
El objetivo principal del *Sistema para Prácticas Profesionales* es proporcionar apoyo a los actores más frecuentes de esta experiencia educativa (EE), los cuales son: el Coordinador de las Prácticas Profesionales, los docentes que imparten la EE y los alumnos que la cursan; buscando, principalmente, reducir el tiempo de trabajo del coordinador y otorgar la posibilidad de realizar todo el proceso de una manera más rápida y eficaz. Así mismo, el propósito de la *Especificación de Diseño* es obtener una visión detallada del funcionamiento que tendrá el sistema, planificando una solución de software para el problema a tratar cumpliendo con los requisitos funcionales y no funcionales establecidos.

El contenido de esta *Especificación de Diseño* comienza con el [planteamiento del problema](#situación-actual), sobre cómo se lleva, actualmente, el proceso de las Prácticas Profesionales. Después pasamos a la [definición de requerimientos](#definición-de-requerimientos), sección dividida en las siguientes secciones: [diagramas de paquetes de Casos de uso](#diagrama-de-paquetes-de-casos-de-uso), [diagramas de casos de uso por paquetes](#diagramas-de-casos-de-uso-por-paquetes), [descripciones de casos de uso](#descripción-de-casos-de-uso) y [diagramas de actividades por caso de uso](#diagramas-de-actividades-por-caso-de-uso). Continuando con el [apartado de diseño](#diseño), donde incorporamos el [Modelo de Dominio](#diagrama-de-clases-del-modelo-de-dominio), como diagrama de clases, del Sistema. También se definen la arquitectura del sistema, el diseño de interfaces 

**Convenciones**  
A continuación se muestran los diferentes identificadores con su descripción que fueron utilizados.

* SPP: Sistema para Prácticas profesionales.
* EE: Experiencia Educativa.
* CU-X-00: Identificador para los casos de uso. Donde "CU" es la abreviación de ‘Casos de Uso’, la "X" indica la inicial del actor de dicho caso de uso y los números indican el número de caso de uso.

**Referencias**  
Equipo 2(TMNT). (2019). *Especificación de Requerimientos de Software para Sistema web para las Prácticas Profesionales (Versión 0.3 propuesta).* Universidad Veracruzana, Xalapa, Veracruz.

### Situación actual
Los proceso de la EE Prácticas Profesionales, como la entrega de documentos por parte de los alumnos toman mucho tiempo y pueden ser entorpecidos. Algunas actividades que el Coordinador de la EE realiza son exhaustivas y, en promedio, se pierden hasta dos días por corregir errores inesperados. Estas situaciones llevan a la necesidad de un nuevo sistema con el cual se puedan gestionar los datos y proceso adecuadamente y, de esta manera, facilitarlos.

### Clases de usuario y características  
**Administrador**  
Un *Administrador* se encarga de registrar y llevar el control de *Coordinadores* y *Profesores*, así mismo tiene la capacidad de darlos de baja y poder mantener un historial para consultas posteriores.

**Coordinador**  
Un *Coordinador* es aquel que se encarga de registrar a los practicantes así como de las asignaciones de proyectos. La persona que lleve a cabo este rol debe tener conocimiento de del estado de los practicantes y profesores, además de la capacidad de generar reportes de indicadores basados en las estadísticas de los usuarios del sistema.

**Profesor**  
Un *Profesor* se encarga de evaluar al grupo de practicantes asiganados a él, así como de generar actividades para estos.

**Practicante**  
Un *Practicante* es quien accede al Sistema para consultar información que le concierna, actividades pendientes, realizar reportes, entregar documentos, consultar fechas importantes, entre otras funcionalidades.

### [Justificaciones de Diseño][DESP]
[DESP]: https://phalord.github.io/PracticasProfesionales/design-justifications/ "Justificaciones de Diseño"

## 2. Definición de Requerimientos
[Justificaciones de Definición de Requerimientos](https://phalord.github.io/PracticasProfesionales/design-justifications/#definicion-de-requerimientos)

### 2.1. Diagrama de paquetes de Casos de Uso
![Paquetes de Casos de Uso][PCU]

[PCU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/packages/packages.PNG

### 2.2. Diagramas de Casos de Uso por paquetes
  1. [CU del Administrador][CUA]
  2. [CU del Coordinador][CUC]
  3. [CU del Profesor][CUP]
  4. [CU del Practicante][CUS]

[CUA]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/packages/administratorpackage.png "Paquete Administrador"
[CUC]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/packages/coordinatorpackage.png "Paquete Coordinador"
[CUP]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/packages/professorpackage.PNG "Paquete Profesor"
[CUS]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/packages/practitionerpackage.png "Paquete Practicante"
[CUU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/packages/userpackage.png "Paquete Usuario"

### 2.3. Descripción de Casos de Uso

#### Descripción: Administrador
  1. [CU-A-1: Registrar Coordinador][RECO]
  2. [CU-A-2: Registrar Profesor][REPS]
  3. [CU-A-3: Eliminar Coordinador][ELCO]
  4. [CU-A-4: Eliminar Profesor][ELPR]

[RECO]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/administrator/cu-a-1/ "Descripción de CU-A-1"
[REPS]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/administrator/cu-a-2/ "Descripción de CU-A-2"
[ELCO]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/administrator/cu-a-3/ "Descripción de CU-A-3"
[ELPR]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/administrator/cu-a-4/ "Descripción de CU-A-4"

#### Descripción: Coordinador
  1. [CU-C-5: Registrar Proyecto][REPR]
  2. [CU-C-6: Asignar Proyecto][ASPR]
  3. [CU-C-7: Eliminar Proyecto][ELPO]
  4. [CU-C-8: Eliminar Practicante][ELPE]
  5. [CU-C-9: Generar Reporte de Indicadores][GRDI]
  6. [CU-C-10: Registrar Practicante][REPE]
  7. [CU-C-11: Actualizar Proyecto][ACPO]

[REPR]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/coordinator/cu-c-5/ "Descripción de CU-C-5"
[ASPR]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/coordinator/cu-c-6/ "Descripción de CU-C-6"
[ELPO]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/coordinator/cu-c-7/ "Descripción de CU-C-7"
[ELPE]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/coordinator/cu-c-8/ "Descripción de CU-C-8"
[GRDI]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/coordinator/cu-c-9/ "Descripción de CU-C-9"
[REPE]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/coordinator/cu-c-10/ "Descripción de CU-C-10"
[ACPO]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/coordinator/cu-c-11/ "Descripción de CU-C-11"

#### Descripción: Profesor
  1. [CU-PF-12: Generar Actividad][GEAC]
  2. [CU-PF-13: Añadir Formato de Presentación][AFPR]
  3. [CU-PF-14: Evaluar Reporte Parcial][ERPA]
  4. [CU-PF-15: Evaluar Reporte Mensual][ERME]

[GEAC]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/professor/cu-pf-12/ "Descripción de CU-PF-12"
[AFPR]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/professor/cu-pf-13/ "Descripción de CU-PF-13"
[ERPA]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/professor/cu-pf-14/ "Descripción de CU-PF-14"
[ERME]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/professor/cu-pf-15/ "Descripción de CU-PF-15"

#### Descripción: Practicante
  1. [CU-PR-16: Solicitar Proyecto][SOPR]
  2. [CU-PR-17: Añadir Horario][ANHO]
  3. [CU-PR-18: Generar Reporte Parcial][GRPA]
  4. [CU-PR-19: Añadir Reporte Parcial][ARPA]
  5. [CU-PR-20: Generar Reporte Mensual][GRME]
  6. [CU-PR-21: Añadir Reporte Mensual][ARME]
  7. [CU-PR-22: Generar Autoevaluación][GAUT]
  8. [CU-PR-23: Añadir Autoevaluación][AAUT]
  9. [CU-PR-24: Añadir Actividad][AACT]
  10. [CU-PR-25: Añadir Bitácora Personal][APSP]
  11. [CU-PR-26: Añadir Plan de Actividades][APAC]

[SOPR]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-16/ "Descripción de CU-PR-16"
[ANHO]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-17/ "Descripción de CU-PR-17"
[GRPA]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-18/ "Descripción de CU-PR-18"
[ARPA]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-19/ "Descripción de CU-PR-19"
[GRME]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-20/ "Descripción de CU-PR-20"
[ARME]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-21/ "Descripción de CU-PR-21"
[GAUT]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-22/ "Descripción de CU-PR-22"
[AAUT]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-23/ "Descripción de CU-PR-23"
[AACT]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-24/ "Descripción de CU-PR-24"
[APSP]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-25/ "Descripción de CU-PR-25"
[APAC]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-26/ "Descripción de CU-PR-26"

### 2.4. Diagramas de Actividades por Caso de Uso
[Justificación de Diagramas por Caso de uso](https://phalord.github.io/PracticasProfesionales/design-justifications/#actividades-por-caso-de-uso)

#### Actividad: Administrador
  1. [CU-A-1: Registrar Coordinador][ARECO]
  2. [CU-A-2: Registrar Profesor][AREPS]
  3. [CU-A-3: Eliminar Coordinador][AELCO]
  4. [CU-A-4: Eliminar Profesor][AELPR]

[ARECO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/administrator/act1.jpg "Registrar Coordinador"
[AREPS]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/administrator/act2.jpg "Registrar Profesor"
[AELCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/administrator/act3.jpg "Eliminar Coordinador"
[AELPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/administrator/act4.jpg "Eliminar Profesor"

#### Actividad: Coordinador
  1. [CU-C-5: Registrar Proyecto pt.1][AREPR]
  2. [CU-C-5: Registrar Proyecto pt.2][AREPR1]
  3. [CU-C-5: Registrar Proyecto pt.3][AREPR2]
  4. [CU-C-6: Asignar Proyecto][AASPR]
  5. [CU-C-7: Eliminar Proyecto][AELPO]
  6. [CU-C-8: Eliminar Practicante][AELPE]
  7. [CU-C-9: Generar Reporte de Indicadores][AGRDI]
  8. [CU-C-10: Registrar Practicante][AREPE]
  7. [CU-C-11: Actualizar Proyecto][AACPO]

[AREPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/coordinator/act5.jpg "Registrar Proyecto pt.1"
[AREPR1]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/coordinator/act5_1.jpg "Registrar Proyecto pt.2"
[AREPR2]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/coordinator/act5_2.jpg "Registrar Proyecto pt.3"
[AASPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/coordinator/act6.png "Asignar Proyecto"
[AELPO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/coordinator/act7.jpg "Eliminar Proyecto"
[AELPE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/coordinator/act8.jpg "Eliminar Practicante"
[AGRDI]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/coordinator/act9.jpg "Generar Reporte de Indicadores"
[AREPE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/coordinator/act10.jpg "Registrar Practicante"
[AACPO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/coordinator/act11.jpg "Actualizar Proyecto"

#### Actividad: Profesor
  1. [CU-PF-12: Generar Actividad][AGEAC]
  2. [CU-PF-13: Añadir Formato de Presentación][AAFPR]
  3. [CU-PF-14: Evaluar Reporte Parcial][AERPA]
  4. [CU-PF-15: Evaluar Reporte Mensual][AERME]

[AGEAC]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/professor/act12.jpg "Generar Actividad"
[AAFPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/professor/act13.jpg "Añadir Formato de Presentación"
[AERPA]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/professor/act14.jpg "Evaluar Reporte Parcial"
[AERME]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/professor/act15.jpg "Evaluar Reporte Mensual"

#### Actividad: Practicante
  1. [CU-PR-16: Solicitar Proyecto][ASOPR]
  2. [CU-PR-17: Añadir Horario][AANHO]
  3. [CU-PR-18: Generar Reporte Parcial][AGRPA]
  4. [CU-PR-19: Añadir Reporte Parcial][AARPA]
  5. [CU-PR-20: Generar Reporte Mensual][AGRME]
  6. [CU-PR-21: Añadir Reporte Mensual][AARME]
  7. [CU-PR-22: Generar Autoevaluación][AGAUT]
  8. [CU-PR-23: Añadir Autoevaluación][AAAUT]
  9. [CU-PR-24: Añadir Actividad][AAACT]
  10. [CU-PR-25: Añadir Bitácora Personal][AAPSP]
  11. [CU-PR-26: Añadir Plan de Actividades][AAPAC]

[ASOPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/practitioner/act16.png "Solicitar Proyecto"
[AANHO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/practitioner/act17.png "Añadir Horario"
[AGRPA]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/practitioner/act18.png "Generar Reporte Parcial"
[AARPA]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/practitioner/act19.png "Añadir Reporte Parcial"
[AGRME]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/practitioner/act20.jpg "Generar Reporte Mensual"
[AARME]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/practitioner/act21.png "Añadir Reporte Mensual"
[AGAUT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/practitioner/act22.jpg "Generar Autoevaluación"
[AAAUT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/practitioner/act23.png "Añadir Autoevaluación"
[AAACT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/practitioner/act24.png "Añadir Actividad"
[AAPSP]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/practitioner/act25.png "Añadir Bitácora Personal" 
[AAPAC]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/practitioner/act26.png "Añadir Plan de Actividades"

## 3. Diseño
### 3.1. Diagrama de Clases y Modelo de Dominio
#### Modelo de Dominio
![Modelo de Dominio][MDD]

#### Diagrama de Clases
![Diagrama de Clases][DDC]

[MDD]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/domain/domain_model.jpg "Modelo de Dominio"

[DDC]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/domain/class_diagram.png "Diagrama de Clases"

### 3.2. Diagramas de Robustez
#### Robustez: Administrador
  1. [CU-A-1: Registrar Coordinador][RRECO]
  2. [CU-A-2: Registrar Profesor][RREPS]
  3. [CU-A-3: Eliminar Coordinador][RELCO]
  4. [CU-A-4: Eliminar Profesor][RELPR]

[RRECO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/administrator/rob1.png "Registrar Coordinador"
[RREPS]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/administrator/rob2.png "Registrar Profesor"
[RELCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/administrator/rob3.png "Eliminar Coordinador"
[RELPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/administrator/rob4.png "Eliminar Profesor"

#### Robustez: Coordinador
  1. [CU-C-5: Registrar Proyecto][RREPR]
  2. [CU-C-6: Asignar Proyecto][RASPR]
  3. [CU-C-7: Eliminar Proyecto][RELPO]
  4. [CU-C-8: Eliminar Practicante][RELPE]
  5. [CU-C-9: Generar Reporte de Indicadores][RGRDI]
  6. [CU-C-10: Registrar Practicante][RREPE]
  7. [CU-C-11: Actualizar Proyecto][RACPO]

[RREPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/coordinator/rob5.png "Registrar Proyecto"
[RASPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/coordinator/rob6.png "Asignar Proyecto"
[RELPO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/coordinator/rob7.png "Eliminar Proyecto"
[RELPE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/coordinator/rob8.png "Eliminar Practicante"
[RGRDI]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/coordinator/rob9.png "Generar Reporte de Indicadores"
[RREPE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/coordinator/rob10.png "Registrar Practicante"
[RACPO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/coordinator/rob11.png "Actualizar Proyecto"

#### Robustez: Profesor
  1. [CU-PF-12: Generar Actividad][RGEAC]
  2. [CU-PF-13: Añadir Formato de Presentación][RAFPR]
  3. [CU-PF-14: Evaluar Reporte Parcial][RERPA]
  4. [CU-PF-15: Evaluar Reporte Mensual][RERME]

[RGEAC]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/professor/rob12.png "Generar Actividad"
[RAFPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/professor/rob13.png "Añadir Formato de Presentación"
[RERPA]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/professor/rob14.png "Evaluar Reporte Parcial"
[RERME]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/professor/rob15.png "Evaluar Reporte Mensual"

#### Robustez: Practicante
  1. [CU-PR-16: Solicitar Proyecto][RSOPR]
  2. [CU-PR-17: Añadir Horario][RANHO]
  3. [CU-PR-18: Generar Reporte Parcial][RGRPA]
  4. [CU-PR-19: Añadir Reporte Parcial][RARPA]
  5. [CU-PR-20: Generar Reporte Mensual][RGRME]
  6. [CU-PR-21: Añadir Reporte Mensual][RARME]
  7. [CU-PR-22: Generar Autoevaluación][RGAUT]
  8. [CU-PR-23: Añadir Autoevaluación][RAAUT]
  9. [CU-PR-24: Añadir Actividad][RAACT]
  10. [CU-PR-25: Añadir Bitácora Personal][RAPSP]
  11. [CU-PR-26: Añadir Plan de Actividades][RAPAC]

[RSOPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/practitioner/rob16.png "Solicitar Proyecto"
[RANHO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/practitioner/rob17.png "Añadir Horario"
[RGRPA]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/practitioner/rob18.png "Generar Reporte Parcial"
[RARPA]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/practitioner/rob19.png "Añadir Reporte Parcial"
[RGRME]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/practitioner/rob20.png "Generar Reporte Mensual"
[RARME]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/practitioner/rob21.png "Añadir Reporte Mensual"
[RGAUT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/practitioner/rob22.png "Generar Autoevaluación"
[RAAUT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/practitioner/rob23.png "Añadir Autoevaluación"
[RAACT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/practitioner/rob24.png "Añadir Actividad"
[RAPSP]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/practitioner/rob25.png "Añadir Bitácora Personal"
[RAPAC]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/practitioner/rob26.png "Añadir Plan de Actividades"

### 3.3. Diagramas de Secuencia  
#### Secuencia: Administrador
  1. [CU-A-1: Registrar Coordinador][SRECO]
  2. [CU-A-2: Registrar Profesor][SREPS]
  3. [CU-A-3: Eliminar Coordinador][SELCO]
  4. [CU-A-4: Eliminar Profesor][SELPR]

[SRECO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/sequence/administrator/seq1.png "Registrar Coordinador"
[SREPS]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/sequence/administrator/seq2.png "Registrar Profesor"
[SELCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/sequence/administrator/seq3.png "Eliminar Coordinador"
[SELPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/sequence/administrator/seq4.png "Eliminar Profesor"

#### Secuencia: Coordinador
  1. [CU-C-5: Registrar Proyecto][SREPR]
  2. [CU-C-6: Asignar Proyecto][SASPR]
  3. [CU-C-8: Eliminar Practicante][SELPE]
  4. [CU-C-10: Registrar Practicante][SREPE]
  5. [CU-C-11: Actualizar Proyecto][SACPO]

[SREPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/sequence/coordinator/seq5.png "Registrar Proyecto"
[SASPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/sequence/coordinator/seq6.png "Asignar Proyecto"
[SELPE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/sequence/coordinator/seq8.png "Eliminar Practicante"
[SREPE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/sequence/coordinator/seq10.png "Registrar Practicante"
[SACPO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/sequence/coordinator/seq11.png "Actualizar Proyecto"

#### Secuencia: Profesor
  1. [CU-PF-14: Evaluar Reporte Parcial][SERPA]
  2. [CU-PF-15: Evaluar Reporte Mensual][SERME]

[SERPA]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/sequence/professor/seq14.png "Evaluar Reporte Parcial"
[SERME]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/sequence/professor/seq15.png "Evaluar Reporte Mensual"

#### Secuencia: Practicante
  1. [CU-PR-16: Solicitar Proyecto][SSOPR]
  2. [CU-PR-17: Añadir Horario][SANHO]
  3. [CU-PR-18: Generar Reporte Parcial][SGRPA]
  4. [CU-PR-19: Añadir Reporte Parcial][SARPA]
  5. [CU-PR-20: Generar Reporte Mensual][SGRME]
  6. [CU-PR-21: Añadir Reporte Mensual][SARME]
  7. [CU-PR-22: Generar Autoevaluación][SGAUT]
  8. [CU-PR-23: Añadir Autoevaluación][SAAUT]

[SSOPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/sequence/practitioner/seq16.png "Solicitar Proyecto"
[SANHO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/sequence/practitioner/seq17.png "Añadir Horario"
[SGRPA]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/sequence/practitioner/seq18.png "Generar Reporte Parcial"
[SARPA]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/sequence/practitioner/seq19.png "Añadir Reporte Parcial"
[SGRME]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/sequence/practitioner/seq20.png "Generar Reporte Mensual"
[SARME]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/sequence/practitioner/seq21.png "Añadir Reporte Mensual"
[SGAUT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/sequence/practitioner/seq22.png "Generar Autoevaluación"
[SAAUT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/sequence/practitioner/seq23.png "Añadir Autoevaluación"

### 3.4. Diagramas de comunicación  

#### Comunicación: Coordinador
  1. [CU-C-7: Eliminar Proyecto][CELPO]
  2. [CU-C-9: Generar Reporte de Indicadores][CGRDI]

[CELPO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/communiaction/coordinator/com_7.png "Eliminar Proyecto"
[CGRDI]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/communication/coordinator/com_9.png "Generar Reporte de Indicadores"

#### Comunicación: Profesor
  1. [CU-PF-12: Generar Actividad][CGEAC]
  2. [CU-PF-13: Añadir Formato de Presentación][CAFPR]

[CGEAC]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/communication/professor/com12.png "Generar Actividad"
[CAFPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/communication/professor/com13.png "Añadir Formato de Presentación"

#### Comunicación: Practicante
  1. [CU-PR-24: Añadir Actividad][CAACT]
  2. [CU-PR-25: Añadir Bitácora Personal][CAPSP]
  3. [CU-PR-26: Añadir Plan de Actividades][CAPAC]

[CAACT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/communication/practitioner/com24.png "Añadir Actividad"
[CAPSP]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/communication/practitioner/com25.png "Añadir Bitácora Personal"
[CAPAC]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/communication/practitioner/com26.png "Añadir Plan de Actividades"

### 3.5. Diagramas de máquina de estado
  1. [**`ACTIVITY`**][MS_1]  
  2. [**`PROJECT`**][MS_2]
  3. [**`PROJECT ASSIGNATION`**][MS_3]
  4. [**`PROJECT REQUEST`**][MS_4]

[MS_1]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/state/sm1.png "Máquina de Estados de Objeto1"
[MS_2]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/state/sm2.png "Máquina de Estados de Objeto1"
[MS_3]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/state/sm3.png "Máquina de Estados de Objeto1"
[MS_4]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/state/sm4.png "Máquina de Estados de Objeto1"

## 4. Prototipos de Interfaz
### Prototipos: Administrador
  1. [View_AddCoordinator][VACR]
  2. [View_AddProfessor][VAPR]
  3. [View_CoordinatorSection][VCSE]
  4. [View_DeleteCoordinator][VDCR]
  5. [View_DeleteProfessor][VDPR]
  6. [View_ProfessorSection][VPSN]

[VACR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/administrator/View_AddCoordinator.png "`View_AddCoordinator` Prototype"
[VAPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/administrator/View_AddProfessor.png "`View_AddProfessor` Prototype"
[VCSE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/administrator/View_CoordinatorSection.png "`View_CoordinatorSection` Prototype"
[VDCR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/administrator/View_DeleteCoordinator.png "`View_DeleteCoordinator` Prototype"
[VDPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/administrator/View_DeleteProfessor.png "`View_DeleteProfessor` Prototype"
[VPSN]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/administrator/View_ProfessorSection.png "`View_ProfessorSection` Prototype"

### Prototipos: Coordinador
  1. [View_CoordinatorMenu][VCMN]
  2. [View_PractitionerSection][VPSE]
  3. [View_ProjectRequests][VPRE]
  4. [View_AssignationConfirmation][VACO]
  5. [View_AddProject][VAPT]
  6. [View_DeleteProject][VDPT]
  7. [View_AddPractitioner][VAPR] 
  8. [View_DeletePractitioner][VDPI]
  9. [View_IndicatorsReport][VIRP]
  10. [View_ChooseProject][VCPT]
  11. [View_AddCompany][VACY]
  12. [View_AddResponsible][VARE]
  13. [View_PractitionerInformation][VPRI]
  14. [View_ProjectSection][VPRS]
  15. [Dialog_ProjectAlreadyAssigned][DLAA]

[VCMN]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_CoordinatorMenu.png "`View_CoordinatorMenu` Prototype"
[VPSE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_PractitionerSection.png "`View_PractitionerSection` Prototype"
[VPRE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_ProjectRequests.png "`View_ProjectRequests` Prototype"
[VACO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_AssignationConfirmation.png "`View_AssignationConfirmation` Prototype"
[VAPT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_AddProject.png "`View_AddProject` Prototype"
[VDPT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_DeleteProject.png "`View_DeleteProject` Prototype"
[VDPI]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_DeletePractitioner.png "`View_DeletePractitioner` Prototype"
[VIRP]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_IndicatorsReport.png "`View_IndicatorsReport` Prototype"
[VCPT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_ChooseProject.png "`View_ChooseProject` Prototype"
[DLAA]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/Dialog_ProjectAlreadyAssigned.png "`Dialog_ProjectAlreadyAssigned` Prototype"
[VAPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_AddPractitioner.png "`View_AddPractitioner` Prototype"
[VACY]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_AddCompany.png "`View_AddCompany` Prototype"
[VARE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_AddResponsible.png "`View_AddResponsible` Prototype"
[VPRI]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_PractitionerInformation.png "`View_PractitionerInformation` Prototype"
[VPRS]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_ProjectSection.png "`View_ProjectSection` Prototype"

### Prototipos: Profesor
  1. [View_ActivitySection][VASN]
  2. [View_AddActivity][VAAY]
  3. [View_EvaluateEvidenceSection][VEES]
  4. [View_EvaluateMonthlyReport][VEMR]
  5. [View_EvaluatePartialReport][VEPR]
  6. [View_RateReport][VRRT]

[VASN]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/professor/View_ActivitySection.png "`View_ActivitySection` Prototype"
[VAAY]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/professor/View_AddActivity.png "`View_AddActivity` Prototype"
[VEES]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/professor/View_EvaluateEvidenceSection.png "`View_EvaluateEvidenceSection` Prototype"
[VEMR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/professor/View_EvaluateMonthlyReport.png "`View_EvaluateMonthlyReport` Prototype"
[VEPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/professor/View_EvaluatePartialReport.png "`View_EvaluatePartialReport` Prototype"
[VRRT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/professor/View_RateReport.png "`View_RateReport` Prototype"

### Prototipos: Practicante
  1. [View_PractitionerHome][VPHO]
  2. [View_GenerateDocumentation][VGDN]
  3. [View_GeneratePartialReport][VGPR]
  4. [View_GenerateMonthlyReport][VGMR]
  5. [View_ProjectInformation][VPIN]
  6. [View_ProjectRequest][VPRQ]
  7. [View_ProjectSection][VPSC]
  8. [View_UploadDocumentation][VUDC]
  9. [View_SelfAppraisal][VSAP]
  10. [View_UploadActivity][VUPA]

[VPHO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_PractitionerHome.png "`View_PractitionerHome` Prototype"
[VGDN]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_GenerateDocumentation.png "`View_GenerateDocumentation` Prototype"
[VGPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_GeneratePartialReport.png "`View_GeneratePartialReport` Prototype"
[VGMR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_GenerateMonthlyReport.png "`View_GenerateMonthlyReport` Prototype"
[VPIN]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_ProjectInformation.png "`View_ProjectInformation` Prototype"
[VPRQ]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_ProjectRequest.png "`View_ProjectRequest` Prototype"
[VPSC]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_ProjectSection.png "`View_ProjectSection` Prototype"
[VUDC]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_UploadDocumentation.png "`View_UploadDocumentation` Prototype"
[VSAP]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_SelfAppraisal.png "`View_SelfAppraisal` Prototype"
[VUPA]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_UploadActivity.png "`View_UploadActivity` Prototype"

### Prototipos comunes
  1. [Dialog_Confirmation][DLCO]
  2. [Dialog_ConnectionError][DLCE]
  3. [Dialog_Error][DLER]
  4. [Dialog_MaxReached][DLMR]
  5. [Dialog_Success][DLSU]
  6. [Dialog_InvalidInformation][DLII]
  7. [View_UploadDocument][VUDT]
  8. [Dialog_Information][DLI]
  9. [Dialog_EmptyTextBox][DLEB]
  10. [Dialog_NoOptionSelected][DLNS]
  11. [Dialog_Warning][DLWA]
  12. [View_LogIn][VLGI]

[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"
[DLMR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_MaxReached.png "`Dialog_MaxReached` Prototype"
[DLII]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_InvalidInformation.png "`Dialog_InvalidInformation` Prototype"
[DLER]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Error.png "`Dialog_Error` Prototype"
[VUDT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/View_UploadDocument.png "`View_UploadDocument` Prototype"
[DLI]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Information.png "`Dialog_Information` Prototype"
[DLEB]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_EmptyTextBox.png "`Dialog_EmptyTextBox` Prototype"
[DLNS]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_NoOptionSelected.png "`Dialog_NoOptionSelected` Prototype"
[DLWA]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Warning.png "`Dialog_Warning` Prototype"
[VLGI]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/View_LogIn.png "`View_LogIn` Prototype"


## 5. Conclusiones
En resumen, lo presentado en esta *Especificación de Diseño* fue una breve descripción de la situación actual sobre el proceso de prácticas profesionales, los [diagramas de casos de uso](#diagramas-de-casos-de-uso-por-paquetes) y algunas [descripciones](#descripción-de-casos-de-uso) de estos, ya que tomamos algunos que consideramos relevantes para esta versión, además de sus respectivos [diagramas de actividad](#diagramas-de-actividades-por-caso-de-uso). Todo esto fue mostrado con la finalidad de dar a entender o, por lo menos, generar una pequeña idea de como será el funcionamiento del sistema y explicar el por qué sería conveniente su realización, pues, como se mencionó anteriormente en la [introducción](#introducción), el sistema permitirá un desarrollo eficaz y rápido del proceso al automatizarlo mediante el uso de Software.