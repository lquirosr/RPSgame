<<<<<<< HEAD
# Solucion al Apps GD Costa Rica – Challenge

Luis Quirós Rojas
Se selección el lenguaje JAVA para la implementación: Es un lenguaje que manejo y me gusta.
Se seleccionó el framework PLAY por ser de rápido desarrollo y ya lo había probado antes.
Se seleccionó hostearlo en heroku pues lo he usado muchas veces y soporta JAVA


System live at:

http://stark-gorge-1645.herokuapp.com/


El sistema cuenta con una pagina principal donde se puede cargar una partida desde un form para subir un archivo de la forma:


[ 
 [ 
 [ ["Armando", "P"], ["Dave", "S"] ], 
 [ ["Richard", "R"], ["Michael", "S"] ] 
 ], 
 [ 
 [ ["Allen", "S"], ["Omer", "P"] ], 
 [ ["John", "R"], ["Robert", "P"] ] 
 ] 
] 



Se cuenta con una pestaña donde se pueden cargar las partidas presalvadas. En la parte inferior se muestra el resultado luego de que un campeonato es ejecutado.

Las partidas presalvadas están almacenadas en dropbox. La partida que se sube no se almacena, sólo se ejecuta y se aplica el resultado del ganador a la base de datos.

El sistema cuenta con un botón para limpiar la base de datos.

El sistema cuenta con un link para ver el ranking de los mejores 10 jugadores, permite eliminar cualquiera del ranking, tiene un boton para ello.

La clase Algorit implementa la solución a los algoritmos propuestos, y se detalla su locación en comentarios.


API (Commands 1 & 3)


API 1
http://stark-gorge-1645.herokuapp.com/api/championship/result/first=Dave&second=Armando

API 3

http://stark-gorge-1645.herokuapp.com/api/championship/new/data=[["Armando","P"],["Al","S"]]

=======
RPSgame
=======

Rock Paper Scissors game
>>>>>>> 249218c9c3d50c38d462f00c886faf08fe1ac843
