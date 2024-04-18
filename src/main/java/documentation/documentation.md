# Приложение СТО.
*Это приложение предоставляет функции создания, редактирования, поиска и удаления заказа по ремонту автомобиля.   
Заказ содержит информацию об автомобиле поступившем на обслуживание, 
а так же перечне запчастей необходимыж для осуществления ремонта, 
статусе и таймингах заказа.  
Приложение взаомодействует с пользователем через REST API, возвращая ответы в формате JSON.*

### Функционал:
    1. Создание:
        a) автомобиля;
        b) заказа;
        c) запчасти;
    2. Поиск:
        a) автомобиля:
            - всех;
            - по ID Auto;
            - по VIN номеру;
            - по бренду;
            - по модели;
        b) заказа:
            - всех;
            - по ID заказа;
            - по ID Auto;
            - по дате создания: на дату;
            - по дате создания: за период;
            - по статусу;
        b) запчасти:
            - всех;
            - по ID запчасти;
            - по названию;
    3. Редактирование:
        a) автомобиля:
            - бренда;
            - модели;
        b) заказа: 
            - добавление запчастей по ID запчасти;
            - удаление запчастей по ID запчасти;
            - изменение количества запчастей по ID;
            - именение описания;
            - изменение статуса;
        с) запчасти:
            - названия;
            - описание;
            - количества;
    4. Удаление: - ??????
        - автомобиля;
        - заказа;
        - запчасти;

### Описание сущностей:
    1. Auto (автомобиль):
            Integer idAuto;
            String vinNumber;
            String brand;
            String model;
            List<Order> orders;

    2. Order (заказ):
            Integer idOrder;
            Auto auto;
            Map<SparePart, Integer> spareParts;
            LocalDateTime createDate;
            LocalDateTime lastUpdate;
            OrderStatus status;
            String description;   

    3. SparePart (запчасти):
            Integer idSparePart;
            String name;
            String description;
    
    4. Warehouse(склад):
            Integer idWarehouse;
            String name;
            Map<SparePart, Integer> spareParts;

    4. OrderStatus (статусы заказа):
                CREATED,
                OPEN,
                COMPLETED,
                CLOSE,
                DELETE

### Репозитории:
    1. AutoRepository
    2. OrderRepository
    3. SparePartRepository

### Описание REST API:
**1. Создание:**  

*a) автомобиля;*  
  - method POST
  - URL: api/autos/createAuto
  - Request: AutoRequestDto
      ```
      {
        "vinNumber" : "VIN1234",
        "brand" : "brand1",
        "model" : "model1"
      }
      ```
  
  - Response: AutoResponseDto
      ```
      {
        "idAuto" : "idAuto1",
        "vinNumber" : "VIN1234",
        "brand" : "brand1",
        "model" : "model1"
      }
      ```
*b) заказа;*
  - method POST
  - URL: api/orders/createOrder
  - Request: MyOrderRequestDto
      ```
      {
        "idAuto" : "idAuto1",
        "description" : "Описание"
      }
      ```
  - Response: MyOrderResponseDto
      ```
      {
        "idOrder" : "idOrder1",
        "idAuto" : "idAuto1",
        "LocalDateTime" : "Дата создания",
        "LocalDateTime" : "Дата последнего обновления",
        "OrderStatus" : "CREATED",
        "description" : "Описание"
      }
      ```
*b) запчасти;*
  - method POST
  - URL: api/spareParts/ -> createSparePart
  - Request: SparePartRequestDto
      ```
      {
        "name" : "SparePart1",
        "description" : "Описание"
      }
      ```
  - Response: SparePartResponseDto
      ```
      {
        "idSparePart" : "idSparePart1",
        "name" : "SparePart1",
        "description" : "Описание"
      }
      ```

