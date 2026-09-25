# Crystal Spider: как подключить модель из Blockbench

Проект использует Minecraft 1.21.1, Fabric и официальные Mojang mappings.

## Что уже готово

- сущность `CrystalSpider`;
- регистрация `CRYSTAL_SPIDER`;
- стандартные характеристики паука;
- отдельный `CrystalSpiderModel`;
- отдельный `CrystalSpiderRenderer`;
- регистрация model layer;
- временно используется форма и текстура обычного паука.

Это сделано специально: сначала проверяем всю цепочку рендера, потом заменяем только геометрию и текстуру.

## Что нужно получить из Blockbench

Нужны два файла:

1. Java-код модели;
2. PNG-текстура.

Сам файл `.bbmodel` полезно сохранить отдельно как исходник для дальнейшего редактирования, но Minecraft напрямую его не читает.

## Что делать в Blockbench

1. Открыть модель кристаллического паука.
2. Проверить, что это проект формата Modded Entity для Minecraft Java Edition.
3. В настройках проекта выбрать версию, совместимую с Minecraft 1.21.1.
4. Выбрать Mojang mappings, потому что в `build.gradle` проекта используется `loom.officialMojangMappings()`.
5. Назвать модель `CrystalSpiderModel`.
6. Экспортировать Java entity model.
7. Экспортировать текстуру как PNG.

Если модель была создана в другом формате, лучше сделать копию проекта перед конвертацией.

## Куда положить Java-модель

Путь:

`src/client/java/ru/azazel/alchemytable/client/model/CrystalSpiderModel.java`

Сейчас в этом файле временно используется:

`return SpiderModel.createSpiderBodyLayer();`

После экспорта из Blockbench этот временный код нужно заменить сгенерированной геометрией Blockbench.

Важно сохранить:

- package `ru.azazel.alchemytable.client.model`;
- имя класса `CrystalSpiderModel`;
- `LAYER_LOCATION`.

Если Blockbench создаст другое имя класса, его нужно привести к `CrystalSpiderModel`.

## Куда положить текстуру

PNG нужно назвать:

`crystal_spider.png`

и положить сюда:

`src/main/resources/assets/azazels-alchemy-table/textures/entity/crystal_spider.png`

После этого в `CrystalSpiderRenderer.java` нужно заменить временную ванильную текстуру:

`minecraft:textures/entity/spider/spider.png`

на:

`azazels-alchemy-table:textures/entity/crystal_spider.png`

## Как проверить

Собрать мод и запустить Minecraft.

Команда:

`/summon azazels-alchemy-table:crystal_spider ~2 ~ ~`

Если появилась нужная форма и текстура, модель подключена.

Если сущность появляется, но форма обычного паука - Java-геометрия Blockbench ещё не заменена.

Если форма правильная, но фиолетово-чёрная - проблема с путём или именем PNG.

Если игра падает при создании моба - чаще всего не совпадают имена частей модели, версия экспорта или mappings.
