# ms-gestion-bootcoin
Aplicativo modular que gestiona los microservicios de solicitud y compra de BootCoin

- ms-solicitud-bootcoin es el productor del mensaje de solicitud de compra BootCoin
- ms-compra-bootcoin es el consumidor del mensaje de solicitud que valida y genera la transaccion de compra BootCoin
- Considera que se debera crear el topico "solicitud-bootcoin-topic" para su funcionamiento
