---
layout: page
title: Especificación de Diseño
permalink: /design-specification/
toc: true
---

## Datos escorlares
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
Equipo 2(TMNT).(2019).*Especificación de Requerimientos de Software para Sistema web para las Prácticas Profesionales (Versión 0.3 propuesta).*Universidad Veracruzana, Xalapa, Veracruz.

### Situación actual
Los proceso de la EE Prácticas Profesionales, como la entrega de documentos por parte de los alumnos toman mucho tiempo y pueden ser entorpecidos. Algunas actividades que el Coordinador de la EE realiza son exhaustivas y, en promedio, se pierden hasta dos días por corregir errores inesperados. Estas situaciones llevan a la necesidad de un nuevo sistema con el cual se puedan gestionar los datos y proceso adecuadamente y, de esta manera, facilitarlos.

**Clases de usuario y características**  
**Administrador**  
Un *Administrador* se encarga de registrar y llevar el control de *Coordinadores* y *Profesores*, así mismo tiene la capacidad de darlos de baja y poder mantener un historial para consultas posteriores.

**Coordinador**  
Un *Coordinador* es aquel que se encarga de registrar a los practicantes así como de las asignaciones de proyectos. La persona que lleve a cabo este rol debe tener conocimiento de del estado de los practicantes y profesores, además de la capacidad de generar reportes de indicadores basados en las estadísticas de los usuarios del sistema.

**Profesor**  
Un *Profesor* se encarga de evalúar al grupo de practicantes asiganados a él, así como de generar actividades para estos.

**Practicante**  
Un *Practicante* es quien accede al Sistema para consultar información que le concierna, actividades pendientes, realizar reportes, entregar documentos, consultar fechas importantes, entre otras funcionalidades.

**Usuario**  
Un *Usuario* es aquel que tiene una cuenta activa en el *SPP*.

## 2. Definición de Requerimientos
### 2.1. Diagrama de paquetes de Casos de Uso
![Paquetes de Casos de Uso][PCU]

