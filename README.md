Se realiza el parcial basados en esta HU
Como gestor de inventario deseo autenticarme para restringir la manipulación de la maquina

Descripción:

La máquina a la fecha no dispone de un mecanismo de autenticación para las tareas de administración. Por tal motivo, se requiere restringir las funcionalidades adicionar inventario y gestionar las monedas de pago.

Criterios de aceptación:

    Métodos de autenticación

Dado que requiero diferentes alternativas de autenticación

Cuando vaya a loguearme

Entonces el sistema debe brindarme 3 alternativas: con usuario contraseña, con pin o con redes sociales.

 

    Autenticación sin implementada

Dado que es la versión inicial

Cuando escoja las opciones de autenticación de Pin o redes sociales

Entonces el sistema debe indicarme que no están implementadas aún

 

    Autenticación con usuario- contraseña

Dado que debo realizar la gestión de inventarios

Cuando ingrese usuario y contraseña correctos

Entonces el sistema debe mostrarme las opciones restringidas (gestionar inventario, gestionar monedas o billetes)

 

    Bloqueo del usuario

Dado que se requiere un mecanismo anti bots

Cuando el usuario ingrese 3 veces la contraseña y/o usuario incorrecto

Entonces el sistema debe bloquear al usuario mostrando el mensaje: “usuario bloqueado. Contacte al administrador”

 

    Funcionalidades sin restricción

Dado que requiero funcionalidades sin restricción

Cuando Acceda a la maquina en condiciones iniciales

Entonces el sistema debe permitir utilizar funcionalidades sin restricción como consultar los productos

![1](https://github.com/sebasjv534/parcial-primer-corte-csw-team5/assets/147444416/00f8a001-a841-44b0-8bf8-8a84a4a16a5b)
![2](https://github.com/sebasjv534/parcial-primer-corte-csw-team5/assets/147444416/7d054505-6faf-4e6e-b603-e32e83702c19)
![3](https://github.com/sebasjv534/parcial-primer-corte-csw-team5/assets/147444416/11cbe28f-edd2-482f-b3e9-81c46bf3083e)
