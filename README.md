# Juego Conecta4  

## Alumnos

Manuel Lorente Almán  
Juan Ángel Garrido Lupiañez  
  
## Evaluacion  

1. Conocer - conoces cosas que no conocias -> 1.5/2.5p  
2. Comprender - comprendes los conceptos (patrones, conocimiento, software) -> 2.5/2.5p  
3. Reconocer - leyendo el tictactoe identificas los conceptos enseñados en teoría -> 1/2.5p  
4. Sintetizar - Lo que yo creo que valdria la practica -> 2/2.5p  

## Justificación de la evaulación  

### Jerarquía y patrones  

Se ha pretendido implementar un modelo del dominio del juego (tras ver el vídeo explicativo), de manera que la implementación del software imite en la medida de lo posible la implementación
de la realidad, por ejemplo a la hora de elegir los tipos de datos, prueba de ello es que el tablero se compone como una matriz bidimensional de colores, tal y como un usuario lo visualizaría en la versión física del juego.  
Se ha decidido implementar un diseño orientado a objetos. Este diseño está compuesto por relaciones entre datos siguiendo un patrón circular: con ciclos de dependencias y relaciones entre clases. Estas relaciones, consisten en composiciones de carácter entre las clases Player, Board, Turn y ConnectFour, ya que ninguna de estas clases podría existir sin el resto. Por ejemplo, este es el caso del Board que está compuesto por las clases Player y Turn.  

### Abstracción  

No se han implementado clases abstractas por la simplicidad del juego. Lo que si se ha tratado es de aplicar abstracción entre el transcurso general del juego por parte del Board, gestionar cuando acaba la partida o se comienza una nueva, y el propio transcurso del juego que es gestionado por las clases Player y Turn.  

### Encapsulación  

Por otra parte, lo que sí se ha aplicado es el concepto de encapsulación, de manera que todas las variables y métodos son únicamente visibles en su  ámbito de uso. Además, el acceso a los datos siempre se hace a través de métodos y no accediendo directamente a su valor.  
  
### Modularización  

Consecuentemente a todo lo anterior, se ha hecho un diseño lo modular y poco cohesionado, tratando de hacer las clases lo más sencilla posibles con las relaciones estrictamente necesarias entre clases para así reducir su acoplamiento. De ahí que la gestión del transcurso del juego lo ejerza la  clase Board, pero la del turno de juego esté gestionada por las clases Player y Turn.  
  
### Sencillez  

Por último, durante todo el ciclo de diseño se ha apostado por la sencillez para que el código sea lo más mantenible posible (principio KISS), sustituyendo los comentarios en el código por funciones autoexplicativas con nombres autodescriptivos y agrupando atributos y métodos por ámbito de aplicación y orden de aparición. De esta manera se permite comprender el código con una lectura lineal de cada clase.