**2.Поиск:**  
*a) автомобиля:*
   - всех;
     - method GET
     - URL: /api/autos
     - Request: 
     - Response: AutoResponseDto
      ```
      {
        "idAuto" : "idAuto1",
        "vinNumber" : "VIN1234",
        "brand" : "brand1",
        "model" : "model1"
      },
      ...
      ```
   - по ID Auto;
     - method GET
     - URL: /api/autos/{idAuto}
     - Request:
      ```
      {
        "idAuto" : "idAuto1"
      }
      ```
     - Response: AutoByIdResponseDto
      ```
      {
        "idAuto" : "idAuto1",
        "vinNumber" : "VIN1234",
        "brand" : "brand1",
        "model" : "model1"
        "idOrders" :
          {
            {
              "idOrder" : "idOrder1",
              "LocalDateTime" : "Дата последнего обновления",
              "OrderStatus" : "CREATED"
            },
            ....    
          }
      }
      ```
 
   - по VIN номеру;
     - method GET
     - URL: /api/autos?vinNumber=...
     - Param: vinNumber;
     - Request:
      ```
      {
        "vinNumber" : "VIN1234",
      }
      ```
     - Response: AutoResponseDto
      ```
      {
        "idAuto" : "idAuto1",
        "vinNumber" : "VIN1234",
        "brand" : "brand1",
        "model" : "model1"
      }

   - по бренду;
     - method GET
     - URL: /api/autos?brand=...
     - Param: brand;
     - Request:
      ```
      {
        "brand" : "brand1",
      }
      ```
     - Response: AutoResponseDto
      ```
      {
        "idAuto" : "idAuto1",
        "vinNumber" : "VIN1234",
        "brand" : "brand1",
        "model" : "model1"
      },
      ...
      ```
   - по модели;
     - method GET
     - URL: /api/autos?model=...
     - Param: model;
     - Request:
      ```
      {
        "model" : "model1",
      }
      ```
     - Response: AutoResponseDto
     ```
     {
       "idAuto" : "idAuto1",
       "vinNumber" : "VIN1234",
       "brand" : "brand1",
       "model" : "model1"
     },
     ...
      ```

*b) заказа:*
  - всех;
     - method GET
     - URL: /api/orders
     - Request:
     - Response: MyOrderResponseDto
      ```
      {
        "idOrder" : "idOrder1",
        "idAuto" : "idAuto1",
        "LocalDateTime" : "Дата создания",
        "LocalDateTime" : "Дата последнего обновления",
        "OrderStatus" : "CREATED",
        "description" : "Описание"
      },
      ...
      ```
  - по ID заказа;
    - method GET
    - URL: /api/orders/{idOrder}
    - Request:
      ```
      {
        "idOrder" : "idOrder1"
      }
      ```
    - Response: MyOrderByIdResponseDto
      ```
      {
        "idOrder" : "idOrder1",
        "idAuto" : "idAuto1",
        "idSpareParts" :
        {
          {
            "idSparePart" : "idSparePart1",
            "quantity" : "1"
          }
          ....
        },
        "LocalDateTime" : "Дата создания",
        "LocalDateTime" : "Дата последнего обновления",
        "OrderStatus" : "CREATED",
        "description" : "Описание"
      }
      ```

  - по ID Auto;
    - method GET
    - URL: /api/orders/idAutos/{idAuto}
    - Request:
      ```
      {
        "idAuto" : "idAuto"
      }
      ```
    - Response: MyOrderResponseDto
      ```
      {
        "idOrder" : "idOrder1",
        "idAuto" : "idAuto1",
        "LocalDateTime" : "Дата создания",
        "LocalDateTime" : "Дата последнего обновления",
        "OrderStatus" : "CREATED",
        "description" : "Описание"
      }
      ```

  - по дате создания: на дату;
    - method GET
    - URL: /api/orders?createDate=...
    - Param: createDate;
    - Request:
      ```
      {
        "createDate" : "2024-04-11"
      }
      ```
    - Response: MyOrderResponseDto
      ```
      {
        "idOrder" : "idOrder1",
        "idAuto" : "idAuto1",
        "LocalDateTime" : "2024-04-11",
        "LocalDateTime" : "Дата последнего обновления",
        "OrderStatus" : "CREATED",
        "description" : "Описание"
      }
      
 - по дате создания: за период; 
     - method GET
     - URL: /api/orders?createDateFrom=...&createDateTo=....
     - Param: createDateFrom, createDateTo;
     - Request:
       ```
       {
         "createDateFrom" : "2024-04-11",
         "createDateTo" : "2024-04-15"
       }
       ```
     - Response: MyOrderResponseDto
       ```
       {
         "idOrder" : "idOrder1",
         "idAuto" : "idAuto1",
         "LocalDateTime" : "2024-04-11",
         "LocalDateTime" : "Дата последнего обновления",
         "OrderStatus" : "CREATED",
         "description" : "Описание"
       }

 - по статусу;
   - method GET
   - URL: /api/orders?status=...
   - Param: status;
   - Request:
      ```
      {
        "status" : "OPEN"
      }
      ```

   - Response: MyOrderResponseDto
      ```
       {
         "idOrder" : "idOrder1",
         "idAuto" : "idAuto1",
         "LocalDateTime" : "Дата создания",
         "LocalDateTime" : "Дата последнего обновления",
         "OrderStatus" : "OPEN",
         "description" : "Описание"
       }
      ```
*b) запчасти:*
  - всех;
    - method GET
    - URL: /api/spareParts
    - Request:
    - Response: SparePartResponseDto
      ```
      {
        "idSparePart" : "idSparePart1",
        "name" : "SparePart1",
        "quantity" : "1";
        "description" : "Описание"
      },
      ...
      ```

  - по ID запчасти;
    - method GET
    - URL: /api/spareParts/{idSparePart}
    - Request:
      ```
      {
        "idSparePart" : "idSparePart1"
      }
      ```
    - Response: SparePartResponseDto
      ```
      {
        "idSparePart" : "idSparePart1",
        "name" : "SparePart1",
        "quantity" : "1";
        "description" : "Описание"
      },
      ```
  - по названию;
    - method GET
    - URL: /api/spareParts?name=...
    - Param: name;
    - Request:
      ```
      {
        "name" : "SparePart1"
      }

    - Response: SparePartResponseDto
      ```
      {
        "idSparePart" : "idSparePart1",
        "name" : "SparePart1",
        "quantity" : "1";
        "description" : "Описание"
      },
      ...
      ```
      
