;Utilizamos Modern UI 
!include "MUI2.nsh" 
;Estructura General

Name "Ejemplo de creación de instalador" ;Título del instalador
OutFile "Demo.exe" ; Fichero que vamos a generar y utilizar como instalador
Unicode True
InstallDir "$PROGRAMFILES\Demo" ;Carpeta donde se instalará la aplicación por defecto 
InstallDirRegKey HKCU "Software\Demo" "" ;Definimos la clave en el registro
RequestExecutionlevel user ;Privilegios para el instalador. Admite los valores user o admin. 
!define MUI_ABORTWARNING

;Definimos las Paginas o ventanas 
!insertmacro MUI_PAGE_COMPONENTS
!insertmacro MUI_PAGE_DIRECTORY
!insertmacro MUI_PAGE_INSTFILES
!insertmacro MUI_UNPAGE_CONFIRM 
!insertmacro MUI_UNPAGE_INSTFILES 
;Configuramos el idioma del instalador
!insertmacro MUI_LANGUAGE "Spanish"


;Definimos el componente que se va a poder señalar para instalar 
Section "Fichero jar" SecDummy
SetOutPath "$INSTDIR"
File demo\Demo.jar 
SetOutPath $INSTDIR\lib ;Creamos la carpeta lib en el directorio en donde se va a instalar la aplicación.
File demo\lib\Clock.jar ;copiamos el contenido 
;Guardar el directorio de instalación
WriteRegStr HKCU "Software\Demo" "" $INSTDIR
;Creamos el desinstalador 
WriteUninstaller "$INSTDIR\Uninstall.exe" ;Definimos la opción de desinstalar
SectionEnd

;Descripciones que aparecerán junto al componente cuando se seleccione. Aparece junto al componente.
;Language strings
LangString DESC_SecDummy ${LANG_SPANISH} "Instalación del fichero Demo.jar"
!insertmacro MUI_FUNCTION_DESCRIPTION_BEGIN
!insertmacro MUI_DESCRIPTION_TEXT ${SecDummy} $(DESC_SecDummy)
!insertmacro MUI_FUNCTION_DESCRIPTION_END
;Definimos la sección para desinstalar.
Section "Desinstalar"
Delete "$INSTDIR\Uninstall.exe"
RMDir "$INSTDIR"
DeleteRegKey /ifempty HKCU "Software\Demo"
SectionEnd

