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
            - именение описания;
            - изменение статуса;
        с) запчасти:
            - названия;
            - описание;
            - количества;
        e) элемент заказа:
            - изменение количества (увеличение, уменьшение) запчастей по ID элемента заказа;

    4. Удаление: - ??????
        - автомобиля;
        - заказа;
        - запчасти;
        - элемента заказа;

### Описание сущностей:
    1. Auto (автомобиль):
            Integer idAuto;
            String vinNumber;
            String brand;
            String model;
            List<MyOrder> myOrders;

    2. Order (заказ):
            Integer idMyOrder;
            Auto auto;
            List<MyOrderItem> MyOrderItemList;
            LocalDateTime createDate;
            LocalDateTime lastUpdate;
            OrderStatus status;
            String description;   

    3. SparePart (запчасти):
            Integer idSparePart;
            String name;
            String description;
            Integer quantity;
    
    4. MyOrderItem(элемент заказа)
            Integer idMyOrderItem
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
    2. MyOrderRepository
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
  - URL: api/myOrders/createMyOrder
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
        "idMyOrder" : "1",
        "idAuto" : "3",
        "LocalDateTime" : "yy-MM-ddT00:00:00",
        "LocalDateTime" : "YY-MM-ddT00:00:00",
        "OrderStatus" : "CREATED",
        "description" : "Описание"
      }
      ```
*b) запчасти;*
  - method POST
  - URL: api/spareParts/createSparePart
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
   - URL: api/myOrderItems/createMyOrderItem
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
     - PathVariable: idAuto
     - Request:
      ```
      {
        "idAuto" : "1"
      }
      ```
     - Response: AutoByIdResponseDto
      ```
      {
        "idAuto" : "1",
        "vinNumber" : "VIN1234",
        "brand" : "brand1",
        "model" : "model1"
        "idMyOrders" :
          {
            {
              "idMyOrder" : "1",
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
        "idAuto" : "1",
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
        "idAuto" : "1",
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
       "idAuto" : "1",
       "vinNumber" : "VIN1234",
       "brand" : "brand1",
       "model" : "model1"
     },
     ...
      ```

*b) заказа:*
  - всех;
     - method GET
     - URL: /api/MyOrders
     - Request:
     - Response: MyOrderResponseDto
      ```
      {
        "idMyOrder" : "1",
        "idAuto" : "3",
        "LocalDateTime" : "Дата создания",
        "LocalDateTime" : "Дата последнего обновления",
        "OrderStatus" : "CREATED",
        "description" : "Описание"
      },
      ...
      ```
  - по ID заказа;
    - method GET
    - URL: /api/MyOrders/{idMyOrder}
    - PathVariable: idMyOrder
    - Request:
      ```
      {
        "idMyOrder" : "2"
      }
      ```
    - Response: MyOrderByIdResponseDto
      ```
      {
        "idMyOrder" : "2",
        "idAuto" : "1",
        "MyOrderItemsList" :
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
    - URL: /api/MyOrders/idAutos/{idAuto}
    - PathVariable: idAuto
    - Request:
      ```
      {
        "idAuto" : "3"
      }
      ```
    - Response: MyOrderResponseDto
      ```
      {
        "idMyOrder" : "5",
        "idAuto" : "3",
        "LocalDateTime" : "Дата создания",
        "LocalDateTime" : "Дата последнего обновления",
        "OrderStatus" : "CREATED",
        "description" : "Описание"
      }
      ```

  - по дате создания: на дату;
    - method GET
    - URL: /api/MyOrders?createDate=...
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
        "idMyOrder" : "1",
        "idAuto" : "idAuto1",
        "LocalDateTime" : "2024-04-11",
        "LocalDateTime" : "Дата последнего обновления",
        "OrderStatus" : "CREATED",
        "description" : "Описание"
      }
      
 - по дате создания: за период; 
     - method GET
     - URL: /api/myOrders?createDateFrom=...&createDateTo=....
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
         "idMyOrder" : "1",
         "idAuto" : "idAuto1",
         "LocalDateTime" : "2024-04-11",
         "LocalDateTime" : "Дата последнего обновления",
         "OrderStatus" : "CREATED",
         "description" : "Описание"
       }
       ....
       ```

 - по статусу;
   - method GET
   - URL: /api/myOrders?status=...
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
         "idMyOrder" : "1",
         "idAuto" : "idAuto1",
         "LocalDateTime" : "Дата создания",
         "LocalDateTime" : "Дата последнего обновления",
         "OrderStatus" : "OPEN",
         "description" : "Описание"
       }
        ....
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
    - PathVariable: idSparePart
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
      ....
      ```

*c) элемент заказа:*
- всех;
    - method GET
    - URL: /api/MyOrderItems
    - Request:
    - Response: MyOrderItemResponseDto
      ```
      {
        "idMyOrderItem" : "1",
        "idSparePart" : "5",
        "idMyOrder" : "3"
        "quantity" : "10"
        "
      },
      ...
      ```
  - по ID элемент заказа;
      - method GET
      - URL: /api/myOrderItems/{idMyOrderItem}
      - PathVariable: idMyOrderItem
      - Request:
        ```
        {
          "idMyOrderItem" : "10"
        }
        ```
      - Response: SparePartResponseDto
      ```
      {
        "idMyOrderItem" : "10",
        "idSparePart" : "5",
        "idMyOrder" : "3"
        "quantity" : "10"
      },
      ...
      ```
    
