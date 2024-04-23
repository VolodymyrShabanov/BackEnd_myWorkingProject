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
        d) количества запчастей;
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
        c) элемент заказа:
            - всех;
            - по ID элемент заказа;
            - по ID запчасти;
            - по ID заказа;
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
            List<OrderItem> orderItemList;
            LocalDateTime createDate;
            LocalDateTime lastUpdate;
            OrderStatus status;
            String description;   

    3. SparePart (запчасти):
            Integer idSparePart;
            String name;
            String description;
            Integer quantity;
    
    4. OrderItem(элемент заказа)
            Integer idOrderItem
            Integer quantity;
            SparePart sparePart;
            MyOrder myOrder;

    5. OrderStatus (статусы заказа):
                CREATED,
                OPEN,
                COMPLETED,
                CLOSE,
                DELETE

### Репозитории:
    1. AutoRepository
    2. OrderRepository
    3. SparePartRepository
    4. MyOrderItemRepository

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
        "idAuto" : "1",
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
        "idAuto" : "3",
        "description" : "Описание"
      }
      ```
  - Response: MyOrderResponseDto
      ```
      {
        "idOrder" : "1",
        "idAuto" : "3",
        "LocalDateTime" : "yy-MM-ddT00:00:00",
        "LocalDateTime" : "YY-MM-ddT00:00:00",
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
        "quantity" : "10"
        "description" : "Описание"
      }
      ```
  - Response: SparePartResponseDto
      ```
      {
        "idSparePart" : "1",
        "name" : "SparePart1",
        "quantity" : "10"
        "description" : "Описание"
      }
      ```

*d) элемент заказа;*
   - method POST
   - URL: api/orderItems/createOrderItem
   - Request: MyOrderItemRequestDto
       ```
       {
         "idSparePart" : "5",
         "idMyOrder" : "3"
         "quantity" : "29"
       }
       ```
   - Response: MyOrderItemResponseDto
       ```
       {
         "idMyOrderItem" : "1",
         "idSparePart" : "5",
         "idMyOrder" : "3",
         "quantity" : "29"
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
        "orderItemsList" :
        {
          {
            "idSparePart" : "2",
            "nameSparePart": "Тормозные колодки передние",
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
        "quantity" : "10"
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
        "quantity" : "10"
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
        "quantity" : "10"
        "description" : "Описание"
      },
      ...
      ```

*c) элемент заказа:*
- всех;
    - method GET
    - URL: /api/orderItems
    - Request:
    - Response: MyOrderItemResponseDto
      ```
      {
        "idOrderItem" : "1",
        "idSparePart" : "5",
        "idOrder" : "3"
        "quantity" : "10"
        "
      },
      ...
      ```
  - по ID элемент заказа;
      - method GET
      - URL: /api/orderItems/{idOrderItem}
      - Request:
        ```
        {
          "idOrderItem" : "10"
        }
        ```
      - Response: SparePartResponseDto
      ```
      {
        "idOrderItem" : "10",
        "idSparePart" : "5",
        "idOrder" : "3"
        "quantity" : "10"
        "
      },
      ...
      ```
    
- по ID запчасти;
    - method GET
    - URL: /api/orderItems/idSparePart:{idSparePart}
    - Request:
      ```
      {
        "idSparePart" : "3"
      }
      ```
    - Response: SparePartResponseDto
      ```
      {
        "idOrderItem" : "1",
        "idSparePart" : "3",
        "idOrder" : "3"
        "quantity" : "10"
        "
      },
      ...
      ```
- по ID заказа;
    - method GET
    - URL: /api/myOrders/orderItems/idOrder:{idOrder}
    - Request:
      ```
      {
        "idOrder" : "5"
      }
      ```
    - Response: SparePartResponseDto
      ```
      {
        "idOrderItem" : "1",
        "idSparePart" : "3",
        "idOrder" : "5"
        "quantity" : "3"
        "
      },
      ...
      ```
         
**3. Редактирование:**
*a) автомобиля:*
   - бренда и/или модели;
      - method POST
      - URL: api/autos/ -> updateAuto
      - Request: AutoRequestDto
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