**3. Редактирование:**
*a) автомобиля:*
   - бренда и/или модели;
      - method POST
      - URL: api/autos/ -> updateAuto
      - Request: AutoUpdateRequestDto
      ```
      {
        "brand" : "brand2",
        "model" : "model2"
      }
      ```
      - Response: AutoResponseDto
      ```
      {
        "idAuto" : "idAuto1",
        "vinNumber" : "VIN1234",
        "brand" : "brand2",
        "model" : "model2"
      }
      ```
*b) заказа:*
   - изменение (добавление, увеличение, уменьшение) количества запчастей по ID;
       - method POST
       - URL: /api/orders?idSparePart=...&quantity=...,
       - Params: idSparePart, quantity
       - Request:
      ```
      {
        "idSparePart" : "idSparePart3",
        "quantity" : "12"
      }
      ```
       - Response: MyOrderByIdResponseDto
      ```
      {
        "idOrder" : "idOrder1",
        "idAuto" : "idAuto1",
        "idSpareParts" :
          {
          ...
            {
              "idSparePart" : "idSparePart3", - add
              "quantity" : "12";
            },
          ...
          },
        "LocalDateTime" : "Дата создания",
        "LocalDateTime" : "Дата последнего обновления", - current date
        "OrderStatus" : "CREATED",
        "description" : "Описание"
      }
      ```
   - удаление запчастей по ID запчасти;
       - method POST
       - URL: /api/orders?idSparePart=...,
       - Params: idSparePart
       - Request:
      ```
      {
        "idSparePart" : "idSparePart3",
      }
      ```
   - Response: MyOrderByIdResponseDto
      ```
      {
        "idOrder" : "idOrder1",
        "idAuto" : "idAuto1",
        "idSpareParts" :
          {
            {
              "idSparePart" : "idSparePart2",
              "quantity" : "1";
            },
            ....  - delete
            {
              "idSparePart" : "idSparePart4",
              "quantity" : "1";
            },
          },
        "LocalDateTime" : "Дата создания",
        "LocalDateTime" : "Дата последнего обновления", - current date
        "OrderStatus" : "CREATED"
        "description" : "Описание"
      }
      ```
   - именение описания и/или статуса;
       - method POST
       - URL: /api/orders?status=...&description=...,
       - Params: status, idSparePart
       - Request:
      ```
      {
        "status" : "COMPLETED"
        "description" : "new Описание"
      }
      ```
   - Response: MyOrderResponseDto
      ```   
      {
        "idOrder" : "idOrder1",
        "idAuto" : "idAuto1",
        "LocalDateTime" : "Дата создания",
        "LocalDateTime" : "Дата последнего обновления", - current date
        "OrderStatus" : "COMPLETED"
        "description" : "new Описание"
      }
      ```
*с) запчасти:*
   - названия и/или описание
      - method POST
      - URL: api/spareParts/ -> updateSparePart
      - Request: SparePartUpdateRequestDto
      ```
      {
        "name" : "SparePart2",
        "description" : "new Описание"
      }
      ```
      - Response: SparePartResponseDto
      ```
      {
        "idSparePart" : "idSparePart1",
        "name" : "SparePart2",
        "description" : "new Описание"
      }
      ```