- по ID запчасти;
    - method GET
    - URL: /api/myOrderItems/idSparePart:{idSparePart}
    - PathVariable: idSparePart
    - Request:
      ```
      {
        "idSparePart" : "3"
      }
      ```
    - Response: SparePartResponseDto
      ```
      {
        "idMyOrderItem" : "1",
        "idSparePart" : "3",
        "idMyOrder" : "3"
        "quantity" : "10"
        "
      },
      ...
      ```
- по ID заказа;
    - method GET
    - URL: /api/myOrderItems/idMyOrder:{idMyOrder}
    - PathVariable: idMyOrder
    - Request:
      ```
      {
        "idMyOrder" : "5"
      }
      ```
    - Response: SparePartResponseDto
      ```
      {
        "idMyOrderItem" : "1",
        "idSparePart" : "3",
        "idMyOrder" : "5"
        "quantity" : "3"
        "
      },
      ...
      ```
         
**3. Редактирование:**
*a) автомобиля:*
   - бренда и/или модели;
      - method PUT
      - URL: api/autos/updateAuto
      - Request: AutoRequestDto
      ```
      {
        "vinNumber" : "VIN1234",
        "brand" : "brand2",
        "model" : "model2"
      }
      ```
      - Response: AutoResponseDto
      ```
      {
        "idAuto" : "1",
        "vinNumber" : "VIN1234",
        "brand" : "brand2",
        "model" : "model2"
      }
      ```
*b) заказа:*
   - именение статуса и/или описания;
        - method PUT
        - URL: /api/myOrders/updateMyOrder/{idMyOrder}?status=...&description=...,
        - PathVariable: idMyOrder
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
         "idMyOrder" : "1",
         "idAuto" : "2",
         "LocalDateTime" : "Дата создания",
         "LocalDateTime" : "Дата последнего обновления", - current date
         "OrderStatus" : "COMPLETED"
         "description" : "new Описание"
       }
       ```
*с) запчасти:*
   - описания
      - method PUT
      - URL: api/spareParts/updateSparePart/{idSparePart}
      - PathVariable: idSparePart
      - Params: description
      - Request: 
      ```
      {
        "description" : "new Описание"
      }
      ```
      - Response: SparePartResponseDto
      ```
      {
        "idSparePart" : "1",
        "name" : "SparePart1",
        "description" : "new Описание"
      }
      ```

*e) элемента заказа:*
   - изменение количества (увеличение, уменьшение) запчастей по ID элемента заказа;
     - method PUT
     - URL: api/myOrderItems/updateMyOrderItem/{idMyOrderItem}
     - PathVariable: idMyOrderItem
     - Params: quantity;
     - Request: 
     ```
     {
        "quantity" : "2"
     }
     ```
     - Response: MyOrderItemResponseDto
     ```
     {
        "idMyOrderItem" : "1",
        "idSparePart" : "5",
        "idMyOrder" : "3",
        quantity" : "2"
     }
     ```