[PCU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/packages/packages.PNG

### 2.2. Diagramas de Casos de Uso por paquetes
  1. [CU del Usuario][CUU] 
  2. [CU del Administrador][CUA]
  3. [CU del Coordinador][CUC]
  4. [CU del Profesor][CUP]
  5. [CU del Practicante][CUS]

[CUA]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/packages/administratorpackage.png "Paquete Administrador"
[CUC]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/packages/coordinatorpackage.png "Paquete Coordinador"
[CUP]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/packages/professorpackage.PNG "Paquete Profesor"
[CUS]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/packages/practitionerpackage.png "Paquete Practicante"
[CUU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/packages/userpackage.png "Paquete Usuario"

### 2.3. Descripción de Casos de Uso
#### Descripción: Administrador
  1. [CU-A-: Registrar Coordinador][RECO]
  2. [CU-A-: Registrar Profesor][REPS]
  3. [CU-A-: Eliminar Coordinador][ELCO]
  4. [CU-A-: Eliminar Profesor][ELPR]

[RECO]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/administrator/cu-a-1/ "Descripción de CU-A-1"
[REPS]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/administrator/cu-a-2/ "Descripción de CU-A-2"
[ELCO]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/administrator/cu-a-3/ "Descripción de CU-A-3"
[ELPR]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/administrator/cu-a-4/ "Descripción de CU-A-4"

#### Descripción: Coordinador
  1. [CU-C-: Registrar Proyecto][REPR]
  2. [CU-C-: Asignar Proyecto][ASPR]
  3. [CU-C-: Eliminar Proyecto][ELPO]
  4. [CU-C-: Eliminar Practicante][ELPE]
  5. [CU-C-: Generar Reporte de Indicadores][GRDI]
  6. [CU-C-: Registrar Practicante][REPE]
  7. [CU-C-: Actualizar Proyecto][ACPO]

[REPR]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/coordinator/cu-c-1/ "Descripción de CU-C-1"
[ASPR]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/coordinator/cu-c-2/ "Descripción de CU-C-2"
[ELPO]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/coordinator/cu-c-3/ "Descripción de CU-C-3"
[ELPE]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/coordinator/cu-c-4/ "Descripción de CU-C-4"
[GRDI]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/coordinator/cu-c-5/ "Descripción de CU-C-5"
[REPE]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/coordinator/cu-c-6/ "Descripción de CU-C-6"
[ACPO]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/coordinator/cu-c-7/ "Descripción de CU-C-7"

#### Descripción: Profesor
  1. [CU-PF-: Generar Actividad][GEAC]
  2. [CU-PF-: Añadir Formato de Presentación][AFPR]
  3. [CU-PF-: Evaluar Reporte Parcial][ERPA]
  4. [CU-PF-: Evaluar Reporte Mensual][ERME]

[GEAC]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/professor/cu-pf-1/ "Descripción de CU-PF-1"
[AFPR]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/professor/cu-pf-2/ "Descripción de CU-PF-2"
[ERPA]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/professor/cu-pf-3/ "Descripción de CU-PF-3"
[ERME]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/professor/cu-pf-4/ "Descripción de CU-PF-4"

#### Descripción: Practicante
  1. [CU-PR-: Solicitar Proyecto][SOPR]
  2. [CU-PR-: Añadir Horario][ANHO]
  3. [CU-PR-: Generar Reporte Parcial][GRPA]
  4. [CU-PR-: Añadir Reporte Parcial][ARPA]
  5. [CU-PR-: Generar Reporte Mensual][GRME]
  6. [CU-PR-: Añadir Reporte Mensual][ARME]
  7. [CU-PR-: Generar Autoevaluación][GAUT]
  8. [CU-PR-: Añadir Autoevaluación][AAUT]
  9. [CU-PR-: Añadir Actividad][AACT]
  10. [CU-PR-: Añadir Bitácora Personal][APSP]
  11. [CU-PR-: Añadir Plan de Actividades][APAC]

[SOPR]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-1/ "Descripción de CU-PR-1"
[ANHO]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-2/ "Descripción de CU-PR-2"
[GRPA]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-3/ "Descripción de CU-PR-3"
[ARPA]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-4/ "Descripción de CU-PR-4"
[GRME]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-5/ "Descripción de CU-PR-5"
[ARME]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-6/ "Descripción de CU-PR-6"
[GAUT]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-7/ "Descripción de CU-PR-7"
[AAUT]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-8/ "Descripción de CU-PR-8"
[AACT]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-9/ "Descripción de CU-PR-9"
[APSP]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-10/ "Descripción de CU-PR-10"
[APAC]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-11/ "Descripción de CU-PR-11"

#### Descripción: Usuario
  1. [CU-U-: Consultar Buzón][COBU]
  2. [CU-U-: EnviarMensaje][ENME]

[COBU]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/user/cu-u-1/ "Descripción de CU-U-1"
[ENME]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/user/cu-u-2/ "Descripción de CU-U-2"

### 2.4. Diagramas de Actividades por Caso de Uso
#### Actividad: Administrador
  1. [CU-A-: Registrar Coordinador][ARECO]
  2. [CU-A-: Registrar Profesor][AREPS]
  3. [CU-A-: Eliminar Coordinador][AELCO]
  4. [CU-A-: Eliminar Profesor][AELPR]

[ARECO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/administrator/act1.jpg "Registrar Coordinador"
[AREPS]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/administrator/act2.jpg "Registrar Profesor"
[AELCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/administrator/act3.jpg "Eliminar Coordinador"
[AELPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/administrator/act4.jpg "Eliminar Profesor"

#### Actividad: Coordinador
  1. [CU-C-: Registrar Proyecto][AREPR]
  2. [CU-C-: Asignar Proyecto][AASPR]
  3. [CU-C-: Eliminar Proyecto][AELPO]
  4. [CU-C-: Eliminar Practicante][AELPE]
  5. [CU-C-: Generar Reporte de Indicadores][AGRDI]
  6. [CU-C-: Registrar Practicante][AREPE]
  7. [CU-C-: Actualizar Proyecto][AACPO]

[AREPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/coordinator/act1.jpg "Registrar Proyecto"
[AASPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/coordinator/act2.png "Asignar Proyecto"
[AELPO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/coordinator/act3.jpg "Eliminar Proyecto"
[AELPE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/coordinator/act4.jpg "Eliminar Practicante"
[AGRDI]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/coordinator/act5.jpg "Generar Reporte de Indicadores"
[AREPE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/coordinator/act6.jpg "Registrar Practicante"
[AACPO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/coordinator/act7.jpg "Actualizar Proyecto"

#### Actividad: Profesor
  1. [CU-PF-: Generar Actividad][AGEAC]
  2. [CU-PF-: Añadir Formato de Presentación][AAFPR]
  3. [CU-PF-: Evaluar Reporte Parcial][AERPA]
  4. [CU-PF-: Evaluar Reporte Mensual][AERME]

[AGEAC]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/professor/act1.jpg "Generar Actividad"
[AAFPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/professor/act2.jpg "Añadir Formato de Presentación"
[AERPA]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/professor/act3.jpg "Evaluar Reporte Parcial"
[AERME]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/professor/act4.jpg "Evaluar Reporte Mensual"

#### Actividad: Practicante
  1. [CU-PR-: Solicitar Proyecto][ASOPR]
  2. [CU-PR-: Añadir Horario][AANHO]
  3. [CU-PR-: Generar Reporte Parcial][AGRPA]
  4. [CU-PR-: Añadir Reporte Parcial][AARPA]
  5. [CU-PR-: Generar Reporte Mensual][AGRME]
  6. [CU-PR-: Añadir Reporte Mensual][AARME]
  7. [CU-PR-: Generar Autoevaluación][AGAUT]
  8. [CU-PR-: Añadir Autoevaluación][AAAUT]
  9. [CU-PR-: Añadir Actividad][AAACT]
  10. [CU-PR-: Añadir Bitácora Personal][AAPSP]
  11. [CU-PR-: Añadir Plan de Actividades][AAPAC]

[ASOPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/practitioner/act1.png "Solicitar Proyecto"
[AANHO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/practitioner/act2.png "Añadir Horario"
[AGRPA]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/practitioner/act3.png "Generar Reporte Parcial"
[AARPA]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/practitioner/act4.png "Añadir Reporte Parcial"
[AGRME]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/practitioner/act5.jpg "Generar Reporte Mensual"
[AARME]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/practitioner/act6.png "Añadir Reporte Mensual"
[AGAUT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/practitioner/act7.jpg "Generar Autoevaluación"
[AAAUT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/practitioner/act8.png "Añadir Autoevaluación"
[AAACT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/practitioner/act9.png "Añadir Actividad"
[AAPSP]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/practitioner/act10.png "Añadir Bitácora Personal" 
[AAPAC]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/practitioner/act11.png "Añadir Plan de Actividades"

#### Actividad: Usuario
  1. [CU-U-: Consultar Buzón][ACOBU]
  2. [CU-U-: Enviar Mensaje][AENME]

[ACOBU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/user/act1.jpg "Consultar Buzón"
[AENME]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/activities/user/act2.jpg "Enviar Mensaje"

## 3. Diseño
### 3.1. Diagrama de Clases del Modelo de Dominio
![Modelo de Dominio][MDD]

[MDD]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/domain/domain_model.jpg

### 3.2. Diagramas de Robustez
  1. [CU-A-: ][ROB1]

[ROB1]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/robustness/coordinator/rob1.jpg

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
  7. [View_DeletePractitioner][VDPI]
  8. [View_IndicatorsReport][VIRP]
  9. [View_ChooseProject][VCPT]
  10. [Dialog_ProjectAlreadyAssigned][DLAA]

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

[VPHO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_PractitionerHome.png "`View_PractitionerHome` Prototype"
[VGDN]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_GenerateDocumentation.png "`View_GenerateDocumentation` Prototype"
[VGPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_GeneratePartialReport.png "`View_GeneratePartialReport` Prototype"
[VGMR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_GenerateMonthlyReport.png "`View_GenerateMonthlyReport` Prototype"
[VPIN]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_ProjectInformation.png "`View_ProjectInformation` Prototype"
[VPRQ]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_ProjectRequest.png "`View_ProjectRequest` Prototype"
[VPSC]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_ProjectSection.png "`View_ProjectSection` Prototype"
[VUDC]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_UploadDocumentation.png "`View_UploadDocumentation` Prototype"

### Prototipos: Usuario
  1. [View_MessageSection][VMSN]
  2. [View_NewMessage][VNMS]

[VMSN]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/user/View_MessageSection.png "`View_MessageSection` Prototype"
[VNMS]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/user/View_NewMessage.png "`View_NewMessage` Prototype"

### Prototipos comunes
  1. [Dialog_Confirmation][DLCO]
  2. [Dialog_ConnectionError][DLCE]
  3. [Dialog_Error][DLER]
  4. [Dialog_MaxReached][DLMR]
  5. [Dialog_Success][DLSU]
  6. [Dialog_InvalidInformation][DLII]
  7. [View_UploadDocument][VUDT]

[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"
[DLMR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_MaxReached.png "`Dialog_MaxReached` Prototype"
[DLII]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_InvalidInformation.png "`Dialog_InvalidInformation` Prototype"
[DLER]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Error.png "`Dialog_Error` Prototype"
[VUDT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/View_UploadDocument.png "`View_UploadDocument` Prototype"


## 5. Conclusiones
En resumen, lo presentado en esta *Especificación de Diseño* fue una breve descripción de la situación actual sobre el proceso de prácticas profesionales, los [diagramas de casos de uso](#diagramas-de-casos-de-uso-por-paquetes) y algunas [descripciones](#descripción-de-casos-de-uso) de estos, ya que tomamos algunos que consideramos relevantes para esta versión, además de sus respectivos [diagramas de actividad](#diagramas-de-actividades-por-caso-de-uso). Todo esto fue mostrado con la finalidad de dar a entender o, por lo menos, generar una pequeña idea de como será el funcionamiento del sistema y explicar el por qué sería conveniente su realización, pues, como se mencionó anteriormente en la [introducción](#introducción), el sistema permitirá un desarrollo eficaz y rápido del proceso al automatizarlo mediante el uso de Software.